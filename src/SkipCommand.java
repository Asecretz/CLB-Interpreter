import java.util.LinkedHashSet;

public class SkipCommand extends Command{

    SkipCommand(String lab){
        super(lab);
    }

    @Override
    public Object run(){
        return null;
    }
    public void listSet(LinkedHashSet<String> linkedHashSet){
        linkedHashSet.add("skip "+lab);
    }
}
