public class User{
    private String firstName, lastName, username, gender, password;
    
    public Character(){
	firstName= "captain";
	lastName= "underpants";
	username = "captain28";
	gender= "male";
	password= "123";
    }

    /*
    public Character (String firstName, String lastName, String username, 
		      String gender, String password){
	setName (firstName,lastName);
	setGender(gender);
	setuserName( username);
	setPassword (password);
	}*/


    //setters & getters 

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

    public void setGender (String g){
	gender =g ;
    }
    public void setName (String fn, String ln ){
	firstName= fn;
	lastName= ln;
    }

    public String getName(){
	return firstName+ " "+lastName;
    }

    public String getUsername(){
	return username;
    }

    public String getPassword(){
	return password;
    }

}
