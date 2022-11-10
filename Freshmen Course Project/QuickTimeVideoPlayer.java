

package videodatabase;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import quicktime.io.*;
import quicktime.std.movies.*;
import quicktime.app.view.*;
import quicktime.*;
/*
 Important Note : Please read the manuel.
 This routes you to run this code properly.
 Manuel can be found in QuickTimeLib.rar in Project Folder
 */

public class QuickTimeVideoPlayer extends Frame
{
    //Class Variable
    public File f;
    Movie media; // Basic Quicktime class representing all types of media
    public QuickTimeVideoPlayer(String title, File f)
    {
    	super(title);
    	this.f=f;
        // This WindowListener helps to close Player
    	this.addWindowListener(new WindowAdapter(){

    		public void windowClosing(WindowEvent e){
    	e.getWindow().dispose();
    }
    	});
        try
        {
            // Initialize the Quicktime engine and must be written in try catch block
             //The QTSession  package allows us to open and close QuickTime sessions between Java and the native QuickTime library

            QTSession.open();


             // Open the media file with Quicktime
             // The normal file input does not used in QuickTime the file object should be the type of QuickTime file.io
                    QTFile inputFile = new QTFile(f);
                    OpenMovieFile QTMedia = OpenMovieFile.asRead(inputFile);// Open the specified movie file for reading.
                     media = Movie.fromFile(QTMedia);
            // Create the movie controller which is same as player
                     MovieController control = new MovieController(media);
            // Create the controller component
                     QTComponent comp1 = QTFactory.makeQTComponent(control);
                     Component Component = comp1.asComponent();
            // Add the controller to the frame and show it
                        this.add(Component);
                        this.pack();
                        this.setVisible(true);
            // Closing the QTSession
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}