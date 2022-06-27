
public class Course {
	String sub;
	int cat;
	int sec;
	String title;
	String teacher;
	boolean[] days;
	int time;
	int hours;
	String facility;
	String campus;

	Course(String Subject, int Category, int Section, String Title, String Teacher, boolean[] Days, int Time, int Hours, String Facility, String Campus){
		sub = Subject;
		cat = Category;
		sec = Section;
		title = Title;
		teacher = Teacher;
		days = Days;
		time = Time;
		hours = Hours;
		facility = Facility;
		campus = Campus;
	}

	String getSubject() {
		return sub;
	}
	  
	int getCategory() {
		return cat;
	}
	  
	int getSection() {
		  return sec;
	}
	  
	String getTitle() {
		  return title;
	}
	  
	String getTeacher() {
		return teacher;
	}
	  
	boolean getDay(int i) {
		return days[i];
	}
	  
	int getTime() {
		return time;
	}
	  
	int getHours() {
		return hours;
	}
	  
	String getFacility() {
		return facility;
	}
	  
	String getCampus() {
		return campus;
	}
}
