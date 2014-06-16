import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;  


public class Driver{

    public static String capitalize (String str){
	String[]arr= str.split(" ");
	String fin = "";
	for (int x=0; x<arr.length; x++){
	    String curr= arr[x];
	    fin+=curr.substring(0,1).toUpperCase();
	    String s= curr.substring(1);
	    for ( int y=0; y<s.length(); y++){
		fin+=s.substring(y,y+1).toLowerCase();
	    }
	    fin+=" ";
	}
	fin=fin.trim();
	return fin;
    }

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
	
	System.out.println("********\nWelcome to the-fab-tria Library! Are you a returning user?\n********");
	System.out.print("Type 'y' for yes or 'n' for no: ");
	String s  = scan.nextLine();
	System.out.println("********");
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
		
		System.out.println("********\nThis username does not exist. \nPlease try again. \nType 'new' if you do not have an account.\n********");
		System.out.print("Username: ");
		s=scan.nextLine();
		userNumber= allUsers.findUser(s);
		if (s.equals("new")){
		    break;
		}
		
	    }
	    newUser=false;
	    if (!newUser){
		System.out.print("Password: ");
		s= scan.nextLine();
		
		while(!s.equals(allUsers.getUser(userNumber).getPassword())){
		    System.out.println("********\nIncorrect password!\n********");
		    System.out.print("Password: ");
		    s= scan.nextLine();
		}
		
		if (s.equals(allUsers.getUser(userNumber).getPassword())){
		    currentUser= allUsers.getUser(userNumber);
		    loggedIn= true;
		    System.out.println("You have logged in!");
		}
	    }
    	}
	//////////////////////////////////////////////////////////////////////////////////////////
	if (newUser){
	    
	    
	    System.out.println("*********\nHello and welcome to the-fab-tria Library! We are a new and up in coming library that has been opened for the community. Feel free to become a member to check out books, sign up on wait lists for books you care to read that are not available, and even send us requests for books we can add to our library. All in all we hope you have a great experience and read on!\n***********\n");
	    System.out.print("Would you like to sign up to become a member? Please type 'y' for yes or 'n' for no: ");
	    
	    s= scan.nextLine().trim();
	    while  (!s.equals("y")&&!s.equals("n")){
		System.out.print("y or n ?");
		s= scan.nextLine().trim();
		
	    }
	    
	    if (s.equals("n")){
		System.out.println("We hope you become a member and visit us soon!");
		System.exit(0);
	    }
	    
	    
	    else if (s.equals("y")){
		System.out.println("********");
		System.out.print("Please enter your first name: ");
		String first = scan.nextLine().trim();
		if(first.isEmpty()){
		    while(first.isEmpty()){
			System.out.print("Please enter a valid first name: ");
			first = scan.nextLine().trim();
		    }
		}
	  		    
		System.out.print("Please enter your last name: ");
		String last = scan.nextLine();
		
		if(last.isEmpty()){
		    while(last.isEmpty()){
			System.out.print("Please enter a valid last name: ");
			last = capitalize(scan.nextLine());
		    }
		}
		currentUser.setName(first+" "+last);
		
		
		System.out.print("Please enter your gender: female or male: ");
		String gender = scan.nextLine().trim().toLowerCase();
		if(!(gender.equals("female") || gender.equals("male")) || gender.isEmpty()){
		    while(!(gender.equals("female") || gender.equals("male")) || gender.isEmpty()){
			System.out.println("Please enter your gender: ");
			gender = scan.nextLine().trim().toLowerCase();
		    }
		}
		currentUser.setGender(gender);
		
		
		System.out.print("Please enter your occupation: professor, student, etc.: ");
		String occupation = scan.nextLine().trim();
		if(occupation.isEmpty()){
		    while(occupation.isEmpty()){
			System.out.println("Please enter your occupation: ");
			occupation = scan.nextLine();
		    }
		}
		currentUser.setOccupation(occupation);
		
		    System.out.print("Please enter a username: ");
		    String username= scan.nextLine().trim();
		    System.out.println("username: "+username);
	      
		    while (username.isEmpty() ||  allUsers.findUser(username)>-1){
			if(username.isEmpty()){
			    System.out.println("Enter a valid username");
			    username = scan.nextLine().trim();
			}

			else{
			    System.out.print("This username is already taken. \nPlease enter a username: ");
			    username = scan.nextLine().trim();
			}   
		    }
		    currentUser.setUsername(username);
		
		    System.out.print("Enter a password: ");
		    String password=scan.nextLine().trim();
		    if(password.isEmpty()){
			while(password.isEmpty()){
			    System.out.println("Enter a valid password");
			    password = scan.nextLine().trim();
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
 mk				  a.printStackTrace();
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
		    allUsers.writeFile();
		    System.out.println("Congratulations! Your account has been created. ");
		    System.out.println("********");
	    }
	}
	String directions = "To CHECKOUT a book, type 'CHECK OUT'. \nTo RETURN a book, type 'RETURN'.\nTo ADD a book to our directory, type 'ADD'.\nTo SEARCH for a book, type 'SEARCH'.\nTo VIEW the books you have checked out, type 'VIEW'.\n";
	System.out.println("********\nWelcome "+currentUser.getUsername()+"! \n********\n"+directions+"At any point, type 'DIRECTIONS' if you need help.\n******** ");
	while (loggedIn){
	    System.out.print(currentUser.getUsername()+": "); 
	    s= scan.nextLine().toUpperCase();
	    if (s.equals("LOG OUT")){
		library.writeFile();
		allUsers.writeFile();
		loggedIn=false;
	    }
	    else if (s.equals("CHECK OUT")){
		System.out.print("Please enter the title of the book you wish to check out (with proper capitalization): ");
		String title = capitalize(scan.nextLine());
		if(title.isEmpty()){
		    while(title.isEmpty()){
			System.out.print("Please enter a book title: ");
			title = capitalize(scan.nextLine());
		    }
		}

		System.out.print("Please enter the author of the book you wish to check out: ");
		String author = capitalize(scan.nextLine());
		if(author.isEmpty()){
		    while(author.isEmpty()){
			System.out.print("Please enter the author's name: ");
			author = capitalize(scan.nextLine());
		    }
		}

		int bookPos = library.findBook(title,author);
		if (bookPos==-1){
		    System.out.println("********\nThis book does not yet exist.\n********");
		    Book newBook = new Book(title,author);
		    System.out.println("1");
		    library.addBook(newBook);
		    System.out.println("2");
		    bookPos = library.findBook(title,author);
		    System.out.println(title+" has been added.");
		}
		if (library.getBook(bookPos).getStatus()==false){
		    if (currentUser.findBook(title,author)>-1)
			System.out.println("********\nYou have already checked out '"+title+"'. Type 'RETURN' if you would like to return this book.\n********");
		    else {
			System.out.println("********\nSomeone has checked this book out.\nNumber of users ahead of you: "+library.getBook(bookPos).amtWaiters()+"\nYou have been waitlisted.\n********");
			library.getBook(bookPos).addWaitlistUser(currentUser.getUsername());
		    }
		}
		else {	
		    System.out.println("hereeeeeeee");
		    library.checkOut(bookPos);
		    currentUser.addBook(library.getBook(bookPos));
		    System.out.println("You have successfully checked out '"+title+"'!\n********");}
	    }
		

	    else if (s.equals("RETURN")){
		System.out.println("********");
		System.out.print("Title: ");
		String title= scan.nextLine().trim();
		while (s.equals (null)){
		    System.out.println("Title: ");
		    title= scan.nextLine();
		}
		System.out.print("Author: ");
		String author=scan.nextLine().trim();
		while (author.equals(null)){
		    System.out.print("Author");
		    author= capitalize(scan.nextLine());
		}
		int userPos = currentUser.findBook(title, author);
		int libPos = library.findBook(title, author);
		if (userPos>-1){
		    currentUser.removeBook(userPos);
		    /*get next user on queue, check out*/
		    library.setStatusofBook(libPos, true);
		    System.out.println("You have successfully returned the book. ");
		}
		else {
		    System.out.println("You have not checked out this book. To checkout, type 'CHECK OUT'.");
		}
		System.out.println("********");
	    }
	    
	    else if (s.equals ("DIRECTIONS")){
		System.out.println("********\n"+directions+"********");
	    }
	    
	    else if (s.equals ("SEARCH")){
		System.out.println("You can currently only search by title. ");
		System.out.print("Title: ");
		String title=capitalize(scan.nextLine().trim());
		if (library.findBook(title, "")==-1)
		    System.out.println ("The book '"+title+"' does not exist.\nType 'ADD' if you would like to add the book to our directory.\n********");
		else {
		    System.out.println("This book is in our library. Type 'CHECK OUT' in order to check out.\n********");
		}

	    }
	    
	    else if (s.equals("ADD")){
		
		System.out.print("Title: ");

		String title=capitalize(scan.nextLine());
		while(title.equals(null)){
		    System.out.print("Title: ");
		    title= capitalize(scan.nextLine());
		}
		System.out.print("Author: ");
		String author = capitalize(scan.nextLine());
		while (author.equals(null)){
		    System.out.print("Author: ");
		    author=capitalize(scan.nextLine());
		}
		if (library.findBook(title, author)>-1)
		    System.out.println("This book already exists and cannot be added to the library.\n******** ");
		else {
		    Book newB = new Book(title, author);
		    library.addBook(newB);
		}
		
	    }
	    //none of the above options 
	    else {
		System.out.println("'"+s+"' is not a valid operation.");
	    }
	}
	System.out.println("********\nYour information has been updated.\nYou have successfully logged out.\n********");
	//just to add

    }
    
}

