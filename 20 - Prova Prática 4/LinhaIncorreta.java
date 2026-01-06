public class LinhaIncorreta extends Exception {
    private String line;

    public LinhaIncorreta(String line){
        this.line = line;
    }

    public String toString(){
        return line;
    }
}
