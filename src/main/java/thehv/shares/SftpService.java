// package thehv.shares;

// import lombok.extern.log4j.Log4j2;
// import org.springframework.stereotype.Component;
// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.nio.file.StandardCopyOption;
// import java.util.Properties;
// import java.util.Vector;
// import com.jcraft.jsch.ChannelSftp;
// import com.jcraft.jsch.JSch;
// import com.jcraft.jsch.Session;
// import com.jcraft.jsch.ChannelSftp.LsEntry;

// @Log4j2
// @Component
// public class SftpService {
//     public void getFileFromRemote() throws IOException {
//         ChannelSftp channelSftp = setupJsch();
//         if (channelSftp == null)
//             return;

//         try {
//             channelSftp.connect();
//             Vector<LsEntry> filelist = channelSftp.ls("/var/opt/remote");
//             for (int i = 0; i < filelist.size(); i++) {
//                 LsEntry entry = (LsEntry) filelist.get(i);
//                 safeDownloadFile(channelSftp, entry.getFilename());
//             }
//         } catch (Exception e) {
//             log.error(e.getMessage(), e);
//         } finally {
//             channelSftp.exit();
//         }
//     }

//     public void safeDownloadFile(ChannelSftp channelSftp, String fileName) {
//         try {
//             String localFilePathStr = "//var/opt/local" + fileName + ".tmp";
//             Path localFilePath = Paths.get(localFilePathStr);
//             channelSftp.get(fileName, localFilePathStr);
//             Files.move(localFilePath, localFilePath.resolveSibling(fileName), StandardCopyOption.REPLACE_EXISTING);
//         } catch (Exception e) {
//             log.error(e.getMessage(), e);
//         }
//     }

//     private ChannelSftp setupJsch() {
//         try {
//             JSch jsch = new JSch();
//             jsch.setKnownHosts("SFTP_HOST");
//             Session jschSession = jsch.getSession("SFTP_USER", "SFTP_HOST", 22);
//             jschSession.setPassword("SFTP_PASSWORD");
//             Properties config = new Properties();
//             config.put("StrictHostKeyChecking", "no");
//             jschSession.setConfig(config);
//             jschSession.connect();
//             return (ChannelSftp) jschSession.openChannel("sftp");
//         } catch (Exception e) {
//             log.info("Exception in connecting to SftpServer");
//             log.error(e.getMessage(), e);
//             return null;
//         }
//     }
// }