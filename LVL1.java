
//Amogh Upadhyaya
// 5/4/20
//Key Wars
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; // This code is the first level of the game, this class is where everything in level one is



public class LVL1 extends JPanel implements KeyListener { // Panel where everything is drawn and all code is written
	static JPanel cards = StartPanel.cards;
	private int playerX, playerY; // coordinates of the player
	private int aX, aY, bX, bY; //coordinates of the guards
	private Timer playertimer, counter, bullettimer, bullettimer2, bullettimer3, bullettimer4, ttimer; // timers for movement
	int speed; // speed of player movement
	int speed1; // speed of guard movement
	int bposition; //bullet placement
	int bposition2;
	int bposition3;
	int bposition4;
	boolean amovement = true, bmovement = true, upshoot = false, downshoot = false, leftshoot = false, rightshoot = false, guardADead= false, guardBDead = false, playerAlive = true, blocks = true; // determines which way the guards move
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
	boolean reset = false, confirm = false, reset2 = false, confirm2 = false, reset3= false, confirm3 = false; //used to see how many lives are left and reset to starting position
	JButton b1 = new JButton("Return to Main Menu"); // button to quit
	JButton b2 = new JButton("Next Level"); // button to continue
	JButton b3 = new JButton("Return to Main Menu"); //button to quit
	int tcount = 0;
	Timer etimer;
	int ecount = 0;
	boolean explosion = false, check = false; //used to make explosion 
	boolean randomcheck = false, TNTBlownUp = false; // checks if TNT is intact
	int TNTx, TNTy; // TNT randomized coordinates
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
	
	public LVL1() { // initializing variables
		playerX = 645;
		playerY = 780;
		aX = 10;
		aY = 400;
		bX = 1324;
		bY = 150;
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
			
			if(bX == -10) // determines which way the first guard moves
			{
				bmovement = false;
			}
			else if(bX == 1320)
			{
				bmovement = true;
			}
			if (bmovement == true) bX-=1;
			else bX+=1;
				
			
			if (aX == 1320) //determines which way the second guard moves
			{
				amovement = false;
			}
			else if(aX == -10)
			{
				amovement = true;
			}
			if(amovement == true) aX+= speed1;
			else aX-= speed1;
			repaint();
			grabFocus();
		}
	} 

	public void paintComponent(Graphics g) { //draws and paints the players, guards, key, and the background 
		super.paintComponent(g);
		setBackground(Color.BLUE);
		Rectangle player = new Rectangle(playerX+10, playerY-35, 100, 100);
		Rectangle key = new Rectangle(700, 20, 50, 50);
		Rectangle a, guardA = new Rectangle(aX+10, aY-35, 100, 100), guardB = new Rectangle(bX, bY, 100, 100);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
		g.drawString("Equipped: ", 20, 850);
		
		if(false){
			playerX = 645;
			playerY = 780; 
			aX = 10;
			aY = 400;
			bX = 1324;
			bY = 150;
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
			while(TNTy>780 || TNTy<100)
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
		
		if(randomcheck2 == false)
		{
			speedx = (int)(Math.random()*1391) + 0;
			speedy = (int)(Math.random()*851) + 0;
			while(speedy>780 || speedy<100 || (speedy>TNTy-50 && speedy<TNTy+50))
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
			while(mapy>780 || mapy<100 || (mapy>TNTy-50 && mapy<TNTy+50) || (mapy>speedy - 50 && mapx<speedy+50) || (mapy>bullety - 50 && mapx<bullety+50))
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
		
		if(guardADead == false)
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
		
		if(guardBDead == false)
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
		
		if(reset == true)
		{
			playerX = 645;
			playerY = 780;
			livescount--;
			reset = false;
			confirm = true;
		}
		
		if(reset2 == true)
		{
			playerX = 645;
			playerY = 780;
			livescount--;
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
		
		if (guardADead == false && blocks == true) g.fillRect(aX+10, aY-35, 100, 100); 
		if (guardADead == false && blocks == true && amovement == true) g.drawImage(guardAImage, aX+10, aY-35, this);
		if (guardADead == false && blocks == true && amovement == false) g.drawImage(guardBImage, aX+10, aY-35, this);
		if (guardBDead == false && blocks == true) g.fillRect(bX, bY, 100, 100);
		if (guardBDead == false && blocks == true && bmovement == true) g.drawImage(guardBImage, bX, bY, this);
		if (guardBDead == false && blocks == true && bmovement == false) g.drawImage(guardAImage, bX, bY, this);
		
		g.setColor(Color.YELLOW);
		
		Image keyimage = new ImageIcon("key.png").getImage();
		if((blocks == true && guardADead == true && guardBDead == true) || (blocks == true && mapactivate == true)) g.fillRect(700, 20, 52, 50);
		if((blocks == true && guardADead == true && guardBDead == true) || (blocks == true && mapactivate == true)) g.drawImage(keyimage, 700, 20, this);
		
		if(player.intersects(key) && guardADead == true && guardBDead == true && dead == false || player.intersects(key) && mapactivate == true && dead == false) // checking to see whether the player has interacted with the key or not
		{
			playerAlive = false;
			blocks = false;
			setBackground(Color.GREEN);
			g.setColor(Color.BLACK);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 150)); 
			g.drawString("Passed Level 1 !", 240, 350);
			b1.setBounds(210, 600, 300, 100);
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
					 LVL2 levelTwo = new LVL2();
						cards.add(levelTwo, "lvl2");
						c.show(cards, "lvl2");
					resetgame = true;
				}
			});
			add(b1);
		    add(b2);
		    ttimer.stop();
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
			

			if(a.intersects(guardA))
			{
				g.fillRect(aX+100, aY, 10, 10);
				g.fillRect(aX+100,  aY+50, 10, 10);
				g.fillRect(aX-20, aY, 10, 10);
				g.fillRect(aX-20, aY+50, 10, 10);
				g.fillRect(aX+20, aY-50, 10, 10);
				g.fillRect(aX+80, aY-50, 10, 10);
				g.fillRect(aX, aY+50, 10, 10);
				g.fillRect(aX+60, aY+50, 10, 10);
				guardADead = true;
				check = true;
			}

			
			if(a.intersects(guardB))
			{
				
					g.fillRect(bX+100, bY, 10, 10);
					g.fillRect(bX+100,bY+50, 10, 10);
					g.fillRect(bX-20, bY, 10, 10);
					g.fillRect(bX-20, bY+50, 10, 10);
					g.fillRect(bX+20, bY-50, 10, 10);
					g.fillRect(bX+80, bY-50, 10, 10);
					g.fillRect(bX, bY+50, 10, 10);
					g.fillRect(bX+60, bY+50, 10, 10);
				
				guardBDead = true;
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
			
			if(a.intersects(guardA))
			{
				
					g.fillRect(aX+100, aY, 10, 10);
					g.fillRect(aX+100,  aY+50, 10, 10);
					g.fillRect(aX-20, aY, 10, 10);
					g.fillRect(aX-20, aY+50, 10, 10);
					g.fillRect(aX+20, aY-50, 10, 10);
					g.fillRect(aX+80, aY-50, 10, 10);
					g.fillRect(aX, aY+50, 10, 10);
					g.fillRect(aX+60, aY+50, 10, 10);
				
				guardADead = true;
			}
			
			if(a.intersects(guardB))
			{
				
					g.fillRect(bX+100, bY, 10, 10);
					g.fillRect(bX+100,  bY+50, 10, 10);
					g.fillRect(bX-20, bY, 10, 10);
					g.fillRect(bX-20, bY+50, 10, 10);
					g.fillRect(bX+20, bY-50, 10, 10);
					g.fillRect(bX+80, bY-50, 10, 10);
					g.fillRect(bX, bY+50, 10, 10);
					g.fillRect(bX+60, bY+50, 10, 10);
				
				guardBDead = true;
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
			
			if(a.intersects(guardA))
			{
				
				g.fillRect(aX+100, aY, 10, 10);
				g.fillRect(aX+100,  aY+50, 10, 10);
				g.fillRect(aX-20, aY, 10, 10);
				g.fillRect(aX-20, aY+50, 10, 10);
				g.fillRect(aX+20, aY-50, 10, 10);
				g.fillRect(aX+80, aY-50, 10, 10);
				g.fillRect(aX, aY+50, 10, 10);
				g.fillRect(aX+60, aY+50, 10, 10);
				guardADead = true;
			}
			
			
			if(a.intersects(guardB))
			{
				
					g.fillRect(bX+100, bY, 10, 10);
					g.fillRect(bX+100,  bY+50, 10, 10);
					g.fillRect(bX-20, bY, 10, 10);
					g.fillRect(bX-20, bY+50, 10, 10);
					g.fillRect(bX+20, bY-50, 10, 10);
					g.fillRect(bX+80, bY-50, 10, 10);
					g.fillRect(bX, bY+50, 10, 10);
					g.fillRect(bX+60, bY+50, 10, 10);
				
				guardBDead = true;
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
			
			if(a.intersects(guardA))
			{
				
					g.fillRect(aX+100, aY, 10, 10);
					g.fillRect(aX+100,  aY+50, 10, 10);
					g.fillRect(aX-20, aY, 10, 10);
					g.fillRect(aX-20, aY+50, 10, 10);
					g.fillRect(aX+20, aY-50, 10, 10);
					g.fillRect(aX+80, aY-50, 10, 10);
					g.fillRect(aX, aY+50, 10, 10);
					g.fillRect(aX+60, aY+50, 10, 10);
				
				guardADead = true;
			}
			
			if(a.intersects(guardB))	{
				
					g.fillRect(bX+100, bY, 10, 10);
					g.fillRect(bX+100,  bY+50, 10, 10);
					g.fillRect(bX-20, bY, 10, 10);
					g.fillRect(bX-20, bY+50, 10, 10);
					g.fillRect(bX+20, bY-50, 10, 10);
					g.fillRect(bX+80, bY-50, 10, 10);
					g.fillRect(bX, bY+50, 10, 10);
					g.fillRect(bX+60, bY+50, 10, 10);
				
				guardBDead = true;
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


