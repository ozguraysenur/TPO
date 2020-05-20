package rmiObject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteService extends UnicastRemoteObject implements IAdd,IEcho {

    public RemoteService() throws RemoteException {
    }

    @Override
    public AddResponse add(AddRequest request) throws RemoteException {
       AddResponse response =new AddResponse();
       response.sum=request.number1+request.number2;
       return response;
    }

    @Override
    public EchoResponse echo(EchoRequest request) throws RemoteException {
        EchoResponse response=new EchoResponse();
        response.echomessage="Echo : " + request.message;
        return response;
    }
}
