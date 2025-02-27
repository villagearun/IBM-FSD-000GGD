package spring_mvcForms;

import java.util.LinkedHashMap;

public class Student {
public String firstName;
public String lastName;
public String country;
private LinkedHashMap<String, String> countryoptions;
private String favouriteLanguage;
private String[] operatingSystems;
public LinkedHashMap<String, String> getCountryoptions() {
	return countryoptions;
}
public Student() 
{
	super();
	countryoptions=new LinkedHashMap<String, String>();
	countryoptions.put("BR","Brazil");
	countryoptions.put("IN", "India");
	countryoptions.put("US","America");
	countryoptions.put("Uk", "England");
	
}
public Student(String firstName, String lastName) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getFavouriteLanguage() {
	return favouriteLanguage;
}
public void setFavouriteLanguage(String favouriteLanguage) {
	this.favouriteLanguage = favouriteLanguage;
}
public String[] getOperatingSystems() {
	return operatingSystems;
}
public void setOperatingSystems(String[] operatingSystems) {
	this.operatingSystems = operatingSystems;
}


}
