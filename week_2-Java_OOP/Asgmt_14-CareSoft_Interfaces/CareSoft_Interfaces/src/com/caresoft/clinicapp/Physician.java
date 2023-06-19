package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {

	// * MEMBER VARIABLES
    private ArrayList<String> patientNotes;
	
    
    // * CONSTRUCTOR --  takes an ID
	public Physician(Integer id) { // Auto-generated constructor stub
		super(id);
	}

	
	// * CLASS METHODS
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
	
	/* ---- INTERFACE SETUPS ---- */
	// Implement HIPAACompliantUser:
	
	// ? Pin must be exactly 4 digits, returns false if not.
	@Override
	public boolean assignPin(int pin) { // Auto-generated method stub
		if( pin >= 1000 && pin <= 9999 ) {
			this.pin = pin; //? Expected to assign the pin to the user (as a member variable)
			return true;
		}
		return false;
	}

	// ? Checks the physician's id against the given id; returns true if they are a match, otherwise false.
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) { // Auto-generated method stub
		if( this.id == confirmedAuthID ) {
			return true;
		}
		return false;
	}


    // * GETTERS & SETTERS
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	
}
