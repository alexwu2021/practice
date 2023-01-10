//package com.docmatter.ims.hive;
//
//import org.apache.hive.service.auth.PlainSaslHelper;
//import org.apache.hive.service.rpc.thrift.*;
//import org.apache.thrift.TException;
//import org.apache.thrift.protocol.TBinaryProtocol;
//import org.apache.thrift.transport.TTransport;
//
//import javax.security.sasl.SaslException;
//import java.sql.*;
//import java.util.Iterator;
//import java.util.List;
//
//import static org.apache.hadoop.hive.common.auth.HiveAuthUtils.getSocketTransport;
//
//public class BuildHiveConnection {
//
//    public static void testThriftConnection() throws SaslException, TException {
//        TTransport transport = getSocketTransport("127.0.0.1", 10000,99999);
//        transport = PlainSaslHelper.getPlainTransport("hive", "password123", transport);
//
//        TBinaryProtocol protocol = new TBinaryProtocol(transport);
//        TCLIService.Client client = new TCLIService.Client(protocol);
//
//        transport.open();
//        TOpenSessionReq openReq = new TOpenSessionReq();
//        TOpenSessionResp openResp = client.OpenSession(openReq);
//        TSessionHandle sessHandle = openResp.getSessionHandle();
//
//        TExecuteStatementReq execReq = new TExecuteStatementReq(sessHandle, "show tables");
//        TExecuteStatementResp execResp = client.ExecuteStatement(execReq);
//        TOperationHandle stmtHandle = execResp.getOperationHandle();
//
//        TFetchResultsReq fetchReq = new TFetchResultsReq(stmtHandle, TFetchOrientation.FETCH_FIRST, 100);
//        TFetchResultsResp resultsResp = client.FetchResults(fetchReq);
//        List<TColumn> res=resultsResp.getResults().getColumns();
//        for(TColumn tCol: res){
//            Iterator<String> it = tCol.getStringVal().getValuesIterator();
//            while (it.hasNext()){
//                System.out.println(it.next());
//            }
//        }
//
//        TCloseOperationReq closeReq = new TCloseOperationReq();
//        closeReq.setOperationHandle(stmtHandle);
//        client.CloseOperation(closeReq);
//        TCloseSessionReq closeConnectionReq = new TCloseSessionReq(sessHandle);
//        client.CloseSession(closeConnectionReq);
//
//        transport.close();
//
//    }
//
//    public static void testJdbcConnection() throws ClassNotFoundException, SQLException {
//        //String hiveConnectionURL = "jdbc:hive2://${hiveserver}:10000/default;principal=hive/_HOST@localhost;hive.server2.proxy.user=Alex";
//
//        String hiveConnectionURL = "jdbc:hive2://${hiveserver}:10000/default";
//
//        hiveConnectionURL = hiveConnectionURL.replace("${hiveserver}","mp-2020-5.lan");
//        String JDBC_DRIVER_NAME = "org.apache.hive.jdbc.HiveDriver";
//        // JDBC_DRIVER_NAME = "org.apache.hadoop.hive.jdbc.HiveDriver"; CLASS NOT FOUND
//
////		jdbc:hive2://<host>:<port>/<db>;transportMode=http;httpPath=<http_endpoint>
////				<http_endpoint> is the corresponding HTTP endpoint configured in hive-site.xml. Default value is cliservice.
////
//        try{
//        // Set JDBC Hive Driver
//        Class.forName(JDBC_DRIVER_NAME);
//        // Connect to Hive
//        // Choose a user that has the rights to write into /user/hive/warehouse/
//        Connection
//                con = DriverManager.getConnection(hiveConnectionURL,"hive","password123");
//        //con = DriverManager.getConnection(hiveConnectionURL,"hdfs","");
//        // Init Statement
//
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from default.test1");
//            while(rs.next()){
//                int id  = rs.getInt("id");
//            }
//            rs.close();
//            stmt.close();
//            con.close();
//        }catch(SQLException se){
//            se.printStackTrace();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//}
