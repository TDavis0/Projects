
public class Student {
	String firstName;
	String lastName;
	int id;
	String eMail;
	boolean[] availability;
	String graduatingQuarter;
	int year;
	boolean class492;
	boolean inEburg;
	boolean xpPy;
	boolean xpVB;
	boolean[] takenClasses;

	Student (String FirstName, String LastName, int ID, String EMail, boolean[] Available, String GraduatingQuarter, int Year, boolean in492, boolean inEllensburg, boolean PythonExperience, boolean VisualBasicExperience, boolean[] ClassesTaken) {
		firstName = FirstName;
		lastName = LastName;
		id = ID;
		eMail = EMail;
		availability = Available;
		graduatingQuarter = GraduatingQuarter;
		year = Year;
		class492 = in492;
		inEburg = inEllensburg;
		xpPy = PythonExperience;
		xpVB = VisualBasicExperience;
		takenClasses = ClassesTaken;
	}
	  
	String getFirstName() {
		return firstName;
	}
	  
	String getLastName() {
		return lastName;
	}
	  
	int getID() {
		return id;
	}
	  
	String getEMail() {
		return eMail;
	}
	  
	boolean getAvailability(int i) {
		return availability[i];
	}
	  
	String getGraduatingQuarter() {
		return graduatingQuarter;
	}
	  
	int getYear() {
		return year;
	}
	  
	boolean getIn492() {
		return class492;
	}
	  
	boolean getInEburg() {
		return inEburg;
	}
	  
	boolean getXpPy() {
		return xpPy;
	}
	  
	boolean getXpVB() {
		return xpVB;
	}
	  
	boolean getClassTaken(int i) {
		return takenClasses[i];
	}
}
