package com.tm.test.beans;


import javax.faces.bean.ManagedBean;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.jms.Connection;

@ManagedBean
public class JNDIBean {

	public void testDataSource() {
		System.out.println("send button clicked...");
		
		getJNDIDetails();
		//getConnection();
	}
	
//	public void getDataSource() {
//		Context ctx = null;
//		Connection con = null;
//		try {
//			ctx = new InitialContext();
//			Context initCtx = (Context) ctx.lookup("java:/comp/env");
//			DataSource ds = (DataSource) initCtx.lookup("jdbc/MyDB");
//			con = ds.getConnection();
//			System.out.println("We got connection ::" + con);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
	
	public void getJNDIDetails(){
	      try {
	    	  Context ctx = null;
	    	  ctx = new InitialContext();
       //   InitialContext initCtx = new InitialContext();
	    	  Context initCtx = (Context) ctx.lookup("java:/comp/env");
	    	  
          ConnectionFactory connectionFactory = (ConnectionFactory) initCtx.lookup("jms/ConnectionFactory");
          Connection connection = connectionFactory.createConnection();
          System.out.println(connection);
//          Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//          MessageProducer producer = session.createProducer((Destination) jndiContext.lookup("queue/MyQueue"));
//
//          TextMessage testMessage = session.createTextMessage();
//          testMessage.setText(text);
//          testMessage.setStringProperty("aKey", "someRandomTestValue");
//          producer.send(testMessage);
//         System.out.println("Successfully sent message.");
      } catch (Exception e) {
      	System.out.println(e.getMessage());
      }
	    
	}

}
