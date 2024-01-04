package Zad50;

import java.util.Set;
import java.util.TreeSet;

public class Component implements Comparable<Component>{
    int weight;
    String color;
    Set<Component> components;
    public Component(String color, int weight) {
        this.color = color;
        this.weight = weight;
        components = new TreeSet<>();
    }

    public static void createString(StringBuilder sb, Component value, int lvl) {
        for(int i=0; i<lvl ; i++){
            sb.append("---");
        }
        sb.append(String.format("%d:%s\n",value.weight, value.color));
        for (Component c: value.components) {
            createString(sb,c,lvl+1);
        }
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public int compareTo(Component o) {
        if(this.weight == o.weight)
            return  this.color.compareTo(o.color);
        return this.weight - o.weight;
    }

    public void changeColor(int weight, String color) {
        if(this.weight < weight){
            this.color = color;
        }
        for (Component component: components) {
            component.change(component,weight, color);
        }
    }
    public void change(Component comp, int weight, String color) {
        if(this.weight < weight){
            this.color = color;
        }
        for (Component component: comp.components) {
            component.change(component,weight, color);
        }
    }

}
