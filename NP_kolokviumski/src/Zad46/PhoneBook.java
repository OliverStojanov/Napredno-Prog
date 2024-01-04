package Zad46;

import java.util.*;

public class PhoneBook {
    Map<String, Set<Contact>> contactsName;
    Map<String, Set<Contact>> contactsNumber;
    List<String> contacts;

    public PhoneBook() {
        this.contactsName = new TreeMap<>();
        this.contactsNumber = new HashMap<>();
        this.contacts = new ArrayList<>();
    }

    public void addContact(String name, String number) throws DuplicateNumberException {
        if(contacts.contains(number)){
            throw new DuplicateNumberException(number);
        }
        contacts.add(number);
        Contact contact = new Contact(name, number);
//za ovoj del e komentarinaiot kod deka moze i na toj nacin
        Set<Contact> nameContacts = contactsName.computeIfAbsent(name, k -> new TreeSet<>());
        nameContacts.add(contact);

        List<String> keys = contact.getPhoneKeys();
        for (String key: keys) {
            Set<Contact> numberContacts = contactsNumber.computeIfAbsent(key, k -> new TreeSet<>());
            numberContacts.add(contact);
        }
//        Set<Contact> nameContacts = contactsName.get(name);
//        if(nameContacts == null){
//            nameContacts = new TreeSet<>();
//            contactsName.put(name, nameContacts);
//        }
//        nameContacts.add(contact);

//        List<String> keys = contact.getPhoneKeys();
//        for (String key: keys) {
//            Set<Contact> numberContacts =  contactsNumber.get(key);
//            if(numberContacts==null){
//                numberContacts = new TreeSet<>();
//                contactsNumber.put(key,numberContacts);
//            }
//            numberContacts.add(contact);
//        }

    }

    public void contactsByNumber(String number) {
        Set<Contact> contacts1 = contactsNumber.get(number);
        if(contacts1 == null){
            System.out.println("NOT FOUND");
            return;
        }
        for (Contact contact: contacts1) {
            System.out.println(contact);
        }
    }

    public void contactsByName(String name) {
        Set<Contact> contacts1 = contactsName.get(name);
        if(contacts1 == null){
            System.out.println("NOT FOUND");
            return;
        }
        for (Contact contact: contacts1) {
            System.out.println(contact);
        }
    }
}
