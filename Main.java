import addressbook.Addressbook;
import addressbook.Address;
import addressbook.Name;
import addressbook.PersonalContact;


public class Main{

    private static void test_proc(){
	Addressbook addressbook = new Addressbook();
	addressbook.addContact();
	addressbook.printContacts();
	addressbook.search("Christian-Albrechts-Platz");
	addressbook.deleteContact();

    }
    public static void main(String[] args){
	test_proc();
    }
}
