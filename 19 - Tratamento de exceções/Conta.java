public class Conta{
    int saldo;

    public void deposita(int valor){
        saldo = saldo + valor;
    }

    public void saca(int valor) throws ContaException{
        saldo = saldo - valor;
        if(valor > saldo){
            throw new ContaException();
        }
        
    }



    public static void main(String[] args) {
        Conta conta = new Conta();

        conta.deposita(100);
        try {
            conta.saca(400);
        } catch (ContaException e) {
            e.printStackTrace();
        }finally{
            System.out.println(conta.saldo);
        }
    }

}