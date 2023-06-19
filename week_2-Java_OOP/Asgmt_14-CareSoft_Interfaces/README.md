# CareSoft Interfaces

### Synopsis
You’ve joined a team of developers that has built the software for a healthcare clinic management system called CareSoft. The codebase is already fully developed, but they are working on standardizing some of their business logic to streamline reporting requirements for the Healthcare Insurance Portability and Accountability Act (HIPAA) and maintain the security of electronic Personal Health Information (PHI or ePHI).

---

This Java project, **CareSoft Interfaces**, consists of several classes and interfaces for managing a clinic application. Below is a summary of each class and its functionality:


## `HIPAACompliantAdmin` Interface

This interface defines the behavior of an admin user who is HIPAA-compliant. It includes the following methods:

- `reportSecurityIncidents()`: This method returns a list of security incidents reported by the admin user.
- `printSecurityIncidents()`: This default method prints the security incidents using the `reportSecurityIncidents()` method.
- `adminQATest(ArrayList<String> expectedIncidents)`: This default method performs a QA test by comparing the reported security incidents with the expected incidents.


## `HIPAACompliantUser` Interface

This interface defines the behavior of a user who is HIPAA-compliant. It includes the following methods:

- `assignPin(int pin)`: This method assigns a PIN to the user and returns `true` if the PIN is exactly 4 digits; otherwise, it returns `false`.
- `accessAuthorized(Integer confirmedAuthID)`: This method checks if the given ID matches the user's ID and returns `true` if they match; otherwise, it returns `false`.


## `User` Class

The User class represents a generic user in the clinic application. It has the following variables and methods:

- Variables:
  - `id`: The user's ID.
  - `pin`: The user's PIN.

- Methods:
  - Getters and setters for `id` and `pin`.


## `Physician` Class

The Physician class represents a physician in the clinic application. It extends the User class and implements the HIPAACompliantUser interface. Additionally, it has the following variables and methods:

- Variables:
  - `patientNotes`: An ArrayList to store the physician's patient notes.

- Methods:
  - `newPatientNotes(String notes, String patientName, Date date)`: This method creates a new patient note report with the given details and adds it to the `patientNotes` ArrayList.


## `AdminUser` Class

The AdminUser class represents an admin user in the clinic application. It extends the User class and implements both the HIPAACompliantAdmin and HIPAACompliantUser interfaces. It has the following variables and methods:

- Variables:
  - `role`: The role of the admin user.
  - `securityIncidents`: An ArrayList to store the admin user's security incidents.

- Methods:
  - `newIncident(String notes)`: This method creates a new security incident report with the given notes and adds it to the `securityIncidents` ArrayList.
  - `authIncident()`: This method creates an incident report for authorization failures.
  - `getRole()`: Getter for the admin user's role.
  - `setRole(String role)`: Setter for the admin user's role.
  - `getSecurityIncidents()`: Getter for the admin user's security incidents.
  - `setSecurityIncidents(ArrayList<String> securityIncidents)`: Setter for the admin user's security incidents.


## `TestController` Class

The TestController class contains the main method for testing the functionality of the classes and interfaces in the clinic application. It creates instances of Physician and AdminUser, and performs various tests for pin assignment, authorization, and security incidents.
