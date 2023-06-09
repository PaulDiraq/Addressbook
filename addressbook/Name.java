package addressbook;

/**
   class to represent a name
   consists of a first name and last name (which can be null) 
 */
 class Name{
    private String firstName=null; //can be null 
    private String lastName=null;  // can  be null
    /**
       @param[firstName] the first name (may be null)
       @param[lastName] the last name (may be null)
     */
     Name(String firstName, String lastName){
	this.firstName = firstName;
	this.lastName = lastName;
    }
    /**
       @return the stored first name
     */
     String getFirstName(){
	return this.firstName;
    }
    /**
       @return the last name
     */
     String getLastName(){
	return this.lastName;
    }
    /**
       @param a new first name
     */
     void setFirstName(String firstName){
	this.firstName=firstName;
    }
    
    /**
       @param a new last name
     */
     void setLastName(String lastName){
	this.lastName=lastName;
    }

    /**
       @return the name as a string "\<no name\>" falls der Name Null ist.
     */
     public String toString(){
	String ret = "";
	if (this.firstName != null){
	    ret += this.firstName+" "; 
	}else{
	    ret += "<> ";
	};
	
	if (this.lastName != null){
	    ret += this.lastName; 
	}else{
	    ret += "<>";
	};
	if (ret.equals("<> <>")){
	    ret = "<no name>";
	};
	return ret;
    }
}
