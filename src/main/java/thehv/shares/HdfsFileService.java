
// package thehv.shares;

// import java.io.File;
// import java.text.SimpleDateFormat;
// import java.util.Date;
// import org.apache.hadoop.conf.Configuration;
// import org.apache.hadoop.fs.FileStatus;
// import org.apache.hadoop.fs.FileSystem;
// import org.apache.hadoop.fs.LocalFileSystem;
// import org.apache.hadoop.fs.Path;
// import org.apache.hadoop.security.UserGroupInformation;
// import lombok.extern.log4j.Log4j2;

// @Log4j2
// public class HdfsFileService {
//     public void getFileFromHadoop() {
//         try {
//             SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");
//             String localPath = "/var/otp/hd_local" + df.format(new Date());
//             File filelocalPath = new File(localPath);
//             filelocalPath.mkdir();

//             Configuration conf = new Configuration();
//             conf.set("fs.defaultFS", "hdfs://mhtt");
//             conf.set("fs.default.name", "hdfs://mhtt");
//             conf.set("dfs.nameservices", "mhtt");
//             conf.set("dfs.ha.namenodes.mhtt", "nn1,nn2");
//             conf.set("dfs.namenode.rpc-address.mhtt.nn1", "mhtt-master:8020");
//             conf.set("dfs.namenode.rpc-address.mhtt.nn2", "dmmanager:8020");
//             conf.set("dfs.client.failover.proxy.provider.mhtt",
//                     "org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider");
//             conf.set("hadoop.security.authentication", "kerberos");
//             conf.set("dfs.namenode.kerberos.principal.pattern", "*");
//             conf.set("fs.hdfs.impl", "DistributedFileSystem.class.getName()");
//             conf.set("fs.file.impl", LocalFileSystem.class.getName());

//             UserGroupInformation.setConfiguration(conf);
//             UserGroupInformation.loginUserFromKeytab("KEYTAB_NAME", "KEYTAB_FILEPATH");
//             FileSystem fs = FileSystem.get(conf);
//             FileStatus[] fsStatus = fs.listStatus(new Path("/var/otp/hd_remote"));
//             for (int i = 0; i < fsStatus.length; i++) {
//                 fs.copyToLocalFile(fsStatus[i].getPath(), new Path(localPath));
//             }
//             log.info("GET FILES DONE");
//         } catch (Exception e) {
//             log.error(e.getMessage(), e);
//         }
//     }
// }