import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class JogoAdivinhaNumero {

    public JogoAdivinhaNumero() throws NumberFormatException {
        int palpite = 0,
                sorteado,
                tentativas = 0;

        Random geradorDeAleatorios = new Random();
        sorteado = geradorDeAleatorios.nextInt(1000) + 1;

        do {

            String entrada = JOptionPane.showInputDialog(null,
                    "Número de tentativas: " + tentativas + "\nQual seu palpite: ", "Número entre 1 e 1000 sorteado! ",
                    JOptionPane.QUESTION_MESSAGE);

            palpite = Integer.parseInt(entrada);

            tentativas++;

            dica(palpite, sorteado, tentativas);
        } while (palpite != sorteado);

    }

    public void dica(int palpite, int numero, int tentativas) {
        if (palpite > numero) {

            JOptionPane.showMessageDialog(null, "Seu palpite é maior que o número sorteado. ", "Resultado",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            if (palpite < numero) {
                JOptionPane.showMessageDialog(null, "Seu palpite é menor que o número sorteado. ", "Resultado",
                        JOptionPane.WARNING_MESSAGE);
            } else {

                JOptionPane.showMessageDialog(null, "Parabéns, você acertou! O número era " + numero + "\nVocê tentou "
                        + tentativas + " vezes antes de acertar!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        JogoAdivinhaNumero jogo = new JogoAdivinhaNumero();

    }

}