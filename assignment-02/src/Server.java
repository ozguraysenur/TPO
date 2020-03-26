import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.channels.SelectionKey.OP_WRITE;

public class Server {

    int first,second;


    public static void main(String[] args) {
        Server server =new Server();
        server.ReadAndWrite();

    }

    public void ReadAndWrite(){
        ServerSocketChannel serverChannel = null;
        Selector selector=null;

        try {
            serverChannel = ServerSocketChannel.open();
            serverChannel.socket().bind(new InetSocketAddress("localhost", 5555)); //binding into the address
            serverChannel.configureBlocking(false);
            selector = Selector.open();
            SelectionKey sscKey = serverChannel.register(selector,SelectionKey.OP_ACCEPT); //registering a channel with a selector
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true){
            try {
                selector.select();                                          //blocking until selector notifies an operation
                Set keys = selector.selectedKeys();
                Iterator iter = keys.iterator();
                while(iter.hasNext()) {
                    SelectionKey key = (SelectionKey) iter.next();
                    iter.remove();                                         //must be removed otherwise it will handle the same key again
                    if (key.isAcceptable()) {                              //ready to accept incoming connection
                        SocketChannel cc = serverChannel.accept();
                        cc.configureBlocking(false);
                        cc.register(selector, SelectionKey.OP_READ | OP_WRITE);   //register client channel with the same selector
                        continue;
                    }
                    if (key.isReadable()) {                                 //a channel is ready for read operation
                        SocketChannel cc = (SocketChannel) key.channel();   //getting channel
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        cc.read(buffer);
                        buffer.flip();   //set limit to the current pos , current pos to 0
                        buffer.clear();
                     if(key.isWritable()) {                                  //a channel is ready for write operation
                          cc = (SocketChannel) key.channel();
                         String result = new String(buffer.array()).trim();
                         System.out.println("message from client :" + result);
                         byte[] bytes;
                         if (isDigit(result)) {

                             int sum = first + second;
                             System.out.println("sum : " + sum);

                             bytes = ("sum : " + sum).getBytes();


                         } else {
                             String echo = "echo : " + result;
                             bytes = echo.getBytes();
                             //System.out.println(echo);

                         }
                         cc.write(ByteBuffer.wrap(bytes));

                         // System.out.println("buraya kadar geldim");
                         continue;
                     }
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public  boolean isDigit(String s){
        String[] arr = s.split(" ");
        if(arr.length != 2) {
            return false;
        }
        try {
            first = Integer.parseInt(arr[0]);
            second = Integer.parseInt(arr[1]);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}

