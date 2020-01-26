package DesignPatterns.ObserverPattern;

public class MailBox implements Observer {

	@Override
	public void update() {
	
		System.out.println("New Mail Arrived");

	}

}
