import java.util.Objects;
import java.util.Scanner;

public class User {
    private String name;
    private int pinCode;
    private int balance;
    private String current;

    public User() {}

    public User(String name, int pinCode, int balance, String current) {
        this.name = name;
        this.pinCode = pinCode;
        this.balance = balance;
        this.current = current;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode() {
        Scanner sc = new Scanner(System.in);
        String pin;
        while (true){
            pin = sc.nextLine();
            if(pin.length() == 4){
                this.pinCode = Integer.parseInt(pin);
                break;
            }
            System.out.println("Пинкод должен состоять из 4-х символов");
        }

    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return pinCode == user.pinCode &&
                balance == user.balance &&
                current == user.current &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pinCode, balance, current);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pinCode=" + pinCode +
                ", balance=" + balance +
                ", current=" + current +
                '}';
    }
}
