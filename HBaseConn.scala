val hbaseConfig = HBaseConfiguration.create()

      import org.apache.hadoop.security.UserGroupInformation
      import scala.collection.JavaConversions._

import scala.collection.JavaConversions._


     System.setProperty("java.security.krb5.realm", "realm name")
      System.setProperty("java.security.krb5.kdc", "server name")
      System.setProperty("sun.security.krb5.debug", "false")
      System.setProperty("java.security.krb5.conf", "Path to krb conf file")
     
      hbaseConfig.addResource(new Path("path to hdfs-site.xml"))
      hbaseConfig.addResource(new Path("path to core-site.xml"))
      hbaseConfig.addResource(new Path("path to hbase-site.xml"))


      hbaseConfig.set("hbase.client.retries.number", "3")
      hbaseConfig.set("hbase.client.pause", "1000")
      hbaseConfig.set("zookeeper.recovery.retry", "1")

      UserGroupInformation.setConfiguration(hbaseConfig)
      UserGroupInformation.loginUserFromKeytab("realm", "path to keytab")
      val conn = ConnectionFactory.createConnection(hbaseConfig)
