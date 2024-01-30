import java.util.LinkedHashSet;

public class WhileCommand extends Command{

    BinexprCommand expression;
    String statementName;

    WhileCommand(String lab,String expressionName,String statementName){
        super(lab);
        this.statementName = statementName;
        this.expression = (BinexprCommand) Simple.scripts.get(expressionName);
    }

    @Override
    public Object run(){
        boolean bool = (Boolean) expression.run();
        while(bool){
            Simple.scripts.get(statementName).run();
            bool = (Boolean) expression.run();
        }
        return null;
    }

    public void listSet(LinkedHashSet<String> linkedHashSet){
        Simple.scripts.get(statementName).listSet(linkedHashSet);
        expression.listSet(linkedHashSet);
        linkedHashSet.add("while "+lab+" "+expression.lab+" "+Simple.scripts.get(statementName).lab);
    }


}
