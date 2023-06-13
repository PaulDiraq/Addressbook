import addressbook.Addressbook;


public class Main{

    private static void test_proc(){
	Addressbook addressbook = new Addressbook();
	addressbook.addContact();
	addressbook.printContacts();
	addressbook.search("Christian-Albrechts-Platz");
	addressbook.deleteContact();
    }
    
    
    /**
       the main function
     */
    public static void main(String[] args){
	test_proc();
    }
}
