import java.util.*;
import java.io.*;

public class Library {
    

    private ArrayList<Book>  books= new ArrayList<Book>(); 
    private int size ;    
    public Library (){
	books= new ArrayList();
    }

    //reading csv file 
    public  void  makeArray(){
	//236 books, 2 fields each 
	try {
	    File file = new File("Books.txt");
	    Scanner doc= new Scanner (file);
	    while (doc.hasNextLine()){
		String line= doc.nextLine();
		if (line.equals(null)){
		}
		String[]split = line.split(",, ");
		books.add(new Book(split[0], split[1]));
		    }
	}
	
	catch (FileNotFoundException e ){
	    System.out.println("boo");
	}
    }


    public String toString(){ 
	String z="";
	for (int x=0; x<books.size(); x++)
	    z+=(books.get(x)+"\n");
	return z;
    }
 
    /*add book to library 
    - check if book already exists
    - place in order*/
    public void addBook(String title, String author){
    	books.add(new Book(title, author));
	String newList="";
	for (int x=0; x<books.size(); x++)
	    newList+=(books.get(x)+"\n");
	try{
	    FileWriter fstream = new FileWriter("Books.txt");
	    BufferedWriter out = new BufferedWriter(fstream);
	    out.write(newList);
	    out.close();
	}
	catch (Exception e){
	    System.err.println("boo");
	}
    }
 
    public int size(){
	return books.size();
    }

    public static void main (String[]args){
	Library test = new Library();
	test.makeArray();
	test.addBook("The Fault In Our Stars", "John Green");
	System.out.println(test);
    }
    
    
}



