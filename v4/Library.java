import java.util.*;
import java.io.*;

public class Library {
    

    private ArrayList<Book>  books= new ArrayList<Book>(); 
    private int size ;    
    public Library (){
	makeArray();
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
	//qsort(books);
    }


    public String toString(){ 
	String z="";
	for (int x=0; x<books.size(); x++)
	    z+=(books.get(x)+"\n");
	return z;
    }

    public void Checkout(String title, String author){
	Book welcome = new Book(title, author);
	if (searchBook(books, welcome, 0, size()) == false)
	    addBook(welcome);
    }
	    
	
 
    /*add book to library 
    - check if book already exists
    - place in order*/
    public void addBook(Book hello){
	books.add(hello);
	qsort(books);
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

    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( ArrayList<Book> d ) {
	System.out.println("sorting");
	qsHelp( 0, d.size()-1, d );
    }
    public static void qsHelp( int lo, int hi, ArrayList<Book> d ) {

	if ( lo >= hi )
	    return;

	int tmpLo = lo;
	int tmpHi = hi;
	Book pivot = d.get(lo);

	while( tmpLo < tmpHi ) {
	    //first, slide markers in as far as possible without swaps
	    while( d.get(tmpLo).compareTo(pivot) < 0) {
		System.out.println("2");
		tmpLo++;
	    }
	    while( d.get(tmpHi).compareTo(pivot) > 0) {
		System.out.println("3");
		tmpHi--;
	    }

	    swap( tmpLo, tmpHi, d );
	}

	//pivot has been floating around... plant it where it belongs
	d.set(tmpLo, pivot);

	//recurse on lower and upper ranges
	qsHelp( lo, tmpLo-1, d );
	qsHelp( tmpLo+1, hi, d );

    }//end qsHelp

    public static void swap( int x, int y, ArrayList<Book> o ) {
	Book tmp = o.get(x);
	o.set(x,o.get(y));
	o.set(y, tmp);
    }

    public static boolean searchBook(ArrayList<Book> o, Book target, int lo, int hi){
	boolean found = false;
	int m = (lo + hi) / 2;
	
	while(lo <= hi){
	    if (o.get(m).equals(target)){
		found = true;
		if(o.get(m).getStatus() == true){
		    o.get(m).setStatus(false);
		    System.out.print("Thank you for checking out"+  target.getTitle() + ". We hope you enjoy it!");
		}
		else{
		    System.out.println("We are sorry to inform you that the book that you requested has already been checked out. Would you like to be added to the waiList for the book?");
		}
	    }
	    else if (o.get(m).compareTo(target) > 0)
		hi = m - 1;
	    else if (o.get(m).compareTo(target) < 0)
		lo = m + 1;
	}

	return found;
    }
	    
    /////copied from the basement: (BinSearchIterative function)
    ///used when reading user information
    ///also used when returning a book
    ///used when only position needed
    public  int findBook( String title, String author){
	int tPos = -1, lo=0, hi= books.size();
	
	int m = (lo + hi) / 2; 

	while( lo <= hi ) {
	    m = (lo + hi) / 2;
	    if ( books.get(m).getTitle().compareTo(title)==0 ) 
		return m ;
	    else if ( books.get(m).getTitle().compareTo(title) >0)
		hi = m - 1; 
	    else if ( books.get(m).getTitle().compareTo(title)<0)
		lo = m + 1; 
	    
	}
	return tPos;
    }

    public void returnBook(Book book){
	int pos= findBook(book.getTitle(), book.getAuthor());
	books.get(pos).setStatus(true);
    }
    
    public static void main (String[]args){
	Library test = new Library();
	test.makeArray();
	//Book heya = new Book("Paper Towns, John Green");
	//test.addBook("Paper Towns", "John Green");
	//System.out.println(test
	//System.out.println(test);
    }
    
    
}
