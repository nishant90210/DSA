package DesignPatterns.Polymorphism;

// Private and Static keywords Assembly instruction is "invokespecial" and "invokestatic" respectively, which invokes Static Binding
// Public keyword Assembly instruction is "invokevirtual", which invokes Dynamic Binding


public class TradingSystem{
   public String getDescription(){
      return "electronic trading system";
   }
   
   public void showDescription(TradingSystem tradingSystem){
	   System.out.println(tradingSystem.getDescription());
	}
   
   
   public static void main(String[] args) {
	  
	   CommodityTradingSystem tradingSystem = new CommodityTradingSystem();
	   tradingSystem.showDescription(tradingSystem);
	   
   }
   
}


//If there is any private, final or static method in a class, there is static binding.
		//Static binding/Compile-Time binding/Early binding/Method overloading.(in same class)

//When type of the object is determined at run-time, it is known as dynamic binding.
	//Dynamic binding/Run-Time binding/Late binding/Method overriding.(in different classes.)

//class Animal{  
//	void eat() {
//		System.out.println("animal is eating...");
//	}  
//}  
//
//class Dog extends Animal{  
//	void eat() {
//		System.out.println("dog is eating...");
//	}  
//
//	public static void main(String args[]){  
//		Animal a=new Dog();  
//		a.eat();  
//	}  
//}

										//static binding

//class Animal{  
//	static void eat() {
//		System.out.println("animal is eating...");
//	}  
//}  
//
//class Dog extends Animal{  
//	static void eat() {
//		System.out.println("dog is eating...");
//	}  
//
//	public static void main(String args[]){  
//		Animal.eat();
//	}  
//}


//@SuppressWarnings("rawtypes")
//class StaticBindingTest {
//
//    public static void main(String args[])  {
//       Collection c = new HashSet();
//       StaticBindingTest et = new StaticBindingTest();
//       et.sort(c);
//
//    }
//
//    //overloaded method takes Collection argument
//    public Collection sort(Collection c){
//        System.out.println("Inside Collection sort method");
//        return c;
//    }
//
//
//   //another overloaded method which takes HashSet argument which is sub class
//    public Collection sort(HashSet hs){
//        System.out.println("Inside HashSet sort method");
//        return hs;
//    }
//
//}