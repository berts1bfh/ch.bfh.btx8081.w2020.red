package model;

/**
 * User for planned Login-Implementation
 */
public class User {

    private final String lastName;
    private final String firstName;
    private int patientNr = 0;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        addPatientNr();
    }

    /**
     * Returns user's full name
     * @return String full name of user
     */
    public String toString() {
        return this.firstName + "," + this.lastName;
    }

    /**
     * @Depricated Auto-increment for patient number (would be solved from DB)
     * Probably outdated or temporary solution
     * @return int patientNumber
     */
    public int addPatientNr() {
        patientNr += patientNr;
        return patientNr;
    }

}
