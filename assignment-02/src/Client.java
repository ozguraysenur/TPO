import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client {


    private static String host="localhost";
    private static int port=5555;
    SocketChannel channel;
    Scanner scanner =new Scanner(System.in);

    String message;


    public Client(String host, int port) {

        try {
            channel = SocketChannel.open();   //opens a channel
            channel.configureBlocking(false);  //setting to non blocking mode
            channel.connect(new InetSocketAddress(host, port));
            System.out.print("Connecting ...");

            while (!channel.finishConnect()) {
                System.out.println("connection established.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nConnected");

        while(true) {
            //sending the message
            try {
                Thread.sleep(750);
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("press 1 for echoing\npress 2 for adding two values :");
            String answer =scanner.nextLine();
            if(answer.equals("1")){
                System.out.println("please enter your message : ");
                message = scanner.nextLine();
            }else if(answer.equals("2")){
                System.out.println("please enter two values : \n" +
                                    "first : " );
                String first =scanner.nextLine();
                System.out.println("second : " );
                String second =scanner.nextLine();
                message =first + " " +second;

            }else{
                System.out.println("enter a valid option");
            }

            byte[] bytes = message.getBytes();
            ByteBuffer buffer =ByteBuffer.wrap(bytes);


           // System.out.println("Message : " + message);
            try {
                channel.write(buffer);
                Thread.sleep(200);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            read();

        }

    }

    public void read(){
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
        while(true){
            buffer.clear();

            int readBytes = channel.read(buffer);
            if (readBytes == 0) {
                System.out.println("there is no data");
            } else if (readBytes == -1) {
                System.out.println("Channel is closed");
                channel.close();
                break;
            } else {
               break;
            }

        }
            String result = new String(buffer.array()).trim();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Client(host,port);
    }
}

