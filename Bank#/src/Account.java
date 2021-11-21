public class Account {
    private String lastName;
    private String firstName;
    private String cnp;
    private String accountNumber;
    public double balance;
    public String accountType;

    public Account(String lastName, String firstName, String cnp, double balance, String accountNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.cnp = cnp;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Account() {
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public double getBalance() {
        return balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCnp() {
        return cnp;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", cnp='" + cnp + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }

}
