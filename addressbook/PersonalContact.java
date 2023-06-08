package addressbook;

public class PersonalContact implements Contact{
    public void accept(ContactVisitor visitor){
	visitor.visit(this);
    }

}
