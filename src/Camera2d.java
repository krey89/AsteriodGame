
public class Camera2d
{
   static int x;
   static int y;
   static int A = 0;
   static boolean CAMmoving = false;
   
   public static void ResetScreen(int xd, int yd)
   {
	   x=xd;
	   y=yd;
	   
   }
   
   public static void moveBy(int dx, int dy)
	{
		x += dx; 
		y += dy;
		
	}
   public static void moveUpBy(int dy)
   {
      y -= dy;
      CAMmoving = true;
   }

   public static void moveDownBy(int dy)
   {
      y += dy;
      CAMmoving = true;
   }

   public static void moveLeftBy(int dx)
   {
      x -= dx;
      CAMmoving = true;
   }

   public static void moveRightBy(int dx)
   {
      x += dx;
      CAMmoving = true;
   }
   public static void moveForwardBy(int dist)
   {
	   x += dist * Lookup.cos[A];
	   y += dist * Lookup.sin[A];
	   CAMmoving = true;
   }
   public static void moveBackwardBy(int dist)
   {
	   x -= dist * Lookup.cos[A];
	   y -= dist * Lookup.sin[A];
	   CAMmoving = true;
   }
   public static void rotateLeftby(int degrees)
	{
		A -= degrees;
		if(A < 0) A += 360;
		//moving = true;
	}
	public static void rotateRightby(int degrees)
	{
		A += degrees;
		if(A > 359) A -= 360;
		//moving = true;
	}
  


}