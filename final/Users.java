import java.util.*;
import java.io.*;

public class Users {
    

    private ArrayList<User> users;
    private int size ;
    public Users (){
	users= new ArrayList<User>();
	makeArray();
    }

    //FILE IN FORMAT: 
    //username,, password,, firstName lastName,, gender,, occupation,, firstTitle,, firstAuthor; secondTitle,, secondAuthor>

    //reading csv file
    public void makeArray(){
	try {
	    File file = new File("Users.txt");
	    Scanner doc= new Scanner (file);
	    while (doc.hasNextLine()){
		String line= doc.nextLine();
		if (line.trim().equals(null)){
		}
		String[]split = line.split(",, ");
		users.add(new User(split[0], split[1], split[2],split[3], split[4], split[5]));
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
	qsort(users);
    }
 
    public int size(){
	return users.size();
    }
    
    public User getUser(int pos){
	return users.get(pos);
    }
   
    /////copied from the basement: (BinSearchIterative function)
    /////used to log in ! 

    public  int findUser( String username){
	int tPos = -1, lo=0, hi= users.size();
	int m = (lo + hi) / 2; 

	while( lo <= hi ) {

	    m = (lo + hi) / 2;
	    if (m>= users.size())
		return -1;
	    else if ( users.get(m).getUsername().compareTo(username)==0 ) 
		return m ;
	    else if ( users.get(m).getUsername().compareTo(username) >0)
		hi = m - 1; 
	    else 
		//f ( users.get(m).getUsername().compareTo(username)<0)
		lo = m + 1; 
	}
	return tPos;
    }
    
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    public void writeFile(){
	String newList= "";
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
 
  public static void qsort( ArrayList<User> d ) {
	qsHelp( 0, d.size()-1, d );
    }
    public static void qsHelp( int lo, int hi, ArrayList<User> d ) {

	if ( lo >= hi )
	    return;

	int tmpLo = lo;
	int tmpHi = hi;
	User pivot = d.get(lo);

	while( tmpLo < tmpHi ) {
	    //first, slide markers in as far as possible without swaps
	    while( d.get(tmpLo).getUsername().compareTo(pivot.getUsername()) < 0) 
		tmpLo++;
	    
	    while( d.get(tmpHi).getUsername().compareTo(pivot.getUsername()) > 0) {
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
    
    public static void swap( int x, int y, ArrayList<User> o ) {
	User tmp = o.get(x);
	o.set(x,o.get(y));
	o.set(y, tmp);
    }
    ///////////////////
    public static void main (String []args){
	Users test = new Users();
    }
}
