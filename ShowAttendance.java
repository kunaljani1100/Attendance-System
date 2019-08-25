package kunal;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Created by kunal on 19-08-2017.
 */
public class ShowAttendance
{
    Scanner scanner=new Scanner(System.in);
    private String rollno="";
    private String str;
    private String message;
    public void showMarks()
    {
        try
        {
            InetAddress address=InetAddress.getLocalHost();
            DatagramSocket socket=new DatagramSocket();
            DatagramSocket socket2=new DatagramSocket(400);
            DatagramPacket packet2;
            byte []buff;
            while (!rollno.equals("exit"))
            {
                System.out.println("Enter Roll Number.Type \"exit\" if you want to quit.");
                rollno = scanner.nextLine();
                if(rollno.equals("exit"))
                {
                    System.exit(0);
                }
                if(rollno.length()!=7)
                {
                    System.out.println("Invalid roll no.");
                    System.exit(1);
                }
                byte[] buffer=rollno.getBytes();
                DatagramPacket packet=new DatagramPacket(buffer,buffer.length,address,500);
                socket.send(packet);

                buff=new byte[100];
                packet2=new DatagramPacket(buff,buff.length);
                socket2.receive(packet2);
                str=new String(buff);
                if(str.charAt(0)=='I')
                {
                    System.out.println("Invalid roll no.");
                    System.exit(1);
                }
                System.out.println(str);
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}

