import addressbook.Address;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestAddress{

    @Test
    public void simple_test(){
	Address address = new Address("Kiel", 1234,"CAU",3);
    }

}
