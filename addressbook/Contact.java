package addressbook;


 abstract class Contact{
    Address address=new Address(null, null, null, null);

    
    /**
       @return return the address.
    */
     Address getAddress(){
	return this.address;
    }

    /**
       @param[address] set the address.
    */
     void setAddress( Address address){
	if (address == null){
	    address = new Address(null, null, null, null);
	};
	this.address=address;
    }

    /**
       accept a contact 
       @param[visitor] the visitor
     */
    abstract void accept(ContactVisitor visitor);
    /**
       @return returns a String representation of the contact.
     */
     public abstract  String toString();

}
