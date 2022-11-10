package automatisiertes_testen_ag;

import MainGUIs.GUI_Main;
import javax.swing.SwingUtilities;


public class Automatisiertes_Testen_AG 
{
  
    public Automatisiertes_Testen_AG()
    {
    
    
    }

    public static void main(String[] args) 
    {

        SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
       GUI_Main gui_start = new GUI_Main();
      gui_start.run();
  
      }
    });

    }
   

    
}
