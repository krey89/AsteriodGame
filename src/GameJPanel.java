import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class GameJPanel extends JPanel implements KeyListener, Runnable{
 
	private static final long serialVersionUID = 1L;

	boolean[] input = new boolean[1024];
	JFrame frame;//needed for a fullScreen
	BufferStrategy flipPages;//needed for Page Flipping approach 

   // Number of miliseconds to wait between frames (default = 15)
   // Can be altered in the setDuration method
   private int duration = 15;//used for thread.sleep();

   // Booleans for pausing and ending the Game Loop
   boolean paused   = false;
   boolean finished = false;
   boolean gameover = false;

   // The thread in which the Game Loop will execute
   Thread timer;
   //
   static int frameWidth;//= frame.getContentPane().getWidth();;
   
   static int frameHeight;
     

//---------- Key events ---------------------------------------------------------------//

   public final static int UP = KeyEvent.VK_UP;
   public final static int DN = KeyEvent.VK_DOWN;
   public final static int LT = KeyEvent.VK_LEFT;
   public final static int RT = KeyEvent.VK_RIGHT;

   public final static int CTRL   = KeyEvent.VK_CONTROL;
   public final static int SHIFT  = KeyEvent.VK_SHIFT;
   public final static int COMMA  = KeyEvent.VK_COMMA;
   public final static int PERIOD = KeyEvent.VK_PERIOD;

   public final static int _A = KeyEvent.VK_A;
   public final static int _B = KeyEvent.VK_B;
   public final static int _C = KeyEvent.VK_C;
   public final static int _D = KeyEvent.VK_D;
   public final static int _E = KeyEvent.VK_E;
   public final static int _F = KeyEvent.VK_F;
   public final static int _G = KeyEvent.VK_G;
   public final static int _H = KeyEvent.VK_H;
   public final static int _I = KeyEvent.VK_I;
   public final static int _J = KeyEvent.VK_J;
   public final static int _K = KeyEvent.VK_K;
   public final static int _L = KeyEvent.VK_L;
   public final static int _M = KeyEvent.VK_M;
   public final static int _N = KeyEvent.VK_N;
   public final static int _O = KeyEvent.VK_O;
   public final static int _P = KeyEvent.VK_P;
   public final static int _Q = KeyEvent.VK_Q;
   public final static int _R = KeyEvent.VK_R;
   public final static int _S = KeyEvent.VK_S;
   public final static int _T = KeyEvent.VK_T;
   public final static int _U = KeyEvent.VK_U;
   public final static int _V = KeyEvent.VK_V;
   public final static int _W = KeyEvent.VK_W;
   public final static int _X = KeyEvent.VK_X;
   public final static int _Y = KeyEvent.VK_Y;
   public final static int _Z = KeyEvent.VK_Z;

   public final static int _0 = KeyEvent.VK_0;
   public final static int _1 = KeyEvent.VK_1;
   public final static int _2 = KeyEvent.VK_2;
   public final static int _3 = KeyEvent.VK_3;
   public final static int _4 = KeyEvent.VK_4;
   public final static int _5 = KeyEvent.VK_5;
   public final static int _6 = KeyEvent.VK_6;
   public final static int _7 = KeyEvent.VK_7;
   public final static int _8 = KeyEvent.VK_8;
   public final static int _9 = KeyEvent.VK_9;


//---------- setFullScreen method -----------------------------------------------------------------------------------------------
 	public void setFullScreen(){
 		GraphicsEnvironment environtment = GraphicsEnvironment.getLocalGraphicsEnvironment();
 		GraphicsDevice screen = environtment.getDefaultScreenDevice();//get the default screen of current device
 		frame = new JFrame();// creating a frame
 		frame.add(this);//since we extend JPanel, we add this class inside the frame
 		frame.setResizable(true);//cant' maximize/restore down the frame
 		frame.setIgnoreRepaint(true);
 		frame.setUndecorated(true);//doesn't display borders and title bar
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//if frame is closed, so is the application
 		screen.setFullScreenWindow(frame);//set the frame to fullScreen
 		
 			
 		frame.createBufferStrategy(3);//creating 3 buffers for page flipping technique 	
 		flipPages = frame.getBufferStrategy();//get a reference of the bufferStrategy created
 	
 		frameWidth  = getWidth();
        frameHeight  = getHeight();
        //frameWidth  = frame.getContentPane().getWidth();
        //frameHeight  = frame.getContentPane().getHeight();
        System.out.println(frameWidth); 
 	}

//---------- start game ---------------------------------------------------------------------------------------------------------
   public final void startGame(){
	  addKeyListener(this);// Attach the KeyListener to the JPanel in order to monitor keypresses
	  setFocusable(true);//KeyEvent will only be dispatched to the panel if it is "focusable"	
	  setFullScreen();//Set the screen
      timer = new Thread(this);// Create the thread for the main loop
      start();//it starts the timer
   }

//---------- Start the thread ---------------------------------------------------------------------------------------------------
   public final void start(){
      timer.start();//The Java Virtual Machine calls the run method of this thread
   }

//---------- Stop the thread ----------------------------------------------------------------------------------------------------
   public final void stop(){
      finished = true;
      try {timer.join();}//waits for thread to die 
      catch (InterruptedException e) {System.out.println("Failed to terminate thread");}
   }
   
//---------- sleep thread -------------------------------------------------------------------------------------------------------
   @SuppressWarnings("static-access")
   public final void sleep(int duration){
      try{
         timer.sleep(duration);//Put the thread into a sleep state for a given number of miliseconds
      }
      catch(InterruptedException e){System.out.println("Couldn't put thread to sleep");}
   }
   
//---------- setDuration --------------------------------------------------------------------------------------------------------
   public final void setDuration(int duration){
      this.duration = duration;//set sleep duration desired for the thread
}
//---------- preGame loop -------------------------------------------------------------------------------------------------------
   public void preGameLoop () {}

//---------- respond to input ---------------------------------------------------------------------------------------------------

   public abstract void respondToInput();

//---------- moveGameObjects ----------------------------------------------------------------------------------------------------

   public abstract void moveGameObjects();

//---------- Handle collisions --------------------------------------------------------------------------------------------------

   public abstract void handleCollisions();

//---------- inGame loop --------------------------------------------------------------------------------------------------------
   public final void inGameLoop(){
	   respondToInput();
      moveGameObjects();
      handleCollisions();
   }

//---------- postGame loop ------------------------------------------------------------------------------------------------------
   public void postGameLoop() {}
   
//---------- draw method --------------------------------------------------------------------------------------------------------
   public abstract void draw(Graphics g);

//---------- update screen ------------------------------------------------------------------------------------------------------
   public void update(){
	   Graphics g = flipPages.getDrawGraphics();//get Graphics context for the draw buffer
	   draw(g);//call the abstract draw method defined by other classes and draw their content
	   g.dispose();//releases any system resources that it using the graphics contex
	   flipPages.show();//show the draw buffer
   }

//---------- Thread run method called by timer.start() --------------------------------------------------------------------------
   public final void run(){
      preGameLoop();//method used to show anything before the actual game starts
      while ( !finished ){//while game is not finished
         if ( !paused ){// and if it's not paused either 
        	 inGameLoop();//implements everything needed in the game 
        	 update();//update the screen
        	 sleep(duration);//sleep the thread every 15 milliseconds
         }
      }
      postGameLoop();//method to show anything you want after the game is over
      System.exit(0);//close the frame
   }

//---------- keyPressed ---------------------------------------------------------------------------------------------------------
   public final void keyPressed(KeyEvent e){
      int code = e.getKeyCode();
      if (code == _P)  paused   = true;
      if (code == _C)  paused   = false;

      if (code == _Q)  finished = true;

      input[code] = true;
   }

//---------- keyReleased --------------------------------------------------------------------------------------------------------
   public final void keyReleased(KeyEvent e)
   {
      int code = e.getKeyCode();
      input[code] = false;
   }

//---------- keyTyped -----------------------------------------------------------------------------------------------------------
   public final void keyTyped(KeyEvent e) {}
}
