package kunal;

import java.io.*;
import java.util.Scanner;

/**
 * Created by kunal on 04-09-2017.
 */
public class AddAttendance {
    public void addAttendance()
    {
        Scanner scanner=new Scanner(System.in);
        String rollno;
        String attendance;
        int x;
        System.out.println("Enter roll number:");
        rollno=scanner.nextLine();
        try
        {
            BufferedReader reader=new BufferedReader(new FileReader(rollno+".txt"));
            attendance=reader.readLine();
            x=Integer.parseInt(attendance);
            reader.close();
            boolean success=new File(rollno+".txt").delete();
            BufferedWriter writer=new BufferedWriter(new FileWriter(rollno+".txt",true));
            x++;
            attendance=Integer.toString(x);
            writer.write(attendance);
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
