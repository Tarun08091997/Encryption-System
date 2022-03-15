import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.tools.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class Substitution_key_create extends JFrame {
    Tools tool = new Tools();
	private JPanel contentPane;
	boolean check = false;
	JButton CheckBox;
	CreatePanel panels[] = new CreatePanel[5];
	
		
	String KEY = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; //0-25 capital,26-51 small,52-61 numbers
	String Default_KEY = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	
	Mouse mice = new Mouse();
	Action ac = new Action();


	/**
	 * Create the frame.
	 */
	public Substitution_key_create() {
		setFont(new Font("Arial Black", Font.PLAIN, 14));
		setTitle("Key Genrator for Substitution Encryption");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(25, 10, 1300, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Restore = new JButton("Restore to Default");
		Restore.setToolTipText("Change Key to Default KEY");
		Restore.setBorder(new LineBorder(Color.BLUE, 2));
		Restore.setFont(new Font("Arial Black", Font.PLAIN, 14));
		Restore.setBounds(89, 609, 143, 41);
		Restore.setActionCommand("R");
		Restore.addActionListener(ac);
		contentPane.add(Restore);
		
		JButton ok = new JButton("OK");
		ok.setToolTipText("Check if Key meet the conditions");
		ok.setFont(new Font("Arial Black", Font.BOLD, 20));
		ok.setBorder(new LineBorder(Color.GREEN, 2));
		ok.setBounds(1077, 609, 76, 41);
		ok.setActionCommand("OK");
		ok.addActionListener(ac);
		contentPane.add(ok);
		
		JLabel AskLabel = new JLabel("Use same charechter for Capital and small letters");
		AskLabel.setFont(new Font("Arial", Font.BOLD, 22));
		AskLabel.setBounds(40, 548, 511, 31);
		contentPane.add(AskLabel);
		
		CheckBox = new JButton("");
		CheckBox.setBounds(561, 549, 30, 30);
		CheckBox.setActionCommand("CheckBox");
		CheckBox.addActionListener(ac);
		contentPane.add(CheckBox);
		
		
// Create 4 panels with for loop
		String ch = "ANan0";
		
		for (int j =0;j<=4;j++) {
			
			CreatePanel panel = new CreatePanel(ch,j);
			panels[j] = panel;
			contentPane.add(panel);
		}
		
		this.setVisible(true);
	}
		void correctKey() {
		    
			this.dispose();
		}
		
		void checkbox_fun() {
			
			if(!check) {
				CheckBox.setIcon(tool.OK_ICON);
				check = true;
				System.out.println(KEY);
				KEY = KEY.substring(0,26)+KEY.substring(0,26)+KEY.substring(52);
				for(int j=2;j<=3;j++) {
					panels[j].smallCapitalsame(j-2,check);
				}
			}
			else {
				check = false;
				CheckBox.setIcon(null);
				KEY = KEY.substring(0,26)+Default_KEY.substring(26,52)+KEY.substring(52);
				for(int j=2;j<=3;j++) {
					panels[j].smallCapitalsame(j,check);
				}
		}}
	
	
	class CreatePanel extends JPanel{
		int max_block = 13;
		int a = 6;
		int b = 98;
		JLabel lbls[] = new JLabel[max_block];
		JTextField txts[] = new JTextField[max_block];
		
		CreatePanel(String ch,int j){
			
			this.setBounds(0, 108*j, 1284, 108);
			this.setLayout(null);
			
			if(j != 4) {
					max_block = 12;
					a = 6;
					b = 98;
				}
			else {
					max_block =9;
					a = 21;
					b = 128;
				}
			
				
		// Creating Labels and Texts
			for(int i=0;i<=max_block;i++) {
					
					String Text = (char)((int) ch.charAt(j) + i)     +" -> ";
					int x = a + b*i;
					JLabel lbl = new JLabel(Text);
					lbls[i] = lbl;
					lbl.setBounds(x, 40, 57, 29);
					lbl.setHorizontalTextPosition(SwingConstants.CENTER);
					lbl.setHorizontalAlignment(SwingConstants.CENTER);
					lbl.setFont(new Font("Arial Black", Font.BOLD, 20));
					
					
					JTextField txt = new JTextField();
					txts[i] = txt;
					txt.setToolTipText("Write Only one Character");
					txt.setHorizontalAlignment(SwingConstants.CENTER);
					txt.setFont(new Font("Arial", Font.BOLD, 18));
					txt.setBounds(x+54, 40, 32, 29);
					txt.setColumns(1);
					txt.setText(KEY.charAt(i+(13*j))+"");
					txt.setName((i+(13*j))+"");
					txt.addMouseListener(mice);
					
					this.add(lbl);
					this.add(txt);
				}}
	
		void reset_txt(int j){
			if(j != 4) {
				max_block = 12;
			}
		   else {
				max_block =9;
			}
			for(int i=0;i<=max_block;i++) {
				txts[i].setText(Default_KEY.charAt(i+(13*j))+"");
				txts[i].setEnabled(true);
			}}
		
		
		void smallCapitalsame(int d,boolean same) {
			if(same) {
				for(int i=0;i<=12;i++) {
					txts[i].setText(KEY.charAt(i+(13*d))+"");
					txts[i].setEditable(false);
				}}
			else {
				for(int i=0;i<=12;i++) {
					txts[i].setText(Default_KEY.charAt(i+(13*d))+"");
					txts[i].setEditable(true);
				}}}
	
	}  
	
	
	class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String a = e.getActionCommand();
			switch(a){
			case("R"):  {
				for(int j=0;j<=4;j++) {
					panels[j].reset_txt(j);
				}
				KEY = Default_KEY;
				check = true;
				checkbox_fun();
				break;
			    }
			
			case("CheckBox"):{
				       checkbox_fun();
				       break;
			          }
			
			case("OK"):{
				if(checkKey()) {
					JOptionPane.showMessageDialog(null, "Please fill the empty space in key", "Conditions not met", JOptionPane.ERROR_MESSAGE);
				}
				else {
					correctKey();
				}
				break;
			}
			}
			
		}
		
	}
	  class Mouse implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			
			JTextField txt = (JTextField)e.getSource();
			txt.setText("");
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
			JTextField txt = (JTextField)e.getSource();
			int pos = Integer.parseInt(txt.getName());
			String Text = txt.getText() ;
			if(Text.length() == 1) {
				KEY = KEY.substring(0, pos) + Text + KEY.substring(pos+1);
			}
			else {
				txt.setText(KEY.charAt(pos)+"");
			}
			
			
			
		}
		  
	  }
	  
	  
	  // Check if all charechter in KEY are single and no space
	  boolean checkKey() {
		  boolean recheck = false;
		  
		  for(int c=0;c< KEY.length();c++) {
			  boolean common = false;
              if(check) {
            	  if(c >= 26 && c <= 51) {
            		  continue;
            	  }
              }
			  //get the character
			  char ch = KEY.charAt(c);
			  if((int)ch == 32) { // if space
				  recheck = true;
				  continue;
			  }			  
			  //check for repetition with loop with next all character
			  for(int x = c+1;x<KEY.length();x++) {
				  if(check) {
	            	  if(x >= 26 && x <= 51) {
	            		  continue;
	            	  }}
				  if(ch == KEY.charAt(x)) {
					  int p = x/13;
					  int t = x % 13;
					  panels[p].txts[t].setText(" ");
					  KEY = KEY.substring(0, x) + " " + KEY.substring(x+1);
					  recheck = true;
					  common = true;
					  
				  }}
			  if(common) {
				  int p = c/13;
				  int t = c % 13;
				  panels[p].txts[t].setText(" ");
				  KEY = KEY.substring(0, c) + " " + KEY.substring(c+1);
				  
				} }
		  
		  return recheck;
	  }
	}
	
	
