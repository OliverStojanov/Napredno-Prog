package Zad51;
enum Operator { VIP, ONE, TMOBILE }
public class PhoneContact extends Contact{
    String phone;
    PhoneContact(String date,String phone) {
        super(date);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String getType() {
        return "Phone";
    }

    @Override
    public String toStr() {
        return String.format("\"%s\"", phone);
    }

    public Operator getOperator(){
        String str = phone.substring(0,3);
        switch (str){
            case "070":
            case "071":
            case "072": return Operator.TMOBILE;
            case "075":
            case "076": return  Operator.ONE;
            case "077":
            case "078": return Operator.VIP;
            default: return null;
        }
    }
}
