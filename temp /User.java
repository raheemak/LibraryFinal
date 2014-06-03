public class User{
    private String name, username, gender, password;
    
    public User(){
	name= "captain underpants";
	username = "captain28";
	gender= "male";
	password= "123";
    }

    
      public User (String username, String password, String name, 
      String gender, String occupation){
      setName (firstName,lastName);
      setGender(gender);
      setuserName( username);
      setPassword (password);
      }


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

    public void setName (String first, String last){
	name= (first+" "+last);
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
