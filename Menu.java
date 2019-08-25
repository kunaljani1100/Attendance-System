package kunal;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by kunal on 04-09-2017.
 */
public class Menu
{
    public void runMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        try
        {
            while (choice != 3)
            {
                System.out.println("1.Enter new roll number.");
                System.out.println("2.Add attendance.");
                System.out.println("3.Exit.");
                choice = scanner.nextInt();

                if (choice == 1) {
                    AddRollno addRollno = new AddRollno();
                    addRollno.addNewID();
                }
                if (choice == 2) {
                    AddAttendance attendance = new AddAttendance();
                    attendance.addAttendance();
                }
                if (choice == 3) {
                    System.exit(0);
                } //else {
                    //System.out.println("Incorrect choice.");
                //}
            }
        }
        catch(InputMismatchException e)
        {
            System.out.println("Input error.");
            System.exit(0);
        }
    }
}