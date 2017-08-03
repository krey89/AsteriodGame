import java.awt.Color;
import java.awt.Graphics;

public class BG extends PolygonModel2d{

	int hl;
	
	public BG(double x, double y, int w, int h, int angle, int hl) {
		super(x, y, w, h, angle);
		this.hl = hl; 
	}
	
public int[][] x_data(){
	int [][] structx = {
			{0, 20, 0},
			{0, 30, 0},
			{0, 30, 0}

	};
	return structx;
	
}

public int[][]y_data(){
	int [][] structy = {
			{30,0,-30},
			{0,30,30},
			{0, -30, -30}

	};
	return structy;
}


public void fire(PlasmaList plasma)
{
  
	//x +=  (d * Lookup.cos[A]);
	//y +=  (d * Lookup.sin[A]);
	plasma.launch((int)x+(int)(50*Lookup.cos[A]),(int)y+(int)(50*Lookup.sin[A]), (double)A);
	//plasma.launch(xx,yy, (double)A);

}

public Color[] getColors() {
	Color [] c = {
			Color.black,Color.darkGray,Color.darkGray
	};
	return c;
}


public boolean inFront(PolygonModel2d p)
{
	if(p.directionEast()==this.directionWest())
	{
		return true;
	}
	if(p.directionWest()==this.directionEast())
	{
		return true;
	}
	if(p.directionNorth()==this.directionSouth())
	{
		return true;
	}
	if(p.directionSouth()==this.directionNorth())
	{
		return true;
	}
	return false;
}
public void track(PolygonModel2d p)
   {
       if(leftOrRight((int)p.x, (int)p.y) > 0)  { rotateLeftby(2); this.rotateLeftrect(2);}
       if(leftOrRight((int)p.x, (int)p.y) < 0)  { rotateRightby(2); this.rotateRightrect(2);}
   }


   public void chase(PolygonModel2d p)
   {
       track(p);

      //if(distanceTo((int)p.x, (int)p.y) > 100)   {moveForwardby(2); this.moveForwardrect(2);}
   }
   /*public int healthmeasure(){
	   return minionHealth-currenthealth;
   }*/
public double leftOrRight(int x, int y)//left or right of the enemy
{
	return (x- this.x) * Lookup.sin[A] - (y- this.y) * Lookup.cos[A];
}
public double distanceTo(int x, int y)
{
	return (x- this.x) * Lookup.cos[A] + (y- this.y) * Lookup.sin[A];
}



public void draw(Graphics g){
	super.draw(g);

//g.drawOval((int)x-10, (int)y-10, 20, 20);
	
	//g.setColor(Color.white);
	g.setColor(Color.green);
	if(hl < 75 && hl >= 50 ){
		g.setColor(Color.YELLOW);
	}if (hl < 50 && hl > 25){
		g.setColor(Color.orange);

	}if (hl <= 25){
		g.setColor(Color.red);

	}
	g.drawString(hl+"", (int)x-Camera2d.x, (int)y-Camera2d.y);
	//g.drawLine(0, 0, (int)x, (int)y);
	
}
public void explode()
{
  // vx = 0;
  // vy = 0;
  // setX(-10000);// Can't really be done because of boundries on move
   //setY(-10000);
   super.x = -10000;
   super.y = -10000;
   moveRect(-10000,-10000);
  // v = 0;
   
}

}
