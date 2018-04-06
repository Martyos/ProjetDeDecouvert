package constantes;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

public enum Statics {
	
	APPNAME ("Cool app"),
	APPDIM (Toolkit.getDefaultToolkit().getScreenSize()),
	DEVICE(GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0]),
	BASICDIM(new Dimension(50,50));
	
	private Object name = new Object();
   
	// Constructor
	Statics(Object name) {
		this.name = name;
	}
	
	public String toString(){
		return this.name.toString();
	}
	
	public Object getObject() {
		return this.name;
	}
}
