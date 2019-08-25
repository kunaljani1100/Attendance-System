package kunal;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.*;
import java.net.DatagramPacket;


/**
 * Created by kunal on 19-08-2017.
 */
public class ReadRollno {
    private String attendance;
    private String rollno;
    public void checkRollNo()
    {
        try
        {
            DatagramSocket socket=new DatagramSocket(500);
            DatagramSocket socket2=new DatagramSocket();
            InetAddress address=InetAddress.getLocalHost();
            while(true)
            {
                byte []buffer=new byte[7];
                DatagramPacket packet=new DatagramPacket(buffer,buffer.length);
                socket.receive(packet);
                rollno=new String(buffer);
                try(BufferedReader reader=new BufferedReader(new FileReader(rollno+".txt")))
                {
                    attendance="Attendance:"+reader.readLine();
                    byte buff[]=attendance.getBytes();
                    DatagramPacket packet2=new DatagramPacket(buff,buff.length,address,400);
                    socket2.send(packet2);
                    reader.close();
                }
                catch (FileNotFoundException e)
                {
                    System.out.println("File not found.");
                    byte buff[]=("Invalid roll no.").getBytes();
                    DatagramPacket packet2=new DatagramPacket(buff,buff.length,address,400);
                    socket2.send(packet2);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
