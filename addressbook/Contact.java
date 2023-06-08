package addressbook;


public abstract class Contact{
    /**
       accept a contact 
       @param[visitor] the visitor
     */
    abstract void accept(ContactVisitor visitor);
    /**
       @return returns a String representation of the contact.
     */
    public abstract String toString();

}
