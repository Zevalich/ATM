import java.util.Objects;
import java.util.Scanner;

public class BankMachine {
    private User currentUser;
    private int countPinCodeInput;
    private Scanner sc = new Scanner(System.in);

    public BankMachine(User user) {
        this.currentUser = user;
        this.countPinCodeInput = 0;
    }
    public int checkPinCode(int pinCode) {
        int i = (currentUser.getPinCode() == pinCode) ? 0 : 1;
        countPinCodeInput += i;
        return i;
    }
    public boolean operation(int operationNumber){
        boolean isWorking = true;
        switch (operationNumber) {
            case 1:
                deposit(currentUser);
                break;
            case 2:
                withdraw(currentUser);
                break;
            case 3:
                printBalance();
                break;
            default:
                isWorking = false;
                break;
        }
        return isWorking;
    }
    private int allowOperation(User user){
        int sum = setSum();
        if(user.getBalance() < sum){
            System.out.println("Недостаточно средств");
            printBalance();
            return 0;
        }else return sum;
    }
    private int setSum(){
        System.out.println("Введите сумму");
        return sc.nextInt();
    }
    private void printBalance(){
        System.out.println("Ваш баланс: " + currentUser.getBalance() + currentUser.getCurrent());
    }
    private void withdraw(User user){
        int sum = allowOperation(user);
        if(sum > 0){
            user.setBalance(user.getBalance() - sum);
            System.out.println(sum + " успешно снято.");
            printBalance();
        }
    }
    private void deposit(User user){
        int sum = setSum();
        user.setBalance(user.getBalance() + sum);
        printBalance();
    }
    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public int getCountPinCodeInput() {
        return countPinCodeInput;
    }

    public void setCountPinCodeInput(int countPinCodeInput) {
        this.countPinCodeInput = countPinCodeInput;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankMachine that = (BankMachine) o;
        return countPinCodeInput == that.countPinCodeInput &&
                Objects.equals(currentUser, that.currentUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentUser, countPinCodeInput);
    }

    @Override
    public String toString() {
        return "BankMachine{" +
                "currentUser=" + currentUser +
                ", countPinCodeInput=" + countPinCodeInput +
                '}';
    }
}
