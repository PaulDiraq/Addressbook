package addressbook;
import java.util.ArrayList;
/**
   Visitor to implement print_formatted_contact
   prints a contact as formatted block.
 */
class FormattedContactPrintingVisitor implements ContactVisitor {
    int indentation;
    public FormattedContactPrintingVisitor(int indentation){
	this.indentation=indentation;
    }
    /**
       prints indentation number of empty spaces
       @param[indentation] the indentation level
     */
    private void print_indentation(int indentation){
	for (int i=0; i<indentation ; ++i){
	    System.out.print(" ");
	};
    };
 
    /**
      prints a formatted PersonalContact
      @param[contact] the contact
     */
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
	     this.print_indentation(this.indentation);
	     System.out.println(address.getCity());
	}  ;
    }
    /**
      prints a formatted CompanyContact
      @param[contact] the contact
     */    
    public  void visit(CompanyContact contact){
	this.print_indentation(this.indentation);
	if (contact.getName() != null){
	    System.out.println(contact.getName());
	} else {
	    System.out.println("<anonymous>");
	};

	Address address = contact.getAddress();
	if (address.getStreet() != null || address.getCity() != null || address.getPostcode() != null){
	    this.print_indentation(this.indentation);
	    System.out.print("Seat: ");
	    if (address.getStreet() != null){
		System.out.print(address.getStreet());
		if (address.getHouseNumber() != null){
		    System.out.print(" "+address.getHouseNumber());
		};
		System.out.println();
		if(address.getPostcode() != null){
		    this.print_indentation(this.indentation+6);
		    System.out.print(address.getPostcode());
		    if (address.getCity() != null){
			System.out.println(" "+address.getCity());
		    } else{
			System.out.println();
		    };
		} else if(address.getCity() != null){
		    this.print_indentation(this.indentation+6);
		    System.out.println(" "+address.getCity());
		} ;
		
	    }else {
		if(address.getPostcode() != null){
		    System.out.print(address.getPostcode());
		    if (address.getCity() != null){
			System.out.println(" "+address.getCity());
		    } else{
			System.out.println();
		    };
		} else if(address.getCity() != null){
		    System.out.println(" "+address.getCity());
		} ;
	    };
	    Name owner = contact.getOwner();
	    if (owner.getFirstName() != null || owner.getLastName() != null){
		this.print_indentation(this.indentation);
		System.out.print("Owner: ");
		if (owner.getFirstName()==null && owner.getLastName() != null ) {
		    System.out.print("Mr./Ms. ");
		    System.out.println(owner.getLastName());
		} else if (owner.getLastName()==null) {
		    System.out.println("<anonymous>");
		} else {// first name is not null
		    System.out.print(owner.getFirstName());
		    if (owner.getLastName() != null){
			System.out.println(" "+owner.getLastName());
		    } else{
			System.out.println();
		    };
		};
	        
	    } 
	}
    }
}

/**
   Visitor for search.
 */

class SearchVisitor implements ContactVisitor{
    String searchTerm;
    Boolean found=false;
    public SearchVisitor(String searchTerm){
	this.searchTerm = searchTerm;
    }

    public void visit(PersonalContact contact){
	Name name = contact.getName();
	if (name.getFirstName() != null && name.getFirstName().contains(this.searchTerm)){
	    this.found = true;
	    return;
	}
    	if (name.getLastName() != null && name.getLastName().contains(this.searchTerm)){
	    this.found = true;
	    return;
	}
	Address address = contact.getAddress();
    	if (address.getStreet() != null && address.getStreet().contains(this.searchTerm)){
	    this.found = true;
	    return;
	}
	if (address.getCity() != null && address.getCity().contains(this.searchTerm)){
	    this.found = true;
	    return;
	}
	if (address.getHouseNumber() != null && address.getHouseNumber().toString().contains(this.searchTerm)){
	    this.found = true;
	    return;
	}
	if (address.getPostcode() != null && address.getPostcode().toString().contains(this.searchTerm)){
	    this.found = true;
	    return;
	}
    }
    
    public void visit(CompanyContact contact){
	if(contact.getName() != null && contact.getName().contains(this.searchTerm)){
	    this.found = true;
	    return;
	}
	Name name = contact.getOwner();
	if (name.getFirstName() != null && name.getFirstName().contains(this.searchTerm)){
	    this.found = true;
	    return;
	}
    	if (name.getLastName() != null && name.getLastName().contains(this.searchTerm)){
	    this.found = true;
	    return;
	}
	Address address = contact.getAddress();
    	if (address.getStreet() != null && address.getStreet().contains(this.searchTerm)){
	    this.found = true;
	    return;
	}
	if (address.getCity() != null && address.getCity().contains(this.searchTerm)){
	    this.found = true;
	    return;
	}
	if (address.getHouseNumber() != null && address.getHouseNumber().toString().contains(this.searchTerm)){
	    this.found = true;
	    return;
	}
	if (address.getPostcode() != null && address.getPostcode().toString().contains(this.searchTerm)){
	    this.found = true;
	    return;
	}
    }
    public Boolean has_found(){
	return this.found;
    };
}


public class Addressbook{
    private ArrayList<Contact> addresses=new ArrayList<Contact>();
    /**
       helper function to print a single contact in a multiline block.
       @param[indentation ]  the level by which the block should be indented.
       @param[contact] the contact to be printed.
     */
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
	boolean found = false;
	for (Contact contact : this.addresses){
	    SearchVisitor visitor = new SearchVisitor(search_expression);
	    contact.accept(visitor);
	    if (visitor.has_found()){
		this.print_formatted_contact(1,contact);
		found = true;
	    }
	}
	return found;
    }
    
}


