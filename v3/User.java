public class User{
    private String name, username, gender, password,occupation;
    
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
    

    public String toString(){
	return (username+",, "+password+",, "+name+",, "+gender);
    }
}
