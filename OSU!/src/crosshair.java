import java.awt.Color;
import java.awt.Graphics;

public class crosshair {
	//declare variables
	
	private int locX;
	private int locY;
	private Color color;
	private int diameter;
	
	public crosshair(int x, int y, Color c, int d){
		// initiate variables
		
		locX = x;
		locY = y;
		color = c;
		diameter = d;
	}
	void drawUser(Graphics g) {
		// draw stuff
		
		g.setColor(color);
		g.fillOval(locX, locY, diameter, diameter);
	}
	public void blackMoved() {
		// move the cursor
		
		locX = getlocX() - (diameter/2);
		locY = getlocY() - (diameter/2);
	}
	void setLocation(int x, int y) {
		// get the location of the cursor
		
		locX = x;
		locY = y;
	}
	boolean ballCollision(int x, int y, int d) {
		//check if circles have touched 
		
		int disX = (x + d/2) - (locX + diameter/2);
		int disY = (y + d/2) - (locY + diameter/2);
		int radii = d/2 + diameter/2;
	return (((disX * disX) + (disY * disY)) < (radii * radii));
		
	
	}

	int getlocX() {
		// return stuff
		return locX;
	}
	int getlocY() {
		// return more stuff
		return locY;
	}
	
}