package videodatabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;

public class Main
{

        private static UserList listofUser = new UserList();
        public static ArrayList <FileChoosingMenuForVideo> FileList = new ArrayList<FileChoosingMenuForVideo>();
        public static ArrayList <FileChoosingMenuForSound> FileList2 = new ArrayList<FileChoosingMenuForSound>();
	public static ArrayList <File> File = new ArrayList<File>();
	public static ArrayList <File> File2 = new ArrayList<File>();
	public static ArrayList <Quiz> quizlist = new ArrayList<Quiz>();
        public static ArrayList <MyJButton> mediaButtonListForAdmin = new ArrayList <MyJButton>();
        public static ArrayList <MyJButton> SecondmediaButtonListForAdmin = new ArrayList <MyJButton>();
	public static JPanel videoPanel = new JPanel();
	public static JPanel soundTrackPanel = new JPanel();
	public static Integer count = 1;
	public static Integer count2 = 1;
	public static Integer count3 = 1;
        public static Integer count4 = 0;

        public static ArrayList <Board> boardList = new ArrayList <Board>();

        public static void main(String[] args) throws Exception
        {

           StartingPage page = new StartingPage(listofUser);
            page.setVisible(true);

        }

}