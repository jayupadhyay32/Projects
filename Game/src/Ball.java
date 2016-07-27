import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.Random;


public class Ball {
	
    private Game game;          
    public int coll = 0;
    
    public Ball(Game game) {    
    	
    	this.game = game; 
    	
    }
    
    
	
	Random rand = new Random();
	int s1 = 0;
    int s2 = 0;
	int  x = rand.nextInt(500); // Initial X coordinate
    int  y = rand.nextInt(50); // Initial Y coordinate
    int xa = 2;                 // Horizontal Movement Speed
    int ya = 2;                 // Vertical Movement Speed
    
    
     
    
    public void speedup(){
    	
   s1 = xa+2;
   s2 = ya+2;
    	
    }
    
    
    
    
    public void collision(){ // Same-thing as edge-collisions but only for the intersection area of the racquet itself. 
    	
    	int currX = game.rect.currentHoriz(); 
    	int currY = game.rect.currentVertic();
    	Rectangle rect1 = new Rectangle(currX, currY, 80, 80);           // Rectangle which will capture the racquet.
    	Rectangle rect2 = new Rectangle(x,y,50,50);                     // Rectangle surrounding the Ball.
    	
    	
    	if(rect1.intersects(rect2)){
    		//coll++;
    		
    		if( (xa) > 0){    // If current ball position is less than the rect position, deflect.
    			xa = 2 + s1;
    		    game.counter++;
    		}
    		if ( (xa) < 0){
    			xa = -2 - s1;
    		    game.counter++;
    		}
    		if( (xa) == currX)
    			xa = 0;
    		
    		if( (ya) < currY)
    			ya = -2 - s2;
    		
    		
    		//if( (ya) == currY)
    			//ya = 0;
    		
    		
    		//if( (ya) > currY)
    		//	ya = 2;
    		
    		}
    	
    	
		
    }
    
    public boolean playerLost(){
		
    	if(((850) < y))
    	return true;
    	return false;
    	
    }
    
    
    
    public void moveBall() {
   	    
        if(x + xa < 0)        	 // If you're at the left edge, deflect to the right. 
        xa = 2 + s1;
        if(x + xa > game.getWidth()-30)  // If you're at the right edge, deflect to the left. 
        xa = -2 - s1;	
        if(y + ya < 0)             // If you're at the top, deflect down.
        	ya = 2 + s1;
        //if(y + ya > game.getHeight()-30) // If you are at the bottom, deflect up. 
        	//ya = -4;
     
    	x = x + xa;
    	y = y + ya;
     
     }
	
	
   public void paint(Graphics g) {
       g.fillOval(x+10, y+30, 30, 30); // Create a circle and attach to the rectangle. 
    }
    
    
    

}
