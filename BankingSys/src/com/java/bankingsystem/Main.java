package com.java.bankingsystem;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main 
{
	HashMap<Integer, Accounts> accountsData = new HashMap<Integer, Accounts>();
	void home() {
		Scanner sc = new Scanner(System.in);
	     System.out.println("Enter 1 for Login");
	     System.out.println("Enter 2 for Creating Customer Account");
	     int choice = sc.nextInt();
	     if(choice ==1) {
	    	login(); 
	     }else if(choice == 2) {
	    	register();
	     }else {
	    	 System.out.println("Invalid option Entered");
	    	 home();
	     }
	}
	int generatePin()
	{
	    Random random = new Random();
	    int a = random.nextInt(9), b = random.nextInt(9);
	    int pinNo = 1000+(a*b);
	    return pinNo;
	    
	}
	
	void register() 
	{
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		System.out.println("***Creating a customer account***");
		System.out.println("Enter the FirstName");
		String firstName = sc.nextLine();
		System.out.println("Enter Username");
		String username = sc.nextLine();
		System.out.println("Enter Lastname");
		String lastName = sc.nextLine();
		System.out.println("Enter the Age");
		int age = sc1.nextInt();
		System.out.println("Enter the Address");
		String address = sc.nextLine();
		System.out.println("Enter Mobile number");
		String mobileNumber = sc.nextLine();
		System.out.println("Enter EmialId");
		String eMailID = sc.nextLine();
		System.out.println("Enter the Date of birth");
		String dateOfBirth = sc.nextLine();
		System.out.println("Enter Your Account Number : ");
		int acNo = sc1.nextInt();
		 if(acNo > 100000 && acNo < 999999) {
	        int generatePin = generatePin();
		System.out.println("Re enter the Pin Number : " +generatePin);
		long pinNo = sc1.nextLong();
		 if(pinNo == generatePin) {
		System.out.println("Enter the Initial Deposit amount : ");
		int depAmt = sc1.nextInt();
		 if(depAmt>999) {
			 Accounts accounts = new Accounts(firstName,username,lastName,age,address,mobileNumber,eMailID,dateOfBirth,acNo,depAmt,pinNo);
			 accountsData.put(acNo, accounts);
			 System.out.println(accountsData);
			 System.out.println("Account Successfully Created ");
			 accountSection(acNo,pinNo);
		 }else {
			 System.out.println("Please Enter a valid amount");
		 }
		 }else {
			 System.out.println("Please Enter a valid Pin No");
		 }
		 }else {
			 System.out.println("Please Enter a valid account number");
		 }
		    
	}
	
	void login(){
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter your account no:");
	    int acNo = sc.nextInt();
	    System.out.println("Enter the User Name");
	    String acName = sc.next();
	    System.out.println("Enter your pin ..");
	    int pinNo = sc.nextInt();
	    accountSection(acNo,pinNo);
	}
	void accountSection(int acNo,long pinNo){
	    Scanner sc=new Scanner(System.in);
	    Accounts accounts=null;
	    boolean isAccExisits = false;
	    for(Map.Entry<Integer,Accounts>entry:accountsData.entrySet()){
	        accounts = entry.getValue();
	        if(acNo == entry.getKey()&& pinNo==accounts.getpinNumber()){
	   
	             System.out.println("******* Account Info ***********");
	             System.out.println("FirstName 	    : "+accounts.getfirstName());
	     		 System.out.println("Username  	    : "+accounts.getUsername());
	     		 System.out.println("LastName  	    : "+accounts.getlastName());
	     		 System.out.println("Age       	    : "+accounts.getage());
	     		 System.out.println("Address   	    : "+accounts.getaddress());
	     		 System.out.println("MobileNumber 	: "+accounts.getmobileNumber());
	     		 System.out.println("EMailID		: "+accounts.geteMailID());
	     		 System.out.println("Dateofbirth  	: "+accounts.getDateofbirth());
	             System.out.println("Account no     : "+entry.getKey());
	             System.out.println("Avail balance  : "+accounts.getdepoistAmount());	             
	             isAccExisits = true;
	        }
	    }
	    if(isAccExisits == false){
	        System.out.println("Your account doesn't exist");
	        register();
	    }else{
	    	System.out.println("Enter 0 to Exit");
	        System.out.println("Enter 1 for depoist");
	        System.out.println("Enter 2 for withdraw");
	        System.out.println("Enter 3 for closing account");
	        System.out.println("Enter 4 for view balance");
	        int choice = sc.nextInt();
	        switch(choice){
	        case 0: home(); break;
	        case 1:
	        System.out.println("Enter the deposit amount : ");
            double depAmt = sc.nextDouble();
            if(depAmt>100) {
            accounts.depoistAmount += depAmt;
            System.out.println("Amount Deposited");
            accountSection(acNo,pinNo);
            }else {
            	System.out.println("Deposit amount greater than 200");
            	 accountSection(acNo,pinNo);
            }
            break;
            
	        case 2:
		        System.out.println("Enter the withdraw amount : ");
	            Double withAmt = sc.nextDouble();
	            if(withAmt<200 && withAmt<accounts.getdepoistAmount()) {
	            accounts.depoistAmount -= withAmt;
	            System.out.println("Amount withdraw");
	            accountSection(acNo,pinNo);
	            break;
	            }else {
	            	System.out.println("Insufficient Balance");
	            	accountSection(acNo,pinNo);
	            }
	        case 3:
	        	
	        	System.out.println("Enter the account No :");
	            int acNo1 = sc.nextInt();
	            System.out.println("Enter pin");
	            pinNo = sc.nextInt();
	            boolean flag=false;
	            for(Map.Entry<Integer,Accounts>entry:accountsData.entrySet())
	            {
	            	int acNum=entry.getKey();
	    	        accounts = entry.getValue();
	    	        if(acNum == acNo1 && pinNo==accounts.getpinNumber())
	    	        {
	    	        	accountsData.remove(acNum);
	    	        	System.out.println("Account closed successfully");
	    	        	flag=true;
	    	        }
	    	       
	            }
	            if(flag==false)
	            {
	            	System.out.println("Invalid account num or pin");
	            }
	            home();
	            break;
	        case 4:
		        System.out.println("Available balance:"+accounts.getdepoistAmount());
		        accountSection(acNo,pinNo);
		        break;
            default:System.out.println("Enter the valid choice");accountSection(acNo,pinNo);
	        }
	    }
	}
	                                     
	public static void main(String[] args) 
	{
	     Main main1 = new Main();
	     main1.home();
	}     

}
