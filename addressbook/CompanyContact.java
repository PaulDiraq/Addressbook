package addressbook;

public final class CompanyContact extends Contact{
    String name = null;
    Name owner=new Name(null, null);

    /**
       @return return the name.
     */
    public Name getOwner(){
	return this.owner;
    }

    /**
       @param[name] set the name.
     */
    public void setOwner( Name owner){
	if (owner == null){
	    owner = new Name(null, null);
	};
	this.owner=owner;
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
