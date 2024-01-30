import java.util.LinkedHashSet;

public class AssignCommand extends Command{

    String varName;

    BinexprCommand expression;

    public AssignCommand(String lab,String varName,String binExpr){
        super(lab);
        this.varName = varName;

        expression = (BinexprCommand) Simple.scripts.get(binExpr);
    }

    @Override
    public Object run(){
        if(Variables.instance.isInt(varName)){
            int integer = (int) expression.run();
            Variables.instance.setIntVariable(varName,integer);
        }
        else if(Variables.instance.isBool(varName)){
            boolean bool = (boolean) expression.run();
            Variables.instance.setBooleanVariable(varName,bool);
        }
        else{
            System.out.println("Error " + Variables.instance.integerMap);
        }
        return null;
    }

    public void listSet(LinkedHashSet<String> linkedHashSet){
        expression.listSet(linkedHashSet);
        linkedHashSet.add("assign "+lab+" "+varName+" "+expression.lab);
    }


}
