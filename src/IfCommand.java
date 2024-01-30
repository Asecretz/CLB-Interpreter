import java.util.LinkedHashSet;

public class IfCommand extends Command{

    BinexprCommand expression;
    String statementName;
    String secondStatementName;

    IfCommand(String lab,String expressionName,String statementName,String secondStatementName){
        super(lab);
        expression = (BinexprCommand) Simple.scripts.get(expressionName);
        this.statementName = statementName;
        this.secondStatementName = secondStatementName;
    }

    @Override
    public Object run(){
        boolean bool = (boolean) expression.run();
        if(bool){
            Simple.scripts.get(statementName).run();
        }
        else{
            Simple.scripts.get(secondStatementName).run();
        }
        return null;
    }
    public void listSet(LinkedHashSet<String> linkedHashSet){
        expression.listSet(linkedHashSet);
        Simple.scripts.get(statementName).listSet(linkedHashSet);
        Simple.scripts.get(secondStatementName).listSet(linkedHashSet);
        linkedHashSet.add("if "+lab+" "+expression.lab+" "+Simple.scripts.get(statementName).lab+" "+Simple.scripts.get(secondStatementName).lab);
    }
}
