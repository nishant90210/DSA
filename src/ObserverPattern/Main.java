package ObserverPattern;

public class Main {

	public static void main(String[] args) {

		MailBox mailBox = new MailBox();
		PostOffice postOffice = new PostOffice("House No - 33");
		
		postOffice.addObserver(mailBox);
		postOffice.notifyObserver();
		postOffice.removeObserver(mailBox);

	}

}
