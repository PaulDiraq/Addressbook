package addressbook;

public interface ContactVisitor{
    public void visit(PersonalContact contact );
    public void visit(CompanyContact contact );


}
