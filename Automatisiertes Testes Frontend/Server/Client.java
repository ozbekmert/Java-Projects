package Server;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;

public class Client extends Thread
{
	private static final int EXIT_SUCCESS = 0;
	private static final int EXIT_ERROR = 1;
        
	private static final String SHUTDOWN_RPC_NAME = "server.shutdown";
        private static final String testRegler = "server.testRegler";
        private static final String SET_SENSOR_TEMP_NAME = "server.setSensorTemp";
        private static final String SET_SENSOR_HUM_NAME = "server.setSensorHum";
        private static final String GET_RELAY_NAME = "server.getRelay";
        private static final String GET_PWM_NAME = "server.getPWM";
        private static final String get10V_NAME = "server.get10V";
        private static final String MixerIsClosing_NAME = "server.MixerIsClosing";
        private static final String MixerIsOpening_NAME = "server.MixerIsOpening";
        private static final String setRcMode_NAME = "server.setRcMode";
        private static final String setRcTemp_NAME = "server.setRcTemp";
        
	private String serverURL = null;
	private XmlRpcClient xmlrpcClient = null;

	public Client(String serverURL) throws MalformedURLException 
        {
		this.serverURL = serverURL;
		initializeXMLRPCClient();
	}
        
	private void initializeXMLRPCClient() throws MalformedURLException 
        {
		xmlrpcClient = new XmlRpcClient(serverURL);
	}

	public boolean executeShutdownRPC() {
		// The result returned by the server.
		boolean success = false;

		/*
		 * The server.shutdown RPC takes zero parameters, so 
		 * we just pass an empty Vector.
		 */
		Vector parameters = new Vector();
		
		try {
			// Execute the RPC.
			System.out.println("Client: Executing the " + SHUTDOWN_RPC_NAME  + " RPC...");
			Object result = xmlrpcClient.execute(SHUTDOWN_RPC_NAME, parameters);
			
			/*
			 * The result object should be a Boolean.
			 * If it is not, then an error occurred, and 
			 * result is an Exception object.  To determine
			 * whether the RPC was successful, try to cast 
			 * result to a Boolean.
			 */
			try {
				success = ((Boolean)result).booleanValue();
			} catch (ClassCastException e) {
				// An error occurred and the server
				// returned an Exception.
				XmlRpcException e2 = (XmlRpcException)result;
				System.err.println("The server threw an exception: " + e2.getMessage());
				System.exit(EXIT_ERROR);
			}
		} catch (XmlRpcException e) {
			// An XML-RPC exception occurred.  For example, a handler  
			// for the requested RPC was not found on the server
			System.err.println("XML-RPC error: " + e.getCause());
			System.exit(EXIT_ERROR);
		} catch (IOException e) {
			// An error with the HTTP connection occurred.  For example,
			// the connection was refused.
			System.err.println("Could not connect to XML-RPC server at " + serverURL + '.');
			System.exit(EXIT_ERROR);
		}
		
		return success;
	}
	
	
	public synchronized boolean setTemp(String name, String value) 
        {
		Vector<String> Program_Properties = new Vector<String>();
		Program_Properties.add(name);
		Program_Properties.add(value);
		boolean reglerResult = false;
		try 
		{
			System.out.println("Client: Executing the " + SET_SENSOR_TEMP_NAME + " RPC...");
			Object result = xmlrpcClient.execute(SET_SENSOR_TEMP_NAME, Program_Properties);
			
			try 
			{
				reglerResult = (boolean)result;
			} 
			catch (ClassCastException e) 
			{
				// An error occurred and the server
				// returned an Exception.
				XmlRpcException e2 = (XmlRpcException)result;
				System.err.println("The server threw an exception: " + e2.getMessage());
				System.exit(EXIT_ERROR);
			}
		} catch (XmlRpcException e) {
			// An XML-RPC exception occurred.  For example, a handler  
			// for the requested RPC was not found on the server
			System.err.println("XML-RPC error: " + e.getCause());
			System.exit(EXIT_ERROR);
		} catch (IOException e) {
			// An error with the HTTP connection occurred.  For example,
			// the connection was refused.
			System.err.println("Could not connect to XML-RPC server at " + serverURL + '.');
			System.exit(EXIT_ERROR);
		}
		
		return reglerResult;
}
        
        
        public synchronized int getPWM(String name) 
        {
		Vector<String> Program_Properties = new Vector<String>();
		Program_Properties.add(name);
		int  reglerResult = -1;
		try 
		{
			System.out.println("Client: Executing the " + GET_PWM_NAME + " RPC...");
			Object result = xmlrpcClient.execute(GET_PWM_NAME, Program_Properties);
			
			try 
			{
				reglerResult = (int) result;
			} 
			catch (ClassCastException e) 
			{
				// An error occurred and the server
				// returned an Exception.
				XmlRpcException e2 = (XmlRpcException)result;
				System.err.println("The server threw an exception: " + e2.getMessage());
				System.exit(EXIT_ERROR);
			}
		} catch (XmlRpcException e) {
			// An XML-RPC exception occurred.  For example, a handler  
			// for the requested RPC was not found on the server
			System.err.println("XML-RPC error: " + e.getCause());
			System.exit(EXIT_ERROR);
		} catch (IOException e) {
			// An error with the HTTP connection occurred.  For example,
			// the connection was refused.
			System.err.println("Could not connect to XML-RPC server at " + serverURL + '.');
			System.exit(EXIT_ERROR);
		}
		
		return reglerResult;
}
        
        public synchronized boolean getRelayStatus(String name)
        {
               Vector<String> Program_Properties = new Vector<String>();
		Program_Properties.add(name);
		boolean reglerResult = false;
		try 
		{
			System.out.println("Client: Executing the " + GET_RELAY_NAME + " RPC...");
			Object result = xmlrpcClient.execute(GET_RELAY_NAME, Program_Properties);
			
			try 
			{
				reglerResult = (boolean)result;
			} 
			catch (ClassCastException e) 
			{
				// An error occurred and the server
				// returned an Exception.
				XmlRpcException e2 = (XmlRpcException)result;
				System.err.println("The server threw an exception: " + e2.getMessage());
				System.exit(EXIT_ERROR);
			}
		} catch (XmlRpcException e) {
			// An XML-RPC exception occurred.  For example, a handler  
			// for the requested RPC was not found on the server
			System.err.println("XML-RPC error: " + e.getCause());
			System.exit(EXIT_ERROR);
		} catch (IOException e) {
			// An error with the HTTP connection occurred.  For example,
			// the connection was refused.
			System.err.println("Could not connect to XML-RPC server at " + serverURL + '.');
			System.exit(EXIT_ERROR);
		}
		
		return reglerResult;
        
        }

	
}
