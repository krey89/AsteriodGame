import java.awt.Color;
import java.awt.Graphics;

public class Ship extends PolygonModel2d {
	boolean shield = false;
	boolean punch = false;
	int health = 100;
	
	//double vx = -10*Lookup.cos[A];
	
   // double vy = +10*Lookup.sin[A];
//---------- Constructor --------------------------------------------------------------------------------------------------------------------------------------------------------
	public Ship(double x, double y, int w, int h, int angle){
		super(x,y,w,h,angle);
	}
	
/********************************************************************************************************************************************************************************
 * Method used to handle all of the character's reaction according to the key pressed by player
 * @param inputIs
 */
	public void respondToInput(boolean[] inputIs){
		if(inputIs[GameJPanel.UP]) {moveForwardby(3);this.moveForwardrect(3);}
	    if(inputIs[GameJPanel.DN]) {moveBackwardby(3);this.moveBackwardrect(3);}
	    if(inputIs[GameJPanel.LT]) {rotateLeftby(3); this.rotateLeftrect(3);}
	    if(inputIs[GameJPanel.RT]) {rotateRightby(3);this.rotateRightrect(3);}
	   // if(inputIs[GameJPanel._Z]) {sl(10); this.moveLeftByrect(10);}
	  //  if(inputIs[GameJPanel._X]) {sr(10);this.moveRightByrect(10);}

	    
	   // if(inputIs[GameJPanel._W]) {fire(plasma);}

	   /* boolean x = false;
	    if(x==false && inputIs[GameJPanel._A])  this.punchWithLeftArm(); x=true;
	      
	    if(x==true && inputIs[GameJPanel._A])  this.punchWithRightArm(); x=false;*/
	        
	      //should add punchWithRightArm() after simultaneously button "A" press
	  }
	


/********************************************************************************************************************************************************************************
 * Array used to collect all of the x-coordinates that compose the character 
 */
	public int [][] x_data(){
		int [][] struct_x = 
			{
				{0,15,0},//x positions for right arm
				{0,10,0},//x positions for the left arm

				
				{0,5,0},//x positions for the body 
				
				
				//{30,20,20,30}//x positions for the foot
				//Struct_var[polygon][[vertex]
			};
		return struct_x;
	}
	
/********************************************************************************************************************************************************************************
 * Array used to collect all of the y-coordinates that compose the character 
 */
	public int [][] y_data(){
		int [][] struct_y =
			{
				
				{15,0,-15},//y positions for the right arm
				{10,0,-10},//y positions for the left arm

				{5,0,-5},//y positions for the body
				
				
				//{15,0,-15},//y positions for the right arm
				//{-20,-20,-10,-10}//y positions for the foot 
			};
		return struct_y;
	}
	
/* 
	public void punchWithLeftArm(){
		struct_x[1][0] = 50;
		struct_x[1][3] = 50;
	}


	public void punchWithRightArm(){
		struct_x[2][0] = 50;
		struct_x[2][3] = 50;
	}
	

	
	public void fire(AsteroidsPlasmaList plasma)
	   {
	      plasma.launch((int)this.x, (int)this.y,this.A);
	   }*/
	
	//int xx = (int)x+(int)(20*Lookup.cos[A]);
	// int yy = (int)y+(int)(20*Lookup.sin[A]);
	public void fire(PlasmaList plasma)
	   {
	     
		//x +=  (d * Lookup.cos[A]);
		//y +=  (d * Lookup.sin[A]);
		plasma.launch((int)x+(int)(50*Lookup.cos[A]),(int)y+(int)(50*Lookup.sin[A]), (double)A);
		//plasma.launch(xx,yy, (double)A);

	   }
//public void fire(AsteroidsPlasmaList plasma)
	   //{
	      
		 //double vx = -10*Math.cos(A);
	      //double vy = +10*Math.sin(A);
		//double vx = -10*Lookup.cos[A];
	      //double vy = +10*Lookup.sin[A];
		 
	      //AsteroidsPlasma p = new AsteroidsPlasma(x,y,20,20,A);	 
	  // }

	
	
	/********************************************************************************************************************************************************************************
* Method that return an array containing 4 different colors 
*/
	 public Color[] getColors(){
	      Color[] c ={Color.yellow,Color.blue,Color.red};

	      return c;
	   }
	
/********************************************************************************************************************************************************************************
* This method changes the coordinates of the left arm 
*/
	public void draw(Graphics g){
		/*
		  double cos = Math.cos(angle);
      double sin = Math.sin(angle);

      // Offset from initial position is constant with a given call
      int x0 = getX()+6;// Plus 6es help center ship in RectObj
      int y0 = getY()+6;

      int[] x = new int[3];
      int[] y = new int[3];

      for (int i = 0; i < 3; i++)
      {
         x[i] = (int)Math.round(sx[i]*cos+sy[i]*sin) + x0;
         y[i] = (int)Math.round(sy[i]*cos-sx[i]*sin) + y0;
      }

      g.setColor(shipcolor);
      g.drawPolygon(x, y, 3);
      g.setColor(Color.RED);
      
      g.drawLine(x0, y0, x[0], y[0]);
		 */
		super.draw(g);
		g.setColor(Color.green);
		if(health < 75 && health >= 50 ){
			g.setColor(Color.YELLOW);
		}if (health < 50 && health > 25){
			g.setColor(Color.orange);

		}if (health <= 25){
			g.setColor(Color.red);

		}

		
		g.drawLine((int)x, (int)y,(int)x+(int)(50*Lookup.cos[A]),(int)y+(int)(50*Lookup.sin[A]));
		g.drawString(health+"", (int)x-10,(int)y+20);
		
		//g.drawLine((int)x,(int)y,struct_x[1][1],struct_y[1][1]);
			
		/*(this.moving == true){
			for(int i = 0;i < 4;i++){
				struct_y[3][i] = struct_y[3][i]*-1;//this changes the foot's y position
				this.moving = false;
			}
		}
		
		if(!punch){// conditions to set the arms back to their default position
			struct_x[1][0] = 10;//left arm
			struct_x[1][3] = 10;
			
			struct_x[2][0] = 10;//right arm
			struct_x[2][3] = 10;
		}	*/
	}
}
