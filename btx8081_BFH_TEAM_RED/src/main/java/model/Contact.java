package model;

public class Contact {

	private	String name;
	private	String surname;
	private	String phoneNum;
	private	String street;
	private	String houseNum;
	private	String City;
	private	int id;
	
	public Contact(String name,String surname,String phoneNum,	String street,String houseNum,String City) {
		this.name =name;
		this.surname = surname;
		this.phoneNum = phoneNum;
		this.street = street;
		this.houseNum=houseNum;
		this.City = City;
	}
	
	public Contact() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	
}
