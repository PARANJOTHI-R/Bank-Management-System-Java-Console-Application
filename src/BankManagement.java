import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class BankManagement {
    ArrayList<Account> accounts=new ArrayList<>();
    HashMap<Long,Account> hm=new HashMap<>();
    void loadAccounts(){
        try{
            FileInputStream fis=new FileInputStream("Accounts.dat");
            ObjectInputStream ois=new ObjectInputStream(fis);
            accounts=(ArrayList<Account>)ois.readObject();
            hm.clear();
            for(Account a:accounts){
                hm.put(a.getAccNo(),a);
            }
            fis.close();
            ois.close();
        }
        catch(Exception e){
            System.out.println("Error in loading accounts:"+e);
        }
    }
    void saveAccounts(){
        try {
            FileOutputStream fos = new FileOutputStream("Accounts.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(accounts);
            fos.close();
            oos.close();
        }catch(Exception e){
            System.out.println("Error in Saving"+e);
        }
    }
    void createAccount(String name,String type ,String phone){
        long accNo=accNoGen();
        Account a=new Account(accNo,name,type,phone);
        accounts.add(a);
        hm.put(a.getAccNo(),a);
        System.out.println("Account Created Successfully");
        System.out.println("Generated Acc No : "+ accNo);
    }
    void addAccount(Account a){
        if(hm.containsKey(a.getAccNo())){
            System.out.println("Account already Exist");
            return;
        }
        accounts.add(a);
        hm.put(a.getAccNo(),a);
        System.out.println("Account created successfully");
    }
    Account searchAccount(long accNo){
        return hm.get(accNo);
    }
    void viewAccounts(){
        if(accounts.isEmpty()){
            System.out.println("No accounts found");
            return;
        }
        System.out.println("\n------All accounts------");
        for(Account a:accounts){
            a.display();
        }
    }
    boolean deleteAccount(long accNo){
        Account a=hm.get(accNo);
        if(a!=null){
            accounts.remove(a);
            hm.remove(accNo);
            System.out.println("Account Successfully deleted");
            return true;
        }
        System.out.println("Account not found");
        return false;
    }
    //Management transaction activities
    boolean Mtransfer(long from,long to,double amt){
        Account src=searchAccount(from);
        Account rec=searchAccount(to);
        if(src==null || rec==null){
            System.out.println("Invalid transaction one of the account not exist");
            return false;
        }
        return src.transfer(rec,amt);
    }
    boolean Mdeposit(long accNo,double amt){
        Account a=searchAccount(accNo);
        if(a==null){
            System.out.println("Account not found");
            return false;
        }
        a.deposit(amt);
        return true;
    }
    boolean Mwithdraw(long accNo,double amt){
        Account a=searchAccount(accNo);
        if(a==null){
            System.out.println("Account not found");
            return false;
        }
        a.withdraw(amt);
        return true;
    }
    long accNoGen(){
        Random r=new Random();
        long accNo;
        do{
            accNo=1000000000000000L+(long)(r.nextDouble()*9000000000000000L);
        }while(hm.containsKey(accNo));
        return accNo;
    }


}
