import java.awt.Color;
import java.awt.Graphics;

public class Plasma extends Rect
{
  
	 //static double x,y;
	//sta double y;
	//static int w,h,angle;
	//int h;
	// int angle;
	public Plasma() {
		super(0, 0, 20, 20, 90);
		// TODO Auto-generated constructor stub
	}
//double vx,vy;
 // boolean b;
//private Color[] color; 
 
	

   public void explodes()
   {
      x = -1000;
	   //setX(-1000);
      //vx = 0;
     // vy = 0;
   }
   // rewrite to take vx & vy from ship and normalize the vector so that
   // plasma's vx & vy can be a multiple of that normal + ship's vx & vy
   public void launch(int x, int y, double angle)
   {
     // super();
	   //setX(x);
      //setY(y);
	   //super.x = x;
	   //super.y = y;
	   super.w = 20;
	   super.h = 20;
	   this.x = x-Camera2d.x;
	   this.y = y-Camera2d.y;
	   //this.vx = (int)vx - (int)Math.round(10*Math.cos(angle));
     // this.vy = (int)vy + (int)Math.round(10*Math.sin(angle));
	   //this.vx =   vx;
	  // this.vy =   vy;
	   super.rectA = (int)angle;

	  // this.A = (int)angle;
	 //  this.b = b;
	   

   }

   

	public void bounce(){
		  this.moveBackwardrect(2);

		super.rectA-=90;
		if(rectA < 0) rectA += 360;

	}
	public void bnc(){
		super.rectA-=180;
		if(rectA < 0) rectA += 360;

	}
	
   
   public void move()
   {
     // setX(getX()+vx);
     // setY(getY()+vy);
	  
	 //moveForwardby(5);
	  this.moveForwardrect(5);
   }

   
   public int[][] x_data(){
		int [][] structx = {
				{0, 15, 0},
				{0, 15, 0},
				{0, 15, 0}

		};
		return structx;
		
	}

	public int[][]y_data(){
		int [][] structy = {
				{20,0,-20},
				{0,15,15},
				{0, -15, -15}

		};
		return structy;
	}
	public void draw(Graphics g){
		super.draw(g);
		g.setColor(Color.red);
		g.fillOval((int)x-Camera2d.x,(int)y-Camera2d.y,w,h);
		g.setColor(Color.yellow);
		g.fillOval((int)x-Camera2d.x+5,(int)y-Camera2d.y+5,w-10,h-10);

		//g.setColor(Color.yellow);
		//g.fillOval((int)x-15-Camera2d.x,(int)y-15-Camera2d.y, 30, 30);
		//g.setColor(Color.red);
		//g.fillOval((int)x-5-Camera2d.x,(int)y-5-Camera2d.y, 30, 30);


	}
	 public Color[] getColors(){
	     
			 Color[] color ={Color.white,Color.white ,Color.white};

	     

	      return color;
	   }

	
	
}