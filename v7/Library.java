import java.util.*;
import java.io.*;

public class Library {
    

    private ArrayList<Book>  books= new ArrayList<Book>(); 
    private int size ;    
    public Library (){
	makeArray();
	writeFile();
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
		books.add(new Book(split[0], split[1],split[2],split[3]));
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
    
    public void checkOut(int pos){
	//user only needed when waitlisting
	Book book= books.get(pos);
	book.setStatus(false);
    }	
    
    /*add book to library 
      - check if book already exists
      - place in order*/
    public void addBook(Book hello){
    	if (findBook(hello.getTitle(), hello.getAuthor())==-1){
	    books.add(hello);
	    qsort(books);
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
		//System.out.println("2");
		tmpLo++;
	    }
	    while( d.get(tmpHi).compareTo(pivot) > 0) {
		//System.out.println("3");
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
    //qsort taken from the basement!

    public static void swap( int x, int y, ArrayList<Book> o ) {
	Book tmp = o.get(x);
	o.set(x,o.get(y));
	o.set(y, tmp);
    }
    //////////////////////////////////////////////////////////////////////
  
/////copied from the basement: (BinSearchIterative function)
    ///used when reading user information
    ///also used when returning a book
    ///used when only position needed
    public  int findBook( String title, String author){
	int tPos = -1, lo=0, hi= books.size();

	int m = (lo + hi) / 2; 

	while( lo <= hi ) {
	    m = (lo + hi) / 2;
	    if (m>= books.size())
		return -1;
	    if ( books.get(m).getTitle().compareTo(title)==0 ) 
		return m ;
	    else if ( books.get(m).getTitle().compareTo(title) >0)
		hi = m - 1; 
	    else if ( books.get(m).getTitle().compareTo(title)<0)
		lo = m + 1; 

	}
	return tPos;
    }

    public void setStatusofBook(int pos, boolean status){
	books.get(pos).setStatus(status);
    }
    //when a book is returned to the library
    public void returnBook(Book book){
	int pos= findBook(book.getTitle(), book.getAuthor());
	books.get(pos).setStatus(true);
    }
    //in order to get a book by position

    public Book getBook(int pos){
	return books.get(pos);
    }
    public void writeFile(){
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
    
    
    public static void main (String[] args){
	Library test = new Library();
	test.addBook(new Book("the fault in ouur stars", "john green"));
	test.writeFile();
	//System.out.println(test);
        //test.writeFile();
    }
    
    
}
