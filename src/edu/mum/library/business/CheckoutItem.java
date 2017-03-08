package edu.mum.library.business;

public abstract class CheckoutItem {
	protected boolean available;
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
}
