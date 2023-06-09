package addressbook;
import java.util.ArrayList;

class FormattedContactPrintingVisitor implements ContactVisitor {
    int indentation;
    public FormattedContactPrintingVisitor(int indentation){
	this.indentation=indentation;
    }
    private void print_indentation(int indentation){
	for (int i=0; i<indentation ; ++i){
	    System.out.print(" ");
	};
    };
    public  void visit(PersonalContact contact){
       
	Name name = contact.getName();
        this.print_indentation(this.indentation);
	if (name.getFirstName()==null && name.getLastName() != null  ) {
	    System.out.print("Mr./Ms. ");
	    System.out.println(name.getLastName());
	} else if (name.getLastName()==null) {
	    System.out.println("<anonymous>");
	} else {// first name is not null
	    System.out.print(name.getFirstName());
	    if (name.getLastName() != null){
		System.out.println(" "+name.getLastName());
	    } else{
		System.out.println();
	    };
	};

	Address address = contact.getAddress();
	if (address.getStreet() != null){
	    this.print_indentation(this.indentation);
	    System.out.print(address.getStreet());
	    if (address.getHouseNumber() != null){
		System.out.print(" "+address.getHouseNumber());
	    };
	    System.out.println();
	}else {
	    // printing a housenumber without street makes no sense, so we don't even try.
	};
	if(address.getPostcode() != null){
	    this.print_indentation(this.indentation);
	    System.out.print(address.getPostcode());
	    if (address.getCity() != null){
		System.out.println(" "+address.getCity());
	    } else{
		System.out.println();
	    };
	} else if(address.getCity() != null){
	    System.out.println(" "+address.getCity());
	}  ;
    }
    public  void visit(CompanyContact contact){
	System.out.println("company");
    }
}


public class Addressbook{
    private ArrayList addresses;
    public static void print_formatted_contact(int indentation, Contact contact){
	contact.accept(new   FormattedContactPrintingVisitor(indentation));
    }
    public String toString(){
	return "Addressbook"; //TODO implement it somehow.
    }

    /**
       deletes a contact.
       @return true if deleteContact was successful false otherwise
     */
    public boolean deleteContact(){
	//TODO
	return false;
    }
    /**
       adds  a new contact.
       @return true if addContact was successful false otherwise
     */
    public boolean addContact(){
	//TODO
	return false;
    }
    
    /**
       prints all contacts.
     */
    public void printContacts(){
	//TODO
    }

    /**
       searches for a String in all addresses.
       @param the string to be searched for
       @return true if search finds an entry false otherwise
     */
    public boolean search(String search_expression){
	//TODO
	return false;
    }
    
}


