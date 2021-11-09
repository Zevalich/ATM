import java.util.*;

public class Runner {
    static Scanner sc = new Scanner(System.in);
    static Map<Integer, String> currencyMap = new HashMap<>();
    static Map<Integer, User> usersMap = new HashMap<>();
    static boolean isWorking = true;

    public static void main(String[] args){
        currencyMap.put(1, "USD");
        currencyMap.put(2, "BYN");
        inputThreeUsers();
        User user = usersMap.get(getId());;


        BankMachine bm = new BankMachine(user);
        System.out.println("Выбран пользователь: " + user.getName());
        while(true){
            if(bm.getCountPinCodeInput() < 3) {
                System.out.println("Введите пин код");
                if(bm.checkPinCode(sc.nextInt()) == 0){
                    break;
                }

            } else System.exit(-1);
        }
        while(isWorking) {
            System.out.println("Выберите номер операции: 1 - положить деньги на счет," +
                    " 2 - снять деньги со счета, 3 - посмотреть счет");
            int operationNumber = sc.nextInt();
            isWorking = bm.operation(operationNumber);
        }
    }
    private static void inputThreeUsers() {
        for (int i = 1; i < 4; i++) {
            usersMap.put(i, inputUser());
        }
    }
    private static User inputUser(){
        User user = new User();
        System.out.println("Создайте нового пользователя. Введите имя.");
        user.setName(sc.next());
        System.out.println("Введите 4-значный пинкод");
        user.setPinCode();
        System.out.println("Введите балланс");
        user.setBalance(sc.nextInt());
        System.out.println("Выберите  валюту: 1- \"USD\" 2- \"BYN\"");
        user.setCurrent(currencyMap.get(sc.nextInt()));
        return user;
    }
    public static int getId(){
        System.out.println("Введите id пользователя.");//почему сканнер запускается 2 раза???
        printUsers();
        int id;
        while (true){
            id = sc.nextInt();
            if(!usersMap.containsKey(id)){
                System.out.println("Такого пользователя нет.\n");
                getId();
            }else {
                return id;
            }
        }
    }
    public static void printUsers() {
        Set<Integer> keys = usersMap.keySet();
        System.out.println("Список существующих id: " + keys);
    }


}
