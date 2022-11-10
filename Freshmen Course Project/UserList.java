package videodatabase;
import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UserList
{
    // Class Variables
    private ArrayList <String> UserIDArrayList;
    private ArrayList <String> UserPasswordArrayList;
    private ArrayList <String> AdminIDArrayList;
    private ArrayList <String> AdminPasswordArrayList;
    
    //Constructor
    public UserList()
    {
	AdminIDArrayList = getAdminIDArrayList();
    	AdminPasswordArrayList = getAdminPasswordArrayList();
    	UserIDArrayList = getUserIDArrayList();
    	UserPasswordArrayList = getUserPasswordArrayList();
    }
    // Those Methods which is written below provides with storing UserList Datas in different file
    
    
    //--------------------------------------------------------------------------------------------------
    //-----------------------------Username & Password Verification----------------------------------
    public  boolean containsGivenIDForUser(String ID)
    {
        if(UserIDArrayList.size()!=0)
        {
       		 for(int i = 0; i < UserIDArrayList.size(); i ++)
                 {
                    if(UserIDArrayList.get(i).equals(ID))
                    {
                            return true;
                    }
        	 }
        return false;
    	}
    	else
        {
        	return false;
    	}
    }
    public boolean containsGivenIDForAdmin(String ID){
        if(AdminIDArrayList.size()!=0)
        {
       		 for(int i = 0; i < AdminIDArrayList.size(); i ++)
                 {
                    if(AdminIDArrayList.get(i).equals(ID))
                    {
                            return true;
                    }
        	}
        	return false;
    	}
    	else
        {
        	return false;
    	}
    }
    public boolean containsGivenPasswordForUser(String pass)
    {
        if(UserPasswordArrayList.size()!=0)
        {
        	for(int i = 0; i < UserPasswordArrayList.size(); i ++)
                {
                    if(UserPasswordArrayList.get(i).equals(pass))
                    {
                            return true;
                    }
        	}
        	return false;
    	}
    	else
        {
        	return false;
    	}
    }
    public boolean containsGivenPasswordForAdmin(String pass)
    {
        if(AdminPasswordArrayList.size()!=0)
        {
        	for(int i = 0; i < AdminPasswordArrayList.size(); i ++)
                {
                    if(AdminPasswordArrayList.get(i).equals(pass))
                    {
                            return true;
                    }
        	}
        	return false;
    	}
    	else
        {
        	return false;
    	}
    }
    public boolean IDandPasswordInSameOrderForUser(String ID, String password)
    {
    	for(int i = 0; i < UserIDArrayList.size(); i++)
        {
    		if(getIDOrderUser(ID)==getPasswordOrderUser(password))
                {
    			return true;
    		}
    		else
                {
    			return false;
    		}
    	}
    	return true;
    }
     public boolean IDandPasswordInSameOrderForAdmin(String ID, String password)
     {
    	for(int i = 0; i < AdminIDArrayList.size(); i++)
        {
    		if(getIDOrderAdmin(ID)==getPasswordOrderAdmin(password))
                {
    			return true;
    		}
    		else
                {
    			return false;
    		}
    	}
    	return true;
    }


    public int getIDOrderUser(String ID)
    {

    	for(int i =0; i< UserPasswordArrayList.size();i++ )
        {
    		if(ID.equals(UserIDArrayList.get(i)))
                {
    			return i;
    		}
    	}
    	return -1;
    }
    public int getPasswordOrderUser(String password){

    	for(int i =0; i< UserPasswordArrayList.size();i++ ){
    		if(password.equals(UserPasswordArrayList.get(i)))
                {
    			return i;
    		}
    	}
    	return -1;
    }

    public int getIDOrderAdmin(String ID){

    	for(int i =0; i< AdminIDArrayList.size();i++ )
        {
    		if(ID.equals(AdminIDArrayList.get(i))){
    			return i;
    		}
    	}
    	return -1;
    }
    public int getPasswordOrderAdmin(String password){

    	for(int i =0; i < AdminPasswordArrayList.size();i++ ){
    		if(password.equals(AdminPasswordArrayList.get(i))){
    			return i;
    		}
    	}
    	return -1;
    
    }
    private void SerializeArraylist(ArrayList <String> source, String fileName)
    {
        // This Method is core of storing data

    	try
    	{
    		FileOutputStream fos = new FileOutputStream(fileName);
	    	ObjectOutputStream oos = new ObjectOutputStream(fos);
	    	oos.writeObject(source);
	    	oos.close();
	    	System.out.println("write : " + fileName + " : " + source);
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

		    System.out.println("read : " + fileName + " : " +anotherList);
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
    public void addIDToAdminArrayList(String text)
    {
    	AdminIDArrayList.add(text);
    	SerializeArraylist(AdminIDArrayList,"AdminIDArrayList");

    }
    public void addIDToUserArrayList(String text){
    	UserIDArrayList.add(text);

    	SerializeArraylist(UserIDArrayList,"UserIDArrayList");

    }
    public void addPasswordToAdminArrayList(String text){
    	AdminPasswordArrayList.add(text);

    	SerializeArraylist(AdminPasswordArrayList,"AdminPasswordArrayList");

    }
    public void addPasswordToUserArrayList(String text){
    	UserPasswordArrayList.add(text);

    	SerializeArraylist(UserPasswordArrayList,"UserPasswordArrayList");

    }
    public ArrayList getUserIDArrayList(){
    	UserIDArrayList = DeSerializeArraylist("UserIDArrayList");
    	return UserIDArrayList;
    }
    public ArrayList getAdminIDArrayList(){
    	AdminPasswordArrayList = DeSerializeArraylist("AdminIDArrayList");
    	return AdminPasswordArrayList;
    }
    public ArrayList getUserPasswordArrayList(){
    	UserPasswordArrayList = DeSerializeArraylist("UserPasswordArrayList");
    	return UserPasswordArrayList;
    }
    public ArrayList getAdminPasswordArrayList(){
    	AdminPasswordArrayList = DeSerializeArraylist("AdminPasswordArrayList");
    	return AdminPasswordArrayList;
    }
}