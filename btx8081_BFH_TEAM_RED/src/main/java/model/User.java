package model;

public class User {
	private String lastName;
	private String firstName;
	private int patientNr=0;
	
	
	public User (String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		addPatientNr();
	}
	
	public String toString () {
		return this.firstName+","+this.lastName;
	}
	
	public int addPatientNr() {
		patientNr += patientNr;
		return patientNr;
	}

}
