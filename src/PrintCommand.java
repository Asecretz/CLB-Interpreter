import java.util.LinkedHashSet;

public class PrintCommand extends Command{
    String varName;

    public PrintCommand(String lab,String varName){
        super(lab);
        this.varName = varName;
    }

    @Override
    public Object run() {
        Object content = Variables.instance.getPotentialExpression(varName);
        System.out.println(content);
        return null;
    }
    public void listSet(LinkedHashSet<String> linkedHashSet){
        if(Simple.scripts.containsKey(varName)){
            Simple.scripts.get(varName).listSet(linkedHashSet);
        }
        linkedHashSet.add("print "+lab+" "+ varName);
    }
}
