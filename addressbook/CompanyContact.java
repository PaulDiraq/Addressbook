package addressbook;

/**
   represents a contact of a company.
   a company
   has a name (which can be null)
   an address (which can be Address(null,null,null,null))
   an owner (represented by a name which can be Name(nul,null))

   Note:  only the default constructor CompanyContact() is available,
   all attributes have to be set afterwards.
 */  
 final class CompanyContact extends Contact{
    String name = null;
    Name owner=new Name(null, null);

    /**
       @return return the name of the owner. never returns null.
     */
     Name getOwner(){
	return this.owner;
    }

    /**
       @param[name] set the name of the owner if null is given, Name(null,null).
     */
     void setOwner( Name owner){
	if (owner == null){
	    owner = new Name(null, null);
	};
	this.owner=owner;
    }
    /**
       @return return the name. is never null
     */
     String getName(){
	return this.name;
    }

    /**
       @param[name] set the name. 
     */
     void setName( String name){
	this.name=name;
    }
 
    /**
       @return string representation of the contact.
     */
    @Override
    public String toString(){
	name = "<>";
	if (this.name != null){
	    name = this.name;
	};
	return name+ " ("+this.owner.toString() +") "+this.address.toString();
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
