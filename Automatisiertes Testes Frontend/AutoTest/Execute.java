
package AutoTest;

import Server.Client;
import java.io.File;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.CellType;


public class Execute extends Thread
{

    private static final String FILE_PATH ="Solar_Test.xlsx";
    private static ArrayList fall = new ArrayList<Double>();
    private String path;
    private Client client;
    private Integer phase,turn;

    public Execute(String path,Client client) 
    {
         this.path=path;
         this.client = client;
         
    }

    public void run() 
    {
         try 
         {
            FileInputStream excelFile = new FileInputStream(new File(path));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            turn =1;
            while (iterator.hasNext()) 
            {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                phase =1;
                
                while (cellIterator.hasNext())
                {

                    Cell currentCell = cellIterator.next();
                    

                    if (currentCell.getCellTypeEnum() == CellType.NUMERIC)
                    {
                       switch (phase)  
                       {
                            case 1:  //client.setTemp("S1", Double.toString(currentCell.getNumericCellValue()));
                                      System.out.println("Setting Temp S1 "+ currentCell.getNumericCellValue()); 
                                     break;
                            case 2:  //client.setTemp("S2", Double.toString(currentCell.getNumericCellValue()));
                                     System.out.println("Setting Temp S2 "+ currentCell.getNumericCellValue());      
                                     break;
                            case 3: // client.setTemp("S3", Double.toString(currentCell.getNumericCellValue()));
                                     System.out.println("Setting Temp S3 "+ currentCell.getNumericCellValue()); 
                                     break;
                            case 4: // client.setTemp("S4", Double.toString(currentCell.getNumericCellValue()));
                                     System.out.println("Setting Temp S4 "+ currentCell.getNumericCellValue()); 
                                     break;
                            case 5: // client.setTemp("S5", Double.toString(currentCell.getNumericCellValue()));
                                      System.out.println("Setting Temp S5 "+ currentCell.getNumericCellValue()); 
                                     break;
                            case 6: // client.setTemp("S6", Double.toString(currentCell.getNumericCellValue()));
                                     System.out.println("Setting Temp S6 "+ currentCell.getNumericCellValue()); 
                                     break;
                            case 7: // client.setTemp("S7", Double.toString(currentCell.getNumericCellValue()));
                                     System.out.println("Setting Temp S7 "+ currentCell.getNumericCellValue()); 
                                     break;
                            case 8: // client.setTemp("S8", Double.toString(currentCell.getNumericCellValue()));
                                    System.out.println("Setting Temp S8 "+ currentCell.getNumericCellValue()); 
                                     break;
                            case 9: // client.setVFS("VFS1", Double.toString(currentCell.getNumericCellValue()));
                                    System.out.println("Setting VFS1"+ currentCell.getNumericCellValue());
                                    break;
                            case 10: // client.setVFS("VFS2", Double.toString(currentCell.getNumericCellValue()));
                                    System.out.println("Setting VFS2"+ currentCell.getNumericCellValue());
                                     break;
                            case 11: // client.setPWM("PWM1", Double.toString(currentCell.getNumericCellValue()));
                                     System.out.println("Setting PWM1 "+ currentCell.getNumericCellValue());
                                     break;
                            case 12: // client.setVFS("PWM2", Double.toString(currentCell.getNumericCellValue()));
                                     System.out.println("Setting PWM2 "+ currentCell.getNumericCellValue());
                                     break;
                        } 
                           
                       
                    }
                  phase++;
                }
                 
                turn++;
                System.out.println("-----Test Phase: "+ turn +"--------" );
               
                sleep(1000);
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException ex) {
            Logger.getLogger(Execute.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }


}