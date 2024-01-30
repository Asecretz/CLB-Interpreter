import java.util.LinkedHashSet;

abstract public class Command {

    String lab;

    Command(String lab){
        this.lab = lab;
    }
    abstract public Object run();

    public void listSet(LinkedHashSet<String>linkedHashSet){}


}
