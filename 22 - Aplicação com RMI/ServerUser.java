import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ServerUser {
    
    private Server remoteCal;
    
    public ServerUser() {
        try {
            remoteCal = (Server) Naming.lookup("rmi:///Server");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Pessoa pegaPessoa(int i) throws IllegalArgumentException, RemoteException {
          
            return new Pessoa(remoteCal.getData(i));          
    }



    
} 
