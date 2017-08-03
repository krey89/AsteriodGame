
import java.awt.*;

import javax.swing.ImageIcon;

public class ImageLayer{
   Image image;//image that'll be used as background and could add tile map if you want
   int x;//x-position for the image
   int y;//y-position for the image
   int totalx;
   int totaly;
   int A = 0;
   Rect CamBorder = new Rect(0,0, 1, 1, 0);//border for the camera
   
//---------- constructor --------------------------------------------------------------------------------------------------------------------------------------------------------------
   public ImageLayer(String filename, int x, int y){//z and w
	  //TookKit loads the image in another thread, so it takes longer to paint in the Game_loop 
      image = new ImageIcon(filename).getImage();//ImageIcon loads the image and waits for it to 
      											//finish loading before painting anything(pg. 36)
      this.x = x;//set the x-position
      this.y = y;//set the y-position
   }
   
/**************************************************************************************************************************************************************************************
* This function is used to move the character up by decreasing the y-coordinate
* @param dy
*/
   public void moveUpBy(int dy){
      y -= dy;
   }

/**************************************************************************************************************************************************************************************
* This function is used to move the character down by increasing the y-coordinate
* @param dy
*/
   public void moveDownBy(int dy){
      y += dy;
   }

/**************************************************************************************************************************************************************************************
* This function is used to move the character to the left by decreasing the x-coordinate
* @param dx
*/
   public void moveLeftBy(int dx){
      x -= dx;
   }

/**************************************************************************************************************************************************************************************
* This function is used to move the character to the right by increasing the x-coordinate
* @param dy
*/
   public void moveRightBy(int dx){
      x += dx;
   }
   
/**************************************************************************************************************************************************************************************
* This function is used to draw the image(background) according to the camera's position
* @param dy
*/
   public void draw(Graphics g){
	   totalx = x - Camera2d.x;
	   totaly = y - Camera2d.y;
	   
	   g.drawImage(image, totalx, totaly, null);  
   }
}