import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileServer 
{
  public static ArrayList <String> UserList = new ArrayList<String>();
  public static ArrayList <String> ClienList = new ArrayList<String>();
  private static int port=8888, maxConnections=10;
  File file1;
    
  public FileServer(File file) 
  {
      this.file1=file1;
    
      startServer();
      
}
  public void startServer()
  {
      System.out.println("Server Started waiting for users...");
    int i=0;
   
    try{
      ServerSocket listener = new ServerSocket(port);
      Socket server;
        
      while((i++ < maxConnections) || (maxConnections == 0))
      {
          
        FileServer.doComms connection;
        server = listener.accept();
        FileServer.doComms conn_c= new FileServer.doComms(server,file1);
        Thread t = new Thread(conn_c);
        t.start();     
      }
    } catch (IOException ioe) {
      System.out.println("IOException on socket listen: " + ioe);
      ioe.printStackTrace();
    }
  }
 
class doComms implements Runnable 
{
    private Socket server;
    private String line,input;
    private ObjectOutputStream outStream ;
    private DataOutputStream outStream2;
    private File file;
    public boolean flag1 = true;
    doComms(Socket server,File file) 
    {
      this.file=file;  
      this.server=server;
    }

    public void run () 
    {

         System.out.println(this.server.getInetAddress().getHostAddress());
         ClienList.add(this.server.getInetAddress().getHostAddress());
         BufferedInputStream in = null;
         FileOutputStream fout = null;
         
        try 
        {
            try 
            {
                 DataInputStream intoData = new DataInputStream(server.getInputStream());
                 outStream = new ObjectOutputStream(server.getOutputStream());
                 outStream2 = new DataOutputStream(server.getOutputStream());
                  outStream.flush();
             
                streamFile(file1);
                    
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
             outStream2.flush();
             outStream2.close();
             server.close();
       
      } 
      catch (IOException ioe) 
      {
        System.out.println("IOException  on socket listen: " + ioe);
        ioe.printStackTrace();
      }
    }
   
    
    public void streamFile(File file) throws IOException
    {
        long fileSize = file.length();
        long completed = 0;
        int step = 1024;
 
        // creates the file stream
        FileInputStream fileStream = new FileInputStream(file);
 
        // sending a message before streaming the file
        
     
        byte[] buffer = new byte[step];
        while (completed <= fileSize) {
            fileStream.read(buffer);
            outStream2.write(buffer);
            completed += step;
        }
       
        fileStream.close();
        outStream.close();
    }
}


}

    
