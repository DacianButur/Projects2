import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private Client client;
    private List<List<Account>> bankList = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public List<List<Account>> getBankList() {
        return bankList;
    }

    public void addClient(Client c) {
        bankList.add(c.getClientAccounts());
    }

    public void printStoredInformation() {
        for (List<Account> accounts : bankList) {
            System.out.println(accounts);
        }
    }
}
