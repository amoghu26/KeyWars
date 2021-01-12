
//Amogh Upadhyaya
// 5/4/20
//Key Wars
import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;


public class InstructionPanel extends JPanel // Panel with all the code and where everything is drawn
{  
	JPanel cards = StartPanel.cards;
	  JButton b1 = new JButton("Return to Main Menu"); // button to return to menu
	  JButton b2 = new JButton("Play"); // button to play game
	  JLabel title1 = new JLabel(); // first rule
	  JLabel title2 = new JLabel();// second rule
	  JLabel title3 = new JLabel();// third rule
	  JLabel title4 = new JLabel();// fourth rule
	  JLabel title5 = new JLabel();// fifth rule
	  JLabel title6 = new JLabel();// sixth rule
	  JLabel title7 = new JLabel();// seventh rule
	  JLabel title8 = new JLabel();// eighth rule
	  JLabel title9 = new JLabel(); //explains role of the map
	  JLabel title10 = new JLabel(); //explains role of the speed boost
	  JLabel title11 = new JLabel(); //explains role of the bullet speed boost
	  JLabel title12 = new JLabel(); //explains role of the TNT
	  CardLayout c; // CardLayout
	  JPanel inpanel; // Panel
	  
  public InstructionPanel()
  {  
	  setLayout(null);
	  setSize(1440, 900);    
	  
	  //setting dimensions and adding both buttons
	  b1.setBounds(210, 600, 300, 100);
	  b2.setBounds(910, 600, 300, 100);
	  
	  b1.addActionListener(new ActionListener() 
	  {
		public void actionPerformed(ActionEvent e) 
		{
			CardLayout c= (CardLayout)(cards.getLayout());
			c.show(cards, "start");
			
			
		}
	  });
	  
	  b2.addActionListener(new ActionListener() {
		  
		  public void actionPerformed(ActionEvent e)
		  {
			  c = (CardLayout)(cards.getLayout());
			  LVL1 levelOne = new LVL1();
			cards.add(levelOne, "lvl1");
			c.show(cards, "lvl1");
			  c.show(cards, "lvl1");
		  }
	  });
	
	  
	  b1.setFont(new Font("Comic Sans", Font.PLAIN, 25));
	  b2.setFont(new Font("Comic Sans", Font.PLAIN, 25));
	    
	  add(b1);
	  add(b2);
	  
	  //setting the text. dimensions, and adding the instructions
	  title1.setFont(new Font("Comic Sans", Font.PLAIN, 25));
	  title1.setText("Instructions:");
	  title1.setBounds(100, 100, 500, 100);
	  title1.setForeground(Color.WHITE);
	  title1.setBackground(Color.WHITE);
	  add(title1);
	  
	  title2.setFont(new Font("Comic Sans", Font.PLAIN, 25));
	  title2.setText("1. Click “Play” on main menu");
	  title2.setBounds(100, 150, 500, 100);
	  title2.setForeground(Color.WHITE);
	  title2.setBackground(Color.WHITE);
	  add(title2);
	  
	  title3.setFont(new Font("Comic Sans", Font.PLAIN, 25));
	  title3.setText("2. Kill all the guards with your gun (move with WASD and shoot with IJKL)");
	  title3.setBounds(100, 200, 900, 100);
	  title3.setForeground(Color.WHITE);
	  title3.setBackground(Color.WHITE);
	  add(title3);
	  
	  title4.setFont(new Font("Comic Sans", Font.PLAIN, 25));
	  title4.setText("3. Use powerups along the way and avoid TNT!");
	  title4.setBounds(100, 250, 600, 100);
	  title4.setForeground(Color.WHITE);
	  title4.setBackground(Color.WHITE);
	  add(title4);
	  
	  title5.setFont(new Font("Comic Sans", Font.PLAIN, 25));
	  title5.setText("4. Find the key and collect it by standing over it");
	  title5.setBounds(100, 300, 600, 100);
	  title5.setForeground(Color.WHITE);
	  title5.setBackground(Color.WHITE);
	  add(title5);
	  
	  title6.setFont(new Font("Comic Sans", Font.PLAIN, 25));
	  title6.setText("5. Repeat until boss fight");
	  title6.setBounds(100, 350, 600, 100);
	  title6.setForeground(Color.WHITE);
	  title6.setBackground(Color.WHITE);
	  add(title6);
	  
	  title7.setFont(new Font("Comic Sans", Font.PLAIN, 25));
	  title7.setText("6. Kill the boss to beat the game");
	  title7.setBounds(100, 400, 600, 100);
	  title7.setForeground(Color.WHITE);
	  title7.setBackground(Color.WHITE);
	  add(title7);
	  
	  title8.setFont(new Font("Comic Sans", Font.PLAIN, 25));
	  title8.setText("7. You are being timed, finish as fast as possible!");
	  title8.setBounds(100, 450, 600, 100);
	  title8.setForeground(Color.WHITE);
	  title8.setBackground(Color.WHITE);
	  add(title8);
	  
	  // Adding the background image
	  
	  ImageIcon icon2 = new ImageIcon("map.jpg"); 
			JLabel bgimage2 = new JLabel();
			bgimage2.setIcon(icon2);

			bgimage2.setBounds(975, 200, 100, 100);
			add(bgimage2);
			
			 title9.setFont(new Font("Comic Sans", Font.PLAIN, 20));
			  title9.setText("- collect to see key without killing guards");
			  title9.setBounds(1040, 200, 900, 100);
			  title9.setForeground(Color.WHITE);
			  title9.setBackground(Color.WHITE);
			  add(title9);
			
	
			
		ImageIcon icon3 = new ImageIcon("2xbulletspeed.jpg"); 
		JLabel bgimage3 = new JLabel();
		bgimage3.setIcon(icon3);

		bgimage3.setBounds(975, 275, 100, 100);
		add(bgimage3);
		
		title10.setFont(new Font("Comic Sans", Font.PLAIN, 20));
		  title10.setText("- doubles bullet speed");
		  title10.setBounds(1040, 275, 900, 100);
		  title10.setForeground(Color.WHITE);
		  title10.setBackground(Color.WHITE);
		  add(title10);
		
		ImageIcon icon4 = new ImageIcon("2xspeed.png"); 
		JLabel bgimage4 = new JLabel();
		bgimage4.setIcon(icon4);

		bgimage4.setBounds(975, 350, 100, 100);
		add(bgimage4);
		
		title11.setFont(new Font("Comic Sans", Font.PLAIN, 20));
		  title11.setText("- doubles player speed");
		  title11.setBounds(1040, 350, 900, 100);
		  title11.setForeground(Color.WHITE);
		  title11.setBackground(Color.WHITE);
		  add(title11);
		
		ImageIcon icon5 = new ImageIcon("TNT.png"); 
		JLabel bgimage5 = new JLabel();
		bgimage5.setIcon(icon5);

		bgimage5.setBounds(975, 425, 100, 100);
		add(bgimage5);
		
		title12.setFont(new Font("Comic Sans", Font.PLAIN, 20));
		  title12.setText("- you lose all your lives if you touch TNT!");
		  title12.setBounds(1040, 425, 900, 100);
		  title12.setForeground(Color.WHITE);
		  title12.setBackground(Color.WHITE);
		  add(title12);
			
	 ImageIcon icon = new ImageIcon("background.png"); 
	  JLabel bgimage = new JLabel();
	  bgimage.setIcon(icon);
	  
	  bgimage.setBounds(0, 0, 1440, 900);
	  add(bgimage);
	  
  }
 
}
