import java.awt.Graphics;

public class PlasmaList
{
   private Plasma[] plasma = new Plasma [64];

   private int next = -1; // The references are recycled

   public PlasmaList ()
   {
      for (int i = 0; i < plasma.length; i++)
         plasma[i] = new Plasma();
   }

   public void move ()
   {
      for (int i = 0; i < plasma.length; i++)
         plasma[i].move();
   }

   //public void launch (int x, int y, double vx, double vy, double angle)
   public void launch (int x, int y,  double angle)

   {
      nextPlasma().launch(x, y, angle);
   }

   public boolean explodesDueToCollisionWith(Rect target)
   {
       //System.out.println("hey");

	   for (int i = 0; i < plasma.length; i++)
      {
    	  
	      // System.out.println("hey"+plasma.length);
	       if (plasma[i].hasCollidedWith(target))
         {
           // plasma[i].explodes();
        // plasma[i] = null;
             plasma[i].bounce();
	    	   //plasma[i].bnc();
            System.out.println("hit");
            return true;
         }
      }
      
      return false;
   }
   
   
   

   private Plasma nextPlasma()
   {
      next = (next + 1) % plasma.length;

      return plasma[next];
   }

   public void draw (Graphics g)
   {
      for (int i = 0; i < plasma.length; i++)
         plasma[i].draw(g);
   }





}

