package kunal;

/**
 * Created by kunal on 05-09-2017.
 */
public class Thread2 extends Thread{
    public void run()
    {
        ReadRollno readRollno=new ReadRollno();
        readRollno.checkRollNo();
    }
}
