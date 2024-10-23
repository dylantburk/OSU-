
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
	
public class osumain extends JPanel implements MouseMotionListener, ActionListener, KeyListener, MouseListener{
	// declaration of variables

		private circles lotsOfBalls[] = new circles[7];
		private crosshair crosshair = new crosshair(280, 280, Color.GREEN, 20);
		private Timer timer = new Timer(1000,this);
		private int counter;
		private String count = "";
		private int countX;
		private boolean lose = false;
		private boolean win = false;
		private int click;
		private Color darkGrey = new Color(25,25,25);
		JFrame frame = new JFrame("Dylan Burkholder - OSU!");
		private Container can = frame.getContentPane();
		private JButton button = new JButton("restart");
		
		
		public osumain() {
		//initiates variables	
			
			button.setBackground(darkGrey);
			button.setOpaque(true);
			can.add(this);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setPreferredSize(new Dimension(600,600));
			frame.pack();
			addMouseMotionListener(this);
			frame.addKeyListener(this);
			frame.addMouseListener(this);
			counter = 6;
			button.addActionListener(this);

				
			for(int i = 0; i < lotsOfBalls.length; i++) {
				lotsOfBalls[i] = new circles((int)((555 - 45 +1) * Math.random() + 45), (int)((555 - 45 +1) * Math.random() + 45), 45, Color.magenta, 600, 600);
	
			}
			frame.setCursor(frame.getToolkit().createCustomCursor(new BufferedImage(3,3, BufferedImage.TYPE_INT_ARGB), new Point (0,0), "null"));
			frame.setVisible(true);
			timer.start();
			if(lose == true) {
				timer.stop();
			}
			if(win == true) {
				timer.restart();
			}
		}

		public void paintComponent(Graphics g) {
			//draw stuff
			
			g.setColor(darkGrey);
			g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
			if(lose == false) {
				for(int i = 0; i < lotsOfBalls.length; i++) {
				lotsOfBalls[i].drawBall(g);	
				}
			}
				g.setColor(Color.white);
				g.drawString(count, countX, 25);
				crosshair.drawUser(g);
			
		}

	public static void main(String[] args) {
		//constructor method go brrrrr
		
		new osumain();
		

	}


	public void mouseDragged(MouseEvent e) {
		//its awful quiet in here
		
	}

	public void mouseMoved(MouseEvent e) {
		//mouse hunter type beat
		
		crosshair.setLocation(e.getX(), e.getY());
		crosshair.blackMoved();
		repaint();
		
	}

	public void actionPerformed(ActionEvent e) {
		//timer stuff and count down
		
		counter--;

		if(counter == 10) {
			count = "10";
			countX = 295;
			repaint();
		}

		if(counter == 9){
			count = "9";
			countX = 295;
			repaint();
		}

		if(counter == 8) {
			count = "8";
			countX = 295;
			repaint();
		}

		if(counter == 7) {
			count = "7";
			countX = 295;
			repaint();
		}

		if(counter == 6) {
			count = "6";
			countX = 295;
			repaint();
		}

		if(counter == 5) {
			count = "5";
			countX = 295;
			repaint();
		}
		

		if(counter == 4) {
			count = "4";
			countX = 295;
			repaint();
		}
		

		if(counter == 3) {
			count = "3";
			countX = 295;
			repaint();
		}
		

		if(counter == 2) {
			count = "2";
			countX = 295;
			repaint();
		}
		
	
		if(counter == 1) {
			count = "1";
			countX = 295;
			repaint();
		
		}
		if(counter == 0) {
			lose = true;
			win = false;
			count = "YOU LOSE";
			countX = 270;
			can.add(button, BorderLayout.NORTH);
			frame.pack();
			repaint();
		}
		if(click == 7) {
			lose = false;
			win = true;
			count = "YOU WIN";
			countX = 270;
			can.add(button, BorderLayout.NORTH);
			frame.pack();
			repaint();
		}
		Object source = e.getSource();	
		if (source == button) {
			frame.dispose();
			new osumain();
			click = 0;
		}
	}


	public void keyTyped(KeyEvent e) {
		//it's ..... empty?
		
	}


	public void keyPressed(KeyEvent e) {
		//click the circles
		
		int keyID=e.getKeyCode();
		if(keyID == KeyEvent.VK_X) { 
			for(int i = 0; i < lotsOfBalls.length; i++) {
				if(crosshair.ballCollision(lotsOfBalls[i].getLocX(), lotsOfBalls[i].getLocY(), lotsOfBalls[i].getDiameter())) {
					click++;
					lotsOfBalls[i].dissappear();
					
				}
			}
		}	
		if(keyID == KeyEvent.VK_Z) {
			for(int i = 0; i < lotsOfBalls.length; i++) {
				if(crosshair.ballCollision(lotsOfBalls[i].getLocX(), lotsOfBalls[i].getLocY(), lotsOfBalls[i].getDiameter())) {
					click++;
					lotsOfBalls[i].dissappear();
							
				}	
			}
		}
		if(keyID == KeyEvent.VK_SPACE) {
			for(int i = 0; i < lotsOfBalls.length; i++) {
				if(crosshair.ballCollision(lotsOfBalls[i].getLocX(), lotsOfBalls[i].getLocY(), lotsOfBalls[i].getDiameter())) {
					click++;
					lotsOfBalls[i].dissappear();
							
				}	
			}
		}
		repaint();			
	}
		
	


	public void keyReleased(KeyEvent e) {
		// it's quiet... too quiet
		
	}


	public void mouseClicked(MouseEvent e) {
		//it's... nothing?
		
	}


	public void mousePressed(MouseEvent e) {
		
	}


	public void mouseReleased(MouseEvent e) {
		//always has been
	}


	public void mouseEntered(MouseEvent e) {
		//still nothing
	}


	public void mouseExited(MouseEvent e) {
		//why are you still looking for code 
		
	}

}

//ok seriously this is the end