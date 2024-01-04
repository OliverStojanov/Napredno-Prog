package Zad25;

public class XMLLeaf extends XML {
    String element;
    public XMLLeaf(String name, String element) {
        super(name);
        this.element = element;
    }

    @Override
    public String toString(int indent) {
        return createTag(indent) + element + "</" + tag + ">\n";
    }
}
