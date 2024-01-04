package Zad25;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public abstract class XML implements XMLComponent{
    public Map<String,String> attributes;
    public String tag;

    public XML(String tag) {
        this.tag = tag;
        attributes = new TreeMap<>();
    }

    public void addAttribute(String name, String value) {
        attributes.put(name,value);
    }

    public String createStringForAttributes(Map.Entry<String,String> entry){
        return String.format("%s=\"%s\"", entry.getKey(), entry.getValue());
    }

    public String createTag(int indent){
        StringBuilder sb = new StringBuilder();
        sb.append(IndentUtil.createIndent(indent));
        sb.append("<").append(tag);

        if(!attributes.isEmpty()){
            sb.append(" ");
            sb.append(attributes.entrySet().stream()
                    .map(this::createStringForAttributes)
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.joining(" ")));
        }
        sb.append(">");
        return sb.toString();
    }
}
