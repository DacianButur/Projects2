import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Client implements Application{
    private final Account accountEUR = new Account();
    private final Account accountRON = new Account();
    private final List<Account> clientAccounts = new ArrayList<>();
    private String lastName;
    private String firstName;
    private String cnp;

    public Client() {
    }

    public List<Account> getClientAccounts() {
        return clientAccounts;
    }

    public void generateAccounts() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 10000;
        int max = 100000;
        System.out.println("Introduce-ti numele de familie: ");
        lastName = scanner.nextLine();
        accountEUR.setLastName(lastName);
        accountRON.setLastName(lastName);
        System.out.println("Introduce-ti prenumele: ");
        firstName = scanner.nextLine();
        accountEUR.setFirstName(firstName);
        accountRON.setFirstName(firstName);
        System.out.println("Introduce-ti CNP-ul: ");
        cnp = scanner.nextLine();
        accountEUR.setCnp(cnp);
        accountRON.setCnp(cnp);
        int nrContEur = random.nextInt(max - min) + min;
        int nrContRon = random.nextInt(max - min) + min;
        accountEUR.setAccountNumber("BTRLEUR" + nrContEur);
        accountRON.setAccountNumber("BTRLRON" + nrContRon);
        accountEUR.accountType = "EUR";
        accountRON.accountType = "RON";
        clientAccounts.add(accountEUR);
        clientAccounts.add(accountRON);
    }

    public void deleteAccounts() {
        if (accountEUR.balance > 0 && accountRON.balance > 0) {
            System.out.println("Nu puteti sterge conturile deoarece mai aveti fonduri disponibile. Prima data retrageti toate fondurile.");
        } else {
            clientAccounts.clear();
        }
    }

    @Override
    public void depositEUR() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce-ti suma pe care doriti sa o depuneti: ");
        try {
            double amount = scanner.nextDouble();
            if (amount < 1000) {
                System.out.println("Alimentarea a esuat. Depunerea minima este de 1000EUR");
            } else {
                accountEUR.balance += amount;
                System.out.println("Alimentare cont reusita! Soldul este :" + accountEUR.balance);
            }
        } catch (Exception e) {
            System.out.println("Introduce-ti suma in cifre!");
        }
    }

    @Override
    public void withdrawEUR() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce-ti suma pe care doriti sa o retrageti: ");
        try {
            double amount = scanner.nextDouble();
            if (accountEUR.balance < amount) {
                System.out.println("Retragere nereusita, fonduri insuficiente!");
            } else {
                accountEUR.balance = accountEUR.balance - amount;
                System.out.println("Retragere reusita! Soldul este: " + accountEUR.balance);
            }
        } catch (Exception e) {
            System.out.println("Introduce-ti suma in cifre!");
        }

    }

    @Override
    public void depositRON() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce-ti suma pe care doriti sa o depuneti: ");
        try {
            double amount = scanner.nextDouble();
            if (amount < 1000) {
                System.out.println("Alimentarea a esuat. Depunerea minima este de 1000RON");
            } else {
                accountRON.balance += amount;
                System.out.println("Alimentare cont reusita! Soldul este :" + accountRON.balance);
            }
        } catch (Exception e) {
            System.out.println("Introduce-ti suma in cifre!");
        }
    }


    @Override
    public void withdrawRON() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce-ti suma pe care doriti sa o retrageti: ");
        try {
            double amount = scanner.nextDouble();
            if (accountRON.balance < amount) {
                System.out.println("Retragere nereusita, fonduri insuficiente!");
            } else {
                accountRON.balance = accountRON.balance - amount;
                System.out.println("Retragere reusita! Soldul este: " + accountRON.balance);
            }
        } catch (Exception e) {
            System.out.println("Introduce-ti suma in cifre!");
        }
    }

    @Override
    public void showAccountsInfo() {
        clientAccounts.forEach(account -> {
            System.out.println("Prenume: " + account.getFirstName());
            System.out.println("Nume: " + account.getLastName());
            System.out.println("Tip de cont: " + account.accountType);
            System.out.println("Numar cont: " + account.getAccountNumber());
            System.out.println("Soldul disponibil: " + account.balance);
        });
    }

    @Override
    public String toString() {
        return "Client{" +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", cnp='" + cnp + '\'' +
                '}';
    }
}
