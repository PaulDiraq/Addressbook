import addressbook.Name;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class TestName{
    @Test
    void test_2_names(){
	Name name = new Name("Hans", "Jürgen");
	assertEquals(name.getFirstName(),"Hans");
	assertEquals(name.getLastName(),"Jürgen");
	assertEquals(name.toString(), "Hans Jürgen");
	
    }
    
    @Test
    void test_no_name(){
	Name name = new Name(null, null);
	assertNull(name.getFirstName());
	assertNull(name.getLastName());
	assertEquals(name.toString(), "<no name>");
    }
    @Test
    void set_name(){
	Name name = new Name(null, null);
	assertNull(name.getFirstName());
	assertNull(name.getLastName());
	name.setLastName("Hull");
	assertNull(name.getFirstName());
	assertEquals(name.getLastName(),"Hull");
	assertEquals(name.toString(), "<> Hull");
	name.setFirstName("Heinrich");
	assertEquals("Heinrich",name.getFirstName());
	assertEquals("Hull",name.getLastName());
	assertEquals("Heinrich Hull",name.toString() );
    }

}
