package addressbook;

public final class PersonalContact extends Contact{
    Name name=new Name(null, null);

    /**
       @return return the name.
     */
    public Name getName(){
	return this.name;
    }

    /**
       @param[name] set the name.
     */
    public void setName( Name name){
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
