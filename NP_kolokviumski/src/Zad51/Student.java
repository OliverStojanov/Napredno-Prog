package Zad51;

import java.util.Arrays;
import java.util.Comparator;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Student {
    String name;
    String surname;
    String city;
    int age;
    long index;
    Contact[] contacts;
    public Student(String firstName, String lastName, String city, int age, long index) {
        this.name = firstName;
        this.surname = lastName;
        this.city = city;
        this.age = age;
        this.index = index;
        this.contacts = new Contact[0];
    }

    public int getContactsLength() {
        return contacts.length;
    }

    public void  addContact(Contact contact){
        this.contacts = Arrays.copyOf(contacts, contacts.length +1);
        this.contacts[contacts.length-1] = contact;
    }
    public void addEmailContact(String date, String email) {
        addContact(new EmailContact(date, email));
    }
    public void addPhoneContact(String date, String phone){
        addContact(new PhoneContact(date, phone));
    }
    public Contact[] getContactsByType(String type){
        return Arrays.stream(contacts)
                .filter(t -> t.getType().equals(type))
                .toArray(Contact[]::new);
    }
    public Contact[] getEmailContacts(){
        return  getContactsByType("Email");
    }

    public Contact[] getPhoneContacts(){
        return  getContactsByType("Phone");
    }

    public String getCity() {
        return city;
    }

    public long getIndex() {
        return index;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public Contact getLatestContact(){
        return Arrays.stream(contacts)
                .sorted(Comparator.comparing(Contact::getDate).reversed())
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ","{", "}");
        stringJoiner.add(String.format("\"%s\":\"%s\"", "ime", name));
        stringJoiner.add(String.format("\"%s\":\"%s\"", "prezime", surname));
        stringJoiner.add(String.format("\"%s\":%d", "vozrast", age));
        stringJoiner.add(String.format("\"%s\":\"%s\"", "grad", city));
        stringJoiner.add(String.format("\"%s\":%d", "indeks", index));
        String contactsFilter = Arrays.stream(getPhoneContacts())
                .map(Contact::toStr)
                .collect(Collectors.joining(",","[","]"));
        stringJoiner.add(String.format("\"%s\":%s", "telefonskiKontakti", contactsFilter));
        contactsFilter = Arrays.stream(getEmailContacts())
                .map(Contact::toStr)
                .collect(Collectors.joining(",","[","]"));
        stringJoiner.add(String.format("\"%s\":%s", "emailKontakti", contactsFilter));
        return stringJoiner.toString();
    }
}
