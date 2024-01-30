import java.util.LinkedHashSet;

public class ProgramCommand extends Command{
    String statementName;

    ProgramCommand(String lab,String statementName){
        super(lab);
        this.statementName = statementName;
    }

    @Override
    public Object run(){
        Simple.scripts.get(statementName).run();
        return null;
    }
    public void listSet(LinkedHashSet<String> linkedHashSet){
        Simple.scripts.get(statementName).listSet(linkedHashSet);
        linkedHashSet.add("program "+lab+" "+Simple.scripts.get(statementName).lab);
    }
}
