import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;  

public class Driver{
    public static void main(String[] args){
       
	///////////////////////////////variables///////////
	Scanner scan = new Scanner(System.in);
	Users allUsers= new Users();
	User currentUser= new User();
	boolean loggedIn= false;
	///////////////////////////////////////////////////

	System.out.println("Welcome to the-fab-tria Library! Are you a returning user?");
	System.out.print("Type 'y' for yes or 'n' for no: ");
	while (true){
	
		while  (!s.equals("y")&&!s.equals("n")){
		    System.out.print("y or n ?");
		    s= scan.nextLine();
		}
	
	
		if (s.equals ("y")){
		    //System.out.println("ay logged in");
		    if (allUsers.findUser(username)==-1){
		    	System.out.println("This username does not exist. \nPlease try again.");
		    }
		    else
		    	break;
		}
		if(s.equals("n"))
			break;
	}
	//////////////////////////////////////////////////////////////////////////////////////////
	else if (loggedIn==false){
	    
	    
	    System.out.println("Hello and welcome to the-fab-tria Library! We are a new and up in coming library that has been opened for the community. Feel free to become a member to check out books, sign up on wait lists for books you care to read that are not available, and even send us requests for books we can add to our library. All in all we hope you have a great experience and read on!");
	    System.out.print("Would you like to sign up to become a member? Please type 'y' for yes or 'n' for no: ");
	    
	    
	    	s= scan.nextLine();
	    while  (!s.equals("y")&&!s.equals("n")){
		System.out.print("y or n ?");
		s= scan.nextLine();
		
	    }
	    
	    if (s.equals("n")){
		System.out.println("We hope you become a member and visit us soon!");
		System.exit(0);
	    }
	    
	    
	    else if (s.equals("y")){
		System.out.print("Please enter your first name: ");
		String first = scan.nextLine();
		if(first.isEmpty()){
		    while(first.isEmpty()){
			System.out.println("Please enter a valid first name: ");
			first = scan.nextLine();
		    }
		}
	  		    
		System.out.print("Please enter your last name: ");
		String last = scan.nextLine();
		
		if(last.isEmpty()){
		    while(last.isEmpty()){
			System.out.println("Please enter a valid last name: ");
			last = scan.nextLine();
		    }
	    }
		currentUser.setName(first+" "+last);
		
		
		System.out.print("Please enter your gender: female or male: ");
		String gender = scan.nextLine().toLowerCase();
		if(!(gender.equals("female") || gender.equals("male")) || gender.isEmpty()){
		    while(!(gender.equals("female") || gender.equals("male")) || gender.isEmpty()){
			System.out.println("Please enter your gender: ");
			gender = scan.nextLine().toLowerCase();
		    }
		}
		currentUser.setGender(gender);
		
		
		System.out.print("Please enter your occupation: professor, student, etc.: ");
		String occupation = scan.nextLine();
		if(occupation.isEmpty()){
		    while(occupation.isEmpty()){
		      System.out.println("Please enter your occupation: ");
		      occupation = scan.nextLine();
		    }
		}
		currentUser.setOccupation(occupation);
		
		System.out.print("Please enter a username: ");
		String username= scan.nextLine();
		while (username.isEmpty() ||  allUsers.findUser(username)==-1){
		    if(username.isEmpty()){
			System.out.println("Enter a valid username");
			username = scan.nextLine();
		    }
		    ////////////////////this check does not work !
		    else{
			System.out.println("This username is already taken.");
			username = scan.nextLine();
		    }   
		}
		currentUser.setUsername(username);
		
		System.out.print("Enter a password: ");
		String password=scan.nextLine();
		if(password.isEmpty()){
		    while(password.isEmpty()){
			System.out.println("Enter a valid password");
		    password = scan.nextLine();
		    }
		}
		currentUser.setPassword(password);
		
		
		/*            
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
			      
			      //some of the encryption code from http://www.codeobsessed.com/code/viewtopic.php?f=6&t=25

			      
			      
			      ////////////////////////////////////////////
			      todo: re-enter password
			      String password2= scan.nextLine();
			      System.out.println("Re-enter password:" );
			      if(password.isEmpty()){
			      while(password.isEmpty()){
			      System.out.println("Enter a valid password");
			      password = scan.nextLine();
			      }
			      }	    
		*/
		
		//add user to file
		allUsers.addUser(currentUser);
		loggedIn=true;
		System.out.println("Congratulations! Your account has been created. ");
		
	    }
	}
    

	if (loggedIn){

	    //this is where the actual library things happen !
	}
    }
}
    
