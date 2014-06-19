import java.util.*;
import java.io.*;

public class Book implements Comparable<Book> {

    private String title;
    private String author;
    private boolean available;
    private ArrayList<String> waitListers=new ArrayList<String>();;

    public Book(String name, String writer) {
	title = capitalize(name);
	author = capitalize(writer);
	available = true;
    }
									
    public Book(String name, String writer, String a, String waitlist) {
	title = capitalize(name);
	author = capitalize(writer);
	available = (a.equals(true));
	makeList(waitlist);
    }
    
    public void makeList(String waitList){
	String[]listers=(waitList.substring(1,waitList.length()-1)).split("; ");
	for (int x=0; x<listers.length;x++){
	    if (listers[x].length()>0)
		waitListers.add(listers[x]);
	}
    }

    public boolean hasNext(){
	return waitListers.size()>0;
    }

    public String getNext(){
	return waitListers.get(0);
    }

    public void addUser(String s){
	waitListers.add(s);
    }
    
    public String getTitle(){
	return title;
    }

    public String getAuthor(){
	return author;
    }

    public boolean getStatus(){
	return available;
    }

    public void setStatus(boolean hello){
	available = hello;
    }

    public void removeUser(){
	waitListers.remove(0);
    }

    public int amtWaiters(){
	return waitListers.size();
    }

    public boolean isEmpty(){
	return waitListers.isEmpty();
    }

    public String toString(){
    	return (getTitle() + ",, "+ getAuthor()+ ",, " + getStatus() + ",, " +printUsers());
    }

    public int compareTo(Book v){
	int temp=  this.getTitle().compareTo(v.getTitle());
	if (temp==0)
	    return this.getAuthor().compareTo(v.getAuthor());
	else 
	    return temp;
    }
	   
    public String printUsers(){
	String all = "<";
	for (int x=0 ; x<waitListers.size(); x++){ 
	    all+=waitListers.get(x);
	    if (x!= (waitListers.size()-1))
		all+="; ";
	}
    	all+=">";
	return all;
    }
    
    public static String capitalize (String str){
	String[]arr= str.split(" ");
	String fin = "";
	for (int x=0; x<arr.length; x++){
	    String curr= arr[x];
	    if (curr.length()>0){
		fin+=curr.substring(0,1).toUpperCase().trim();
		String s= curr.substring(1);
		for ( int y=0; y<s.length(); y++)
		    fin+=s.substring(y,y+1).toLowerCase();
		fin+=" ";
	    }
	}
	fin=fin.trim();
	return fin;
    }

    public void addWaitlistUser(String username){
	waitListers.add(username);
    }
	
    public static void main(String[] args){
	Book newbook = new Book("dj", "d", "true", "<>");
	newbook.addUser("huh");
	System.out.println(newbook);
    }
}
