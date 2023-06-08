package addressbook;

public final class PersonalContact extends Contact{
    Address address=new Address(null, null, null, null);
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
       @return return the address.
    */
    public Address getAddress(){
	return this.address;
    }

    /**
       @param[address] set the address.
    */
    public void setAddress( Address address){
	if (address == null){
	    address = new Address(null, null, null, null);
	};
	this.address=address;
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
