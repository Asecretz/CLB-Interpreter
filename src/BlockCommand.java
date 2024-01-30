import java.util.ArrayList;
import java.util.LinkedHashSet;

public class BlockCommand extends Command{

    ArrayList<Command> list = new ArrayList<>();
    ArrayList<String> commandNameList = new ArrayList<>();
    BlockCommand(String[] commandName){
        super(commandName[0]);
        for(int i = 1;i< commandName.length;i++){
            commandNameList.add(commandName[i]);
            Command command = Simple.scripts.get(commandName[i]);
            if(command == null){
                System.out.println(String.format("Command name %s does not exist!", commandName[i]));
            }
            else{
                list.add(Simple.scripts.get(commandName[i]));
            }
        }
    }

    @Override
    public Object run() {
        for(Command c : list){
            c.run();
        }
        return null;
    }

    public void listSet(LinkedHashSet<String> linkedHashSet){
        // add number of n Statements
        StringBuilder temp = new StringBuilder(lab);
        for(int i=0;i<list.size();i++){
            Simple.scripts.get(commandNameList.get(i)).listSet(linkedHashSet);
            String append = Simple.scripts.get(commandNameList.get(i)).lab;
            temp.append(" ").append(append);
        }
        linkedHashSet.add("block "+ temp);
    }
}
