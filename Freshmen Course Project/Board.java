package videodatabase;
import java.util.*;
import javax.swing.*;

public class Board
{
    //Local Variable
    private int numberthDocument = 1;
    private int like=0;
    private int dislike=0;
    private String boardName, boardDocuments;
    public int count = 0;

    public ArrayList <JLabel> documentLabelList = new ArrayList<JLabel>();
    //Constructor
    public Board(String boardName)
    {
    	this.boardName = boardName;
    }
    // ----------------------Those two Mehtods increase amount of like and dislike number
//    public void like(){
//        like++;
//    }
//    public void dislike(){
//        dislike++;
//    }
    //--------------------------Those two Mehtods shows amount of like and dislike number in Panel
    public String showLike(){
    	String tmp = "" + like;
        return tmp;
    }
    public String showDislike(){
    	String tmp = "" + dislike;
        return tmp;
    }
    //------------------------Those two Mehtods returns The board name and it's document name which will be used in BoaedDOC for ins and student
    public String getBoardName(){
    	return boardName;
    }
    public String getBoardDocuments(){
    	return boardDocuments;
    }
}


