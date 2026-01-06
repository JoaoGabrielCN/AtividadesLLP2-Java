import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Chat extends Remote {
    String getDate(String mensagem) throws RemoteException;
}
