import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
 
public class Game extends JPanel{
	
	
	boolean alreadyex = false;
	boolean lvl1 = false;
	boolean lvl2 = false;
	int counter = 0;
	Racquet rect = new Racquet(this);    // Create a Racket Object
	Ball ball = new Ball(this);          // Create a Ball Object
	Ball ball2 = new Ball(this);         // Second ball.
	Ball ball3 = new Ball(this);         // Third ball. 

	public Game(){
	
		addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e){
			}
			
			public void keyReleased(KeyEvent e){
				rect.keyreleased(e);
			}
			
			public void keyPressed(KeyEvent e){
				rect.keypressed(e);
			}
			
			
		});
		setFocusable(true);
	 }
	
	
	
	private void Level1(){
		
	
	ball2.moveBall();
		
	}
	
	
	
	
	
	
	private void moveBall(){
		    
		    ball.moveBall();
		    
	}
	
	private void playerMove(){
		rect.playerMove();
	}
	
	public void restart() {
	    /*  dispose();
	        Window.main(null);*/
	          StringBuilder cmd = new StringBuilder();
	            cmd.append(System.getProperty("java.home") + File.separator + "bin" + File.separator + "java ");
	            for (String jvmArg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
	                cmd.append(jvmArg + " ");
	            }
	            cmd.append("-cp ").append(ManagementFactory.getRuntimeMXBean().getClassPath()).append(" ");
	            cmd.append(Window.class.getName()).append(" ");

	            try {
	                Runtime.getRuntime().exec(cmd.toString());
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	            System.exit(0);
	    }
	
	
	
	
	public void paint(Graphics g) {
    	super.paint(g);  // This acts as repaint by calling the paint method in the superclass.                                                                        // Destroy the image after each run.
    	Graphics2D g2d = (Graphics2D) g;                                                         // Encapsulate the graphics object into a Graphics2D object
    	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); // Use Aliasing to remove Jaggies on shape.
        ball.paint(g2d);                                                                         // Generate ball on graphics object
        if(counter >= 10){
        ball2.paint(g2d);                                                                        //  Generate Ball2 on graphics object.
        }
        rect.paint(g2d);                                                                           // Generate the racquet on the graphics object. 
         }
	     
        public static void main(String[] args) throws InterruptedException{
        JFrame frame = new JFrame(" Tennis ");
        JOptionPane.showMessageDialog(null, " Controls: Use Left Arrow to move left, Right arrow to move right.   Good Luck! ");
        Game game = new Game();
        frame.add(game);
        frame.setSize(900,900);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        
        // Infinite loop for the repaint method, this will keep "painting" the shapes over and over. 
        
        while(true){
        
        if(game.ball.playerLost()==true || game.ball2.playerLost()==true){
        	
        	JOptionPane.showMessageDialog(null, " Game Over! You Lost. " + "Total Score: " + (game.counter));
        	
        	//game.restart();
        	//System.exit(0);
        	
        	
        }
        	
        	
        game.ball.collision();	// check if first ball will collide with the Racquet.
        game.ball2.collision(); // Check if the second ball will collide.
        game.moveBall();        // Keep the movement for each of the balls.
        
        if(game.counter>=10){
        game.Level1();
        if(!game.lvl1){	
        JOptionPane.showMessageDialog(null, " 10 Hit Streak! Welcome to Level 2! ");
        game.lvl1 = true;
        }
        
        
        
        
        }
        if((game.counter)>=20){
        if((!game.lvl2)){	
        JOptionPane.showMessageDialog(null, " 20 Hit Streak! Welcome to the Final Level! Speed has Increased for one Ball!!! ");
        game.lvl2 = true;
        }
        
        
        if(!game.alreadyex){
        	 
        	 game.ball.speedup();    // Speed up the first ball.
        	 game.alreadyex = true;
        	 
        }	 
            
        }
        if(game.counter>=40)
        {
        	JOptionPane.showMessageDialog(null, " Fine.. you win :)  * Gives a Oreo * ");
        	System.exit(0);
        }
        game.playerMove();
        game.repaint();
        Thread.sleep(10);
        
        }	
        	
        }

		
        
        
           
        
         
         
	
	

}
