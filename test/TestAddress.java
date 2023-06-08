import addressbook.Address;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class TestAddress{

    @Test
    public void simple_test(){
	Address address = new Address("Kiel", 1234,"CAU",3);
	assertEquals("Kiel",address.getCity());
	assertEquals(1234,address.getPostcode());
	assertEquals("CAU",address.getStreet());
	assertEquals(3,address.getHouseNumber());
	assertEquals("CAU 3 in 1234 Kiel",address.toString());
    }

     @Test
     public void emptyAddress_test(){
	 Address address = new Address(null, null, null, null);
	 assertNull(address.getCity());
	 assertNull(address.getPostcode());
	 assertNull(address.getStreet());
	 assertNull(address.getHouseNumber());
	 assertEquals("<> <> in <> <>", address.toString());
	 address.setCity("Kiel");
	 assertEquals("Kiel",address.getCity());
	 address.setPostcode(1234);
	 assertEquals(1234,address.getPostcode());
	 address.setStreet("CAU");
	 assertEquals("CAU",address.getStreet());
	 address.setHouseNumber(3);
	 assertEquals(3,address.getHouseNumber());
	 assertEquals("CAU 3 in 1234 Kiel",address.toString());
	     
     }
}
