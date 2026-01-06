import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServerImpl extends UnicastRemoteObject implements Server{
    ArrayList<Pessoa> pessoas;

    public ServerImpl() throws RemoteException{
        pessoas = new ArrayList<Pessoa>();

        try {
        FileReader fr = new FileReader("pessoal.csv");
        BufferedReader in = new BufferedReader(fr);
        String line;

        in.readLine();

        while((line = in.readLine()) != null){
            pessoas.add(new Pessoa(line));
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getData(int i) throws RemoteException{
        return pessoas.get(i).toString();
    }

   	public static void main(String args[]) {
		ServerImpl server;
		try {
			server = new ServerImpl();
			LocateRegistry.createRegistry(1099);
			Naming.bind("rmi:///Server", server);
			System.out.println("Servidor rodando!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
