import java.sql.*;
public class Connect {
	
	private static final String username = "root";
	private static final String passwd = "mert";
        private static String prep_str;
        private static int columnIndex;
        private static String[] initial_Name;
	Connection con;
	com.mysql.jdbc.Statement statement;
	ResultSet rs;
	
	public Connect()
        {
            initial_Name = new String[200];
		try{
		
			con = DriverManager.getConnection("jdbc:mysql://localhost", username,passwd );
			 statement = (com.mysql.jdbc.Statement) con.createStatement() ;

			 
		}catch(Exception e){
			System.out.println("in connect " + e.toString());
		}
	}
	
	public void createDB(){
		try{ 
			/*drop DB if it is exist*/
			/*try{
				statement.execute("DROP DATABASE assing;");
			}catch (Exception e) {
				System.out.println(" drop DB " + e.toString());
			}*/
                    
			/*create n7ew DB*/
			//statement.execute("CREATE DATABASE assing;");
			statement.execute("use assing");
		}catch(Exception e){
			System.out.println("create DB " + e.toString());
		}
	}
//-----------------------------------------------------------------------------------------------------------------------        
	public void createTables(char letter)
        {
		try{ 
			statement.execute("CREATE TABLE" + letter + " " +
						"(Course_Name varchar(45);");
		}catch (Exception e) {
			System.out.println("Cannot create detailed Table. Error: " + e.toString());
		}
        }
		
//-----------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------
                
	public void insertCourse_Name(String s_kelime)
        {
           prep_str = "INSERT INTO Course_Details " + "VALUES" + "(" + "'" + s_kelime + "'" + "," + ");";;
		          System.out.println(prep_str);
           
           try{
			statement.execute(prep_str);
					
		}
                catch (Exception e) 
                {
                    System.out.println(   e.toString());
		}
	}
	
	
	
	
	public void contentOfCourses(){
		try{
			rs = statement.executeQuery("SELECT * FROM Course_Details;");
			rs.first();
			System.out.println("Course Details");
			System.out.println("Course Name	| Course Code	| Credit	|Grade");
			do{
				for(int i = 1 ; i <= 4 ;i++ )
					System.out.print(rs.getString(i)+" | ");
				System.out.println();
			}while(rs.next());
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
        
        
        public void deleteContentOfCourses(String Course_name)
         {
          
                
       
         prep_str = "DELETE FROM Course_Details WHERE Course_Name='"+Course_name+"'"; 
         
         
		          System.out.println(prep_str);
           
           try{
			statement.execute(prep_str);
					
		}
                catch (Exception e) 
                {
                    System.out.println(   e.toString());
		}
        }
    
        
        
        
        
        
        
        
        public void updateContentOfCourses(String Course_name,String Course_Code,String Credit,String grade)
        {
        
       
         prep_str = "UPDATE Course_Details SET Course_credit='"+Credit+"',"+"Course_Grade='"+grade+"'"+ "WHERE Course_Name='"+Course_name+"'"+" AND Couse_Code='"+Course_Code+"'"; 
         
         
		          System.out.println(prep_str);
           
           try{
			statement.execute(prep_str);
					
		}
                catch (Exception e) 
                {
                    System.out.println(   e.toString());
		}
        }
        public void updateContentOfCourses(String Course_name, String grade)
        {
        
       
         prep_str = "UPDATE Course_Details SET Course_Grade='"+grade+"'"+ "WHERE Course_Name='"+Course_name+"'"; 
         
         
		          System.out.println(prep_str);
           
           try{
			statement.execute(prep_str);
					
		}
                catch (Exception e) 
                {
                    System.out.println(   e.toString());
		}
        }
        
        public String[] contentOfCourses_Name()
        {
		try{
                       columnIndex =1;
                               
			rs = statement.executeQuery("SELECT Course_Name FROM Course_Details;");
			rs.first();
                 
			System.out.println("Course Details");
			System.out.println("Course Name");
			do{
				
				//System.out.print(rs.getString(1));
                                 initial_Name[columnIndex] =rs.getString(1);
                                
                                 columnIndex++;
                              
				System.out.println();
                                
                                
                                
			}while(rs.next());
		}catch (Exception e) {
			// not neccesary to be implemented
		}
                finally 
                {
                 return initial_Name;
                }

                
	}
    
}
