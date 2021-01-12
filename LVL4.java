
//Amogh Upadhyaya
// 5/4/20
//Key Wars
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; // This code is the fourth level of the game, this class is where everything in level four is 


 public class LVL4 extends JPanel implements KeyListener { // Panel where everything is drawn and all code is written 
	static JPanel cards = StartPanel.cards;
	private int playerX, playerY; // coordinates of the player
	private int aX, aY, bX, bY, cX, cY, dX, dY; //coordinates of the guards
	private int bossx, bossy;
	boolean bossDead = false;
	boolean bossmovement = false, bossmovement2 = false;
	Timer bosstimer;
	int bbulletx, bbullety;
	int bosshealth = 1500;
	private Timer playertimer, counter, bullettimer, bullettimer2, bullettimer3, bullettimer4, ttimer; // timers for movement
	int speed; // speed of player movement
	int speed1; // speed of guard movement
	int bposition; //bullet placement
	int bposition2;
	int bposition3;
	int bposition4;
	boolean amovement = true, bmovement = true, cmovement = true, dmovement = true, upshoot = false, downshoot = false, 
	leftshoot = false, rightshoot = false, guardADead= false, guardBDead = false, guardCDead = false, guardDDead = false, playerAlive = true, blocks = true; // determines which way the guards move
	long time;
	long end;
	boolean bstop = false; //bullet stop
	boolean bstop2 = false;
	boolean bstop3 = false;
	boolean bstop4 = false;
	boolean bside = false, bside2 = false, bside3 = false, bside4 = false; //prevents bullet from straying to the sides
	int bulletX;
	int bulletY;
	int [] arrayx = {1200, 1210, 1220, 1230, 1240, 1220}; // coordinates for lives (hearts)
	int [] arrayy = {30, 20, 25, 20, 30, 50};
	int [] arrayx2 = {1260, 1270, 1280, 1290, 1300, 1280};
	int [] arrayy2 = {30, 20, 25, 20, 30, 50};
	int [] arrayx3 = {1320, 1330, 1340, 1350,1360, 1340};
	int [] arrayy3 = {30, 20, 25, 20, 30, 50};
	int livescount = 3; //life counter
	boolean reset = false, confirm = false, reset2 = false, confirm2 = false, reset3= false, confirm3 = false, r = true; //used to see how many lives are left and reset to starting position
	JButton b1 = new JButton("Return to Main Menu"); // button to quit
	JButton b2 = new JButton("Publish Score"); // button to continue
	JButton b3 = new JButton("Return to Main Menu"); //button to quit
	int tcount = 0;
	Timer etimer;
	int ecount = 0;
	boolean explosion = false, check = false; //used to make explosion 
	boolean randomcheck = false, TNTBlownUp = false, TNT2BlownUp = false, TNT3BlownUp = false,
	TNT4BlownUp = false, TNT5BlownUp = false, TNT6BlownUp= false; // checks if TNT is intact
	int TNTx, TNTy; // TNT randomized coordinates
	int tnt2x, tnt2y, tnt3y, tnt3x, tnt4x, tnt4y;
	int tnt5x, tnt5y, tnt6x, tnt6y;
	boolean tnt2check = false, tnt3check = false, tnt4check = false, tnt5check = false, tnt6check = false;
	boolean randomcheck2 = false, collected = false, randomcheck3 = false, collected2 = false, randomcheck4 = false, collected3 = false; //checks if items are collected
	int speedx, speedy; //coordinates
	boolean speedboostactivate = false; //checks if activated
	int bulletx, bullety; //coordinates
	boolean bulletboostactivate = false; //checks if activated
	int mapx, mapy; //coordinates
	boolean mapactivate = false; //checks if activated
	boolean b1switch = false, b2switch = false, b3switch = false;
	boolean resetgame = false; // checks whether to reset game or not
	boolean dead = false;
	int ahealth = 500, bhealth = 500, chealth =500, dhealth = 500;
	boolean healtha = false, healthb = false, healthc = false, healthc2 = false, healthc3 = false;
	int whichkey = (int)(Math.random()*2)+1;
	
	public LVL4() { // initializing variables
		playerX = 645;
		playerY = 780;
		aX = 10;
		aY = 320;
		bX = 1324;
		bY = 70;
		cX = 1324;
		cY = 500;
		dX = 10;
		dY = 750;
		bossx = 10;
		bossy = 300;
		addKeyListener(this);
		PlayerMover pmover = new PlayerMover();
		playertimer = new Timer(5, pmover);
		playertimer.start();
		AMover amover = new AMover();
		counter = new Timer(10, amover);
		counter.start();
		speed = 1;
		speed1 = 1;
		BulletMover bmover = new BulletMover();
		bullettimer = new Timer(25, bmover);
		bposition = 0;
		BulletMover2 bmover2 = new BulletMover2();
		bullettimer2 = new Timer(25, bmover2);;
		bposition2 = 0;
		BulletMover3 bmover3 = new BulletMover3();
		bullettimer3 = new Timer(25, bmover3);;
		bposition3 = 110;
		BulletMover4 bmover4 = new BulletMover4();
		bullettimer4 = new Timer(25, bmover4);;
		bposition4 = 0;
		ttimer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e)	{tcount++;}
		});
		etimer = new Timer(50, new ActionListener() {
			public void actionPerformed(ActionEvent e){	ecount++;}
		});
	}
	
	class BulletMover implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(bstop == true) 
			{
				bposition = 0; 
				bstop = false;
				upshoot = false;
				bullettimer.stop();
			}
			if(bulletboostactivate == true) bposition+=20;
			else bposition+=10;
			repaint();
			grabFocus();
		}
	}
	
	class BulletMover2 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(bstop2 == true)
			{
				bposition2 = 0;
				bstop2 = false;
				downshoot = false;
				bullettimer2.stop();
			}
			if(bulletboostactivate == true) bposition2+=20;
			else bposition2+=10;
			repaint();
			grabFocus();
		}
	}
	
	class BulletMover3 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(bstop3 == true)
			{
				bposition3 = 110;
				bstop3 = false;
				rightshoot = false;
				bullettimer3.stop();
			}
			if(bulletboostactivate == true) bposition3+=20;
			else bposition3+=10;
			repaint();
			grabFocus();
		}
	}
	
	class BulletMover4 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(bulletboostactivate == true) bposition4+=20;
			else bposition4+=10;
			if(bstop4 == true)
			{
				bposition4 = 0;
				bstop4 = false;
				leftshoot = false;
				bullettimer4.stop();
			}
			repaint();
			grabFocus();
		}
	}
	
	class PlayerMover implements ActionListener { // repaints player
		public void actionPerformed(ActionEvent e) {
			repaint();
			grabFocus();
		}
	}

	class AMover implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(bX == -10 && bossDead == true) // determines which way the first guard moves
			{
				bmovement = false;
			}
			else if(bX == 1320 && bossDead == true)
			{
				bmovement = true;
			}
			if (bmovement == true && bossDead == true) bX-=2;
			else if(bmovement == false && bossDead == true) bX+=2;
				
			
			if (aX == 1320 && bossDead == true) //determines which way the second guard moves
			{
				amovement = false;
			}
			else if(aX == -10 && bossDead == true)
			{
				amovement = true;
			}
			if(amovement == true && bossDead == true) aX+= 2;
			else if(amovement == false && bossDead == true) aX-= 2;
			
			if(cX == 1320 && bossDead == true) // determines the way the third guard moves
			{
				cmovement = true;
			}
			else if(cX == -10 && bossDead == true)
			{
				cmovement = false;
			}
			if(cmovement == true && bossDead == true) cX -= 2;
			else if (cmovement == false && bossDead == true) cX+=2;
			
			if (dX == 1320 && bossDead == true) //determines which way the fourth guard moves
			{
				dmovement = false;
			}
			else if(dX == -10 && bossDead == true)
			{
				dmovement = true;
			}
			if(dmovement == true && bossDead == true) dX+= 2;
			else if (dmovement == false && bossDead == true) dX-= 2;
			
			if(bossx >= 1220)
			{
				bossmovement = false;
			}
			else if(bossx <= -10)
			{
				bossmovement = true;
			}
			if(bossmovement == true) bossx+=3;
			else bossx-=3;
			
			if(bossy <= 0)
			{
				bossmovement2 = false;
			}
			else if(bossy >= 570)
			{
				bossmovement2 = true;
			}
			if(bossmovement2 == true) bossy-=3;
			else bossy+=3;

			repaint();
			grabFocus();
		}
	} 

	public void paintComponent(Graphics g) { //draws and paints the players, guards, key, and the background 
		super.paintComponent(g);
		setBackground(Color.BLUE);
		Rectangle player = new Rectangle(playerX+10, playerY-35, 100, 100);
		Rectangle key;
		Rectangle a, guardA = new Rectangle(aX+10, aY-35, 100, 100), guardB = new Rectangle(bX, bY, 100, 100);
		Rectangle guardC = new Rectangle(cX+10, cY-35, 100, 100);
		Rectangle guardD = new Rectangle(dX, dY, 100, 100);
		Rectangle boss = new Rectangle(bossx, bossy, 200, 300);
		Rectangle fakekey;
		

		if(whichkey == 1)
		{
			key = new Rectangle(50, 400, 50, 50);
			fakekey = new Rectangle(1340, 400, 50, 50);
		}
		else
		{
			key = new Rectangle(1340, 400, 50, 50);
			fakekey = new Rectangle(50, 400, 50, 50); 
		}
		
		
		
		
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
		g.drawString("Equipped: ", 20, 850);
		
		g.setColor(Color.WHITE);
		if(ahealth<=0)
		{
			ahealth = 0;
			guardADead = true;
		}
		if(ahealth<50) g.setColor(Color.RED);
		if(guardADead == false && blocks == true && bossDead == true)
		{
			g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
			g.drawString("Health:" + ahealth, aX+28, aY-40);
		}
		g.setColor(Color.WHITE);
		
		if(bhealth<=0)
		{
			bhealth = 0;
			guardBDead = true;
		}
		if(bhealth<50) g.setColor(Color.RED);
		if(guardBDead == false && blocks == true && bossDead == true)
		{
			g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
			g.drawString("Health:" + bhealth, bX+18, bY-3);
		}
		g.setColor(Color.WHITE);
		
		if(chealth<=0)
		{
			chealth = 0;
			guardCDead = true;
		}
		if(chealth<50) g.setColor(Color.RED);
		if(guardCDead == false && blocks == true && bossDead == true)
		{
			g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
			g.drawString("Health:" + chealth, cX+28, cY-40);
		}
		
		if(dhealth<=0)
		{
			dhealth = 0;
			guardDDead = true;
		}
		if(dhealth<50) g.setColor(Color.RED);
		if(guardDDead == false && blocks == true && bossDead == true)
		{
			g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
			g.drawString("Health:" + dhealth, dX+18, dY-3);
		}
		
		if(bosshealth<=0)
		{
			bosshealth = 0;
			bossDead = true;
		}
		if(bosshealth<500) g.setColor(Color.RED);
		if(bossDead == false && blocks == true)
		{
			g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
			g.drawString("Health:" + bosshealth, bossx+18, bossy-3);
		}
		
		
		g.setColor(Color.BLACK);
		
		
		if(r == false){
			playerX = 645;
			playerY = 780; 
			aX = 10;
			aY = 400;
			bX = 1324;
			bY = 150;
			cX = 1324;
			cY = 650;
			dX = 0;
			dY = 0;
			dmovement = true;
			guardDDead = false;
			playertimer.stop();
			counter.stop();
			bullettimer.stop();
			bullettimer2.stop(); 
			bullettimer3.stop();
			bullettimer4.stop();
			playertimer.start();
			counter.start();
			bullettimer.start();
			bullettimer2.start(); 
			bullettimer3.start();
			bullettimer4.start();
			ttimer.start();;
			speed = 1; 
			speed1 = 1; 
			bposition = 0; 
			bposition2 = 0;
			bposition3 = 110;
			bposition4 = 0;
			amovement = true;
			bmovement = true;
			upshoot = false;
			downshoot = false;
			leftshoot = false;
			rightshoot = false;
			guardADead= false;
			guardBDead = false;
			playerAlive = true;
			blocks = true; 
			time = 0;
			end = 0;
			bstop = false; 
			bstop2 = false;
			bstop3 = false;
			bstop4 = false;
			bside = false;
			bside2 = false;
			bside3 = false;
			bside4 = false; 
			bulletX = 0;
			bulletY = 0;
			livescount = 3; 
			reset = false;
			confirm = false;
			reset2 = false;
			confirm2 = false;
			reset3= false;
			confirm3 = false;
			tcount = 0;
			etimer.stop();
			ecount = 0;
			explosion = false;
			check = false; 
			randomcheck = false;
			TNTBlownUp = false; 
			TNTx = 0 ;
			TNTy = 0; 
			randomcheck2 = false;
			collected = false;
			randomcheck3 = false;
			collected2 = false;
			randomcheck4 = false;
			collected3 = false; 
			speedx = 0;
			speedy = 0; 
			speedboostactivate = false; 
			bulletx = 0;
			bullety = 0; 
			bulletboostactivate = false; 
			mapx = 0;
			mapy = 0; 
			mapactivate = false; 
			b1switch = false;
			b2switch = false;
			b3switch = false;
			
			resetgame = false;
		}
		
		
		if(randomcheck == false)
		{
			TNTx = (int)(Math.random()*1391) + 0;
			TNTy = (int)(Math.random()*851) + 0;
			while(TNTy>720 || TNTy<100)
			{
				TNTy = (int)(Math.random()*851) + 0;
			}
			randomcheck = true;
		}
		
		Rectangle TNTRect = new Rectangle(TNTx, TNTy, 50, 50);
		
		Image TNT = new ImageIcon("tnt.png").getImage();
		if(TNTBlownUp == false && blocks == true) g.drawImage(TNT, TNTx, TNTy, this);
		
		if(player.intersects(TNTRect))
		{
			TNTBlownUp = true;
			livescount = 0;
			reset3 =true;
		}
		
		if(tnt2check == false)
		{
			tnt2x = (int)(Math.random()*1391) + 0;
			tnt2y = (int)(Math.random()*851) + 0;
			while(tnt2y>720 || tnt2y<100 || (tnt2y>TNTy-50 && tnt2y<TNTy+50) || (tnt2y>speedy - 50 && tnt2y<speedy+50) || (tnt2y>bullety - 50 && tnt2y<bullety+50) || (tnt2y>mapy-50 && tnt2y<mapy+50))
			{
				tnt2y = (int)(Math.random()*851) + 0;
			}
			tnt2check = true;
		}
		
		Rectangle TNT2Rect = new Rectangle(tnt2x, tnt2y, 50, 50);
		
		Image TNT2 = new ImageIcon("tnt.png").getImage();
		if(TNTBlownUp == false && blocks == true) g.drawImage(TNT2, tnt2x, tnt2y, this);
		
		if(player.intersects(TNT2Rect))
		{
			TNT2BlownUp = true;
			livescount = 0;
			reset3 =true;
		}
		
		if(tnt3check == false)
		{
			tnt3x = (int)(Math.random()*1391) + 0;
			tnt3y = (int)(Math.random()*851) + 0;
			while(tnt3y>720 || tnt3y<100 || (tnt3y>TNTy-50 && tnt3y<TNTy+50) || (tnt3y>speedy - 50 && tnt3y<speedy+50)
					|| (tnt3y>bullety - 50 && tnt3y<bullety+50) || (tnt3y>mapy-50 && tnt3y<mapy+50) && (tnt3y>tnt2y-50 && tnt3y<tnt2y+50))
			{
				tnt3y = (int)(Math.random()*851) + 0;
			}
			tnt3check = true;
		}
		
		Rectangle tnt3Rect = new Rectangle(tnt3x, tnt3y, 50, 50);
		
		Image tnt3 = new ImageIcon("tnt.png").getImage();
		if(TNTBlownUp == false && blocks == true) g.drawImage(tnt3, tnt3x, tnt3y, this);
		
		if(player.intersects(tnt3Rect))
		{
			TNT3BlownUp = true;
			livescount = 0;
			reset3 =true;
		}
		
		if(tnt4check == false)
		{
			tnt4x = (int)(Math.random()*1391) + 0;
			tnt4y = (int)(Math.random()*851) + 0;
			while(tnt4y>720 || tnt4y<100 || (tnt4y>TNTy-50 && tnt4y<TNTy+50) 
					|| (tnt4y>speedy - 50 && tnt4y<speedy+50) || (tnt4y>bullety - 50 && tnt4y<bullety+50) || (tnt4y>mapy-50 && tnt4y<mapy+50) && (tnt4y>tnt2y-50 && tnt4y<tnt2y+50))
			{
				tnt4y = (int)(Math.random()*851) + 0;
			}
			tnt4check = true;
		}
		
		Rectangle tnt4Rect = new Rectangle(tnt4x, tnt4y, 50, 50);
		
		Image tnt4 = new ImageIcon("tnt.png").getImage();
		if(TNTBlownUp == false && blocks == true) g.drawImage(tnt4, tnt4x, tnt4y, this);
		
		if(player.intersects(tnt4Rect))
		{
			TNT4BlownUp = true;
			livescount = 0;
			reset3 =true;
		}
		
		if(tnt5check == false)
		{
			tnt5x = (int)(Math.random()*1391) + 0;
			tnt5y = (int)(Math.random()*851) + 0;
			while(tnt5y>720 || tnt5y<100 || (tnt5y>TNTy-50 && tnt5y<TNTy+50) 
					|| (tnt5y>speedy - 50 && tnt5y<speedy+50) || (tnt5y>bullety - 50 && tnt5y<bullety+50) || (tnt5y>mapy-50 && tnt5y<mapy+50) && (tnt5y>tnt2y-50 && tnt5y<tnt2y+50)
					|| tnt5y>tnt4y - 50 && tnt5y<tnt4y+50)
			{
				tnt5y = (int)(Math.random()*851) + 0;
			}
			tnt5check = true;
		}
		
		Rectangle tnt5Rect = new Rectangle(tnt5x, tnt5y, 50, 50);
		
		Image tnt5 = new ImageIcon("tnt.png").getImage();
		if(TNTBlownUp == false && blocks == true) g.drawImage(tnt5, tnt5x, tnt5y, this);
		
		if(player.intersects(tnt5Rect))
		{
			TNT5BlownUp = true;
			livescount = 0;
			reset3 =true;
		}
		
		if(tnt6check == false)
		{
			tnt6x = (int)(Math.random()*1391) + 0;
			tnt6y = (int)(Math.random()*851) + 0;
			while(tnt6y>720 || tnt6y<100 || (tnt6y>TNTy-50 && tnt6y<TNTy+50) 
					|| (tnt6y>speedy - 50 && tnt6y<speedy+50) || (tnt6y>bullety - 50 && tnt6y<bullety+50) || (tnt6y>mapy-50 && tnt6y<mapy+50) && (tnt6y>tnt2y-50 && tnt6y<tnt2y+50)
					|| tnt6y>tnt4y - 50 && tnt6y<tnt4y+50 || tnt6y>tnt5y-50 && tnt6y<tnt5y+50)
				
			{
				tnt6y = (int)(Math.random()*851) + 0;
			}
			tnt6check = true;
		}
		
		Rectangle tnt6Rect = new Rectangle(tnt6x, tnt6y, 50, 50);
		
		Image tnt6 = new ImageIcon("tnt.png").getImage();
		if(TNTBlownUp == false && blocks == true) g.drawImage(tnt6, tnt6x, tnt6y, this);
		
		if(player.intersects(tnt6Rect))
		{
			TNT6BlownUp = true;
			livescount = 0;
			reset3 =true;
		}
		
		if(randomcheck2 == false)
		{
			speedx = (int)(Math.random()*1391) + 0;
			speedy = (int)(Math.random()*851) + 0;
			while(speedy>400 || speedy<100 || (speedy>TNTy-50 && speedy<TNTy+50))
			{
				speedy = (int)(Math.random()*851) + 0;
			}
			randomcheck2 = true;
		}
		Rectangle speedboost = new Rectangle(speedx, speedy, 50, 50);
		Image speed = new ImageIcon("2xspeed.png").getImage();
		
		if(collected == false && blocks == true) g.drawImage(speed, speedx, speedy, this);
		
		if(player.intersects(speedboost))
		{
			collected = true;
			speedboostactivate = true;
		}
		
		
		
		if(randomcheck3 == false)
		{
			bulletx = (int)(Math.random()*1391) + 0;
			bullety = (int)(Math.random()*851) + 0;
			while(bullety>780 || bullety<100 || (bullety>TNTy-50 && bullety<TNTy+50) || (bullety>speedy - 50 && bulletx<speedy+50))
			{
				bullety = (int)(Math.random()*851) + 0;
			}
			randomcheck3 = true;
		}
		
		Rectangle bulletboost = new Rectangle(bulletx, bullety, 50, 25);
		Image bullet = new ImageIcon("2xbulletspeed.jpg").getImage();
		
		if(collected2 == false && blocks == true) g.drawImage(bullet, bulletx, bullety, this);
		
		if(player.intersects(bulletboost)) 
		{
			bulletboostactivate = true;
			collected2 = true;
		}
		
		Rectangle maprect = new Rectangle(mapx, mapy, 50, 50);
		Image map = new ImageIcon("map.jpg").getImage();
		
		if(randomcheck4 == false)
		{
			mapx = (int)(Math.random()*1391) + 0;
			mapy = (int)(Math.random()*851) + 0;
			while(mapy>300 || mapy<100 || (mapy>TNTy-50 && mapy<TNTy+50) || (mapy>speedy - 50 && mapx<speedy+50) || (mapy>bullety - 50 && mapx<bullety+50))
			{
				mapy = (int)(Math.random()*851) + 0;
			}
			randomcheck4 = true;
		}
		
		if(collected3 == false && blocks == true) g.drawImage(map, mapx, mapy, this);
		
		if(player.intersects(maprect))
		{
			mapactivate = true;
			collected3 = true;
		}
		
		if(collected == true && collected2 == false && collected3 == true)
		{
			g.drawImage(speed, 150, 805, this);
			g.drawImage(map, 210, 805, this);
		}
		if(collected == false && collected2 == true && collected3 == true)
		{
			g.drawImage(map, 150, 805, this);
			g.drawImage(bullet, 210, 820, this);
		}
		if(collected == true && collected2 == true && collected3 == false)
		{
			g.drawImage(speed, 150, 805, this);
			g.drawImage(bullet, 210, 820, this);
		}
		if(collected == true && collected2 == false && collected3 == false)
		{
			g.drawImage(speed, 150, 805, this);
		}
		if(collected == false && collected2 == false && collected3 == true)
		{
			g.drawImage(map, 150, 805, this);
		}
		if(collected == false && collected2 == true && collected3 == false)
		{
			g.drawImage(bullet, 150, 820, this);
		}
		if(collected == true && collected2 == true && collected3 == true)
		{
			g.drawImage(speed, 150, 805, this);
			g.drawImage(map, 210, 805, this);
			g.drawImage(bullet, 270, 820, this);
		}
		
		
		
		
		ttimer.start();
		if(tcount<10)
		{
			g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
			g.drawString("Time:", 20, 49);
			g.drawString("00:0" + tcount, 100, 50);
		}
		else if(tcount>=10 && tcount<60)
		{
			g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
			g.drawString("Time:", 20, 49);
			g.drawString("00:" + tcount, 100, 50);
		}
		else if(tcount>=60 && tcount<600)
		{
			if(tcount%60<10)
			{
				g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
				g.drawString("Time:", 20, 49);
				g.drawString("0" + tcount/60 + ":0" + tcount%60, 100, 50);
			}
			else
			{
				g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
				g.drawString("Time:", 20, 49);
				g.drawString("0" + tcount/60 + ":" + tcount%60, 100, 50);
			}
		}
		else if(tcount>=600 && tcount<3600)
		{
			if(tcount%60<10)
			{
				g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
				g.drawString("Time:", 20, 49);
				g.drawString("" + tcount/60 + ":0" + tcount%60, 100, 50);
			}
			else
			{
				g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
				g.drawString("Time:", 20, 49);
				g.drawString("" + tcount/60 + ":" + tcount%60, 100, 50);
			}
		}
		
		if(guardADead == false && bossDead == true)
		{
		if(guardA.intersects(player))
		{
			if(confirm == false) reset = true;
			else if(confirm2 == false && confirm == true) reset2 = true;
			else if(confirm3 == false && confirm == true && confirm2 == true) reset3 = true;
			/*if(livescount==0)
			{
				playerAlive = false;
				blocks = false;
				setBackground(Color.BLACK);
				g.setColor(Color.RED);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 150)); 
				g.drawString("YOU DIED!", 350, 500);
			}*/
		}
		}
		
		if(guardBDead == false && bossDead == true)
		{
		if(guardB.intersects(player))
		{
			if(confirm == false) reset = true;
			else if(confirm2 == false && confirm == true) reset2 = true;
			else if(confirm3 == false && confirm == true && confirm2 == true) reset3 = true;
			/*if(livescount==0)
			{
				playerAlive = false;
				setBackground(Color.BLACK);
				g.setColor(Color.RED);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 150)); 
				blocks = false;
				g.drawString("YOU DIED!", 350, 500);
			}*/
		}
		}
		
		if(guardCDead == false && bossDead == true)
		{
		if(guardC.intersects(player))
		{
			if(confirm == false) reset = true;
			else if(confirm2 == false && confirm == true) reset2 = true;
			else if(confirm3 == false && confirm == true && confirm2 == true) reset3 = true;
			/*if(livescount==0)
			{
				playerAlive = false;
				setBackground(Color.BLACK);
				g.setColor(Color.RED);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 150)); 
				blocks = false;
				g.drawString("YOU DIED!", 350, 500);
			}*/
		}
		}
		
		if(guardDDead == false && bossDead == true)
		{
		if(guardD.intersects(player))
		{
			if(confirm == false) reset = true;
			else if(confirm2 == false && confirm == true) reset2 = true;
			else if(confirm3 == false && confirm == true && confirm2 == true) reset3 = true;
			/*if(livescount==0)
			{
				playerAlive = false;
				setBackground(Color.BLACK);
				g.setColor(Color.RED);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 150)); 
				blocks = false;
				g.drawString("YOU DIED!", 350, 500);
			}*/
		}
		}
		
		if(bossDead == false)
		{
		if(boss.intersects(player))
		{
			if(confirm == false) reset = true;
			else if(confirm2 == false && confirm == true) reset2 = true;
			else if(confirm3 == false && confirm == true && confirm2 == true) reset3 = true;
			/*if(livescount==0)
			{
				playerAlive = false;
				setBackground(Color.BLACK);
				g.setColor(Color.RED);
				g.setFont(new Font("TimesRoman", Font.PLAIN, 150)); 
				blocks = false;
				g.drawString("YOU DIED!", 350, 500);
			}*/
		}
		}
		
		if(reset == true)
		{
			playerX = 645;
			playerY = 780;
			livescount=2;
			reset = false;
			confirm = true;
		}
		
		if(reset2 == true)
		{
			playerX = 645;
			playerY = 780;
			livescount=1;
			reset2 = false;
			confirm2 = true;
		}
		
		if(reset3 == true)
		{
			livescount = 0;
			blocks = false;
			playerAlive = false;
			setBackground(Color.BLACK);
			g.setColor(Color.RED);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 150)); 
			g.drawString("YOU DIED!", 350, 350);
			b3.setBounds(560, 600, 300, 100);
			b3.setFont(new Font("Comic Sans", Font.PLAIN, 25));
			b3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					CardLayout c = (CardLayout) cards.getLayout();
					c.show(cards, "start");
					resetgame = true;

				}
			});
			if(livescount==0&&resetgame==false)
			{
				add(b3);
			}
			ttimer.stop();
			dead = true;
		}
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
		g.drawString("Lives: ", 1115, 50);
		
		g.setColor(Color.RED);
		
		
		if(livescount == 3)
		{
			g.fillPolygon(arrayx, arrayy, 6);
			g.fillPolygon(arrayx2, arrayy2, 6);
			g.fillPolygon(arrayx3, arrayy3, 6);
		}
		if(livescount == 2)
		{
			g.fillPolygon(arrayx, arrayy, 6);
			g.fillPolygon(arrayx2, arrayy2, 6);
		}
		if(livescount == 1)
		{
			g.fillPolygon(arrayx, arrayy, 6);
		}
		
		Image playerimage = new ImageIcon("heroblue.jpg").getImage();
		g.setColor(Color.BLACK);
		if(playerAlive == true) g.fillRect(playerX+10, playerY-35, 100, 100);
		if(playerAlive == true) 
		{
			g.drawImage(playerimage, playerX+10, playerY-35, this);
		}

		
		g.setColor(Color.WHITE);

		Image guardAImage = new ImageIcon("guardsblue2.jpg").getImage();
		Image guardBImage = new ImageIcon("guardsblue.jpg").getImage();
		Image bossImage = new ImageIcon("blueboss.jpg").getImage();
		
		if (guardADead == false && blocks == true && bossDead == true) g.fillRect(aX+10, aY-35, 100, 100); 
		if (guardADead == false && blocks == true && amovement == true && bossDead == true) g.drawImage(guardAImage, aX+10, aY-35, this);
		if (guardADead == false && blocks == true && amovement == false && bossDead == true) g.drawImage(guardBImage, aX+10, aY-35, this);
		if (guardBDead == false && blocks == true && bossDead == true ) g.fillRect(bX, bY, 100, 100);
		if (guardBDead == false && blocks == true && bmovement == true && bossDead == true) g.drawImage(guardBImage, bX, bY, this);
		if (guardBDead == false && blocks == true && bmovement == false && bossDead == true) g.drawImage(guardAImage, bX, bY, this);
		if (guardCDead == false && blocks == true && bossDead == true) g.fillRect(cX+10, cY-35, 100, 100); 
		if (guardCDead == false && blocks == true && cmovement == true && bossDead == true) g.drawImage(guardBImage, cX+10, cY-35, this);
		if (guardCDead == false && blocks == true && cmovement == false && bossDead == true) g.drawImage(guardAImage, cX+10, cY-35, this);
		if (guardDDead == false && blocks == true && bossDead == true) g.fillRect(dX, dY, 100, 100); 
		if (guardDDead == false && blocks == true && dmovement == true && bossDead == true) g.drawImage(guardAImage, dX, dY, this);
		if (guardDDead == false && blocks == true && dmovement == false && bossDead == true) g.drawImage(guardBImage, dX, dY, this);
		
		if(bossDead == false && blocks == true) g.fillRect(bossx,  bossy,  200,  300);
		if(bossDead == false && blocks == true && (bossmovement == false || bossmovement == true)) g.drawImage(bossImage, bossx, bossy, this);
		
		g.setColor(Color.YELLOW);
		
		Image keyimage = new ImageIcon("key.png").getImage();
		if((blocks == true && guardADead == true && guardBDead == true && guardCDead == true && guardDDead == true && bossDead == true) 
		|| (blocks == true && mapactivate == true && bossDead == true)) 
		{
			g.setColor(Color.RED);
			g.drawString("Choose the right key!", 600, 50);
			g.setColor(Color.YELLOW);
			g.fillRect(50, 400, 50, 50);
			g.fillRect(1340,  400,  50,  50);
		}
		if((blocks == true && guardADead == true && guardBDead == true && guardCDead == true && guardDDead == true && bossDead == true) 
		|| (blocks == true && mapactivate == true && bossDead == true))
		{
			g.drawImage(keyimage, 50, 400, this);
			g.drawImage(keyimage, 1340,  400,  this);
		}
		
		
		if(player.intersects(key) && guardADead == true && guardBDead == true && guardCDead == true && guardDDead == true && dead == false && bossDead == true
				|| player.intersects(key) && mapactivate == true && dead == false && bossDead == true) // checking to see whether the player has interacted with the key or not
		{
			playerAlive = false;
			blocks = false;
			setBackground(Color.GREEN);
			g.setColor(Color.BLACK);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 150)); 
			g.drawString("You Win !", 400, 350);
			b1.setBounds(570, 600, 300, 100);
			b2.setBounds(910, 600, 300, 100);
			b1.setFont(new Font("Comic Sans", Font.PLAIN, 25));
			b2.setFont(new Font("Comic Sans", Font.PLAIN, 25));
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					CardLayout c = (CardLayout) cards.getLayout();
					c.show(cards, "start");
					resetgame = true;
				}
			});
			b2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					CardLayout c = (CardLayout) cards.getLayout();
					// LVL2 levelTwo = new LVL2();
						//cards.add(levelTwo, "lvl2");
						c.show(cards, "lvl2");
					resetgame = true;
				}
			});
			add(b1);
		    //add(b2);
		    ttimer.stop();
		}
		else if(player.intersects(fakekey) && guardADead == true && guardBDead == true && guardCDead == true && guardDDead == true && dead == false && bossDead == true
				|| player.intersects(fakekey) && mapactivate == true && dead == false && bossDead == true)
		{
			reset3 = true;
		}
		
		
		if(chealth == 150)
		{
			healthc = true;
		}
		 if(chealth > 50 && chealth<150)
		{
			healthc2 = true;
		}
		if(chealth == 50)
		{
			healthc3 = true;
		}
		
		if(upshoot == true) //checks to see in which way player is shooting
		{
			bullettimer.start();
			g.setColor(Color.ORANGE);
			if(bside == false)
			{
				bulletX = playerX;
				bulletY = playerY;
				bside = true;
			}
			g.fillRect(bulletX + 55, bulletY - bposition, 10, 20);
			if(bulletY-bposition<=0)
			{
				bstop = true;
				bposition = 0;
			}
			bullettimer.start();
			a = new Rectangle(bulletX + 55, bulletY - bposition, 10, 20);
				
			guardA = new Rectangle(aX+10, aY-35, 100, 100);
			guardB = new Rectangle(bX, bY, 100, 100);
			
			if(a.intersects(guardA) && bossDead == true)
			{
				g.fillRect(aX+100, aY, 10, 10);
				g.fillRect(aX+100,  aY+50, 10, 10);
				g.fillRect(aX-20, aY, 10, 10);
				g.fillRect(aX-20, aY+50, 10, 10);
				g.fillRect(aX+20, aY-50, 10, 10);
				g.fillRect(aX+80, aY-50, 10, 10);
				g.fillRect(aX, aY+50, 10, 10);
				g.fillRect(aX+60, aY+50, 10, 10);
				ahealth-=1;
			}

			
			if(a.intersects(guardB) && bossDead == true)
			{
				
					g.fillRect(bX+100, bY, 10, 10);
					g.fillRect(bX+100,bY+50, 10, 10);
					g.fillRect(bX-20, bY, 10, 10);
					g.fillRect(bX-20, bY+50, 10, 10);
					g.fillRect(bX+20, bY-50, 10, 10);
					g.fillRect(bX+80, bY-50, 10, 10);
					g.fillRect(bX, bY+50, 10, 10);
					g.fillRect(bX+60, bY+50, 10, 10);
				
				bhealth-=1;
			}
			
			
			if(a.intersects(guardC) && bossDead == true)
			{
				
					g.fillRect(cX+100, cY, 10, 10);
					g.fillRect(cX+100,cY+50, 10, 10);
					g.fillRect(cX-20, cY, 10, 10);
					g.fillRect(cX-20, cY+50, 10, 10);
					g.fillRect(cX+20, cY-50, 10, 10);
					g.fillRect(cX+80, cY-50, 10, 10);
					g.fillRect(cX, cY+50, 10, 10);
					g.fillRect(cX+60, cY+50, 10, 10);
				
					chealth-=1;
			}
			
			if(a.intersects(guardD) && bossDead == true)
			{
				
					g.fillRect(dX+100, dY, 10, 10);
					g.fillRect(dX+100,dY+50, 10, 10);
					g.fillRect(dX-20, dY, 10, 10);
					g.fillRect(dX-20, dY+50, 10, 10);
					g.fillRect(dX+20, dY-50, 10, 10);
					g.fillRect(dX+80, dY-50, 10, 10);
					g.fillRect(dX, dY+50, 10, 10);
					g.fillRect(dX+60, dY+50, 10, 10);
				
					dhealth-=1;
			}
			
			if(a.intersects(boss))
			{
				
					g.fillRect(bossx+230, bossy, 10, 10);
					g.fillRect(bossx+230,bossy+200, 10, 10);
					g.fillRect(bossx-20, bossy, 10, 10);
					g.fillRect(bossx-20, bossy+200, 10, 10);
					g.fillRect(bossx+80, bossy-50, 10, 10);
					g.fillRect(bossx+80, bossy-50, 10, 10);
					g.fillRect(bossx, bossy+300, 10, 10);
					g.fillRect(bossx+60, bossy+300, 10, 10);
				
					bosshealth-=1;
			}
			
		}
			
	
		
		if(downshoot == true) //checks to see in which way player is shooting
		{
			bullettimer2.start();
			g.setColor(Color.ORANGE);
			if(bside2 == false)
			{
				bulletX = playerX;
				bulletY = playerY;
				bside2 = true;
			}
			g.fillRect(bulletX + 55, bulletY + bposition2, 10, 20);
			if(bulletY+bposition2>=900)
			{
				bstop2 = true;
				bposition2 = 0;
			}
			a = new Rectangle(bulletX + 55, bulletY + bposition2, 10, 20);
			//b = new Rectangle(playerX + 55, playerY + 155, 10, 20);
			//c = new Rectangle(playerX + 55, playerY + 210, 10, 20);
			//d = new Rectangle(playerX + 55, playerY + 265, 10, 20);
			//e = new Rectangle(playerX + 55, playerY + 320, 10, 20);
			
			guardA = new Rectangle(aX+10, aY-35, 100, 100);
			guardB = new Rectangle(bX, bY, 100, 100);
			
			if(a.intersects(guardA) && bossDead == true)
			{
				
					g.fillRect(aX+100, aY, 10, 10);
					g.fillRect(aX+100,  aY+50, 10, 10);
					g.fillRect(aX-20, aY, 10, 10);
					g.fillRect(aX-20, aY+50, 10, 10);
					g.fillRect(aX+20, aY-50, 10, 10);
					g.fillRect(aX+80, aY-50, 10, 10);
					g.fillRect(aX, aY+50, 10, 10);
					g.fillRect(aX+60, aY+50, 10, 10);
				
				ahealth-=1;
			}
			
			if(a.intersects(guardB) && bossDead == true)
			{
				
					g.fillRect(bX+100, bY, 10, 10);
					g.fillRect(bX+100,  bY+50, 10, 10);
					g.fillRect(bX-20, bY, 10, 10);
					g.fillRect(bX-20, bY+50, 10, 10);
					g.fillRect(bX+20, bY-50, 10, 10);
					g.fillRect(bX+80, bY-50, 10, 10);
					g.fillRect(bX, bY+50, 10, 10);
					g.fillRect(bX+60, bY+50, 10, 10);
				
				bhealth-=1;
			}
			
			if(a.intersects(guardC) && bossDead == true)
			{
				
					g.fillRect(cX+100, cY, 10, 10);
					g.fillRect(cX+100,cY+50, 10, 10);
					g.fillRect(cX-20, cY, 10, 10);
					g.fillRect(cX-20, cY+50, 10, 10);
					g.fillRect(cX+20, cY-50, 10, 10);
					g.fillRect(cX+80, cY-50, 10, 10);
					g.fillRect(cX, cY+50, 10, 10);
					g.fillRect(cX+60, cY+50, 10, 10);
				
				chealth-=1;
			}
			
			if(a.intersects(guardD) && bossDead == true)
			{
				
					g.fillRect(dX+100, dY, 10, 10);
					g.fillRect(dX+100,dY+50, 10, 10);
					g.fillRect(dX-20, dY, 10, 10);
					g.fillRect(dX-20, dY+50, 10, 10);
					g.fillRect(dX+20, dY-50, 10, 10);
					g.fillRect(dX+80, dY-50, 10, 10);
					g.fillRect(dX, dY+50, 10, 10);
					g.fillRect(dX+60, dY+50, 10, 10);
				
					dhealth-=1;
			}
			
			if(a.intersects(boss))
			{
				
					g.fillRect(bossx+230, bossy, 10, 10);
					g.fillRect(bossx+230,bossy+200, 10, 10);
					g.fillRect(bossx-20, bossy, 10, 10);
					g.fillRect(bossx-20, bossy+200, 10, 10);
					g.fillRect(bossx+80, bossy-50, 10, 10);
					g.fillRect(bossx+80, bossy-50, 10, 10);
					g.fillRect(bossx, bossy+300, 10, 10);
					g.fillRect(bossx+60, bossy+300, 10, 10);
				
					bosshealth-=1;
			}
				
		}
		
		if(rightshoot == true) //checks to see in which way player is shooting
		{
			bullettimer3.start();
			g.setColor(Color.ORANGE);
			if(bside3 == false)
			{
				bulletX = playerX;
				bulletY = playerY;
				bside3 = true;
			}
			g.fillRect(bulletX + bposition3, bulletY+20, 20, 10);
			if(bulletX+bposition3>=1400)
			{
				bstop3 = true;
				bposition3 = 110;
			}
			
			a = new Rectangle(bulletX + bposition3, bulletY + 20, 20, 10);
			//b = new Rectangle(playerX + 165+55, playerY + 20, 20, 10);
			//c = new Rectangle(playerX + 220+55, playerY + 20, 20, 10);
			//d = new Rectangle(playerX + 275+55, playerY + 20, 20, 10);
			//e = new Rectangle(playerX + 330+55, playerY + 20, 20, 10);
			
			guardA = new Rectangle(aX+10, aY-35, 100, 100);
			guardB = new Rectangle(bX, bY, 100, 100);
			
			if(a.intersects(guardA) && bossDead == true)
			{
				
				g.fillRect(aX+100, aY, 10, 10);
				g.fillRect(aX+100,  aY+50, 10, 10);
				g.fillRect(aX-20, aY, 10, 10);
				g.fillRect(aX-20, aY+50, 10, 10);
				g.fillRect(aX+20, aY-50, 10, 10);
				g.fillRect(aX+80, aY-50, 10, 10);
				g.fillRect(aX, aY+50, 10, 10);
				g.fillRect(aX+60, aY+50, 10, 10);
				ahealth-=1;
			}
			
			
			if(a.intersects(guardB) && bossDead == true)
			{
				
					g.fillRect(bX+100, bY, 10, 10);
					g.fillRect(bX+100,  bY+50, 10, 10);
					g.fillRect(bX-20, bY, 10, 10);
					g.fillRect(bX-20, bY+50, 10, 10);
					g.fillRect(bX+20, bY-50, 10, 10);
					g.fillRect(bX+80, bY-50, 10, 10);
					g.fillRect(bX, bY+50, 10, 10);
					g.fillRect(bX+60, bY+50, 10, 10);
				
				bhealth-=1;
			}
			
			if(a.intersects(guardC) && bossDead == true)
			{
				
					g.fillRect(cX+100, cY, 10, 10);
					g.fillRect(cX+100,cY+50, 10, 10);
					g.fillRect(cX-20, cY, 10, 10);
					g.fillRect(cX-20, cY+50, 10, 10);
					g.fillRect(cX+20, cY-50, 10, 10);
					g.fillRect(cX+80, cY-50, 10, 10);
					g.fillRect(cX, cY+50, 10, 10);
					g.fillRect(cX+60, cY+50, 10, 10);
				
				chealth-=1;
			}
			
			if(a.intersects(guardD) && bossDead == true)
			{
				
					g.fillRect(dX+100, dY, 10, 10);
					g.fillRect(dX+100,dY+50, 10, 10);
					g.fillRect(dX-20, dY, 10, 10);
					g.fillRect(dX-20, dY+50, 10, 10);
					g.fillRect(dX+20, dY-50, 10, 10);
					g.fillRect(dX+80, dY-50, 10, 10);
					g.fillRect(dX, dY+50, 10, 10);
					g.fillRect(dX+60, dY+50, 10, 10);
				
					dhealth-=1;
			}
			
			if(a.intersects(boss))
			{
				
					g.fillRect(bossx+230, bossy, 10, 10);
					g.fillRect(bossx+230,bossy+200, 10, 10);
					g.fillRect(bossx-20, bossy, 10, 10);
					g.fillRect(bossx-20, bossy+200, 10, 10);
					g.fillRect(bossx+80, bossy-50, 10, 10);
					g.fillRect(bossx+80, bossy-50, 10, 10);
					g.fillRect(bossx, bossy+300, 10, 10);
					g.fillRect(bossx+60, bossy+300, 10, 10);
				
					bosshealth-=1;
			}
			
			
		}
		
		if(leftshoot == true) //checks to see in which way player is shooting
		{
			bullettimer4.start();
			g.setColor(Color.ORANGE);
			if(bside4 == false)
			{
				bulletX = playerX;
				bulletY = playerY;
				bside4 = true;
			}
			g.fillRect(bulletX - bposition4, bulletY+20, 20, 10);
			//g.fillRect(playerX - 165+55, playerY+20, 20, 10);
			//g.fillRect(playerX - 220+55, playerY+20, 20, 10);
			//g.fillRect(playerX - 275+55, playerY+20, 20, 10);
			//g.fillRect(playerX - 330+55, playerY+20, 20, 10);
			if(bulletX-bposition4<=0)
			{
				bstop4 = true;
				bposition4 = 0;
			}
			
			a = new Rectangle(bulletX - bposition4, bulletY + 20, 20, 10);
			
			guardA = new Rectangle(aX+10, aY-35, 100, 100);
			guardB = new Rectangle(bX, bY, 100, 100);
			
			if(a.intersects(guardA) && bossDead == true)
			{
				
					g.fillRect(aX+100, aY, 10, 10);
					g.fillRect(aX+100,  aY+50, 10, 10);
					g.fillRect(aX-20, aY, 10, 10);
					g.fillRect(aX-20, aY+50, 10, 10);
					g.fillRect(aX+20, aY-50, 10, 10);
					g.fillRect(aX+80, aY-50, 10, 10);
					g.fillRect(aX, aY+50, 10, 10);
					g.fillRect(aX+60, aY+50, 10, 10);
				
				ahealth -= 1;
			}
			
			if(a.intersects(guardB) && bossDead == true)	{
				
					g.fillRect(bX+100, bY, 10, 10);
					g.fillRect(bX+100,  bY+50, 10, 10);
					g.fillRect(bX-20, bY, 10, 10);
					g.fillRect(bX-20, bY+50, 10, 10);
					g.fillRect(bX+20, bY-50, 10, 10);
					g.fillRect(bX+80, bY-50, 10, 10);
					g.fillRect(bX, bY+50, 10, 10);
					g.fillRect(bX+60, bY+50, 10, 10);
				
				bhealth-=1;
			}
			
			if(a.intersects(guardC) && bossDead == true)
			{
				
					g.fillRect(cX+100, cY, 10, 10);
					g.fillRect(cX+100,cY+50, 10, 10);
					g.fillRect(cX-20, cY, 10, 10);
					g.fillRect(cX-20, cY+50, 10, 10);
					g.fillRect(cX+20, cY-50, 10, 10);
					g.fillRect(cX+80, cY-50, 10, 10);
					g.fillRect(cX, cY+50, 10, 10);
					g.fillRect(cX+60, cY+50, 10, 10);
				
				chealth-=1;
			}
			
			if(a.intersects(guardD) && bossDead == true)
			{
				
					g.fillRect(dX+100, dY, 10, 10);
					g.fillRect(dX+100,dY+50, 10, 10);
					g.fillRect(dX-20, dY, 10, 10);
					g.fillRect(dX-20, dY+50, 10, 10);
					g.fillRect(dX+20, dY-50, 10, 10);
					g.fillRect(dX+80, dY-50, 10, 10);
					g.fillRect(dX, dY+50, 10, 10);
					g.fillRect(dX+60, dY+50, 10, 10);
				
					dhealth-=1;
			}
			
			if(a.intersects(boss))
			{
				
					g.fillRect(bossx+230, bossy, 10, 10);
					g.fillRect(bossx+230,bossy+200, 10, 10);
					g.fillRect(bossx-20, bossy, 10, 10);
					g.fillRect(bossx-20, bossy+200, 10, 10);
					g.fillRect(bossx+80, bossy-50, 10, 10);
					g.fillRect(bossx+80, bossy-50, 10, 10);
					g.fillRect(bossx, bossy+300, 10, 10);
					g.fillRect(bossx+60, bossy+300, 10, 10);
				
					bosshealth-=1;
			}
		}
		
		 /*ImageIcon icon = new ImageIcon("cement2.jpg"); 
		  JLabel bgimage = new JLabel();
		  bgimage.setIcon(icon);
		  bgimage.setBounds(0, 0, 1440, 900);
		  add(bgimage);*/
	} 
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == b1)
		{
			b1switch = true;
		}
		if(e.getSource() == b2)
		{
			b2switch = true;
		}
		if(e.getSource() == b3)
		{
			b3switch = true;
		}
	}

	public void keyTyped(KeyEvent e) { // uses WASD input to move the player
		char c = e.getKeyChar();
		 if ( c == 'w' || c == 'W')
		 {
			 if(speedboostactivate == true) playerY-=10;
			 else playerY-=5;
			  if(playerY<=30 && speedboostactivate == true)
			  {
				  playerY+=10;
			  }
			  else if(playerY<=30 && speedboostactivate == false) playerY +=5;
		 }
		 else if(c == 's' || c == 'S')
		 {
			 if(speedboostactivate == true) playerY+=10;
			 else playerY+=5;
			 if(playerY>=802 && speedboostactivate == true)
			  {
				  playerY-=10;
			  }
			 else if(playerY>=802 && speedboostactivate == false)
			 {
				 playerY-=5;
			 }
		 }
		 else if(c == 'a' || c == 'A')
		 {
			 if(speedboostactivate == true) playerX-=10;
			 else playerX-=5;
			  if(playerX<=-15 && speedboostactivate == true)
			  {
				  playerX+=10;
			  }
			 else if(playerX<=-15 && speedboostactivate == false)
			  {
				  playerX+=5;
			  }
		 }
		 else if(c == 'd' || c == 'D')
		 {
			 if(speedboostactivate == true) playerX+=10;
			 else playerX+=5;
			 if(playerX>=1320 && speedboostactivate == true)
			  {
				  playerX-=10;
			  }
			 else if(playerX>=1320 && speedboostactivate == false)
			  {
				  playerX-=5;
			  }
		 }
		 
		 if(c == 'i' || c == 'I')
		 {
			 upshoot = true;
			 bside = false;
		 }
		 else if(c == 'k' || c == 'K')
		 {
			 downshoot = true;
			 bside2 = false;
		 }
		 else if(c == 'j' || c == 'J')
		 {
			leftshoot = true;
			bside4 = false;
		 }
		 else if(c == 'l' || c == 'L')
		 {
			 rightshoot = true;
			 bside3 = false;
		 }
		 
		  
	}

	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}

}


