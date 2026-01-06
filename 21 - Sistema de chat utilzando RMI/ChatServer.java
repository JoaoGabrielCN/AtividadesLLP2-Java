import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ChatServer extends UnicastRemoteObject implements Chat {

	public ChatServer() throws RemoteException {
	}

	public String getDate(String mensagem) throws RemoteException {
		System.out.println("\nA MENSAGEM QUE CHEGOU FOI: \n" + mensagem);
		System.out.println("INSIRA UMA MENSAGEM (SE DESEJA SAIR DIGITE '!exit'): ");

		Scanner sc = new Scanner(System.in);
		String resposta = sc.nextLine();
		return resposta;
	}

	public static void main(String args[]) {
		ChatServer chat;
		try {
			chat = new ChatServer();
			LocateRegistry.createRegistry(1099);
			Naming.bind("rmi:///ChatServer", chat);
			System.out.println("Servidor rodando!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}