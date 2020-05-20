package rmiClient;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;
import rmiObject.*;

import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);


        try {

            IEcho e =(IEcho) Naming.lookup("echo");
            IAdd a =(IAdd) Naming.lookup("add");



            while(true){

                System.out.println("press 1 for echoing\npress 2 for adding two values\npress 3 for exit.");
                String answer =scanner.nextLine();
                if(answer.equals("1")){
                    System.out.println("please enter your message : ");
                    String message = scanner.nextLine();
                    EchoRequest req =new EchoRequest();
                    req.message= message;
                    EchoResponse resp=e.echo(req);
                    System.out.println(resp.echomessage);


                }else if(answer.equals("2")) {


                    System.out.println("please enter two values : \n" +
                            "first : ");
                    int first = scanner.nextInt();
                    System.out.println("second : ");
                    int second = scanner.nextInt();
                    scanner.nextLine();

                    AddRequest req = new AddRequest();
                    req.number1 = first;
                    req.number2 = second;
                    AddResponse resp = a.add(req);
                    System.out.println("sum :" + resp.sum);
                }
                else if (answer.equals("3")) {
                    System.out.println("goodbye..");
                    break;
                }else{
                    System.out.println("enter a valid option");
                }

            }

        } catch (Exception e) {
            System.out.println("error");
        }
    }

}
