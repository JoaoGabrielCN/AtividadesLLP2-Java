package zoo;

public class Mamifero {
    public int idade;
    public String nome;

    public Mamifero(){
        idade = 0;
        nome = " ";
    }

    public Mamifero(int idade, String nome){
        this.idade = idade;
        this.nome = nome;
    }

    public void mamar(){
        System.out.println("xuc xuc xuc...");
    }

    public void emitirSom(){
        System.out.println("Inonimado diz: zzzzzzzzz");
    }
}
