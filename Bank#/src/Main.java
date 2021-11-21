import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // password for accesing Autoritate Fiscala --> 2498
        Client client = new Client();
        Bank bank = new Bank("BT");
        FiscalAuthorities irs = new FiscalAuthorities();
        Scanner scanner = new Scanner(System.in);
        byte customerChoice;
        byte customerChoice1;
        int irsChoice;
        System.out.println("Buna ziua, bine ati venit la BT!\nVa rugam sa folositi doar cifre pentru a naviga prin meniu.");
        do {
            System.out.println("Ce operatiuni doriti sa faceti?\n1.Creare conturi.\n2.Stergere conturi.\n3.Vizualizati informatiile despre conturi.\n4.Altele.");
            customerChoice = scanner.nextByte();
            switch (customerChoice) {
                case 1 -> {
                    client = new Client();
                    client.generateAccounts();
                    bank.addClient(client);
                }
                case 2 -> client.deleteAccounts();
                case 3 -> client.showAccountsInfo();
            }
        } while (customerChoice != 4);

        do {
            System.out.println("Ce cont doriti sa folositi? ---> \n1.EUR\n2.RON\n3.Inapoi\n5.Autoritate fiscala.");
            customerChoice1 = scanner.nextByte();
            switch (customerChoice1) {
                case 1 -> {
                    System.out.println("1.Alimentare cont EUR.\n2.Retragere fonduri EUR.");
                    customerChoice1 = scanner.nextByte();
                    if (customerChoice1 == 1) {
                        client.depositEUR();
                    } else {
                        client.withdrawEUR();
                    }
                }
                case 2 -> {
                    System.out.println("1.Alimentare cont RON. \n2.Retragere fonduri RON.");
                    customerChoice1 = scanner.nextByte();
                    if (customerChoice1 == 1) {
                        client.depositRON();
                    } else {
                        client.withdrawRON();
                    }
                }
                case 3 -> {
                    do {
                        System.out.println("Ce operatiuni doriti sa faceti?\n1.Stergere conturi.\n2.Vizualizati informatiile despre conturi.\n3.Altele.");
                        customerChoice = scanner.nextByte();
                        switch (customerChoice) {
                            case 1 -> client.deleteAccounts();
                            case 2 -> client.showAccountsInfo();
                        }
                    } while (customerChoice != 3);

                }
            }
        } while (customerChoice1 != 5);

        System.out.println("Introduce-ti parola: ");
        irsChoice = scanner.nextInt();
        irs.addBankAccounts(bank);
        if (irsChoice == 2498) {
            do {
                System.out.println("1.Incepeti urmarirea conturilor unei persoane.\n2.Incetati urmarirea conturilor unei persoane.\n3.Accesati toate conturile.\n4.Iesire");
                irsChoice = scanner.nextByte();
                switch (irsChoice) {
                    case 1 -> irs.startTracking();
                    case 2 -> irs.stopTracking();
                    case 3 -> irs.accesAllAccounts();
                }

            } while (irsChoice != 4);
        } else System.out.println("Acces nepermis!");
    }
}

