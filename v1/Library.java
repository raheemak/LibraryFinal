import java.util.*;
import java.lang.*;

public class Library {
//reading csv file 

    ArrayList books; 
    String[][ ] list;
    public Library (){
	books= new ArrayList();
	for (int x=0; x<list.length; x++){
	}
    }

    public String   makeArray(){
	//98 books, 2 fields each 
	File file = new File("Books.txt")
	list = new String[98][2];
	int index=0;
	Scanner doc= new Scanner (file);
	while (doc.hasNextLine()){
	    String line= doc.nextLine();
	    String[]split = line.subString(line.indexOf(".")).split(", ");
	    list[index]= split;
	    index++;
	}
	return list.toString();
    }

    public static void main (String[]args){
	Library temp= new Library();
	System.out.println(temp.makeArray());
    }
    
}



