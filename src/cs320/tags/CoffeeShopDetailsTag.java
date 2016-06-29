package cs320.tags;

import java.io.IOException;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class CoffeeShopDetailsTag extends SimpleTagSupport {
	
	protected int coffeeShopId = -1;
	
	public void doTag() throws JspException, IOException{
		
		// Get a reference to my OUT object
		JspWriter out = this.getJspContext().getOut();
		
		out.write("Hello from CoffeeShopDetailsTag");
	}
	
	public void setCoffeeShopId(String id){
		try{
			this.coffeeShopId = Integer.parseInt(id);
		}catch(Exception e){
			this.coffeeShopId = -1;
		}
	}
}
