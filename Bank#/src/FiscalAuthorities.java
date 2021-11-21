import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FiscalAuthorities implements Trackable{
    private final List<List<Account>> irsList = new ArrayList<>();
    private Map<String, Double> map;
    private Map<String, String> map1;

    @Override
    public void startTracking() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        System.out.println("Introduce-ti pozitia contului pe care il doriti: ");
        choice = scanner.nextLine();
        System.out.println(irsList.get(Integer.parseInt(choice)));
        // OR use map.
//        List<Account> flat = irsList.stream().flatMap(List::stream).collect(Collectors.toList());
//        map = flat.stream().collect(Collectors.toMap(Account::getAccountNumber, Account::getBalance));
//        map1 = flat.stream().collect(Collectors.toMap(Account::getAccountNumber, Account::getLastName));
//        System.out.println("Introduce-ti numele persoanei despre care doriti informatii: ");
//        choice = scanner.nextLine();
//        if (map1.containsValue(choice)) {
//            System.out.println(map);
//            System.out.println(map1);
//        } else {
//            System.out.println("Contul nu exista!");
//        }

    }

    @Override
    public void stopTracking() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        System.out.println("Introduce-ti pozitia contului pe care doriti sa il stergeti: ");
        choice = scanner.nextLine();
        irsList.remove(Integer.parseInt(choice));

        //OR use maps.
//        System.out.println("Introduce-ti numele persoanei: ");
//        choice = scanner.nextLine();
//        if (map1.containsValue(choice)) {
//            map1.clear();
//            map.clear();
//            System.out.println("Urmarirea a incetat!");
//        } else {
//            System.out.println("Contul nu exista!");
//        }


    }


    @Override
    public void accesAllAccounts() {
        for (List<Account> acc : irsList) {
            System.out.println(acc);
        }
    }

    public void addBankAccounts(Bank b) {
        irsList.addAll(b.getBankList());
    }
}
