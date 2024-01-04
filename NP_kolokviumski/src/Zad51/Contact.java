package Zad51;

public abstract class Contact implements Comparable<Contact>{
    String date;
    Contact(String date){
        this.date = date;
    }// - конструктор каде што date е датумот кога е креиран контактот даден во следниов формат YYYY-MM-DD
    public boolean isNewerThan(Contact c){
        return date.compareTo(c.date)>0;
    } //- метод кој враќа true доколку контактот е креиран подоцна од контактот c и обратно

    public String getDate() {
        return date;
    }

    public abstract String getType();// - метод кој враќа вредност "Email" или "Phone" во зависност од типот на контактот
    public abstract String toStr();
    @Override
    public int compareTo(Contact o) {
        return this.date.compareTo(o.date);
    }

}
