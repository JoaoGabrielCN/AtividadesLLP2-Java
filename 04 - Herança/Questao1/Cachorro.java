package zoo;

public class Cachorro extends Mamifero {
    @Override
    public void emitirSom() {
        System.out.println(nome + " diz: au au au!");
    }

    public Cachorro(String nome){
        this.nome = nome;
    }
}
