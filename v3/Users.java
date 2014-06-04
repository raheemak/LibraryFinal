import java.util.*;
import java.io.*;

public class Users {
    

    private ArrayList<User> users;
    private int size ;
    public Users (){
	users= new ArrayList<User>();
	makeArray();
    }

    //reading csv file
    public void makeArray(){
	try {
	    File file = new File("Users.txt");
	    Scanner doc= new Scanner (file);
	    while (doc.hasNextLine()){
		String line= doc.nextLine();
		if (line.equals(null)){
		}
		String[]split = line.split(",, ");
		users.add(new User(split[0], split[1], split[2],split[3], split[4]));

	    }
	}

	catch (FileNotFoundException e ){
	    System.out.println("boo");
	}
    }


    public String toString(){
	String z="";
	for (int x=0; x<users.size(); x++)
	    z+=(users.get(x)+"\n");
	return z;
    }
 
   
    public void addUser(User newUser){
	users.add(newUser);
	String newList="";
	for (int x=0; x<users.size(); x++)
	    newList+=(users.get(x)+"\n");
	try{
	    FileWriter fstream = new FileWriter("Users.txt");
	    BufferedWriter out = new BufferedWriter(fstream);
	    out.write(newList);
	    out.close();
	}
	catch (Exception e){
	    System.err.println("boo");
	}
    }
 
    public int size(){
	return users.size();
    }

    public static void main (String[]args){
	Users test = new Users();
	System.out.println(test);
    }
    
    
}
