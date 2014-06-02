import java.util.Scanner;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException; 

public class Password {   
   public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String password = " ";       
        String again = "Y";
       
        while (again.toUpperCase().charAt(0) == 'Y')
        {
           System.out.print("Enter string: ");
           password = scan.nextLine();

           try
           {
               System.out.println("MD5 string: " + DemoMD5.MD5(password));
           }
       
           catch (NoSuchAlgorithmException a)
           {
               a.printStackTrace();
           }
       
           catch (UnsupportedEncodingException a)
           {
              a.printStackTrace();
           }
       
           System.out.print("\nRun again?: ");
           again = scan.nextLine();
        }
        System.exit(0);
    }
}
