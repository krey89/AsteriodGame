
import java.awt.Color;
import java.awt.Graphics;

/*******************************************************************************************************************************************************************************
 * This class is used to create the edges for the room
 */
public class Line{	
	int x1;//x-coordinate of starting point
	int y1;//y-coordinate of starting point
	
	int x2;//x-coordinate of ending point
	int y2;//y-coordinate of ending point
	
	double xv;
	double yv;
	
//---------- constructor -------------------------------------------------------------------------------------------------------------------------------------------------------
	public Line(int x1, int y1, int x2, int y2){
		this.x1 = x1;
		this.y1 = y1;
		
		this.x2 = x2;
		this.y2 = y2;
		
		//Precaculate vectors v
		double mag = Math.sqrt( ( x1 - x2 )*( x1 - x2 )+( y1 - y2 )*( y1 - y2 ) );
		
		xv = (x1- x2) / mag;
		yv = (y1-y2) / mag;
	}

/*******************************************************************************************************************************************************************************
 * This method calculates the distance between the player and the borders of the rooms
 * @param g
 */
	public double distanceTo(int x, int y){
		return (x-x1) * yv - (y-y1) * xv;
	}
	
/**************************************************************************************************************************************************************************************
*This function is used to draw the edges of the room according to the camera's position
* @param dy
*/
	public void draw(Graphics g){
		g.setColor(Color.white);
		g.drawLine(x1-Camera2d.x, y1-Camera2d.y, x2-Camera2d.x, y2-Camera2d.y);
	}
}
