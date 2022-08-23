package com.java.bankingsystem;

public class Accounts 
{/*
  String accountName;
  int pinNumber;
  int depoistAmount;

  public Accounts(String accountName,int pinNumber,int depoistAmount)
  {
     this.accountName = accountName;
	 this.pinNumber = pinNumber;
	 this.depoistAmount = depoistAmount;

  }

	@Override
	public String toString() {
		return "Accounts [accountName=" + accountName + ", pinNumber=" + pinNumber + ", depoistAmount=" + depoistAmount
				+ "]";
	}
  
}*/

    private String firstName;
    private  String username;
    private String lastName;
    private int age;
    private String address;
    private String mobileNumber;
    private String eMailID;
    private String dateOfBirth;
    private long accountNumber;
    double depoistAmount;
    private long pinNumber;
       public long getpinNumber() {
	   return pinNumber;
       }
       public void setpinNumber(long pinNumber) {
	   this.pinNumber = pinNumber;
       }

       public double getdepoistAmount() {
	   return depoistAmount;
       }
       public void setdepoistAmount(double depoistAmount) {		
       this.depoistAmount = depoistAmount;
       }
       public long getaccountNumber() {
	   return accountNumber;
       }

       public Accounts() {
	   super();
	     this.firstName = firstName;
	     this.username = username;
	     this.lastName = lastName;
	     this.age = age;
	     this.address = address;
	     this.mobileNumber = mobileNumber;
	     this.eMailID = eMailID;
	     this.dateOfBirth = dateOfBirth;
	     this.accountNumber = accountNumber;
	     this.pinNumber =pinNumber;
       }
       
     public Accounts(String firstName, String username, String lastName, int age, String address, String mobileNumber,
			String eMailID, String dateOfBirth, long accountNumber, double depoistAmount, long pinNumber) {
		super();
		this.firstName = firstName;
		this.username = username;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.eMailID = eMailID;
		this.dateOfBirth = dateOfBirth;
		this.accountNumber = accountNumber;
		this.depoistAmount = depoistAmount;
		this.pinNumber = pinNumber;
	}
	public String getfirstName() {
	 return firstName;
     }
     public void setfirstName(String firstName) {
	 if(firstName.contains(null) &&firstName.trim().equals(" "))
		throw new IllegalArgumentException("firstName should not be null or empty");
	 else firstName = firstName;
     }
     public String getUsername() {
	 return username;
     }
     public void setusername(String username) {
	 if(username.contains(null) && username.trim().equals(" "))
		throw new IllegalArgumentException("username should not be null or empty");
	 else username = username;
     }
     public String getlastName() {
	 return lastName;
     }
     public void setlastName(String lastName) {
	 if(lastName.contains(null) && lastName.trim().equals(" "))
		throw new IllegalArgumentException("username should not be null or empty");
	 else lastName = lastName;
     }
     public int getage() {
	 return age;
     }
     public void setage(int age) {
	 if(age < 0 || age >100)
		throw new IllegalArgumentException("Age should be greater than zero");
	 else age = age;
     }
     public String getaddress() {
	 return address;
     }
     public void setaddress(String address) {
	 if(address.contains(null) && address.trim().equals(" "))
		throw new IllegalArgumentException("address should not be null or empty");
	 address = address;
     }
     public String getmobileNumber() {
	 return mobileNumber;
     }
     public void setmobileNumber(String mobileNumber) {
	
	    char c =0;
	    for(int i =0 ;i<=mobileNumber.length();i++)
	    {
		    c=mobileNumber.charAt(i);
		    if(!Character.isAlphabetic(c))
		    {
			  System.out.println("invalid mobile number");
		    }
		    else this.mobileNumber = mobileNumber;
	    }		
	
      }
     public String geteMailID() {
	 return eMailID;
     }
     public void seteMailID(String eMailID) {
	    if(eMailID.contains(null) && eMailID.trim().equals(" "))
		  throw new IllegalArgumentException("eMailID should not be null or empty");
	    else eMailID = eMailID;
        }
     public String getDateofbirth() {
	 return dateOfBirth;
     }
     public void setDateofbirth(String dateofbirth) {
	  dateOfBirth = dateofbirth;
  }
	@Override
	public String toString() {
		return "Accounts [firstName=" + firstName + ", username=" + username + ", lastName=" + lastName + ", age=" + age
				+ ", address=" + address + ", mobileNumber=" + mobileNumber + ", eMailID=" + eMailID + ", dateOfBirth="
				+ dateOfBirth + ", accountNumber=" + accountNumber + ", depoistAmount=" + depoistAmount + ", pinNumber="
				+ pinNumber + "]";
	}
     
     
}
