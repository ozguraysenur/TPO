import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.Random;
import java.util.Scanner;

public class ReaderWriter {


    private static final int WRITEMODE = 0;
    private static final int READMODE = 1;
    Random random = new Random();
    static String fname = "C:\\Users\\aysen\\IdeaProjects\\assignment-01\\src\\test";

    RandomAccessFile file;
    FileChannel channel;
    MappedByteBuffer buf;

    public ReaderWriter(String path) {

        try {

            this.file =new RandomAccessFile(path,"rw"); // open channel write-read mode
            this.channel=file.getChannel();
            buf  = channel.map(
                    FileChannel.MapMode.READ_WRITE,  // read-write mode
                    0,                         // starting from the beginning of the file
                    //(int)channel.size()              // map the whole file
                    64
            );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(){

        while(true){
            buf.rewind(); //before reading buffer first rewind (set current pos to 0 )
            if(buf!=null && buf.getInt()== READMODE){

                int first =buf.getInt();
                int second=buf.getInt();

                System.out.println("sum = "+ first+second);
                buf.rewind();
                buf.putInt(WRITEMODE);

            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }
    public void write(){
        while(true){
            buf.rewind();
            if(buf.getInt()==WRITEMODE){
                int random1=random.nextInt(100);
                int random2=random.nextInt(100);
                buf.rewind();
                buf.putInt(READMODE)
                    .putInt(random1)
                    .putInt(random2);


            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args) {
        ReaderWriter rw =new ReaderWriter(fname);
       // Scanner s =new Scanner(System.in);
        //String ss= s.nextLine();


       if(args[0].equals("read")){
            rw.read();
        }else if(args[0].equals("write")){
            rw.write();
        }else{
            System.out.println("illegal argument!!!");
        }
       /*if(ss.equals("read")){
           rw.read();

        }else{
           rw.write();ss
        }*/

    }



}
