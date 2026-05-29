import java.io.Serializable;
public class Account implements Serializable {
    private long accNo;
    private String accHolderName;
    private String accType;
    private double balance;
    private String phoneNo;
    private int transCnt;

    Account(long accNo,String accHolderName,String accType,String phoneNo){
        setAccNo(accNo);
        setAccHolderName(accHolderName);
        setAccType(accType);
        setPhoneNo(phoneNo);
        transCnt=0;
        balance=0;
    }

    void setAccNo(long accNo){
        int len=String.valueOf(accNo).length();
        if(len!=16){
            System.out.println("Invalid");
            return;
        }
        this.accNo=accNo;
    }
    long getAccNo(){
        return accNo;
    }

    void setPhoneNo(String phoneNo){
        if(phoneNo.length()!=10){
            System.out.println("Ivalid");
            return;
        }
        this.phoneNo=phoneNo;
    }
    String getPhoneNo(){
        return phoneNo;
    }

    void setAccType(String accType){
        this.accType=accType;
    }
    String getAccType(){
        return accType;
    }

    double getBalance(){
        return balance;
    }

    void setAccHolderName(String accHolderName){
        this.accHolderName=accHolderName;
    }
    String getAccHolderName(){
        return accHolderName;
    }

    int getTransCnt(){
        return transCnt;
    }


    boolean deposit(double val){
        if(val<=0){
            System.out.println("Invalid transaction");
            return false;
        }
        balance+=val;
        transCnt++;
        return true;
    }
    boolean withdraw(double val){
        double remaining=this.balance-val;
        if(remaining<0){
            System.out.println("Amount Exceeding the Acc balance");
            return false;
        }
        this.balance=remaining;
        transCnt++;
        return true;
    }
    boolean transfer(Account target,double amount){
        if(withdraw(amount)){
            target.deposit(amount);
            System.out.println("Successfully Transferred");
            return true;
        }
        return false;
    }
    void display(){
        System.out.println("\n-----Customer Details------");
        System.out.println("Account Number: " + accNo);
        System.out.println("Account Holder: " + accHolderName);
        System.out.println("Account Type: " + accType);
        System.out.println("PhoneNo: " + phoneNo);
        System.out.println("Balance: " + balance);
        System.out.println("Transactions : " + transCnt);
        System.out.println("------------------");
    }


}
