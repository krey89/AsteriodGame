
import java.awt.*;

/*************************************************************************************************************************************************************************
 * This class is used to surround the walls and the character in order to detect collisions
 */
public class Rect{
	double x;//x-coordinte starting corner
	double y;//y-coordinte starting corner
	int w;//width for the rectangle
	int h;//height for the rectangle
	int rectA;//angle used for the rotation of the rectangle
	
//---------- constructor -------------------------------------------------------------------------------------------------------------------------------------------------
	public Rect(double x,double y, int w, int h, int angle){//constructor must protect the code, what if it was negative??
		this.x = x;
		this.y = y;
	
		this.w = w;
		this.h = h;
		rectA = angle;
	}
	
/*************************************************************************************************************************************************************************
 * This method is used to check if the coordinates of an instance are inside the rectangle
 * @param mx
 * @param my
 * @return true
 */
	public boolean contains(int mx, int my){
		return ((mx < x+w) && (mx > x) && (my > y) && (my<y+h));
		
	}
	
/*************************************************************************************************************************************************************************
 * This method checks if another rectangle has collides with this rectangle
 * @param r
 * @return
 */
	public boolean hasCollidedWith(Rect r){
		return ((r.x <= x+w) && (r.x+r.w >= x) && (r.y+r.h>= y) && (r.y<= y+h));
	}
	

	
	
	/*************************************************************************************************************************************************************************
 * This function is used to move the rectangle's coordinates by a certain amount
 * @param dx
 * @param dy
 */
	public void moveRect(int xx, int yy){
		x = xx;
		x = yy;
	}
	public void moveByrect(int dx, int dy){
		x += dx; 
		y += dy;	
	}
	
/*************************************************************************************************************************************************************************
 * This function is used to rotate the rectangle to the left by a certain amount of degrees
 * @param degrees
 */
	
	
	public void rotateLeftrect(int degrees){
		rectA -= degrees;
		if(rectA < 0) rectA += 360;
	}
	
/*************************************************************************************************************************************************************************
 * This function is used to rotate the rectangle to the right by a certain amount of degrees
 * @param degrees
 */
	public void rotateRightrect(int degrees){
		rectA += degrees;
		if(rectA > 359) rectA -= 360;
		//moving = true;
	}
	
/*************************************************************************************************************************************************************************
 *This function is used to move the character forward according to the angle and distance desired
 * @param d
 */
	public void moveForwardrect(int d){
		x +=  (d * Lookup.cos[rectA]); 
		y +=  (d * Lookup.sin[rectA]);
	}
	
/*************************************************************************************************************************************************************************
 * * This function is used to move the character backward according to the angle and distance desired
 * @param d
 */
	public void moveBackwardrect(int d){
		x -=  (d * Lookup.cos[rectA]); 
		y -=  (d * Lookup.sin[rectA]);
	}
	
/*************************************************************************************************************************************************************************
 * This function is used to move the character up by decreasing the y-coordinate
 * @param dy
 */
	public void moveUpByrect(int dy){
	     y -= dy;
	}

/*************************************************************************************************************************************************************************
 * This function is used to move the character down by increasing the y-coordinate
 * @param dy
 */
	public void moveDownByrect(int dy){
	     y += dy;    
	}

/*************************************************************************************************************************************************************************
 * This function is used to move the character to the left by decreasing the x-coordinate
 * @param dx
 */
	public void moveLeftByrect(int dx){
		x -= dx;   
	}

/*************************************************************************************************************************************************************************
 * This function is used to move the character to the right by increasing the x-coordinate
 * @param dx
 */
	public void moveRightByrect(int dx){
        x += dx;   
	}
	
/*************************************************************************************************************************************************************************
 * This method is used to draw the rectangles around the interior walls and the character
 * @param g
 */
	public void draw(Graphics g){
		g.setColor(Color.red);
		g.drawRect((int)x-Camera2d.x,(int)y-Camera2d.y,w,h);
	}
}
