import java.io.*;
import java.util.*;

public class Simple {

    public static Variables variables;
    public static HashMap<String,Command> scripts = new HashMap<>();
    public Simple() {
        variables = new Variables();
    }

    public void run() throws Exception {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print(">");
            String input = sc.nextLine();
            process(input.split(" "));
        }
    }

    public void runLoad(ArrayList<String> commandList) throws IOException {
        for (String arr : commandList) {
            process(arr.split(" "));
        }
        System.out.println("Successfully Loading");
    }

    void process(String[] arg) throws IOException {
        String commandType = arg[0];

        if(commandType.equals("execute")){
            scripts.get(arg[1]).run();
        }
        else if(commandType.equals("list")){
            LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
            scripts.get(arg[1]).listSet(linkedHashSet);
            System.out.println(linkedHashSet);
        }
        else if(commandType.equals("store")){
            store(arg[1],arg[2]);
        }
        else if(commandType.equals("load")){
            load(arg[1],arg[2]);
        }
        else if(commandType.equals("quit")){
            System.exit(0);
        }

        else {
            Command command;
            if (commandType.equals("vardef")) {
                command = new DefineCommand(arg[1], arg[2], arg[3], arg[4]);
            } else if (commandType.equals("binexpr")) {
                command = new BinexprCommand(arg[1], arg[2],arg[3],arg[4]);
            } else if (commandType.equals("unexpr")) {
                command = new UnexprCommand(arg[1], arg[2],arg[3]);
            } else if (commandType.equals("assign")) {
                command = new AssignCommand(arg[1], arg[2],arg[3]);
            } else if (commandType.equals("print")) {
                command = new PrintCommand(arg[1], arg[2]);
            } else if (commandType.equals("skip")) {
                command = new SkipCommand(arg[1]);
            } else if (commandType.equals("block")) {
                command = new BlockCommand(Arrays.copyOfRange(arg, 1, arg.length));
            } else if (commandType.equals("if")) {
                command = new IfCommand(arg[1], arg[2],arg[3],arg[4]);
            } else if (commandType.equals("while")) {
                command = new WhileCommand(arg[1], arg[2],arg[3]);
            } else if (commandType.equals("program")) {
                command = new ProgramCommand(arg[1], arg[2]);
            } else {
                command = new SkipCommand(arg[1]);
            }
            scripts.put(arg[1], command);
        }

    }

    public void store(String programName,String path) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        scripts.get(programName).listSet(linkedHashSet);
        try{
            int ascii = 92;
            char asciiTo = (char) ascii;
            FileWriter fw = new FileWriter(path+asciiTo+programName+".txt");
            for (String s : linkedHashSet) {
                fw.write(s);
                fw.write("\n");
            }
            System.out.println("Successfully written");
            fw.close();
        }catch (Exception e){
            e.getStackTrace();
        }

    }

    public void load(String path,String programName) throws IOException {
        int ascii = 92;
        char asciiTo = (char) ascii;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path+asciiTo+programName+".txt"));
        ArrayList<String> commandList = new ArrayList<>();
        String curLine;
        while ((curLine = bufferedReader.readLine()) != null){
            commandList.add(curLine);
        }
        bufferedReader.close();
        runLoad(commandList);
    }
}
