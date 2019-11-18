# Coding FHIR in Mirth

This Jar facilitated mirth programmers to invoke FHIR rest service with very simple invocation...

## How to use ?

* Initiate the object with Version (DSTU2, STU3, R4)
```java
FhirFactory fhirFactory = new FhirFactory();
FhirInterface client = fhirFactory.initFhir("Dstu2", url, uname, pwd);
```
> url - Endpoint url of DSTU2, uname - usernam, pwd - Password.
Note: This is for Basic authorization.

* Get Patient Bundle JSON
```java
String Patients = client.getUserDetail("Patient");
System.out.print(Patients);
```
* Get Practitioner Bundle JSON
```java
String Practitioner = client.getUserDetail("Practitioner");
System.out.print(Practitioner);
```
* Get Patient Resource Bundle JSON
```java
String PatientObservation = client.getPatientResourceList("100000006", "Observation");
System.out.print(PatientObservation);
```
## Contribution Steps
### How to setup Java Project in Eclipse?
* Clone this repository to your local machine
* Open eclipse and goto File -> New -> Java Project
* Window will be opened with setting of the project.
* Give your desired project name.
* Un-check default location and select the location where you have cloned the repository.
