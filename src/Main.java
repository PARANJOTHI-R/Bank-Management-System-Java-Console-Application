import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        BankManagement bm=new BankManagement();
        bm.loadAccounts();
        while(true){
            System.out.println("\n===== BANK PORTAL =====");
            System.out.println("1.Admin");
            System.out.println("2.Customer");
            System.out.println("3.Exit");

            System.out.print("Enter Choice : ");
            int role=sc.nextInt();
            sc.nextLine();

            switch(role){
                //Admin
                case 1:
                    while(true){
                        System.out.println("\n===== ADMIN PANEL =====");
                        System.out.println("1.Create Account");
                        System.out.println("2.View All Accounts");
                        System.out.println("3.Search Account");
                        System.out.println("4.Deposit");
                        System.out.println("5.Withdraw");
                        System.out.println("6.Transfer");
                        System.out.println("7.Delete Account");
                        System.out.println("8.Logout");

                        System.out.print("Enter Choice : ");
                        int ch=sc.nextInt();
                        sc.nextLine();

                        switch(ch){

                            case 1:
                                System.out.print("Enter Holder Name : ");
                                String name=sc.nextLine();

                                System.out.print("Enter Account Type : ");
                                String type=sc.nextLine();

                                System.out.print("Enter Phone No : ");
                                String phone=sc.nextLine();

                                bm.createAccount(name,type,phone);
                                break;
                            case 2:
                                bm.viewAccounts();
                                break;
                            case 3:
                                System.out.print("Enter Account No : ");
                                long search=sc.nextLong();
                                Account found=bm.searchAccount(search);
                                if(found!=null){
                                    found.display();
                                }
                                else{
                                    System.out.println("Account not found");
                                }
                                break;
                            case 4:
                                System.out.print("Enter Account No : ");
                                long depAcc=sc.nextLong();
                                System.out.print("Enter Amount : ");
                                double depAmt=sc.nextDouble();
                                bm.Mdeposit(depAcc,depAmt);
                                break;
                            case 5:
                                System.out.print("Enter Account No : ");
                                long withAcc=sc.nextLong();
                                System.out.print("Enter Amount : ");
                                double withAmt=sc.nextDouble();
                                bm.Mwithdraw(withAcc,withAmt);
                                break;
                            case 6:
                                System.out.print("From Account No : ");
                                long from=sc.nextLong();
                                System.out.print("To Account No : ");
                                long to=sc.nextLong();
                                System.out.print("Amount : ");
                                double amt=sc.nextDouble();
                                bm.Mtransfer(from,to,amt);
                                break;
                            case 7:
                                System.out.print("Enter Account No : ");
                                long del=sc.nextLong();
                                bm.deleteAccount(del);
                                break;
                            case 8:
                                bm.saveAccounts();
                                System.out.println("Admin Logout");
                                break;
                            default:
                                System.out.println("Invalid Choice");
                        }

                        if(ch==8){
                            break;
                        }
                    }

                    break;
                //Customer
                case 2:
                    System.out.print("Enter Account No : ");
                    long accNo=sc.nextLong();

                    Account current=bm.searchAccount(accNo);

                    if(current==null){
                        System.out.println("Invalid Account");
                        break;
                    }

                    while(true){
                        System.out.println("\n===== CUSTOMER PANEL =====");
                        System.out.println("1.View Account");
                        System.out.println("2.Check Balance");
                        System.out.println("3.Withdraw");
                        System.out.println("4.Transfer");
                        System.out.println("5.Deposit");
                        System.out.println("6.Logout");

                        System.out.print("Enter Choice : ");
                        int ch=sc.nextInt();

                        switch(ch){
                            case 1:
                                current.display();
                                break;
                            case 2:
                                System.out.println("Available Balance : "+ current.getBalance());
                                break;
                            case 3:
                                System.out.print("Enter Amount : ");
                                double w=sc.nextDouble();
                                bm.Mwithdraw(current.getAccNo(),w);
                                break;
                            case 4:
                                System.out.print("Receiver Acc No : ");
                                long to=sc.nextLong();
                                System.out.print("Amount : ");
                                double amt=sc.nextDouble();
                                bm.Mtransfer(current.getAccNo(),to,amt);
                                break;
                            case 5:
                                System.out.print("Enter Amount : ");
                                double d=sc.nextDouble();
                                bm.Mdeposit(current.getAccNo(),d);
                                break;
                            case 6:
                                bm.saveAccounts();
                                System.out.println("Customer Logout");
                                break;
                            default:
                                System.out.println("Invalid Choice");
                        }
                        if(ch==6){
                            break;
                        }
                    }

                    break;

                case 3:
                    bm.saveAccounts();
                    System.out.println("Program Closed");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}