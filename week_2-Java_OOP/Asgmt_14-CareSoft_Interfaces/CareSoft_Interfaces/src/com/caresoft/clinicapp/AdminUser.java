package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {

	private String role;
    private ArrayList<String> securityIncidents;
	
    // * CONSTRUCTOR -- Implement a constructor that takes an ID and a role
	public AdminUser(Integer id, String role ) { // Auto-generated constructor stub
		super(id);
		this.role = role;
		this.securityIncidents = new ArrayList<String>();
	}
    
	
	// * CLASS METHODS
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n",
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n",
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
	
	
	/* ---- INTERFACE SETUPS ---- */
	// Implement HIPAACompliantUser:
    
	// ? Pin must be 6 digits or more; returns false if not.
	@Override
	public boolean assignPin(int pin) { // Auto-generated method stub
		if ( pin < 100000 || pin > 999999 ) {
			this.pin = pin; //? Expected to assign the pin to the user (as a member variable)
			return false;
		}
		return true;
	}

	// ? Compares the ids, and if they are not a match, creates an incident report using the authIncident method. Returns true if ids match, false if not.
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) { // Auto-generated method stub
		if( confirmedAuthID != this.id ) {
			this.authIncident();
			return false;
		}
		return true;
	}
	
    // Implement HIPAACompliantAdmin - Returns a list of strings (incidents reported from method above)
	@Override
	public ArrayList<String> reportSecurityIncidents() { // Auto-generated method stub
		return this.securityIncidents;
	}
	
	
	// * SETTERS & GETTERS
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}


	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
}
