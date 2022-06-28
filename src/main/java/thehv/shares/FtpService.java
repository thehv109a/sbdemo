
package thehv.shares;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Log4j2
@Component
public class FtpService {
    public void getFileFromRemote() throws IOException {
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("FTP_HOST", 21);
        int reply = ftpClient.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftpClient.disconnect();
            throw new IOException("Exception in connecting to FTP Server");
        }
        boolean loginOK = ftpClient.login("FTP_USER", "FTP_PASSWORD");
        if (loginOK) {
            ftpClient.enterLocalPassiveMode();
            ftpClient.type(FTP.BINARY_FILE_TYPE);
        }

        try {
            FTPFile[] ftpFiles = ftpClient.mlistDir();
            if (ftpFiles == null || ftpFiles.length == 0) {
                return;
            }

            for (FTPFile ftpFile : ftpFiles) {
                safeDownloadFile(ftpClient, ftpFile);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (ftpClient != null) {
                ftpClient.disconnect();
            }
        }
    }

    private void safeDownloadFile(FTPClient ftpClient, FTPFile ftpFile) {
        try {
            String srcFilePath = "./files/" + ftpFile.getName() + ".tmp";
            try (FileOutputStream fileOutputStream = FileUtils.openOutputStream(new File(srcFilePath))) {
                ftpClient.retrieveFile(ftpFile.getName(), fileOutputStream);
            }
            Path sourcePath = Paths.get(srcFilePath);
            Files.move(sourcePath, sourcePath.resolveSibling(ftpFile.getName()), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}