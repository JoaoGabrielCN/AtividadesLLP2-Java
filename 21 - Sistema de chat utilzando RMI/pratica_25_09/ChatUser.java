import java.rmi.Naming;
import java.util.Scanner;


public class ChatUser {
    public static void main(String args[]) {
        Chat remoteChat;
        String mensagem = "";

        try {
            while (!mensagem.equals("!exit")) {

                remoteChat = (Chat) Naming.lookup("rmi:///ChatServer");

                System.out.println("\nINSIRA UMA MENSAGEM (SE DESEJA SAIR DIGITE '!exit'): ");
                Scanner sc = new Scanner(System.in);
                mensagem = sc.nextLine();
                if (mensagem.equals("!exit"))
                    break;
                String resposta = remoteChat.getDate(mensagem);

                if (resposta.equals("!exit")) {
                    break;
                } else {
                    System.out.println("A RESPOSTA FOI: \n" + resposta);
                }

            }

            System.out.println("CHAT ENCERRADO");
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
