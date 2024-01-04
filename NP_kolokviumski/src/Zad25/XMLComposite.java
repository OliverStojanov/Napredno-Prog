package Zad25;

import java.util.ArrayList;
import java.util.List;

public class XMLComposite extends XML{

    List<XMLComponent> xmlComponents;
    public XMLComposite(String name) {
        super(name);
        xmlComponents = new ArrayList<>();
    }

    public void addComponent(XMLComponent xmlComponent) {
        xmlComponents.add(xmlComponent);
    }

    @Override
    public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(createTag(indent)).append("\n");
        xmlComponents.forEach(xmlComponent -> sb.append(xmlComponent.toString(indent+1)));
        sb.append(IndentUtil.createIndent(indent)).append("</").append(tag).append(">\n");
        return sb.toString();
    }
}
