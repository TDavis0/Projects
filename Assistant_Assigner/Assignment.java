
public class Assignment {
	Course C;
	Student S1;
	Student S2;
	
	void setCourse(Course course) {
		C = course;
	}

	void setStudent(Student student, int i) {
		if (i == 1) {
			S1 = student;
		} else {
			S2 = student;
		}
	}

	Course getCourse() {
		return C;
	}
	
	Student getStudent(int i) {
		if (i == 1) {
			return S1;
		} else {
			return S2;
		}
	}
}
