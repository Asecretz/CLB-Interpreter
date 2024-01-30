import java.util.LinkedHashSet;

public class DefineCommand extends Command{

    String varName;
    String type;
    String defaultValue;



    public DefineCommand(String lab, String type, String varName, String defaultValue) {
        super(lab);
        this.varName = varName;
        this.defaultValue = defaultValue;
        this.type = type;
    }

    @Override
    public Object run() {
        if(type.equals("bool")){
            Variables.instance.setBooleanVariable(varName,Boolean.valueOf(defaultValue));
        }
        else if(type.equals("int")){
            Variables.instance.setIntVariable(varName,Integer.valueOf(defaultValue));
        }
        else {
            System.out.println(String.format("Error: Unknown type %s.", type));
        }
        return null;
    }
    public void listSet(LinkedHashSet<String> linkedHashSet){
        linkedHashSet.add("vardef "+lab+" "+type+" "+varName+" "+defaultValue);
    }
}
