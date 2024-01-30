import java.util.LinkedHashSet;

public class UnexprCommand extends Command{
    String operation;
    String expressionName;

    public UnexprCommand(String lab,String operation,String expressionName){
        super(lab);
        this.expressionName = expressionName;
        this.operation = operation;
    }

    @Override
    public Object run(){
        Object value = null;
        value = Variables.instance.getPotentialExpression(expressionName);
        if(value instanceof Integer){
            return changeOperation((Integer) value);
        }
        else if(value instanceof Boolean){
            int changedValue = changeOperation((Integer) value);
            return changedValue > 0;
        }
        return null;
    }

    public int changeOperation(Integer value){
        switch(operation){
            case("#"):
                value = + value;
                return value;
            case("~"):
                value = - value;
                return value;
        }
        return value;
    }

    public void listSet(LinkedHashSet<String> linkedHashSet){
        Simple.scripts.get(expressionName).listSet(linkedHashSet);
        linkedHashSet.add("unexpr "+lab+" "+operation+" "+expressionName);
    }
}
