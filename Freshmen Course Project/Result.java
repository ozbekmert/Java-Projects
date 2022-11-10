

package videodatabase;

import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.*;

public class Result extends JFrame {
    private int rigth;
    private int wrong;
    private String name;
    private double time;
    private JLabel scoreLabel1;
    private JLabel scoreLabel2;
    private JLabel scoreLabel3;
    private JLabel scoreLabel4;
    private JLabel ImageLabel;
    private JButton back;
    private JTextField box1;
    private JTextField box2;
      private JPanel panelAllForASplitPane;
   private JPanel panelAllForBSplitPane;
   private JSplitPane jsp;
   private int placement =1;
 
    private ArrayList successList = new ArrayList<String>();
    private ArrayList successListOfScore = new ArrayList<Integer>();

    public Result(int rigth,int wrong,String name)
    {
        this.rigth=rigth;
        this.wrong=wrong;
        this.name=name;
        box1 = new JTextField();
        box2 = new JTextField();
        box1.setEditable(false);
        box2.setEditable(false);

        checkArrayList();
        panelAllForASplitPane = new JPanel();
        panelAllForBSplitPane = new JPanel();
        scoreLabel1 = new JLabel();
        scoreLabel2 = new JLabel();
        scoreLabel3 = new JLabel();
        scoreLabel4 = new JLabel();
        ImageLabel = new JLabel(new ImageIcon("cong.jpg"));
       panelAllForASplitPane.setLayout(new GridLayout(4,1));
       scoreLabel1.setText("                              Top Scores");
       panelAllForASplitPane.add(scoreLabel1);
       scoreLabel2.setLayout(new GridLayout(successListOfScore.size(),1));
       box1.setText(TopScoreToString());
       panelAllForASplitPane.add(box1);
       scoreLabel3.setText("                               Scores that users had");
       panelAllForASplitPane.add(scoreLabel3);
       box2.setText(toString());
       panelAllForASplitPane.add(box2);
       panelAllForBSplitPane.add(ImageLabel);



        jsp = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );

	jsp.setLeftComponent(  panelAllForASplitPane);
	jsp.setRightComponent(panelAllForBSplitPane );
        jsp.setOneTouchExpandable(true);
        add(jsp);
        setVisible(true);
        pack();

      
     




    }
    public void checkArrayList()
    {
       
             successList = getSuccessList();
             successListOfScore = getSuccessListScore();
             addScoreToArrayList();

    }

    public int successCalculator()
    {
        int sum = 0;
        if(wrong !=0)
        {
            try
            {
                 sum=rigth*100/(rigth+wrong);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            sum = rigth*100/(rigth+wrong);
        }
        return sum;

    }
    
    private void SerializeArraylist(ArrayList <String> source, String fileName)
    {
       

    	try
    	{
    		FileOutputStream fos = new FileOutputStream(fileName);
	    	ObjectOutputStream oos = new ObjectOutputStream(fos);
	    	oos.writeObject(source);
	    	oos.close();

    	}
    	catch(Exception e )
    	{
            e.printStackTrace();
    	}
    }
    private void SerializeIntegerArraylist(ArrayList <Integer> source, String fileName)
    {


    	try
    	{
    		FileOutputStream fos = new FileOutputStream(fileName);
	    	ObjectOutputStream oos = new ObjectOutputStream(fos);
	    	oos.writeObject(source);
	    	oos.close();

    	}
    	catch(Exception e )
    	{
            e.printStackTrace();
    	}
    }
    private ArrayList <String> DeSerializeArraylist( String fileName)
    {
    	ArrayList <String> anotherList = null;
    	try
    	{
		    FileInputStream fis = new FileInputStream(fileName);
		    ObjectInputStream ois = new ObjectInputStream(fis);
		    anotherList = (ArrayList <String>) ois.readObject();
		    ois.close();


    	}
    	catch(Exception e )
    	{
    		e.printStackTrace();
    	}
    	if( anotherList == null )
    	{
    		anotherList =  new ArrayList<String>();
    	}
    	return anotherList;
    }
    private ArrayList <Integer> DeSerializeIntegerArraylist( String fileName)
    {
    	ArrayList <Integer> anotherList = null;
    	try
    	{
		    FileInputStream fis = new FileInputStream(fileName);
		    ObjectInputStream ois = new ObjectInputStream(fis);
		    anotherList = (ArrayList <Integer>) ois.readObject();
		    ois.close();


    	}
    	catch(Exception e )
    	{
    		e.printStackTrace();
    	}
    	if( anotherList == null )
    	{
    		anotherList =  new ArrayList<Integer>();
    	}
    	return anotherList;
    }
    public void addScoreToArrayList()
    {

    	String info ="\r\n" +"The Success Rate of "+name+ " is " + successCalculator()+"\r\n";
        successList.add(info);
        successListOfScore.add(successCalculator());
    	SerializeArraylist(successList,"SuccessList");
        SerializeIntegerArraylist(successListOfScore,"successListOfScore");

    }
    public ArrayList getSuccessList(){
    	successList = DeSerializeArraylist("SuccessList");
    	return successList;
    }
    public ArrayList getSuccessListScore(){
    	successListOfScore = DeSerializeIntegerArraylist("SuccessListOfScore");
    	return successListOfScore;
    }
    @Override
    public String toString()
    {
        String s = "";
        for(int i =0;i<successList.size();i++)
        {
            s +="\r\n"+ successList.get(i).toString()+"\r\n";
        }
        return s;
    }
    public String TopScoreToString()
    {
       String ts = "";
       bubbleSort(successListOfScore,successListOfScore.size());

        for(int a =0 ; a<successListOfScore.size(); a++)
        {
            ts += "\r\n" +placement +". "+successListOfScore.get(a)+"\r\n";
            placement++;
        }
       
        
        return ts;
    }



    private static void bubbleSort(ArrayList<Integer> unsortedArrayList, int length) {

        int temp, counter, index;



        for(counter=0; counter<length-1; counter++) { //Loop once for each element in the array.

            for(index=0; index<length-1-counter; index++) { //Once for each element, minus the counter.

                if(unsortedArrayList.get(index) > unsortedArrayList.get(index+1)) { //Test if need a swap or not.

                    temp = unsortedArrayList.get(index); //These three lines just swap the two elements:

                    unsortedArrayList.set(index,unsortedArrayList.get(index+1));

                    unsortedArrayList.set(index+1, temp);

                }

            }

        }

    }

   


}
