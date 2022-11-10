
import java.io.File;

public class Test 
{
    public Test()
    {
    
    }
    
    public static void main(String[] args) 
    {
        Test t = new Test();
        int[] arr1 = {10,20,30,40,50,60};
        int[] arr2 = {10,20,30,40,60,50};
        
        System.out.println(t.TrueFalse(arr1));
        System.out.println(t.TrueFalse(arr2));
    }
    
    public boolean TrueFalse(int[] arr)
    {
        boolean flag = false;
        
        for(int i =0; i<arr.length-1; i++)
        {
            System.out.println("Karşılaştırdığı indexler " + i + " - " + (i+1) );
            if(arr[i]<arr[i+1])
                flag = true;
            else
            {
                flag = false;
                break;
            }
        }
   
        return flag;
    }
}
