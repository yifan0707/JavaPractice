package part11_DeadLock;

public class BankAccount {
    private int balance;

    public BankAccount(){
        balance=10000;
    }

    public void deposite(int i){
        balance+=i;
    }

    public void withdraw(int i){
        balance-=i;
    }

    public int getBalance(){
        return balance;
    }

    public static void transefer(BankAccount account1,BankAccount account2,int amount){
        account1.withdraw(amount);
        account2.deposite(amount);
    }

}
