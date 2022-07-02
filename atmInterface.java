                                                    //ATM INTERFACE PROJECT FOR OASIS INFOBYTE

import java.util.Scanner;
public class atmInterface {
	String name;
	String username;
	String password;
	String accountno;
	float balance=100000f;
	int transactions=0;
	String transactionsHistory="";
	public void register() {
		Scanner in=new Scanner(System.in);
		System.out.print("\nEnter Your Name-");
		this.name=in.nextLine();
		System.out.print("\nEnter Your Username-");
		this.username=in.nextLine();
		System.out.print("\nEnter Your Password-");
		this.password=in.nextLine();
		System.out.print("\nEnter Your Account Number-");
		this.accountno=in.nextLine();
		System.out.println("\nRegistration completed..you can now login..");
	}

	public boolean isLogin() {
		boolean login=false;
		Scanner in=new Scanner(System.in);
		while (!login) {
			System.out.print("\nEnter Your Username-");
			String userName=in.nextLine();
			if (userName.equals(username)) {
				while (!login) {
					System.out.print("\nEnter Your Password-");
					String pwd=in.nextLine();
					if (pwd.equals(password)) {
						System.out.print("\nYou have successfully logged in!");
							login=true;
					}
					else {
						System.out.print("\nIncorrect Password, please check the password that you have entered");
					}
				}
			}else {
				System.out.print("\nUsername not found, please check the username that you have entered");
			}
				
				
			}
		return login;
		}
		public void withdraw() {
			System.out.print("\nEnter amount to withdraw-");
			Scanner in=new Scanner(System.in);
			float amount=in.nextFloat();
			try {
				if (balance>=amount) {
					transactions++;
					balance-=amount;
					System.out.println("\n"+amount+" Rs Withdrawn Successfully");
					String str=amount+" Rs Withdrawn\n";
					transactionsHistory=transactionsHistory.concat(str);
					
				}
				else {
					System.out.println("\n Sorry ...Limit is 100000.00");
				}
				
			}
			catch(Exception e){
			}
		}
		public void deposit() {
			System.out.print("\nEnter amount to deposit-");
			Scanner in=new Scanner(System.in);
			float amount=in.nextFloat();
			try {
				if (amount<=100000f) {
					transactions++;
					balance+=amount;
					System.out.println("\n"+amount+" Rs Successfully Deposited");
					String str=amount+" Rs deposited\n";
					transactionsHistory=transactionsHistory.concat(str);
				}
				else {
					System.out.println("\n Sorry ...Limit is 100000.00");
				}
			}
			catch(Exception e){
			}
		}
		public void transfer() {
			Scanner in=new Scanner(System.in);
			System.out.print("\nEnter Recepient's Name-");
			String receipent=in.nextLine();
			System.out.print("\nEnter amount to transfer-");
			
			float amount=in.nextFloat();
			try {
				if (balance>=amount) {
					if (amount<=500000f) {
					transactions++;
					balance-=amount;
					System.out.println("\nSuccessfully Transfered "+amount+" to "+receipent);
					String str=amount+" Rs transfered to"+receipent+"\n";
					transactionsHistory=transactionsHistory.concat(str);
					
				}
				else {
					System.out.println("\n Sorry ...Limit is 100000.00");
				}
				
			}
			else {
					System.out.println("\n Insufficient Balance");
				}
			}
			catch(Exception e){
			}
			
		}
		public void checkBalance() {
			System.out.println("\n"+"balance="+balance+" Rs");
		}
		public void transac() {
			if (transactions==0)
			{
				System.out.println("\nEmpty");
			}
			else {
				System.out.println("\n"+transactionsHistory);
			}
		}

	public static int takeInput(int limit) {
		int input=0;
		boolean flag=false;
		while(!flag) {
			try {
				Scanner in=new Scanner (System.in);
				input=in.nextInt();
				flag=true;
				if (flag&&input>limit || input<1) {
					System.out.println("Choose the number between 1 to "+limit);
					flag=false;
				}
			}
			catch(Exception e) {
				System.out.println("Enter only integer value");
				flag=false;
			}
		}
		return input;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\n ****Welcome to ATM interface system***\n");
		System.out.println("1.Register\n2.Exit");
		System.out.println("Enter your choice");
		int choice= takeInput(2);
		if (choice==1) {
			atmInterface b=new atmInterface();
			b.register();
			while (true) {
				System.out.println("\n 1.Login\n 2.Exit ");
				System.out.print("Enter your choice-");
				int ch=takeInput(2);
				if (ch==1) {
					if (b.isLogin()) {
						System.out.println("\n\n ****WELCOME BACK "+b.name+"****\n");
						boolean finished=false;
						while (!finished) {
							System.out.println("\n 1.Withdraw \n 2.Deposit \n 3.Transfer \n 4.Check Balance\n 5.Transactions History\n 6.Exit");
							System.out.print("\nEnter your choice-");
							int c=takeInput(6);
							switch(c) {
							case 1:
								b.withdraw();
								break;
							case 2:
								b.deposit();
								break;
							case 3:
								b.transfer();
								break;
							case 4:
								b.checkBalance();
								break;
							case 5:
								b.transac();
								break;
							case 6:
								finished=true;
								break;
							}
						}
					}
				}else {
					System.exit(0);
					System.out.println("Thank you for using our ATM services");
				}
			}
		}
			
	}
	
}

