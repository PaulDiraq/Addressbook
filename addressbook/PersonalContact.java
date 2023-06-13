package addressbook;


/**
   Represents a Contact to a Person.
   A Personal Contact has
   an address (which can be Address(null,null,null, null)
   a name (which can be Name(null,null)
 */
 final class PersonalContact extends Contact{
    Name name=new Name(null, null);

    /**
       @return return the name. is never null
     */
     Name getName(){
	return this.name;
    }

    /**
       @param[name] set the name.
     */
     void setName( Name name){
	if (name == null){
	    name = new Name(null, null);
	};
	this.name=name;
    }
    /**
       @return string representation of the contact.
     */
    @Override
     public String toString(){
	return this.name.toString() +", "+this.address.toString();
    }
    /**
       accept method to accept a visitor.
       @param[visitor] the visitor.
    */
    @Override
    void accept(ContactVisitor visitor){
	visitor.visit(this);
    }

}
