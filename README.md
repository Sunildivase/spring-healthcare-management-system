
# spring-healthcare-management-system
spring-healthcare-management-system

# Project Overview  
spring-healthcare-management-system project is a basic Java application that demonstrates a healthcare management system. It utilizes object-oriented programming principles and simulates the interactions between patients,doctors and hospitals . It also uses Spring framework.

# Features   
* Manage patient information.
* Manage doctor information.
* Manage hospital information.
* Manage department information.
* Manage appointment information.

# Installation and Setup  
* Prerequisites
* Java Development Kit (JDK) 21.
* An Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse.
* Git (optional, for version control).

# Steps
* Clone the repository
* Navigate to the project directory:
* cd spring-healthcare-management-system
* Open the project in your preferred IDE.
* Compile and run the application:
* Locate Main.java.
* Run the file to start the application.

# Package Structure
* com.healthcareApp Contains the main application logic (healthcareApp.java)
* * com.healthcareApp.controller: includes all the controller classes:
  * PersonController.java
  * DoctoController.java
  * HospitalController.java
  * DepartmentController.java
  * AppointmentController.java
  * PrescriptionController.java
  * BillingController.java
* com.helathcareApp.model: includes all the model classes:
  * Person.java
  * Doctor.java
  * Hospital.java
  * Department.java
  * Appointment.java
  * Prescription.java
  * Billing.java
* com.healthcareApp.service: includes all the service classes and interfaces:
   * PersonService.java
   * DoctorService.java
   * HospitalService.java
   * DepartmentService.java
   * AppointmentService.java
   * PrescriptionService.java
   * BillingService.java
   * ConnectionService.java
     
 # Class Diagram
```mermaid
---
title: healthcare management system
---
classDiagram

 note " This is generally appointment booking for health services"

 class Person
 Person : +int personId
 Person : +String firstname
 Person : +String lastName
 Person : +int age
 Person : +String gender
 Person : +Long contactNo
 Person : +Long alternateMobile
 Person : +String address

class Person{
 +createPerson()
 +displayPerson()
}

 

Doctor: +int doctorId
Doctor: +String firstName
Doctor: +String lastName
Doctor: +int age
Doctor: +String gender
Doctor: +String contactNo
Doctor: +String speciality
Doctor: +int experience

class Doctor{
 +createDoctor()
 +displayDoctor()
}


Hospital: +int hospitalId
Hospital: +String hospitalName
Hospital: +String address
Hospital: +Long contactNo
Hospital: +String emailId

class Hospital{
+createHospital()
+displayHospital()
}

Department: +int deptId
Department: +String deptName
Department: +doctorId
Department: +hosptitalId

class Department{
+createDepartment()
+displayDepartment()
}

Hospital <-- Department : Association
Doctor  <-- Department  : Assocciation

Appointment: +int appointmentId
Appointment: +int personId
Appointment: +int doctorId
Appointment: +int hospitalId
Appointment: +int deptId

class Appointment{
+createAppointment()
+displayAppointment()

}


Appointment --> Person : Association
Appointment --> Doctor : Association
Appointment --> Hospital : Association
Appointment --> Department : Association

Prescription : +int prescriptionId
Prescription : +String prescriptionDetails
Prescription : +int personId

class Prescription{
+createPrescription()
+displayPrescription()
}

Prescription --> Person : Association

Billing : +int billId
Billing : +int bill
Billing : +int totalBill
Billing : +int personId

class Billing{
+createBilling()
+displayBilling()
}

Billing --> Person : Association

```


