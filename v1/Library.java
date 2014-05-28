import java.util.*;
import java.io.*;

public class Library {
//reading csv file 

    ArrayList books; 
    //String[][ ] list;
    public Library (){
	books= new ArrayList();
    }

    public static String  makeArray(){
	//98 books, 2 fields each 

	String [][]list = new String[101][2];
	int index=0;

	try {
	    File file = new File("Books.txt");
	    Scanner doc= new Scanner (file);
	    while (doc.hasNextLine()){
		String line= doc.nextLine();
		String[]split = (line.substring(line.indexOf(".")+2)).split(", by ");
		list[index]= split;
		index++;
	    }
	}
	
	catch (FileNotFoundException e ){
	    return "boo";
	}

	String z="{";

	for (int x=0; x<100; x++){
	    z+="{";
	    z+=list[x][0];
	    z+=",";
	    z+=list[x][1];
	    z+="}";
	}
	z+="}";
	return z;
    }

    public static void main (String[]args){
	System.out.println(makeArray());
    }
    
}



