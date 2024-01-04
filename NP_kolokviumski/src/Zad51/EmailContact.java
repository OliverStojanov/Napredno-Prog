package Zad51;

public class EmailContact extends Contact{
    String email;
    EmailContact(String date, String email) {
        super(date);
        this.email = email;
    }

    @Override
    public String getType() {
        return "Email";
    }

    @Override
    public String toStr() {
        return String.format("\"%s\"", email);
    }

    public String getEmail() {
        return email;
    }
}
