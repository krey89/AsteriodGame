import java.awt.*;
import java.awt.Graphics;

public abstract class PolygonModel2d extends Rect
{
		
		double x;
		double y;
		int w;
		int h;
		int A;
		//int z;
		int [][] struct_x = x_data();
		int [][] struct_y = y_data();
		boolean moving = false;
		boolean front = false;
		boolean back = false;
		double totalx;
		double totaly;
		Color[] color = getColors();
		public abstract Color[] getColors();
		
	
		
		
		
		public PolygonModel2d(double x, double y,int w, int h, int angle)
		{
			super((int)x-20,(int)y-20,w, h,angle);
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			A = angle;//changed so it can be remember from the beginning
		}
		public boolean directionNorth()
		{
			if(this.A > 225 && this.A < 315){return true;}
			return false;
		};
		public boolean directionSouth()
		{
			if(this.A < 135 && this.A > 45){return true;}
			return false;
		};
		public boolean directionEast()
		{
			if(this.A < 45  || this.A > 315){return true;}
			return false;
		};
		public boolean directionWest()
		{
			if(this.A < 225 && this.A > 135){return true;}
			return false;
		};
		public boolean directionNorth2()
		{
			if(this.A > 180 && this.A < 359){return true;}
			return false;
		};
		public boolean directionSouth2()
		{
			if(this.A < 180 && this.A > 0){return true;}
			return false;
		};
		public boolean directionEast2()
		{
			if(this.A < 90  || this.A > 270){return true;}
			return false;
		};
		public boolean directionWest2()
		{
			if(this.A < 270 && this.A > 90){return true;}
			return false;
		};
		public abstract int[][] x_data();
		public abstract int[][] y_data();
		//public abstract Color[] getColors();
		
		public void draw(Graphics g){
			//g.translate((int)this.x-Camera2d.x,(int)this.y-Camera2d.y);
			totalx = x - Camera2d.x;
			totaly = y - Camera2d.y;
			   
			int[] xpoints = new int[4];
			int[] ypoints = new int[4];
			double cosA =  Lookup.cos[A];
			double sinA =  Lookup.sin[A];
			//g.setColor(color[2]);
			//g.translate((int)x-Camera2d.x, (int)y - Camera2d.y);
			super.draw(g);
			//g.translate((int)x-Camera2d.x, (int)y - Camera2d.y);
			
			for(int poly = 0; poly < struct_x.length; poly++)
			{
			
				for(int vertex = 0; vertex< struct_x[poly].length; vertex++)
				{
					xpoints[vertex] = (int) (struct_x[poly][vertex]* cosA - struct_y[poly][vertex]* sinA + x-Camera2d.x);
					ypoints[vertex] = (int) (struct_x[poly][vertex]* sinA + struct_y[poly][vertex]* cosA + y-Camera2d.y);
				}
//				double [] puchx = new double [struct_x[poly].length];
				g.drawPolygon(xpoints, ypoints, struct_x[poly].length);
				//g.translate((int)this.x-Camera2d.x,(int)this.y-Camera2d.y);
			    g.setColor(color[poly]);
				g.fillPolygon(xpoints, ypoints, struct_x[poly].length);
				//g.translate((int)this.x-Camera2d.x,(int)this.y-Camera2d.y);
				//if(GameJPanel.input[GameJPanel._A]&& poly==1){
					
				//}
			}
			//g.setColor(color[0]);
			//g.translate((int)this.x-Camera2d.x,(int)this.y-Camera2d.y);
			//refreshPoly(this);
			
			
	
		}
		//*
		public void moveBy(int dx, int dy)
		{
			x += dx; 
			y += dy;
			
		}
		//*/
		public void rotateLeftby(int degrees)
		{
			A -= degrees;
			if(A < 0) A += 360;
			//moving = true;
		}
		public void rotateRightby(int degrees)
		{
			A += degrees;
			if(A > 359) A -= 360;
			//moving = true;
		}
		public void moveForwardby(int d)
		{
			x +=  (d * Lookup.cos[A]);
			y +=  (d * Lookup.sin[A]);
			moving = true;
			front = true;
		}
		public void moveBackwardby(int d)
		{
			x -=  d * Lookup.cos[A]; 
			y -=  d * Lookup.sin[A];
			moving = true;
			back = true;
		}
		public void moveUpBy(int dy)
		{
		     y -= dy;
		}

		public void moveDownBy(int dy)
		{
		     y += dy;
		      
		}

		public void moveLeftBy(int dx)
		{
			x -= dx;
		     
		}

		public void moveRightBy(int dx)
		{
	        x += dx;
		     
		}
	
}
