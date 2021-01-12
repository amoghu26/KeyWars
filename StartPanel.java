
//Amogh Upadhyaya
// 5/4/20
//Key Wars
import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;

public class StartPanel extends JFrame  {      //This class shows the starting screen
	static JPanel cards;//This is the overview panel that has the cardlayout and flips through the "pages"
	JPanel levelOne;
	JPanel levelTwo;
	JPanel levelThree;
	JPanel levelFour;
	public StartPanel() //sets details of the frame such as size
	{  
		super ("Key Wars");
		setSize(1440, 900);    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		setLocation(200,100);
		setResizable(true);
		cards = new JPanel(); 
		cards.setLayout(new CardLayout());
		JPanel startPanel = new Panel();
		cards.add(startPanel,"start");
		JPanel instructions = new InstructionPanel();
		cards.add(instructions,"instr");
		levelOne = new LVL1();
		cards.add(levelOne, "lvl1");
		JPanel lVL2JPanel = new LVL2();
		cards.add(lVL2JPanel, "lvl2");
		levelThree = new LVL3();
		cards.add(levelThree, "lvl3");
		levelFour = new LVL4();
		cards.add(levelFour, "lvl4");



		add(cards);  
		setVisible(true); 
	} 

	public static void main (String [] args)   // main function
	{  
		StartPanel sp= new StartPanel(); 
	}


	class Panel extends JPanel {   // Panel where everything is drawn and all code is written
		JButton b1 = new JButton("Instructions"); //instructions button
		JButton b2 = new JButton("Play"); // play button
		JButton b3 = new JButton("Quit"); // leaderboards button
		JLabel title1 = new JLabel(); // text 
		JLabel title2 = new JLabel(); // text
		JPanel inpanel; // JPanel
		InstructionPanel sm = new InstructionPanel(); // Object of InstructionPanel

		public Panel() {
			setLayout(null);
			setSize(1440, 900);    

			// setting dimensions and drawing buttons
			b1.setBounds(210, 600, 200, 100);
			b2.setBounds(610, 600, 200, 100);
			b3.setBounds(1010, 600, 200, 100);

			b1.setFont(new Font("Comic Sans", Font.PLAIN, 25));
			b2.setFont(new Font("Comic Sans", Font.PLAIN, 25));
			b3.setFont(new Font("comic Sans", Font.PLAIN, 25));

			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					CardLayout c = (CardLayout) cards.getLayout();
					c.show(cards, "instr");

				}
			});
			
			b2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout c = (CardLayout) cards.getLayout();
					levelOne = new LVL1();
					cards.add(levelOne, "lvl1");
					c.show(cards, "lvl1");

				}
			});
			
			b3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				System.exit(1);

				}
			});

			add(b1);
			add(b2);
			add(b3);

			//setting dimensions and drawing text
			title1.setFont(new Font("Comic Sans", Font.PLAIN, 40));
			title2.setFont(new Font("Comic Sans", Font.PLAIN, 100));
			title1.setText("Welcome To");
			title2.setText("Key Wars");

			title1.setBounds(600, 100, 300, 50);
			title2.setBounds(505, 115, 500, 200);

			title1.setForeground(Color.white);
			title2.setForeground(Color.white);

			add(title1);
			add(title2);

			// setting dimensions and adding background image
			ImageIcon icon = new ImageIcon("background.png"); 
			JLabel bgimage = new JLabel();
			bgimage.setIcon(icon);

			bgimage.setBounds(0, 0, 1440, 900);
			add(bgimage);

		}


	}

}


