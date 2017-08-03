import java.awt.Color;
import java.awt.Graphics;

public class Rocks extends Rect
{
   private int v;
private Color c;
private int q;


   public int getQ() {
	return q;
}

public void setQ(int q) {
	this.q = q;
}

public Rocks(double x, double y, int w, int h, int angle, Color c, int q,int v)
   {
      super(x, y, w, h, angle);
      //this.vx = vx;
      //this.vy = vy;
      this.c = c;
      this.setQ(q);
      this.v = v;
   }

   public void move()
   {
      //int x = getX() + vx;
      //int y = getY() + vy;
	   //x += vx;
	   //y += vy;
		  this.moveForwardrect(v);

	   
      if (x > 1500) x = -70;
      if (x < -70) x = 1500;
      if (y > 1000) y = -60;
      if (y < -60) y = 1000;
     // this.moveRect((int)x,(int)y);
      //setX(x);
      //setY(y);
   }

   
   public void bounce(){
		  this.moveBackwardrect(2);

		super.rectA-=90;
		if(rectA < 0) rectA += 360;

	}
   
   
   
   public void explodes()
   {
     // vx = 0;
     // vy = 0;
     // setX(-10000);// Can't really be done because of boundries on move
      //setY(-10000);
      x = -10000;
      y = -10000;
      v = 0;
   }

   public void draw (Graphics g)
   {
		super.draw(g);

	   // The minus 4 is to compansate for the fact that collision detection
      // is being done with rectangles
      int x1 = (int) (x-4);
      int y1 = (int) (y-4);

      // The hard coded numbers are the "shape" of asteriods
      int[] x = { 0 + x1, 20 + x1, 50 + x1, 70 + x1, 50 + x1, 20 + x1};
      int[] y = {30 + y1, 60 + y1, 60 + y1, 30 + y1,  0 + y1,  0 + y1};

      g.setColor(c);
      g.fillPolygon(x, y, 6);
      g.setColor(Color.WHITE);
      g.drawString(""+getQ(), (int)super.x+10-Camera2d.x, (int)super.y+10-Camera2d.y);
   }

public static boolean checkrocks() {
	// TODO Auto-generated method stub
	return false;
}
}