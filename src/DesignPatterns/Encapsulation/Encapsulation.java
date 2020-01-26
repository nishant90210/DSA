//DesignPatterns.Encapsulation in Java is achieved using access modifier private, protected and public.
//Factory pattern , Singleton pattern in Java makes good use of DesignPatterns.Encapsulation.

package DesignPatterns.Encapsulation;

//DesignPatterns.Encapsulation is nothing but protecting anything which is prone to change. rational behind encapsulation is that if any
//functionality which is well encapsulated in code i.e maintained in just one place and not scattered around code is easy 
//to change. this can be better explained with a simple example of encapsulation in Java. we all know that constructor is 
//used to creating object in Java and constructor can accept an argument. Suppose we have a class Loan has a constructor 
//and then in various classes, you have created an instance of the loan by using this constructor. now requirements change
//and you need to include the age of borrower as well while taking a loan. 


//Since this code is not well encapsulated i.e. not confined in one place you need to change everywhere you are calling 
//this constructor i.e. for one change you need to modify several file instead of just one file which is more error prone 
//and tedious, though it can be done with refactoring feature of advanced IDE wouldn't it be better if you only need to 
//make change at one place? Yes, that is possible if we encapsulate Loan creation logic in one method say createLoan() and 
//client code call this method and this method internally create Loan object. in this case, you only need to modify this 
//method instead of all client code.


class Encapsulation{
	private int duration;  //private variables examples of encapsulation
	private String loan;
	private String borrower;
	private String salary;

	//public constructor can break encapsulation instead use factory method
	private Encapsulation(int duration, String loan, String borrower, String salary){
		this.duration = duration;
		this.loan = loan;
		this.borrower = borrower;
		this.salary = salary;
	}

	//no argument constructor omitted here

	// create loan can encapsulate loan creation logic
	public Encapsulation createLoan(String loanType){

		//processing based on loan type and then returning loan object
		return null;
	}

}