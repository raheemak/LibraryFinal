import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String[] args){
	System.out.println("Hello and welcome to the-fab-tria Library. We are a new and up in coming library that has been opened for the community. Feel free to become a member to check out books, sign up on wait lists for books you care to read that are not available, and even send us requests for books we can add to our library. All in all we hope you have a great experience and read on!");
	System.out.print("Would you like to sign up to become a member? Please type 'y' for yes or n for 'no': ");
	Scanner scan = new Scanner(System.in);
	String s = scan.nextLine();
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
	    first = first.toLowerCase();
		    
	    System.out.print("Please enter your last name: ");
	    String last = scan.nextLine();

	    if(last.isEmpty()){
		while(last.isEmpty()){
		      System.out.println("Please enter a valid last name: ");
		      last = scan.nextLine();
		}
	    }
	    last = last.toLowerCase();
		    
	    System.out.print("Please enter your gender: female or male: ");
	    String gender = scan.nextLine().toLowerCase();
	    if(!(gender.equals("female") || gender.equals("male")) || gender.isEmpty()){
		while(!(gender.equals("female") || gender.equals("male")) || gender.isEmpty()){
		      System.out.println("Please enter your gender: ");
		      gender = scan.nextLine().toLowerCase();
		}
	    }

		    
	    System.out.print("Please enter your occupation: professor, student, etc.: ");
	    String occupation = scan.nextLine();
	    if(occupation.isEmpty()){
		while(occupation.isEmpty()){
		      System.out.println("Please enter your occupation: ");
		      occupation = scan.nextLine();
		}
	    }
	    occupation = occupation.toLowerCase();
	    
	    
	    System.out.print("Enter a username: ")

	    String username  = scan.nextLine();
	    if(occupation.isEmpty()){
		while(occupation.isEmpty()){
		      System.out.println("Enter a  ");
		      username = scan.nextLine();
		}
	    }
	    
	    


	    System.out.println(first);
	    System.out.println(last);
	    System.out.println(gender);
	    System.out.println(occupation);
	}
    }
}
