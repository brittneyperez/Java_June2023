package com.demo.interfaces;

public interface ACPowerable {
	
	// voltage and frequency are always present in interfaces
	Integer voltage = 120;
    Integer frequency = 60;
    
    // these two methods are the requirements an interface needs
    // they don't need to be implemented, they're only declared
    abstract void unPlug();
    abstract boolean checkPluggedIn();
    
    // this is a default method - which means its already implemented below, so in case if a class doesn't implement this interface 
    public default void hasPower() {
        String message = "The device is ";
        if(!checkPluggedIn()) {
            message += "not ";
        }
        System.out.println(message + "plugged in.");
    }

}
