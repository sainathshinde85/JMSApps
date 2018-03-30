package com.tm.test.beans;



import javax.faces.bean.ManagedBean;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ManagedBean
public class BasicView {

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void sendMessage() {
		System.out.println("send button clicked...");
		getJNDIDetails();
		//getDataSource();
		//getConnection();
	}

	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/applicationContext.xml");
		Test test = (Test) context.getBean("t");
		test.sayhello();

	}

	public void getDataSource() {
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

	}

	public static void getConnection() {

//		try {
//			// step1 load the driver class
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//
//			// step2 create the connection object
//			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
//			System.out.println(con);
//			con.close();
//
//		} catch (Exception e) {
//			System.out.println(e);
//		}

	}
	public void getJNDIDetails(){
	      try {
	    	  Context ctx = null;
	    	  Connection con = null;
	    	  ctx = new InitialContext();
	    	  
	    	 
	    	  Context initCtx  = (Context) ctx.lookup("java:/comp/env");
	    	  
	    	  System.out.println(" ctx  lookup");
	    	  
	    	  DataSource ds = (DataSource) initCtx.lookup("jdbc/MyLocalDB");
	    	  System.out.println(" ds lookup successful ");
//	    	  DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/MyLocalDB");
				
//				con = (Connection) ds.getConnection();
				System.out.println(" connection successful ");
				
	    	  
         //   InitialContext initCtx = new InitialContext();
//	    	  Context initCtx = (Context) ctx.lookup("java:/comp/env/");
	    	  
//            ConnectionFactory connectionFactory = (ConnectionFactory) initCtx.lookup("jms/ConnectionFactory");
//            Connection connection = connectionFactory.createConnection();
//            System.out.println(connection);
//            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//            MessageProducer producer = session.createProducer((Destination) jndiContext.lookup("queue/MyQueue"));
//
//            TextMessage testMessage = session.createTextMessage();
//            testMessage.setText(text);
//            testMessage.setStringProperty("aKey", "someRandomTestValue");
//            producer.send(testMessage);
//           System.out.println("Successfully sent message.");
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
	    
	}
}