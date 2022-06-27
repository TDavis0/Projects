
public class Picker 
{
	public static void main(String[] args)
	{
		testAssigner();
	}
	
	static void testAssigner () {
					//time  8     9     10    11    12    1     2     3
		boolean[] avail1 = {true, true, true, true, true, true, true, true,
							true, true, true, true, true, true, true, true,
							true, true, true, true, true, true, true, true,
							true, true, true, true, true, true, true, true};
		boolean[] avail2 = {true, true, true, true, true, true, true, true,
							true, true, true, true, true, true, true, true,
							true, true, true, true, true, true, true, true,
							true, true, true, true, true, true, true, true};
		boolean[] avail3 = {true, true, true, true, true, true, true, true,
							true, true, true, true, true, true, true, true,
							true, true, true, true, true, true, true, true,
							true, true, true, true, true, true, true, true};
		boolean[] avail4 = {true, true, true, true, true, true, true, true,
							true, true, true, true, true, true, true, true,
							true, true, true, true, true, true, true, true,
							true, true, true, true, true, true, true, true};
		boolean[] avail5 = {true, true, true, true, true, true, true, true,
							true, true, true, true, true, true, true, true,
							true, true, true, true, true, true, true, true,
							true, true, true, true, true, true, true, true};
		boolean[] avail6 = {true, true, true, true, true, true, true, true,
							true, true, true, true, true, true, true, true,
							true, true, true, true, true, true, true, true,
							true, true, true, true, true, true, true, true};
		// past classes    102   105    109    110    111    112    301    302    311    312    361    362    380    420    427    430    440    467    470    480
		boolean[] past1 = { true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true};
		boolean[] past2 = {false,  true, false,  true, false,  true, false,  true, false,  true, false,  true, false,  true, false,  true, false,  true, false,  true};
		boolean[] past3 = { true, false,  true, false,  true, false,  true, false,  true, false,  true, false,  true, false,  true, false,  true, false,  true, false};
		boolean[] past4 = {false, true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true};
		boolean[] past5 = {false, false,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true,  true};
		
		
		Student[] toSort = {new Student("Alice", "", 9999999, "", avail1, "Spring", 2022, true, true, true, true, new boolean[0]),
							new Student("Bob", "", 9999999, "", avail2, "Winter", 2022, false, true, true, true, new boolean[0]),
							new Student("Carol", "", 9999999, "", avail3, "Fall", 2022, true, true, true, true, new boolean[0]),
							new Student("Dave", "", 9999999, "", avail4, "Spring", 2020, false, true, true, true, new boolean[0]),
							new Student("Eve", "", 9999999, "", avail5, "Spring", 2021, true, true, true, true, new boolean[0]),
							new Student("Frank", "", 9999999, "", avail6, "Spring", 2021, false, true, true, true, new boolean[0]),
							new Student("Grace", "", 9999999, "", avail1, "Summer", 2021, true, true, true, true, new boolean[0]),
							new Student("Harry", "", 9999999, "", avail2, "Spring", 2021, false, true, true, true, new boolean[0])};
		Assigner test = new Assigner();
		test.sortStudents(toSort);
		
		boolean[] Sch1 = {true, true, true, true};
		boolean[] Sch2 = {false, true, false, true};
		Course[] toAssignTo = {new Course("CS", 111, 1,"", "", Sch1, 3, 1, "SAMULSON", "EBURG"),
							   new Course("CS", 111, 2,"", "", Sch1, 5, 1, "ONLINE", "WEB"),
							   new Course("CS", 259, 1,"", "", Sch2, 6, 2, "ONLINE", "WEB"),
							   new Course("CS", 329, 1,"", "", Sch2, 2, 1, "SAMULSON", "EBURG")};
	}
}
