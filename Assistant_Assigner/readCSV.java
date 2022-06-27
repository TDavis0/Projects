import java.io.*;
import java.util.Scanner; 

public class readCSV{
    public static void main(String[]args)throws Exception{

        String line = "";
        String splitBy = ",";

        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        while((line = br.readLine()) != null){
            String student[] = line.split(splitBy);
            System.out.println("Student: Name: " + student[0] + " " + student[1] + " ID: " + student[2] +  " Email: " + student[3] + " Graduating: " + student[4] + " Year: " + student[5] + " Class: " + student[6] + " In Ellensburg: " + student[7] + " Python: " + student[40] + " Visual Basic: " + student[41]);
        }

    }
}