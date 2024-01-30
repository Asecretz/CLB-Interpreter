import java.util.LinkedHashSet;

public class BinexprCommand extends Command{

    String varName;
    String operation;
    String number;

    BinexprCommand(String lab,String varName,String operation,String number){
        super(lab);
        this.varName = varName;
        this.operation = operation;
        this.number = number;
    }

    @Override
    public Object run(){
        Object valueOfCommandRun = null;
        valueOfCommandRun = Variables.instance.getPotentialExpression(varName);

        if(valueOfCommandRun instanceof Integer){
            return checkOperation(valueOfCommandRun);
        }


        else{
            System.out.println("Error: Type is null\n Keys: \n");
            for (String key : Simple.scripts.keySet()) {
                System.out.println(key);
            }
            return null;
        }
    }

    public Object checkOperation(Object value){
        switch (operation) {
            case ("+"):
                return (Integer) value + Integer.parseInt(number);
            case ("-"):
                return (Integer) value - Integer.parseInt(number);
            case ("*"):
                return (Integer) value * Integer.parseInt(number);
            case ("/"):
                return (Integer) value / Integer.parseInt(number);
            case ("%"):
                return (Integer) value % Integer.parseInt(number);
            case (">"):
                return (Integer) value > Integer.parseInt(number);
            case (">="):
                return (Integer) value >= Integer.parseInt(number);
            case ("<"):
                return (Integer) value < Integer.parseInt(number);
            case ("<="):
                return (Integer) value <= Integer.parseInt(number);
            case ("=="):
                return value.toString().equals(number);
            case ("!="):
                return !value.toString().equals(number);
        }
        return null;
    }
    public void listSet(LinkedHashSet<String> linkedHashSet){
        if(Simple.scripts.containsKey(varName)){
            Simple.scripts.get(varName).listSet(linkedHashSet);
        }
        linkedHashSet.add("binexpr "+lab+" "+varName+" "+operation+" "+number);
    }
}
