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
	int userNumber = 0;
	boolean newUser=true;
	Library library = new Library();
	///////////////////////////////////////////////////
	
	System.out.println("Welcome to the-fab-tria Library! Are you a returning user?");
	System.out.print("Type 'y' for yes or 'n' for no: ");
	String s  = scan.nextLine();
	
	while  (!s.equals("y")&&!s.equals("n")){
	    System.out.print("y or n ?");
	    s= scan.nextLine();
	}
	
	
	if (s.equals ("y")){
	    System.out.print("Username: ");
	    s=scan.nextLine();
	    
	    while(s==null){
		System.out.println("Username: " );
		s=scan.nextLine();
	    }
	    userNumber= allUsers.findUser(s);

	    while (userNumber==-1){
		
		System.out.println("This username does not exist. \nPlease try again. \nType 'new' if you do not have an account.");
		s=scan.nextLine();
		userNumber= allUsers.findUser(s);
		if (s.equals("new")){
		    break;
		}
		
	    }
	    newUser=false;
	    if (!newUser){
		System.out.print("password: ");
		s= scan.nextLine();
		
		while(!s.equals(allUsers.getUser(userNumber).getPassword())){
		    System.out.println("incorrect password!");
		    System.out.println("password: ");
		    s= scan.nextLine();
		}
		
		if (s.equals(allUsers.getUser(userNumber).getPassword())){
		    currentUser= allUsers.getUser(userNumber);
		    loggedIn= true;
		    System.out.println(" you are logged in !");
		}
	    }
    	}
	//////////////////////////////////////////////////////////////////////////////////////////
	if (newUser){
	    
	    
	    System.out.println("*********\nHello and welcome to the-fab-tria Library! We are a new and up in coming library that has been opened for the community. Feel free to become a member to check out books, sign up on wait lists for books you care to read that are not available, and even send us requests for books we can add to our library. All in all we hope you have a great experience and read on!\n***********\n");
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
			System.out.print("Please enter a valid first name: ");
			first = scan.nextLine();
		    }
		}
	  		    
		System.out.print("Please enter your last name: ");
		String last = scan.nextLine();
		
		if(last.isEmpty()){
		    while(last.isEmpty()){
			System.out.print("Please enter a valid last name: ");
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
		    System.out.println("username: "+username);
	      
		    while (username.isEmpty() ||  allUsers.findUser(username)>-1){
			if(username.isEmpty()){
			    System.out.println("Enter a valid username");
			    username = scan.nextLine();
			}

			else{
			    System.out.print("This username is already taken. \nPlease enter a username: ");
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
	
	System.out.println("********\nWelcome "+currentUser.getUsername()+"! \nTo CHECK OUT a book : type 'CHECK OUT'. \nYour information will not be updated until you log out. \nIn order to LOG OUT, type 'LOG OUT'. \nAt any point, type 'DIRECTIONS' if you need help.\n******** ");
	while (loggedIn){
	    System.out.print(currentUser.getUsername()+": "); 
	s= scan.nextLine();
	    if (s.equals("LOG OUT")){
		library.writeFile();
		allUsers.writeFile();
		loggedIn=false;
	    }
	    else if (s.equals("CHECK OUT")){
	    }
	}
	System.out.println("You have successfully logged out.");
    }
    
}
