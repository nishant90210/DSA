package DesignPatterns.ObserverPattern;

import java.util.ArrayList;

public class PostOffice implements Subject{

	private String address;
	private ArrayList<Observer> observers;
	
	public PostOffice(String address) {
		super();
		this.address = address;
		observers = new ArrayList<Observer>();
	}

	@Override
	public void addObserver(Observer o) {
		
		observers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
		
		observers.remove(o);
		
	}

	@Override
	public void notifyObserver() {
		
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).update();
		}
		
	}

}
