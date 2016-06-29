package cs320.beans;

public class PageCounterBean {

	private int count;
	
	public PageCounterBean(){
		count = 0;
	}
	
	public int getCount(){
		return ++count;
	}
	
}
