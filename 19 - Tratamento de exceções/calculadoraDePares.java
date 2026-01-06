import java.util.Scanner;

public class calculadoraDePares {

    public int somar(int x, int y) throws naoParException {
        if ((x % 2) != 0) {
            throw new naoParException(x);
        }
        if ((y % 2) != 0) {
            throw new naoParException(y);
        }
        return x + y;
    }

    public int subtrair(int x, int y) throws naoParException {
        if ((x % 2) != 0) {
            throw new naoParException(x);
        }
        if ((y % 2) != 0) {
            throw new naoParException(y);
        }
        return x - y;
    }

    public int multiplicar(int x, int y) throws naoParException {
        if ((x % 2) != 0) {
            throw new naoParException(x);
        }
        if ((y % 2) != 0) {
            throw new naoParException(y);
        }
        return x * y;
    }

    public int dividir(int x, int y) throws naoParException {
        if ((x % 2) != 0) {
            throw new naoParException(x);
        }
        if ((y % 2) != 0) {
            throw new naoParException(y);
        }
        return x / y;
    }

    public void chamaMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println(
                "Insira a operação que voce quer realizar\n(1) Somar\n(2) Subtrair\n(3) Multiplicar\n(4) Dividir");
        int controle = sc.nextInt();

        if (controle < 1 || controle > 4) {
            System.out.println("Operaçao invalida");
            return;
        }
        System.out.println("Insira o primeiro numero (par): ");
        int x = sc.nextInt();
        System.out.println("Insira o primeiro numero (par): ");
        int y = sc.nextInt();

        sc.close();
        try {
            switch (controle) {
                case 1:
                    System.out.println("O resultado eh " + somar(x, y));
                    break;
                case 2:
                    System.out.println("O resultado eh " + subtrair(x, y));
                    break;
                case 3:
                    System.out.println("O resultado eh " + multiplicar(x, y));
                    break;
                case 4:
                    System.out.println("O resultado eh " + dividir(x, y));
                    break;
            }
        } catch (naoParException e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        calculadoraDePares cdp = new calculadoraDePares();

        cdp.chamaMenu();
    }
}