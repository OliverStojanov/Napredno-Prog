package Zad50;

import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Window {
    String name;
    Map<Integer,Component> componentMap;
    public Window(String name) {
        this.name = name;
        componentMap = new TreeMap<>();
    }

    public void addComponent(int position, Component component) throws InvalidPositionException{
        if(componentMap.containsKey(position)){
            throw new InvalidPositionException(position);
        }
        componentMap.put(position,component);
    }

    public void changeColor(int weight, String color) {
        for(Component component : componentMap.values()){
            component.changeColor(weight,color);
        }
    }

    public void swichComponents(int pos1, int pos2) {
        Component comp1 = componentMap.get(pos1);
        Component comp2 = componentMap.get(pos2);
        componentMap.put(pos1,comp2);
        componentMap.put(pos2,comp1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("WINDOW %s\n",name));
        for (Map.Entry<Integer, Component> entry : componentMap.entrySet()) {
            sb.append(String.format("%d:", entry.getKey()));
            Component.createString(sb, entry.getValue(), 0);
        }

        return sb.toString();
    }
}
