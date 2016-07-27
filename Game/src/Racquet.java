import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class Racquet{

	private Game gm;
	
	public Racquet(Game gm){
	
		this.gm = gm; 	
	}
	
	
	int x = 410;        // Initial Horizontal Coordinate in the middle.
	int y = 820;        // Initial Vertical Coordinate all the way on the bottom.
	int xm = 0;         // Initial Speed.
	
	public int currentHoriz(){
		
		return x;
	}
	
	public int currentVertic(){
		
	    return y; 
	}
	
	
	public void playerMove(){  // Player movement will only occur if its within the Left and Right Edges.
		
	//if((x+xm) > 0 && ((x+xm) < gm.getWidth()-80))	
	x = x + xm;	        // This method will decide how the racquet moves in response to keyboard input. 
		
	}
	
	public void paint(Graphics g){
		
	g.fillRect(x,y,80,10);	      // Generate a rectangle which will act as a "racket".
		
	}
	
	public void keypressed(KeyEvent e){  // When the actual key is pressed on the keyboard. LEFT/RIGHT implemented. 
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			xm =  8;
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			xm = -8; 
		
	}
	
	public void keyreleased(KeyEvent e){ // When the actual key is released. 
		
		xm = 0;                         // No Movement will actually occur if the key is released. 
	
	
	}
	
	

}
