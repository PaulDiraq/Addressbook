package addressbook;
import java.util.ArrayList; // import the ArrayList class
import java.util.Scanner; // import Scanner to read strings from input
/**
   Visitor to implement print_formatted_contact
   prints a contact as formatted block.
 */
class FormattedContactPrintingVisitor implements ContactVisitor {
    // how much the block should be indented.
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
        this.print_indentation(this.indentation); //indent 
	if (name.getFirstName()==null && name.getLastName() != null  ) {
	    System.out.print("Mr./Ms. "); // print Mr./Ms <lastName> if no first name is given
	    System.out.println(name.getLastName()); 
	} else if (name.getLastName()==null) {
	    System.out.println("<anonymous>"); 
	} else {// first name is not null so print <firstName> <lastName>
	    System.out.print(name.getFirstName());
	    if (name.getLastName() != null){
		System.out.println(" "+name.getLastName());
	    } else{
		System.out.println();
	    };
	};

	Address address = contact.getAddress();
	if (address.getStreet() != null){
	    // indent only if street is given since nothing is printed if no street is given
	    this.print_indentation(this.indentation);
	    System.out.print(address.getStreet());
	    if (address.getHouseNumber() != null){
		// print housenumber separated by a space
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
		System.out.println(); //still needing a newline
	    };
	} else if(address.getCity() != null){// falls nur eine city angegeben ist
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
	    // if no name is given, print anonymous instead of a name
	    System.out.println("<anonymous>");
	};

	Address address = contact.getAddress();
	// again, a housenumber alone makes no sense as address. 
	if (address.getStreet() != null || address.getCity() != null || address.getPostcode() != null){
	    this.print_indentation(this.indentation);
	    System.out.print("Seat: ");
	    final int seat_indentation=6;// because "Seat: " has the length 6 this is the additional 
	    if (address.getStreet() != null){
		System.out.print(address.getStreet());
		if (address.getHouseNumber() != null){
		    System.out.print(" "+address.getHouseNumber());
		};
		System.out.println();
		if(address.getPostcode() != null){
		    this.print_indentation(this.indentation+seat_indentation);
		    System.out.print(address.getPostcode());
		    if (address.getCity() != null){
			System.out.print(" "+address.getCity());
		    } ;
		    System.out.println();
		} else if(address.getCity() != null){
		    this.print_indentation(this.indentation+seat_indentation);
		    System.out.println(" "+address.getCity());
		} ;
		
	    }else {// case that address is null
		if(address.getPostcode() != null){
		    System.out.print(address.getPostcode());
		    if (address.getCity() != null){
			System.out.print(" "+address.getCity());
		    } ;
		    System.out.println();
		} else if(address.getCity() != null){
		    System.out.println(" "+address.getCity());
		} ;// omit line if postcode and city is null
	    };
	    Name owner = contact.getOwner();
	    if (owner.getFirstName() != null || owner.getLastName() != null){
		this.print_indentation(this.indentation);
		System.out.print("Owner: ");
		if (owner.getFirstName()==null && owner.getLastName() != null ) {
		    System.out.print("Mr./Ms. ");//if first name is unknown: print Mr./Ms.
		    System.out.println(owner.getLastName());
		} else if (owner.getLastName()==null) {
		    System.out.println("<anonymous>");// if full name is unkown: print <anonymous>
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
   implements visitor pattern
   takes a single search term on construction and visits a contact.
   if the searchterm is found in any field of the contact, has_found returns true afterwards. It returns false otherwise. 
 */

class SearchVisitor implements ContactVisitor{
    String searchTerm;
    Boolean found=false;
    /**
       @param[searchTerm] the searchTerm
    */
    public SearchVisitor(String searchTerm){
	this.searchTerm = searchTerm;
    }
    /**
       @param[contact] the contact to be searcherd
     */
    public void visit(PersonalContact contact){
	Name name = contact.getName();
	//if value is not null check if it contains the search term. Repeat for all fields
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
    /**
       visit method for CompanyContact (see visitor pattern)
       @param[contact] the contact
     */
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

    /**
       @return true if the searchterm was previously found in a visited contact. 
     */
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
	// Initialize scanner, used to get user input.
        Scanner sc = new Scanner(System.in);
	int contact_num = 0;
	boolean status = true;
	if (addresses.size() > 0){
	    System.out.println("Select the  entry you want to delete (enter -1 to cancel):");
	    for (int i = 0; i < addresses.size(); i++) {
		System.out.println("Entry: " + i);
		this.print_formatted_contact(1,this.addresses.get(i));
		// => Needs a function to print a contact
	    }
	    while(true){
		// check if input is a valid integer
		try{
		    contact_num = Integer.parseInt(sc.nextLine());
		} 
		catch (NumberFormatException nfe){
		    System.out.println("Wrong format");
		}
		// if input = -1, cancel delete
		if (contact_num == -1 ){
		    System.out.println("Successfully canceled!");
		    status = false;
		    break;
		}
		// if contact num is out of bounds, print "error message" and try again (=> while loop)
		if(contact_num >= addresses.size()){
		    System.out.println("Entry is not part of addressbook!");
		}
		// selected contact is deleted
		else{
		    System.out.println("Entry " + contact_num + " was deleted");
		    addresses.remove(contact_num);
		    status = true;
		    break;
		}
	    }
	    
    	}
	// catch empty Addressbook
	else{
	    System.out.println("Not possible to delete. Addressbook is empty.");
	    status = false;
	}
	// close scanner, gave error in VSCode without
	sc.close();
	// returns boolean if delete was successful
	return status;
    }

    /**
       adds  a new contact.
       @return true if addContact was successful false otherwise
     */
    public void addContact(){
		// Initialize scanner, used to get user input.
        Scanner sc = new Scanner(System.in);
	Name name = new Name("","");
	String firstName;
	String lastName;
	String companyName;
        Name owner = new Name("","");
        Address address;
        String chosenOption;
		System.out.println("What kind of contact do you want to add? 1: Person 2: Company");
        chosenOption = sc.nextLine();
	// if 1 was entered, a PersonalContact is created
	if (chosenOption.equals("1")){
	    // Add Name
	    PersonalContact person = new PersonalContact();
	    System.out.println("Enter the first name:");
	    firstName = sc.nextLine();
	    name.setFirstName(firstName);
	    System.out.println("Enter the last name:");
	    lastName = sc.nextLine();
	    name.setLastName(lastName);
	    person.setName(name);
			// Add address
	    address = buildAddress(sc);
	    person.setAddress(address);
	    addresses.add(person); 
	}
	// if 2 was entered, a CompanyContact is created
	else if (chosenOption.equals("2")){
	    // Add Name
	    CompanyContact person = new CompanyContact();
	    System.out.println("Enter the Owners' first name:");
	    firstName = sc.nextLine();
	    owner.setFirstName(firstName);
	    System.out.println("Enter the Owners' last name:");
	    lastName = sc.nextLine();
	    owner.setLastName(lastName);
	    person.setOwner(owner);
	    System.out.println("Enter the Companys' name:");
	    companyName = sc.nextLine();
	    person.setName(companyName);
	    // Add address
	    address = buildAddress(sc);
	    person.setAddress(address);
	    addresses.add(person); 
	}
	else{System.out.println("Invalid input!");}
    }
    
    /**
       prints all contacts.
     */
    public void printContacts(){
	System.out.println("printing Addressbuch");
	int i = 0;
	for(Contact contact : this.addresses){
	    System.out.println("Entry: "+i);
	    i+=1;
	    this.print_formatted_contact(1,contact);
	};
    }

    /**
       searches for a String in all addresses.
       @param the string to be searched for
       @return true if search finds an entry false otherwise
     */
    public boolean search(String search_expression){
	boolean found = false;
	System.out.println("searching for " + search_expression);
	int ientry = 0;
	for (Contact contact : this.addresses){
	    //for every contact look if value of the contact matches the search expression.
	    // the SearchVisitor does this
	    SearchVisitor visitor = new SearchVisitor(search_expression);
	    contact.accept(visitor);
	    if (visitor.has_found()){
		System.out.println("Found entry "+ientry+" :");
		this.print_formatted_contact(1,contact);
		found = true;
	    }
	    ientry +=1;
	}
	if (!found){
	    System.out.println("No matching entry found.");
	}
	return found;
    }
    
	// helper method to get adress for addContact
    private Address buildAddress(Scanner sc) {
        String city;
        int postcode;
        String street;
        int houseNumber;
	
        System.out.println("What is the address of your contact?");
        // get the city via user input
        System.out.println("Enter a city:");
        city = sc.nextLine();
        //  if no city is given, set to null
        if (city.equals("")){
            city = null;
        }
        // get the postcode via userinput
        while(true){
            System.out.println("Enter a postcode:");
            String postcodeString = sc.nextLine();
            // if no postcode is given, set to 0
            if (postcodeString.equals("")){
                postcode = 0;
                break;
            }
            // else, convert input to Integer. 
			// If a wrong format string is given an error is raised and another
            // input can be given
            else{
                try {
                    postcode = Integer.parseInt(postcodeString);
                    break;
                }catch(NumberFormatException nfe){
                    System.out.println("Wrong format");
                }
            }
        }
        // get the street name via user input
        System.out.println("Enter a street:");
        street = sc.nextLine();
        // if no street is given, set street to null
        if (street.equals("")){
            street = null;
        }
        // same procedure as with postcode.
        while(true){
            System.out.println("Enter the house number:");
            String houseNumberString = sc.nextLine();
            if (houseNumberString.equals("")){
                houseNumber = 0;
                break;
            }
            else{
                try {
                    houseNumber = Integer.parseInt(houseNumberString);
                    break;
                }catch(NumberFormatException nfe){
                    System.out.println("Wrong format");
                }
            }
        }
        Address address = new Address(city,postcode,street,houseNumber);
        return address;
    }

}



