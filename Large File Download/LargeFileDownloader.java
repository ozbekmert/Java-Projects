

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

public class LargeFileDownloader extends Thread
{ 
    public static String URL;
    public static String URL2;
    public static int thread_no;
    public static String path="";
    public static String host;
    public static String path2="";
    public static String host2;
    
    public static String filename;
    public  int byte1 = -1;
    public  int byte2=-1;
    public static int byteRange=-1;
    public static final String range = "bytes=" ;
    public boolean single_thread_flag = false;
    public boolean multi_thread_flag1 = false;
    public StringBuffer buf;

    public LargeFileDownloader(String URL)
    {
       this.URL = URL;
       single_thread_flag = true;
       multi_thread_flag1 = false;
       URL_Extractor();
    }
    
    public LargeFileDownloader(String URL, int byte1 , int byte2, int thread_no, ThreadGroup tg,StringBuffer buf)
    {
        super(tg,Integer.toString(thread_no));
        this.URL=URL;
        this.byte1=byte1;
        this.byte2=byte2; 
        this.buf=buf;
        this.thread_no=thread_no;
        multi_thread_flag1 = true;
        single_thread_flag = false;
        URL_Extractor();
        System.out.println("Host: "+host+" path: "+ path    +" Byte: "+this.byte1+" byte2 "+ this.byte2);
    }

    public void URL_Extractor()
    {
        path ="";
        String temp;
        int start_index;
        int start_index2;
        StringBuffer buf = new StringBuffer(); 
        StringBuffer buf2 = new StringBuffer(); 
        start_index = URL.lastIndexOf("/");
         for(int i = start_index+1; i< URL.length(); i++)
         {    
            if(URL.charAt(i) != ' ')
            {   
               buf.append( URL.charAt(i) );
            }
         }
         filename = buf.toString().trim();
         StringTokenizer st2 = new StringTokenizer(URL,"/");
         host=st2.nextToken();
         host=st2.nextToken();
         while(st2.hasMoreTokens())
         {
          path=path.concat("/"+st2.nextToken());   
         }
    }
    
   public static ArrayList<String> URL_Extractor2(String URL2)
    {
        
         ArrayList<String> str_list = new ArrayList<String>();
        int start_index;
        int start_index2;
        StringBuffer buf = new StringBuffer(); 
        StringBuffer buf2 = new StringBuffer(); 
        start_index = URL2.lastIndexOf("/");
         for(int i = start_index+1; i< URL2.length(); i++)
         {    
            if(URL2.charAt(i) != ' ')
            {   
               buf.append( URL2.charAt(i) );
            }
         }
         filename = buf.toString().trim();
         StringTokenizer st2 = new StringTokenizer(URL2,"/");
         host=st2.nextToken();
         str_list.add(st2.nextToken());
         while(st2.hasMoreTokens())
         {
          path=path.concat("/"+st2.nextToken());   
         }
         str_list.add(path);
         
         
         return str_list;
    }
   public static ArrayList<String> URL_Extractor3(String URL2)
    {
        
         ArrayList<String> str_list = new ArrayList<String>();
        int start_index;
        int start_index2;
        StringBuffer buf = new StringBuffer(); 
        StringBuffer buf2 = new StringBuffer(); 
        start_index = URL2.lastIndexOf("/");
         for(int i = start_index+1; i< URL2.length(); i++)
         {    
            if(URL2.charAt(i) != ' ')
            {   
               buf.append( URL2.charAt(i) );
            }
         }
         StringTokenizer st2 = new StringTokenizer(URL2,"/");
         host2=st2.nextToken();
         str_list.add(st2.nextToken());
         while(st2.hasMoreTokens())
         {
          path2=path2.concat("/"+st2.nextToken());   
         }
         str_list.add(path2);
         System.out.println(host2);
         System.out.println(path2)
                 ;
         return str_list;
    }

    public static boolean checkConnection() throws UnknownHostException, IOException
    {
       
             boolean flag = false;
            Socket sock = new Socket();
            InetAddress addr = InetAddress.getByName(host);
            int port = 80; 
            SocketAddress sockaddr = new InetSocketAddress(addr, port);
            sock.connect(sockaddr); 
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()))); 
            out.write("HEAD "+path+" HTTP/1.1"+"\r\n"+"Host: "+host+"\r\n\r\n");
            out.flush(); 

          BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream())); 
          if(in.readLine().equals("HTTP/1.1 200 OK"))
          {
            System.out.println("HTTP/1.1 200 OK Recieved"); 
            flag = true;
          }
            in.close(); 
            return flag;
    }

    public void downloadContent() throws FileNotFoundException, IOException 
    { 

            Socket sock = new Socket();
            InetAddress addr = InetAddress.getByName(host);
            int port = 80; 
            SocketAddress sockaddr = new InetSocketAddress(addr, port);
            sock.connect(sockaddr); 
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()))); 
            out.write("GET "+path+" HTTP/1.1"+"\r\n"+"Host: "+host+"\r\n\r\n");
            out.flush(); 
            File file = new File(filename);
            FileOutputStream fileOutput = new FileOutputStream(file);
            InputStream inputStream = sock.getInputStream();
            byte[] buffer = new byte[1024];
            int bufferLength = 0;
            int count=0;
            int i=0;
            String headerMessagge;
            BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            try 
            {
                
                while(count!=2)
                {
                    headerMessagge = reader.readLine();
                    i++; 
                    if(headerMessagge.equals("")){
                    count++;
                    
                }

                if(count == 1)
                {
                    while ((bufferLength = inputStream.read(buffer)) > 0)
                    {
                    fileOutput.write(buffer, 0, bufferLength);
                    }
                count++;
                } 
                
              }
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(LargeFileDownloader.class.getName()).log(Level.SEVERE, null, ex);
            }        
            
    }
    
    public void downloadContent2() throws IOException
    {
            Socket sock = new Socket();
            InetAddress addr = InetAddress.getByName(host);
            int port = 80; 
            SocketAddress sockaddr = new InetSocketAddress(addr, port);
            sock.connect(sockaddr); 
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()))); 
            out.write("GET " + path + " HTTP/1.1"+"\r\n"+"Host: "+host+"\r\n"+"Range: bytes="+byte1+ "-" + byte2 +"\r\n\r\n");
            out.flush(); 
            InputStream inputStream = sock.getInputStream();
            byte[] buffer = new byte[1024];
            int bufferLength = 0;
            int count=0;

            String headerMessagge;
            BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            try 
            {
                String a;
                while(count!=2)
                {
                    headerMessagge = reader.readLine();
                    if(headerMessagge.equals(""))
                    {
                      count++;
                    }

                if(count == 1)
                {
                    while ((bufferLength = inputStream.read(buffer)) > 0)
                    {
                        buf.append(new String(buffer, 0, bufferLength, "ASCII"));
                       
                    }
                count++;
                } 
                
              }
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(LargeFileDownloader.class.getName()).log(Level.SEVERE, null, ex);
            } 
   
    }
    
    public static int getByteRange(String host1, String path1) throws IOException
    {
            Socket sock = new Socket();
            InetAddress addr = InetAddress.getByName(host1);
            int port = 80; 
            SocketAddress sockaddr = new InetSocketAddress(addr, port);
            sock.connect(sockaddr); 
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()))); 
            out.write("HEAD "+path1+" HTTP/1.1"+"\r\n"+"Host: "+host1+"\r\n\r\n");
            out.flush(); 
            BufferedReader reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String temp;
            while(true)
            {
                    if((temp=reader.readLine()).substring(0, 14).equals("Content-Length"))
                    {
                        StringTokenizer token = new StringTokenizer(temp);
                        System.out.print(token.nextToken().toString());
                        byteRange = Integer.parseInt(token.nextToken().toString());
                        System.out.println(byteRange );
                        break;
                    }
                    
                   }   
            return byteRange;
    }
    public static void writeToFile( StringBuffer pData) throws IOException {  
        String a;   
        BufferedWriter out = new BufferedWriter(new FileWriter(filename));  
           out.write(a=pData.toString());  
           
           out.flush();  
           out.close();  
    }  

    public void run()
    {
        
        if(single_thread_flag == true)
        {
            try {
               if( checkConnection())
                downloadContent(); // singleThreadDownload
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LargeFileDownloader.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(LargeFileDownloader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(multi_thread_flag1 == true)
        { 
            try {
                if(checkConnection())
                      downloadContent2();
            } catch (UnknownHostException ex) {
                Logger.getLogger(LargeFileDownloader.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(LargeFileDownloader.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        
        
      
      
      
    }
    public static void main(String[] args)throws Exception
    {
        double startTime =0;
        double fin_time=0;
        double finalTime;
        String args_url;
        String args_url2;
        int number_of_thread;
        ArrayList<StringBuffer> threadBuffer = new ArrayList<StringBuffer>();
        ArrayList<LargeFileDownloader> Thread_List = new ArrayList<LargeFileDownloader>(); 
        ThreadGroup  grp ;
        StringBuffer args_buffer = new StringBuffer();
        StringBuffer fin_buffer = new StringBuffer();
         
      
        
        if(args.length==0)
        { 
         System.out.println("Proper Input Required / No input entered");     
     
        }        
        else if(args.length==1) //Scenario 1
        {
            boolean flag = true;
            args_url =args[0];
            LargeFileDownloader down = new LargeFileDownloader(args_url);
            down.start();
            startTime= System.currentTimeMillis(); 
            while(flag)
            {
              
                
                if((down.getState().toString()).equals("TERMINATED"))
                {
                       fin_time = System.currentTimeMillis(); 
                  flag=false;
                }
                else
                {
                   flag = true;
                }
            }
            finalTime = (fin_time-startTime)/1000;
             System.out.println("Total Time :" + finalTime); 
        }
        else if(args.length==2) //Scenario 2
        {
           args_url = args[0];
           number_of_thread =Integer.parseInt(args[1]);
           ArrayList<String> buf;
           buf = LargeFileDownloader.URL_Extractor2(args_url);  
           int totalBytes= LargeFileDownloader.getByteRange(buf.get(0), buf.get(1));
           int frame_size = totalBytes /(number_of_thread);
           int remaning_byte = totalBytes-(frame_size*(number_of_thread));
           System.out.println("rem bytes: "+remaning_byte );
           grp = new ThreadGroup ("DownloaderGroup");
           for(int i = 0; i<=number_of_thread-1;i++)
           {
               if(i != number_of_thread-1)
               {
                if(i ==0)
                {       
                 threadBuffer.add(new StringBuffer());
                 Thread_List.add(i,new LargeFileDownloader(args_url,0,(frame_size*(i+1)),i,grp,threadBuffer.get(i)));
                }
                else
                {
                 threadBuffer.add(new StringBuffer());
                 Thread_List.add(i,new LargeFileDownloader(args_url,(frame_size*i)+1,(frame_size*(i+1)),i,grp,threadBuffer.get(i)));
                }
               }
               if(i ==number_of_thread-1)
               {
                 threadBuffer.add(new StringBuffer());
                 Thread_List.add(new LargeFileDownloader(args_url,frame_size*i,(frame_size*(i+1)+remaning_byte),i,grp,threadBuffer.get(i)));
               }
    
           }
           
           for(int i = 0; i<=number_of_thread-1;i++)
           {
            Thread_List.get(i).start(); 
           }
            startTime= System.currentTimeMillis(); 
     
            while(grp.activeCount()!=0)
            {
                
                
            }
          
             fin_time = System.currentTimeMillis(); 

             for(int i = 0; i<=number_of_thread-1;i++)
             {
              fin_buffer.append(threadBuffer.get(i));
             }
             LargeFileDownloader.writeToFile(fin_buffer);  
                finalTime = (fin_time-startTime)/1000;
             System.out.println("Total Time :" + finalTime); 
        }
        else if(args.length==3) //Scenario 3
        {
 
           args_url =args[0]; //Store URL
           args_url2 =args[1]; //Store URL
           number_of_thread = Integer.parseInt(args[2]);
           ArrayList<String> buf;
           ArrayList<String> buf2;
           buf = LargeFileDownloader.URL_Extractor2(args_url);
           buf2 = LargeFileDownloader.URL_Extractor3(args_url2);
           int totalBytes= LargeFileDownloader.getByteRange(buf.get(0), buf.get(1));
           int frame_size = totalBytes /(number_of_thread);
           int remaning_byte = totalBytes-(frame_size*(number_of_thread));
           System.out.println("rem bytes: "+remaning_byte );
           grp = new ThreadGroup ("DownloaderGroup");
           for(int i = 0; i<=number_of_thread-1;i++)
           {
               if(i != number_of_thread-1)
               {
                if(i ==0)
                {       
                 threadBuffer.add(new StringBuffer());
                 Thread_List.add(i,new LargeFileDownloader(args_url,0,(frame_size*(i+1)),i,grp,threadBuffer.get(i)));
                }
                else if(i%2 == 0)
                {
                 threadBuffer.add(new StringBuffer());
                 Thread_List.add(i,new LargeFileDownloader(args_url,(frame_size*i)+1,(frame_size*(i+1)),i,grp,threadBuffer.get(i)));
                }
                else if(i%2 == 1)
                {
                  threadBuffer.add(new StringBuffer());
                  Thread_List.add(i,new LargeFileDownloader(args_url2,(frame_size*i)+1,(frame_size*(i+1)),i,grp,threadBuffer.get(i)));
                }
               }
               if(i ==number_of_thread-1)
               {
                 threadBuffer.add(new StringBuffer());
                 Thread_List.add(new LargeFileDownloader(args_url2,frame_size*i,(frame_size*(i+1)+remaning_byte),i,grp,threadBuffer.get(i)));
               }
    
           }
            startTime = System.currentTimeMillis();
           for(int i = 0; i<=number_of_thread-1;i++)
           {
            Thread_List.get(i).start(); 
           }
          
     
            while(grp.activeCount()!=0)
            {
            }
             fin_time = System.currentTimeMillis();
         
             for(int i = 0; i<=number_of_thread-1;i++)
             {
              fin_buffer.append(threadBuffer.get(i));
             }
             LargeFileDownloader.writeToFile(fin_buffer);  
              finalTime = (fin_time-startTime)/1000;
             System.out.println("Total Time :" + finalTime); 
        }
        else
        {
            System.err.println("Unexpected Input Entered");
        }

    
        System.out.println("Main Finished");
        System.exit(0);
            
    }

}