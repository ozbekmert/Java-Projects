import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.StringTokenizer;
public class FileRequest 
{
    
     
   public FileRequest() 
   {  
       StringBuffer buf = new StringBuffer(); 
       BufferedInputStream in = null;
       FileOutputStream fout = null;
           
      try 
      {
          Scanner scan = new Scanner(System.in);
          System.out.println("Please enter Server IP");
          InetAddress ownIP = InetAddress.getByName(scan.nextLine());
          Socket c = new Socket(ownIP,8888);
         
         printSocketInfo(c);
         DataOutputStream outToServer=new DataOutputStream(c.getOutputStream());
         DataInputStream inToServer = new DataInputStream(c.getInputStream());
          System.out.println("Please enter filename: ");
          String filename;
         outToServer.writeBytes(filename=scan.nextLine());
        in = new BufferedInputStream(c.getInputStream());
        fout = new FileOutputStream(filename);
               
                byte data[] = new byte[1024];
                int count;
             
              
                while ((count = in.read(data, 0, 1024)) != -1)
                {
                    if(data.length==0)
                        System.out.println("no data recieved");
                     fout.write(data, 0, count);
                }
                 System.out.println("finished");
              
         
         
       
         
         
             
       outToServer.close();
       inToServer.close();
       c.close();

       
      } catch (IOException e) {
         System.err.println(e.toString());
      }
      
       
   }

   private static void printSocketInfo(Socket s) {
      System.out.println("Remote address = "
         +s.getInetAddress().toString());
      System.out.println("Remote port = "
         +s.getPort());
      System.out.println("Local socket address = "
         +s.getLocalSocketAddress().toString());
      System.out.println("Local address = "
         +s.getLocalAddress().toString());
      System.out.println("Local port = "
         +s.getLocalPort());
   }
}
