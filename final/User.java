import java.util.*;
import java.io.*;

public class User{
    private String name, username, gender, password,occupation;
    private ArrayList<Book> checkedOut= new ArrayList<Book>(); 
    private Library library= new Library ();
    
    public User(){
	name= "captain underpants";
	username = "captain28";
	gender= "male";
	password= "123";
	occupation ="superhero";
	addBook(new Book("l","ss"));
	addBook(new Book("enxklnk","ss"));
    }
    public void addBook(Book newB){
	checkedOut.add(newB);
    }
    
    public User (String username, String password, String name, 
		 String gender, String occupation, String books){
	setName (name);
	setGender(gender);
	setUsername( username);
	setPassword (password);
	setOccupation (occupation);
	setBooks( books);
    }
    
    ///example: "<Book One,, Author One; Book Two,, Author Two>";
    public  void  setBooks(String strBooks){
	//if there are books
	if (strBooks.length()>2){
	    //split into array of books
	    String[]books= (strBooks.substring(1, strBooks.length()-1)).split(";; ");
	    for (int x=0; x<books.length; x++){
		//make array [title, author]
		String[]currBook= books[x].split("; ");
		//find book from library (by title and author)  and then add to array 
		checkedOut.add(library.getBook(library.findBook(currBook[0], currBook[1])));
	    }
	}
    }
    
    public int findBook(String title, String author){
	System.out.println("title: "+title);
	for (int x=0 ; x<checkedOut.size(); x++){
	    if (checkedOut.get(x).getTitle().equals(title))
		return x;
	}
	return -1;
    }
    
    
    public Book getBook(int pos){
	return checkedOut.get(pos);
    }
    public void removeBook(int pos ){
	checkedOut.remove(pos);
    }
    
    //setters & getters 
    public ArrayList<Book> getBooks(){
	return checkedOut;
    }

    public void setOccupation (String oc){
	occupation= oc;
    }

    public void  setPassword(String pw){
	password= pw;
    }

    public void  setUsername(String un){
	username= un;
    }

    public void setName (String newName ){
	name= newName;
}	

    public void setGender (String g){
	gender =g ;
    }

    public String getName(){
	return name;
    }

    public String getUsername(){
	return username;
    }

    public String getPassword(){
	return password;
    }

    public String printBooks(){
	String all = "<";
	for (int x=0 ; x<checkedOut.size(); x++){
	    all+=checkedOut.get(x).getTitle();
	    all+= "; ";
	    all+= checkedOut.get(x).getAuthor();
	    if (x!= (checkedOut.size()-1))all+=";; ";
	}
    	all+=">";
	return all;
    }

    public String toString(){
	return (username+",, "+password+",, "+name+",, "+
		gender + ",, "+occupation+",, "+ printBooks());
    }
   
    public int sizeCheckedOut(){
	return checkedOut.size();
    }
    public String viewCheckedOut(){
	if (checkedOut.size()==0)
	    return "--\nYou have not checked out any books.\n--";
	String finale="";
	for (int x=0; x<checkedOut.size(); x++)
	    finale +=((x+1)+". '"+checkedOut.get(x).getTitle()+"'; By:"+checkedOut.get(x).getAuthor()); 
	return finale;
    }
    
 
}
