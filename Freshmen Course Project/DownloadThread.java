
package videodatabase;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class DownloadThread implements Runnable
{
    private String filename;
    private String url;
    private File file;



    public DownloadThread(String filename,String url)
    {
        this.filename=filename;
        this.url=url;
        file = new File(filename);

    }


    public void run()
    {
        try
        {
            File file = setFileFromURL(url);
            Main.File.add(file);
           
            FileChoosingMenuForVideo.FromUrl.setEnabled(true);

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public File setFileFromURL(String urlString) throws IOException
    {


        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try
        {
                in = new BufferedInputStream(new URL(urlString).openStream());
                fout = new FileOutputStream(file);

                byte data[] = new byte[1024];
                int count;

                while ((count = in.read(data, 0, 1024)) != -1)
                {
                        fout.write(data, 0, count);
                        int val = FileChoosingMenuForVideo.progress.getValue();

                        FileChoosingMenuForVideo.progress.setValue(++val);


                }

        }


        finally
        {
                if (in != null)
                        in.close();
                if (fout != null)
                        fout.close();

                return file;
        }

    }



    }




