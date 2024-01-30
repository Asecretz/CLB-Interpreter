import java.util.HashMap;

public class Variables {
    public static Variables instance;
    HashMap<String,Integer> integerMap;
    HashMap<String,Boolean> booleanMap;

    public Variables() {
        instance = this;
        integerMap = new HashMap<>();
        booleanMap = new HashMap<>();
    }

    public Integer getIntVariable(String name){
        return integerMap.get(name);
    }

    public Boolean getBooleanVariable(String name){
        return booleanMap.get(name);
    }

    public Object getPotentialExpression(String name) {
        Object toReturn = null;
        if (Simple.scripts.containsKey(name)) {
            toReturn = Simple.scripts.get(name).run();
        }
        else if (isInt(name)) {
            toReturn = this.getIntVariable(name);
        }
        else if (isBool(name)) {
            toReturn = this.getBooleanVariable(name);
        }
        return toReturn;
    }
    public void setIntVariable(String name,Integer value){
        integerMap.put(name,value);
    }
    public void setBooleanVariable(String name,Boolean value){
        booleanMap.put(name,value);
    }

    public boolean isInt(String name){
        return integerMap.containsKey(name);
    }

    public boolean isBool(String name){
        return booleanMap.containsKey(name);
    }

}
