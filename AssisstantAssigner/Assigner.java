import java.util.ArrayList;
import java.util.Arrays;

public class Assigner {

	Assignment[] AssignStudents(Student[] students, Course[] classes){
		ArrayList<Assignment> pairs = new ArrayList<Assignment>(0);
		sortStudents(students);
		if (canAssign(pairs.get(pairs.size()-1), students[0], classes[0])) {
			//pass
		}
		return (Assignment[]) pairs.toArray();
	}

	Student[] sortStudents (Student[] students) {
	    
	    //sort by quarter
	    int win = 0;
	    int spr = 0;
	    int sum = 0;
	    int fal = 0;

	    for (int i = 0; i < students.length; i++) {
	    	switch (students[i].getGraduatingQuarter()) {
	          case "Winter":
	            win++;
	            break;
	          case "Spring":
	            spr++;
	            break;
	          case "Summer":
	            sum++;
	            break;
	          case "Fall":
	            fal++;
	            break;
	        }
	    }

	    spr += win;
	    sum += spr;
	    fal += sum;
	    
	    Student[] newStudentArray = new Student[students.length];
	    
	    for (int i = students.length-1; i > -1; i--)
	    	switch (students[i].getGraduatingQuarter()) {
	          case "Winter":
	              win--;
		          newStudentArray[win] = students[i];
	              break;
	          case "Spring":
	              spr--;
		          newStudentArray[spr] = students[i];
	              break;
	          case "Summer":
	        	  sum--;
		          newStudentArray[sum] = students[i];
	              break;
	          case "Fall":
	        	  fal--;
		          newStudentArray[fal] = students[i];
		          break;
	        }
	    
		//sort by year
		students = MergeSortStudents(newStudentArray);
	    
	    //sort by whether the student is taking 492, 492 students should come first

	    int studentsIn492 = 0;
	    for (int i = 0; i < students.length; i++) {
	    	if (students[i].getIn492()) {
	    		studentsIn492++;
	    	}
	    }
	    
		int j = 0;
		for (int i = 0; i < students.length; i++) {
	   		if (!students[i].getIn492()) {
	   			newStudentArray[studentsIn492] = students[i];
	   			studentsIn492++;
	   		} else {
	   			newStudentArray[j] = students[i];
				j++;
			}
		}
		return newStudentArray;
	}

	Student[] MergeSortStudents(Student[] students) {
		if (students.length == 1) {
			return students;
		} else {
			Student[] S1 = MergeSortStudents(Arrays.copyOfRange(students, 0, students.length/2));
			Student[] S2 = MergeSortStudents(Arrays.copyOfRange(students, students.length/2, students.length));
			
			int p1 = 0;
			int p2 = 0;
			int current = 0;
			Student[] toReturn = new Student[students.length];
			while (p1 < S1.length || p2 < S2.length) {
				if (p1 >= S1.length) {
					toReturn[current] = S2[p2];
					p2++;
				} else if (p2 >= S2.length) {
					toReturn[current] = S1[p1];
					p1++;
				} else if (S1[p1].year <= S2[p2].year) {
					toReturn[current] = S1[p1];
					p1++;
				} else {
					toReturn[current] = S2[p2];
					p2++;
				}
				current++;
			}
			return toReturn;
		}
	}

	  boolean canAssign(Assignment toAssign, Student newStudent, Course newClass) {
	    if (checkScheduleConflict(newStudent, newClass) && newStudent.getClassTaken(newClass.getCategory()) && (toAssign.getStudent(1) == null || !toAssign.getStudent(1).getIn492())) {
	      return true;
	    } else {
	      return false;
	    }
	  }

	  boolean checkScheduleConflict (Student stu, Course cla) {
	    for (int i = 0; i < 4; i++) {
	      if (cla.getDay(i)) { 
	        for (int j = cla.getTime() + i*8; j < cla.getTime() + cla.getHours() + i*8; j++) {
	          return true;
	        }
	      }
	    }
	    return false;
	  }

}
