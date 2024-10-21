import java.awt.*;
import javax.swing.*;

public class circles {
	//declare variables
	
	private int locX;
	private int locY;
	private int diameter;
	private Color color;
	private int dX;
	private int dY;
	private int height;
	private int width;

	public circles(int x, int y, int d, Color c, int w, int h) {
		//initiate variables
		
		locX = x;
		locY = y;
		color = c;
		diameter = d;
		height = h;
		width = w;
		dX = -50;
		dY = -50;
	}
	void setLocX(int x) {
		//return x
		locX = x;
		
	}
	void setLocY(int y) {
		//return y
		locY = y;

	}
	void drawBall(Graphics g) {
		//draw stuff
		g.setColor(color);
		int color2= (int)((1500 - 0 + 1)*Math.random()+0);
		if (color2 == 1) {
			g.setColor(Color.black);
		}
		g.fillOval(getLocX(), getLocY(), diameter, diameter);

	}
	int getLocX() {
		// return locX
		return locX;
	}
	int getLocY() {
		// return locY
		return locY;
	}

	public void dissappear() {
		// circles go bye bye
		locX= dX;
		locY= dY;
		
	
	}
	int getX(){
		// return more stuff
		return dX;
	}
	int getY() {
		//return even more stuff
		return dY;
	}
	int getDiameter() {
		// return even even more stuff
		return diameter;
	}
	}

