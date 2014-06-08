import java.util.*;

public class User{
    private String name, username, gender, password,occupation;
    private ArrayList<Book> checkedOut= new ArrayList<Book>(); 
    
    public User(){
	name= "captain underpants";
	username = "captain28";
	gender= "male";
	password= "123";
    }

    
    public User (String username, String password, String name, 
		 String gender, String occupation){
	setName (name);
	setGender(gender);
	setUsername( username);
	setPassword (password);
	setOccupation (occupation);
    }


    //setters & getters 


    public void setOccupation (String oc){
	occupation= oc;
    }

    public void  setPassword(String pw){
	password= pw;
    }

    public boolean setUsername(String un){
	/*check whether username is available 
	  if (taken)
	  return false;
	*/
       	username= un;
	return true;
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
	    all+= ",, ";
	    all+= checkedOut.get(x).getAuthor();
	    if (x!= (checkedOut.size()-1))all+="; ";
	}
    	all+=">";
	return all;
    }

    public String toString(){
	return (username+",, "+password+",, "+name+",, "+
		gender + ",, "+occupation+",, "+ printBooks());
    }
}
