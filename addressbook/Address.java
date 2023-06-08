package addressbook;

public class Address{
    private String city;
    private Integer postcode;
    private String street;
    private Integer houseNumber;
    /**
       @param[city] ths city where this address is located.
       @param[postcode] postocde of the address.
       @param[street] street of the address.
       @param[houseNumber] housenumber of the address.
     */
    public Address(String city, Integer postcode, String street, Integer houseNumber){
	this.city = city;
	this.postcode = postcode;
	this.street = street;
	this.houseNumber = houseNumber;
    }

    /**
       @return the city of the address.
     */
    public String getCity(){
	return this.city;
    }

    /**
       @param set a new city for this address
     */
    public void setCity(String city){
	this.city = city;
    }
    
    /**
       @return the postcode of the address.
     */
    public Integer getPostcode(){
	return this.postcode;
    }

    /**
       @param set a new postcode for this address
     */
    public void setPostcode(Integer postcode){
	this.postcode = postcode;
    }
    
    /**
       @return the city of the address.
     */
    public String getStreet(){
	return this.city;
    }

    /**
       @param set a new city for this address
     */
    public void setStreet(String city){
	this.city = city;
    }

    /**
       @return the house number of the address.
     */
    public Integer getHouseNumber(){
	return this.houseNumber;
    }

    /**
       @param set a new house number for this address
     */
    public void setHouseNumber(Integer houseNumber){
	this.houseNumber = houseNumber;
    }

}
