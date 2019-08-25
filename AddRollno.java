package kunal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * Created by kunal on 04-09-2017.
 */
public class AddRollno {
    String rollno;
    Scanner scanner=new Scanner(System.in);
    int attendance=0;
    public void addNewID()
    {
        System.out.println("Enter roll number:");
        rollno=scanner.nextLine();
        try
        {
            BufferedWriter writer=new BufferedWriter(new FileWriter(rollno+".txt",true));
            writer.write(Integer.toString(attendance));
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
