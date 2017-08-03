import java.awt.Color;
import java.awt.Graphics;

public class GameLoop extends GameJPanel{
	private static final long serialVersionUID = 1L;
	PlasmaList plasma   = new PlasmaList();
	//PlasmaList p  = new PlasmaList();


//---------- instance objects --------------------------------------------------------------------------------------------------------------------------------------
	int Level = 1;//change to work on other levels
	//ImageLayer layer1 = new ImageLayer("ring-nebula.png", -1, -1);//background for first level
	//ImageLayer layer2 = new ImageLayer("star-clusters.png", -1, -1);//background for second level
	ImageLayer layer1 = new ImageLayer("nasa-89125.jpeg", -1, -1);//background for first level
//	ImageLayer layer2 = new ImageLayer("star-clusters.png", -1, -1);//background for second level
	//ImageLayer layer3 = new ImageLayer("bkg3.png", -1, -1);//background for third level
	//ImageLayer layer4 = new ImageLayer("bkg4.png", -1, -1);//background for the forth level
	//ImageLayer layer5 = new ImageLayer("bkg5.jpg", -2, -2);//background for the fifth level
	
	int x_CameraMax = 720;
	int y_CameraMax = 450;
	int XoriginCam = 0-720;// Since you're moving the image layer in the negative
	int YoriginCam = 0-450;
	
	int m = 480;
	int n = 180;

	boolean fire      = false;
	//boolean won = false;
	 Rocks[] rocks =
		   {
			   new Rocks (125, -200, 55,55,90,Color.gray,100,1),
			      new Rocks (-800, 100,55,55 ,150,Color.DARK_GRAY,100,3),
			      new Rocks (120, -190,55,55,80, Color.BLACK,100,5),
			    
				   new Rocks (125, 200, 55,55,40,Color.gray,100,1),
			      new Rocks (800, 100,55,55 ,50,Color.DARK_GRAY,100,3),
			      new Rocks (320, -90,55,55,180, Color.BLACK,100,5),
			      new Rocks (300, 50,55,55,333,Color.blue,100,6),
				   
				   new Rocks (280, -20, 55,55,10,Color.gray,100,1),
		      new Rocks (100, 90,55,55 ,20,Color.DARK_GRAY,100,3),
		      new Rocks (200, -200,55,55,110, Color.BLACK,100,5),
		      new Rocks (300, 300,55,55,330,Color.blue,100,6),
		      new Rocks (250, 400,55,55,290,Color.gray,100,10),
//		      
//		      new Rocks (-30, 30, 55,55,115,Color.red,100,1),
//		      new Rocks (150, 250,55,55 ,35,Color.green,100,3),
//		      new Rocks (-400, 300,55,55,305, Color.yellow,100,5),

		   };
	
//------------CAMERA LIMIT--------------------------------------------------------------------------------------------------------------------------------------------
// Theses lines combine to create a box to detect if the layey1 left the box, then to return it to the box 
	/*Line leftDiagnol = new Line(0,0,1440,900);
	Line rightDiagnol = new Line(1440,0,0,900);*/
	Line LeftBorder = new Line(-479,-179,-479,0);
	Line RightBorder = new Line(1,-179,1,1);
	Line TopBorder = new Line(-479,-179,-1,-179);
	Line BottomBorder = new Line(-479,1,-1,1);
	Rect CameraLimit = new Rect(-479,-179, m, n, 0);
//------------Characters--------------------------------------------------------------------------------------------------------------------------------------------------
	Ship hero = new Ship(950, 850,40,40, 270);
	BG badguy  = new BG(720,450, 50, 50,0,100);
	/*private boolean won{
		if ((badguy.hl <=0) && (rocks[0].getQ()<=0) && (rocks[1].getQ()<=0) && (rocks[2].getQ()<=0) && (rocks[3].getQ()<=0) && (rocks[4].getQ()<=0)){
			won = true;		};
	}*/

	
//------------LEVEL!----------------------------------------------------------------------------------------------------------	
	/*Line leftWALL = new Line(30,0,30,730);
	Line rightWALL = new Line(1870,0,1870,730);
	Line topWALL = new Line(30,60,1870,60);
	Rect b1WALL = new Rect(0,680,880,400,0);
	Rect b2WALL = new Rect(1050,675,260,400,0);
	Line b3WALL = new Line(1370,935,1870,935);
	Rect middlePillar1 = new Rect(210,240,50,440,0);
	Rect middlePillar2 = new Rect(525,242,50,240,0);
	Rect middlePillar4 = new Rect(1310,242,60,740,0);
	Rect middlePillar3 = new Rect(525,242,1180,60,0);
	Rect middlePillar5 = new Rect(1655,680,210,50,0);
	Rect Teleport1 = new Rect(1800,730,100,210,0);
//-----------Level2--------------------------------------------------------------------------------------------------------------
	Line rightwall = new Line(1800,0,1800,1080);
	Rect Topwall_1 = new Rect(0,0,670,200,0);
	Rect Topwall_2 = new Rect(650,220,430,110,0);
	Rect Topwall_3 = new Rect(1178,-1,660,180,0);
	Rect PillarA = new Rect(300,485,260,345,0);
	Rect PillarB = new Rect(1300,485,260,345,0);
	Rect middleWALL1 = new Rect(800,476,60,600,0);
	Rect middleWALL2 = new Rect(1040,330,60,502,0);
	Rect leftwallA = new Rect(0,0,60,740,0);
	Rect leftwallB = new Rect(0,945,60,150,0);
	Rect Teleport2 = new Rect(0,740,60,200,0);
	Line bottomwall = new Line(0,1080,1920,1080);
	Rect Topwall_4 = new Rect(675,40,500,30,0);
	Rect Teleport3 = new Rect(860,40,128,30,0);
//------------LEVEL3--------------------------------------------------------------------------------------------------------------
	Line Topwall = new Line(0,35,1920,35);
	Line RIGHTwall = new Line(1680,0,1680,1080);
	Line LEFTwall = new Line(0,40,0,240);
	Rect bookshelf = new Rect(160,35,530,100,0);
	Rect door = new Rect(0,230,160,35,0);
	Rect Teleport22 = new Rect(0,265,50,135,0);
	Rect plant = new Rect(0,400,100,100,0);
	Rect Col = new Rect(0,508,692,60,0);
	Rect Colleft = new Rect(625,310,65,260,0);
	Rect Desk = new Rect(1365,310,88,152,0);
	Rect desk = new Rect(140,635,97,230,0);
	Rect Coltop = new Rect(1120,135,555,50,0);
	Rect Coltopa = new Rect(1120,135,65,195,0);
	Rect ColbottomA = new Rect(1120,485,65,300,0);
	Rect Colbottom = new Rect(1120,685,555,105,0);
	Rect outerworldA = new Rect(985,780,600,300,0);
	Rect outerworldB = new Rect(710,780,120,300,0);
	Rect BHdesk = new Rect(0,570,66,145,0);
	Rect BHdeska = new Rect(0,825,66,250,0);
	Rect BHdeskb = new Rect(0,1019,750,61,0);
	Rect TelePort4 = new Rect(830,1000,155,100,0);
//------LEVEL-4-----------------------------------------------------------------------------------------------------------------------------------------------------
	Rect box1 = new Rect(1450,400,470,530,0);
	Rect Teleport5 = new Rect(0,0,195,170,0);
	Rect Teleport24 = new Rect(1870,930,100,150,0);
	Rect box2 = new Rect(1060,0,860,230,0);
	Rect box3 = new Rect(1055,400,205,350,0);
	Rect box4 = new Rect(0,925,1325,170,0);
	Rect box5 = new Rect(0,750,864,170,0);
	Rect box6 = new Rect(0,170,195,230,0);
	Rect box7 = new Rect(0,400,275,350,0);
	Rect box8 = new Rect(390,0,470,400,0);
	Rect box9 = new Rect(195,0,860,60,0);
	Rect box10 = new Rect(860,400,195,50,0);
	Rect box11 = new Rect(470,400,390,180,0);*/
	
//---------- constructor -------------------------------------------------------------------------------------------------------------------------------------------
	public void startTheGame(){
		
		startGame();//call the method that starts the game in GameJPanel
	}
	
//---------- respond to input --------------------------------------------------------------------------------------------------------------------------------------
	public void respondToInput(){
       hero.respondToInput(input);
       if(input[GameJPanel._A] == true){
    	   hero.fire(plasma);
    	  //badguy.fire(plasma);
    	   input[GameJPanel._A] = false;
           System.out.println("boom");
       }
       
       if(hero.health < 0){
    	   gameover = true;
       }
       
       
       //System.out.println(BottomBorder.distanceTo((int)layer1.totalx,(int)layer1.totaly)+"");
//--------CAMERA_START----------------------------------------------------------------------------------------------------------------------------------------------------
      
      //if(Level==1){
//-----CAMERA-FOR-LEVEL-1-------------------------------------------------------------------------------------------------------------------------------------------------
    	  /* if(input[GameJPanel.UP]) //{Camera2d.moveUpBy(3);}if(input[GameJPanel.DN]) {Camera2d.moveDownBy(3);}if(input[GameJPanel.RT]) {Camera2d.moveRightBy(3);}if(input[GameJPanel.LT]) {Camera2d.moveLeftBy(3);}
       
       {
    		   //System.out.print(RightBorder.distanceTo((int)layer1.totalx,(int)layer1.totaly));
    		   if(LeftBorder.distanceTo((int)layer1.totalx,(int)layer1.totaly)>1)	   {Camera2d.moveLeftBy(1);}
    		   if(RightBorder.distanceTo((int)layer1.totalx,(int)layer1.totaly)<2)	   {Camera2d.moveRightBy(1);}
    		   if(TopBorder.distanceTo((int)layer1.totalx,(int)layer1.totaly)>169)     {Camera2d.moveDownBy(1);}
    		   if(BottomBorder.distanceTo((int)layer1.totalx,(int)layer1.totaly)<-179) {Camera2d.moveUpBy(1);}
       }
       // CameraLimit is a rect create to take advantage of the contains() method inside rect to keep the imagelayer x and y inside that rect 
       /*if(CameraLimit.contains((int)layer1.totalx,(int)layer1.totaly))
       	{  //uses the angle of direction character is facing
    	   		if(input[GameJPanel.UP] && (hero.A < 45  || hero.A > 315))   {Camera2d.moveRightBy(1);}//super.update();} 
    	   		if(input[GameJPanel.UP] && (hero.A < 225 && hero.A > 135))   {Camera2d.moveLeftBy(1);}//super.update();}
    	   		if(input[GameJPanel.UP] && (hero.A > 225 && hero.A < 315))   {Camera2d.moveUpBy(1);}//super.update();}
    	   		if(input[GameJPanel.UP] && (hero.A < 135 && hero.A > 45))    {Camera2d.moveDownBy(1);}//super.update();}
       	}
     
       }
       /*if(Level==2){
//-----CAMERA-FOR-LEVEL-2-----------------------------------------------------------------------------------------------------------------------------------------------------------
           if(input[GameJPanel.UP])// {Camera2d.moveUpBy(3);}if(input[GameJPanel.DN]) {Camera2d.moveDownBy(3);}if(input[GameJPanel.RT]) {Camera2d.moveRightBy(3);}if(input[GameJPanel.LT]) {Camera2d.moveLeftBy(3);}
           System.out.println(bottomwall.distanceTo((int)hero.x,(int)hero.y)+" oh");
           //*
           {
        	   if(LeftBorder.distanceTo((int)layer2.totalx,(int)layer2.totaly)>1)	{Camera2d.moveLeftBy(1); }
        	   if(RightBorder.distanceTo((int)layer2.totalx,(int)layer2.totaly)<2)	{Camera2d.moveRightBy(1);}
        	   if(TopBorder.distanceTo((int)layer2.totalx,(int)layer2.totaly)>169)  {Camera2d.moveDownBy(1);}
        	   if(BottomBorder.distanceTo((int)layer2.totalx,(int)layer2.totaly)<-179){Camera2d.moveUpBy(1);}
           }
           //CameraLimit is a rect create to take advantage of the contains() method inside rect to keep the imagelayer x and y inside that rect 
           if(CameraLimit.contains((int)layer1.totalx,(int)layer1.totaly))
          	{  //uses the angle of direction character is facing
       	   		if(input[GameJPanel.UP] && (hero.A < 45  || hero.A > 315))   {Camera2d.moveRightBy(1);}//super.update();} 
       	   		if(input[GameJPanel.UP] && (hero.A < 225 && hero.A > 135))   {Camera2d.moveLeftBy(1);}//super.update();}
       	   		if(input[GameJPanel.UP] && (hero.A > 225 && hero.A < 315))   {Camera2d.moveUpBy(1);}//super.update();}
       	   		if(input[GameJPanel.UP] && (hero.A < 135 && hero.A > 45))    {Camera2d.moveDownBy(1);}//super.update();}
          	}
         //
           }
       if(Level==3){
//-----CAMERA-FOR-LEVEL-3-------------------------------------------------------------------------------------------------------------------------------------------------------------
           if(input[GameJPanel.UP]) //{Camera2d.moveUpBy(3);}if(input[GameJPanel.DN]) {Camera2d.moveDownBy(3);}if(input[GameJPanel.RT]) {Camera2d.moveRightBy(3);}if(input[GameJPanel.LT]) {Camera2d.moveLeftBy(3);}
           //*
           {
        	   if(LeftBorder.distanceTo((int)layer3.totalx,(int)layer3.totaly)>1)	{Camera2d.moveLeftBy(1);}
        	   if(RightBorder.distanceTo((int)layer3.totalx,(int)layer3.totaly)<2)	{Camera2d.moveRightBy(1);}
        	   if(TopBorder.distanceTo((int)layer3.totalx,(int)layer3.totaly)>169)  {Camera2d.moveDownBy(1);}
        	   if(BottomBorder.distanceTo((int)layer3.totalx,(int)layer3.totaly)<-179){Camera2d.moveUpBy(1);}
           }
           // CameraLimit is a rect create to take advantage of the contains() method inside rect to keep the imagelayer x and y inside that rect 
           if(CameraLimit.contains((int)layer1.totalx,(int)layer1.totaly))
          	{  //uses the angle of direction character is facing
       	   		if(input[GameJPanel.UP] && (hero.A < 45  || hero.A > 315))   {Camera2d.moveRightBy(1);}//super.update();} 
       	   		if(input[GameJPanel.UP] && (hero.A < 225 && hero.A > 135))   {Camera2d.moveLeftBy(1);}//super.update();}
       	   		if(input[GameJPanel.UP] && (hero.A > 225 && hero.A < 315))   {Camera2d.moveUpBy(1);}//super.update();}
       	   		if(input[GameJPanel.UP] && (hero.A < 135 && hero.A > 45))    {Camera2d.moveDownBy(1);}//super.update();}
          	}
                   }
       if(Level==4){
//-----CAMERA-FOR-LEVEL-4----------------------------------------------------------------------------------------------------------------------------------------------------------------
           if(input[GameJPanel.UP]) //{Camera2d.moveUpBy(10);}if(input[GameJPanel.DN]) {Camera2d.moveDownBy(10);}if(input[GameJPanel.RT]) {Camera2d.moveRightBy(10);}if(input[GameJPanel.LT]) {Camera2d.moveLeftBy(10);}
           //
           {
        	   if(LeftBorder.distanceTo((int)layer4.totalx,(int)layer4.totaly)>1)	{Camera2d.moveLeftBy(1);}
        	   if(RightBorder.distanceTo((int)layer4.totalx,(int)layer4.totaly)<2)	{Camera2d.moveRightBy(1);}
        	   if(TopBorder.distanceTo((int)layer4.totalx,(int)layer4.totaly)>169)  {Camera2d.moveDownBy(1);}
        	   if(BottomBorder.distanceTo((int)layer4.totalx,(int)layer4.totaly)<-179){Camera2d.moveUpBy(1);}
           }
           // CameraLimit is a rect create to take advantage of the contains() method inside rect to keep the imagelayer x and y inside that rect 
           if(CameraLimit.contains((int)layer1.totalx,(int)layer1.totaly))
          	{  //uses the angle of direction character is facing
       	   		if(input[GameJPanel.UP] && (hero.A < 45  || hero.A > 315))   {Camera2d.moveRightBy(1);}//super.update();} 
       	   		if(input[GameJPanel.UP] && (hero.A < 225 && hero.A > 135))   {Camera2d.moveLeftBy(1);}//super.update();}
       	   		if(input[GameJPanel.UP] && (hero.A > 225 && hero.A < 315))   {Camera2d.moveUpBy(1);}//super.update();}
       	   		if(input[GameJPanel.UP] && (hero.A < 135 && hero.A > 45))    {Camera2d.moveDownBy(1);}//super.update();}
          	}
         */
          // }
  //------------CAMERA_END-------------------------------------------------------------------------------------------------------------------------------------------
	}

//---------- moveGameObjects ---------------------------------------------------------------------------------------------------------------------------------------
   public void moveGameObjects(){
	   plasma.move();
	     for (int i = 0; i < rocks.length; i++){
	         rocks[i].move();
	 	}
	     badguy.track(hero);
	     double dis = badguy.distanceTo((int)hero.x, (int)hero.y);
	     if( dis < 300 && dis>100){
	    	  badguy.fire(plasma);

	     }
	     // badguy.chase(hero);
	  // badguy.checkright(hero);
	   //layer1.FollowCharacter(hero);
      //box.x = player.x;
	   }

//---------- HANDLING COLLISIONS-------------------------------------------------------------------------------------------------------------------------------------
   public void handleCollisions()
   {//}
	   
	   
	   for (int i = 0; i < rocks.length; i++)
	   {
		  for(int j = i+1; j < rocks.length-1;j++){
			  if(rocks[i].hasCollidedWith(rocks[j])){
				  rocks[i].bounce();
				  rocks[j].bounce();
			  }
		  }
		   if (badguy.hasCollidedWith(rocks[i])){
			   rocks[i].bounce();

		   }

		   
		   if (hero.hasCollidedWith(rocks[i]))
	      {
	         //ship.setX(-10000);
	    	  hero.health -= 1;
	    	  hero.moveBackwardby(3);
			   hero.moveBackwardrect(3);

	      }

	      if (plasma.explodesDueToCollisionWith(rocks[i]))
	      {
	         rocks[i].setQ(rocks[i].getQ() - 5);
	    	  
	         if(rocks[i].getQ() < 1)rocks[i].explodes();

	         //explode.play();

	        // score.increaseScoreBy(200);
	        // scoreboard.repaint();
	      }
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   if (plasma.explodesDueToCollisionWith(badguy))
	      {
	       badguy.hl-=10;  
		   System.out.println("yo");
	      }
	   
	  if (plasma.explodesDueToCollisionWith(hero))
	      {
	         System.out.println("im hit");
	         hero.health -= 1;
	         
	      }
	 
	   
	   if (hero.hasCollidedWith(badguy))
	   {
		   hero.moveBackwardby(3);
		   hero.moveBackwardrect(3);
	   }
	   if(hero.health <= 0){
    	   gameover = true;

		   //input[GameJPanel._P] = true;
    	  // paused = true;
    	   //gameover = true;
	   }
	   if(badguy.hl <= 0){
		   badguy.explode();
	   }
	   /*
//-----LEVEL-1------------------------------------------------------------------------------------------------------------------------------------------------------
	  // if(Level == 1)
	   {
//---------TELEPORT-TO-NEXT-LEVEL-2--------------------------------------------
		   if(Teleport1.contains((int)hero.x,(int)hero.y))
		   {
			   Level=2; 
			   hero.moveBy(-1700, 10); 
			   hero.moveByrect(-1700, 10);
			   Camera2d.moveBy(-450, 0);
		   												 }
//---------LINE-COLLISION--------------------------------------------------------
		   if(leftWALL.distanceTo((int)hero.x,(int)hero.y)>-32)
		   {
			   hero.moveRightBy(3); 
			   hero.moveRightByrect(3);
		   }
		   if(rightWALL.distanceTo((int)hero.x,(int)hero.y)<32)
		   {
			   hero.moveLeftBy(3);
			   hero.moveLeftByrect(3);
		   }
		   if(topWALL.distanceTo((int)hero.x,(int)hero.y)<35)
		   {
			   hero.moveDownBy(3); 
			   hero.moveDownByrect(3);
		   }
		   if(b3WALL.distanceTo((int)hero.x,(int)hero.y)>0)
		   {
			   hero.moveUpBy(3);
			   hero.moveUpByrect(3);
		   }
//---------RECTANGLE-COLLISION------------------------------------------------------------------------------
		   if(b1WALL.hasCollidedWith(hero)||b2WALL.hasCollidedWith(hero)
		     ||middlePillar1.hasCollidedWith(hero)||middlePillar2.hasCollidedWith(hero)
		     ||middlePillar3.hasCollidedWith(hero)||middlePillar4.hasCollidedWith(hero)
		     ||middlePillar5.hasCollidedWith(hero))
		   {	//
			   if(hero.front && input[GameJPanel.UP])
			   {
				   hero.moveBackwardby(3);
				   hero.moveBackwardrect(3);
			   }//
			   if(hero.back && input[GameJPanel.DN])
			   {
				   hero.moveForwardby(3);
				   hero.moveForwardrect(3);
			   }   
		   }
		
	   }
//-----LEVEL-2------------------------------------------------------------------------------------------------------------------------------------------------------
	   if(Level == 2)
	   {
//---------TELEPORT-BACK-TO-LEVEL-1-------------------------------------
		   if(Teleport2.contains((int)hero.x,(int)hero.y))
		   {
			   Level=1;
			   hero.A=180;hero.rectA=180;
			   hero.moveBy(1700, 0);
			   hero.moveByrect(1700, 0);
			   Camera2d.moveBy(450, 0);
		   }
			  
//---------LINES-COLLISION-----------------------------------------------
		   if(rightwall.distanceTo((int)hero.x,(int)hero.y)<32)
		   	{
			   hero.moveLeftBy(3); 
			   hero.moveLeftByrect(3);
		    }
		   if(bottomwall.distanceTo((int)hero.x,(int)hero.y)>-45)
		    {
			   hero.moveUpBy(3); 
			   hero.moveUpByrect(3);
			}
//---------RECTANGLE-COLLISION-------------------------------------------
		   if(Topwall_1.hasCollidedWith(hero)|Topwall_2.hasCollidedWith(hero)
			 |Topwall_3.hasCollidedWith(hero)|PillarA.hasCollidedWith(hero)
			 |PillarB.hasCollidedWith(hero)|middleWALL1.hasCollidedWith(hero)
			 |middleWALL2.hasCollidedWith(hero)|leftwallA.hasCollidedWith(hero)
			 |leftwallB.hasCollidedWith(hero)) //Topwall_4.hasCollidedWith(hero))
		   {
			   if(hero.front && input[GameJPanel.UP])
			   {
				   hero.moveBackwardby(3);
				   hero.moveBackwardrect(3);
			   }//
			   if(hero.back && input[GameJPanel.DN])
			   {
				   hero.moveForwardby(3);
				   hero.moveForwardrect(3);
			   }
		   }
//----------TELEPORT-TO-THE-NEXT-LEVEL-3
		    if(Teleport3.contains((int)hero.x,(int)hero.y))
		    {
		    	Level=3;
		    	hero.moveBy(-845, 260);
		    	hero.moveByrect(-845, 260);
		    	hero.A=0;hero.rectA=0;
		    	Camera2d.moveBy(-200, 0);
		    }
	   }
//-----LEVEL-3------------------------------------------------------------------------------------------------------------------------------------------------------
	   if(Level == 3)
	   {
//---------TELEPORT-BACK-TO-LEVEL-2-------------------------------------------
		   if(Teleport22.contains((int)hero.x,(int)hero.y))
		   {
			   Level=2;
			   hero.moveBy(850, -200);
			   hero.moveByrect(850, -200);
			   hero.A=90;hero.rectA=90;
			   Camera2d.moveBy(150, 0);
			}
//---------LINE-COLLISION-------------------------------------------
		   //System.out.println(Topwall.distanceTo((int)hero.x,(int)hero.y));
		   if(Topwall.distanceTo((int)hero.x,(int)hero.y)<37)
		   {
			   hero.moveDownBy(3);
			   hero.moveDownByrect(3);
		   }
		   if(LEFTwall.distanceTo((int)hero.x,(int)hero.y)>-30)
		   {
			   hero.moveRightBy(3);
			   hero.moveRightByrect(3);
		   }
		   if(RIGHTwall.distanceTo((int)hero.x,(int)hero.y)<30)
		   {
			   hero.moveLeftBy(3);
			   hero.moveLeftByrect(3);
		   }
//---------RECTANGLE-COLLISION-------------------------------------------
		   if(bookshelf.hasCollidedWith(hero)|door.hasCollidedWith(hero)
			|plant.hasCollidedWith(hero)|Col.hasCollidedWith(hero)|Colleft.hasCollidedWith(hero)
			|Desk.hasCollidedWith(hero)|desk.hasCollidedWith(hero)
			|Coltop.hasCollidedWith(hero)|Coltopa.hasCollidedWith(hero)
			|ColbottomA.hasCollidedWith(hero)|Colbottom.hasCollidedWith(hero)
			|outerworldA.hasCollidedWith(hero)|outerworldB.hasCollidedWith(hero)
			|BHdesk.hasCollidedWith(hero)|BHdeska.hasCollidedWith(hero)
			|BHdeskb.hasCollidedWith(hero))
		   {
			   if(hero.front && input[GameJPanel.UP])
			   {
				   hero.moveBackwardby(3);
				   hero.moveBackwardrect(3);
			   }//
			   if(hero.back && input[GameJPanel.DN])
			   {
				   hero.moveForwardby(3);
				   hero.moveForwardrect(3);
			   }
		   }
//---------TELEPORT-TO-NEXT-LEVEL 4------------------------------------
		   if(TelePort4.contains((int)hero.x,(int)hero.y))
		   {
			   Level=4;hero.moveBy(900, 0);
			   hero.moveByrect(900, 0);
			   hero.A=180;hero.rectA=180;
			   Camera2d.moveBy(100, -10);
		   }
	   }
//-----LEVEL-4------------------------------------------------------------------------------------------------------------------------------------------------------
	   if(Level == 4)
	   {
//---------TELEPORT-BACK2-LEVEL 3------------------------------------
		   if(Teleport24.contains((int)hero.x,(int)hero.y))
		   {
			   Level=3;
			   hero.moveBy(-1000, -100);
			   hero.moveByrect(-1000, -100);
			   hero.A=270;hero.rectA=270;
			   Camera2d.moveBy(-100, -100);
		   }
//---------RECTANGLE-COLLISION-------------------------------------------
		   if(box1.hasCollidedWith(hero)|box2.hasCollidedWith(hero)
			 |box3.hasCollidedWith(hero)|box4.hasCollidedWith(hero)
			 |box5.hasCollidedWith(hero)|box6.hasCollidedWith(hero)
			 |box7.hasCollidedWith(hero)|box8.hasCollidedWith(hero)
			 |box9.hasCollidedWith(hero)|box10.hasCollidedWith(hero)
			 |box11.hasCollidedWith(hero))
			 {
			   if(hero.front && input[GameJPanel.UP])
			   {
				   hero.moveBackwardby(3);
				   hero.moveBackwardrect(3);
			   }//
			   if(hero.back && input[GameJPanel.DN])
			   {
				   hero.moveForwardby(3);
				   hero.moveForwardrect(3);
			   }
			 }
//---------TELEPORT-END-GAMEOVER------------------------------------		   
		   if(Teleport5.contains((int)hero.x,(int)hero.y))
		   {
			   Level=5;
		   }
	   }
	  
	   */
  
   }//
   
//---------- draw the instances ------------------------------------------------------------------------------------------------------------------------------------
   public void draw(Graphics g){   
	super.paintComponent(g);//prints the panel where every component will be placed

	
	/*for (int i = 0; i < rocks.length; i++){
        rocks[i].draw(g);
	}*/
	
//-----DRAW-LEVEL-1-----------------
/* if(Level==1)
 	{
	 	layer1.draw(g);//draw image background
	 	
	 	hero.draw(g);//draw hero
	 	badguy.draw(g);//draw bad guy
	 	LeftBorder.draw(g);
	 	TopBorder.draw(g);
	 	BottomBorder.draw(g);
	 	RightBorder.draw(g);
	 	leftWALL.draw(g);
	 	rightWALL.draw(g);
	 	topWALL.draw(g);
	 	b1WALL.draw(g);
	 	b2WALL.draw(g);
	 	b3WALL.draw(g);
	 	middlePillar1.draw(g);
	 	middlePillar2.draw(g);
	 	middlePillar3.draw(g);
	 	middlePillar4.draw(g);
	 	middlePillar5.draw(g);
	 	Teleport1.draw(g);
 	}
//-----DRAW-LEVEL-2-----------------
 if(Level == 2)
 {
	 layer2.draw(g);
	 hero.draw(g);
	 rightwall.draw(g);
	 leftwallA.draw(g);
	 leftwallB.draw(g);
	 Topwall_1.draw(g);
	 Topwall_2.draw(g);
	 Topwall_3.draw(g);
	 //Topwall_4.draw(g);
	 PillarA.draw(g);
	 PillarB.draw(g);
	 middleWALL1.draw(g);
	 middleWALL2.draw(g);
	 bottomwall.draw(g);
	 Teleport2.draw(g);
	 Teleport3.draw(g);
 }
//-----DRAW-LEVEL-3-----------------
 if(Level == 3)
 {
	 layer3.draw(g);
	 hero.draw(g);
	 Topwall.draw(g);
	 bookshelf.draw(g);
	 RIGHTwall.draw(g);
	 LEFTwall.draw(g);
	 door.draw(g);
	 plant.draw(g);
	 Col.draw(g);
	 Colleft.draw(g);
	 Coltop.draw(g);
	 Coltopa.draw(g);
	 ColbottomA.draw(g);
	 Colbottom.draw(g);
	 Desk.draw(g);
	 desk.draw(g);
	 BHdesk.draw(g);
	 BHdeska.draw(g);
	 BHdeskb.draw(g);
	 outerworldA.draw(g);
	 outerworldB.draw(g);
	 TelePort4.draw(g);
	 Teleport22.draw(g);
 }
//-----DRAW-LEVEL-4-----------------
 if(Level == 4)
 {
	 layer5.draw(g);
	 layer4.draw(g);
	 hero.draw(g);
	 badguy.draw(g);
	 box1.draw(g);
	 box2.draw(g);
	 Teleport5.draw(g);
	 Teleport24.draw(g);
	 box3.draw(g);
	 box4.draw(g);
	 box5.draw(g);
	 box6.draw(g);
	 box7.draw(g);
	 box8.draw(g);
	 box9.draw(g);
	 box10.draw(g);
	 box11.draw(g);
 }
*/	
	layer1.draw(g);
   plasma.draw(g);
   
   hero.draw(g);//draw hero
   if(gameover){
	   g.setColor(Color.WHITE);
	   
	   g.drawString("GAME OVER",(int)hero.x-Camera2d.x,(int)hero.y-Camera2d.y);
   }/*if(won){
	   g.drawString("WINNER",(int)hero.x-Camera2d.x,(int)hero.y-Camera2d.y);

   }*/
   
   badguy.draw(g);//draw bad guy
   for (int i = 0; i < rocks.length; i++){
      // if(rocks[i].getQ() < 1){
    	   rocks[i].draw(g);

       //}
	}
  //if(gameover = true) paused = true;
   }
   
//---------- main method -------------------------------------------------------------------------------------------------------------------------------------------
   public static void main(String[] args){
	   GameLoop game = new GameLoop();//create a Game_loop object
	   game.startGame();//that will start the thread for the game
   }
}