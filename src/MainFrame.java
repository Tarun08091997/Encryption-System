import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import java.awt.ComponentOrientation;
import java.awt.Cursor;

public class MainFrame extends JFrame {

	Button Encryption,Decryption,Cryptonalysis,Exit;
	JLabel BackGround_Image;
	JComboBox Options;
	String[] items = {"Ceaser Cipher",
			           "Afine Cipher",
			           "Substitution Cipher",
			           "Hill Cipher",
			           "Playfair Cipher",
			           "Vignere Cipher",
			           "Vernem Cipher",
			           "Autokey Cipher",
			           "ColumnTransposition Cipher",
			           "Rail-Fence Cipher"};
			           
	
	String[] item_tip = {"Uses Substitution , Monoaplhabetic , Stream Cipher and is also called a shift cipher or additive cipher",
	                     "Monoalbhabetic Substitution Cipher",
	                     "Substitution Cipher",
	                     "Polyalphabetic substitution cipher",
	                     "Polyalphabetic substitution cipher",
	                     "Polyalphabetic substitution cipher",
	                     "Polyalphabetic substitution cipher",
	                     "Polyalphabetic substitution cipher",
	                     "Transposition Cipher",
	                     "Transposition Cipher"};
	Container contentPane;
	
	
//Create Action Listener
	Action ac = new Action();
	
//Importing All tools for main Window
	
	Tools tools = new Tools();
	
	/**
	 * Create the frame.
	 */
	public MainFrame() {
	    this.setResizable(false);
		this.setTitle("Cryptography");
		this.setIconImage(tools.LOGO.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 50, 800, 600);    //800,500
		contentPane = this.getContentPane();
		contentPane.setLayout(null);
		
		
// Button Declaration and Implementation
		
		Encryption = new Button("",tools.ENCRYPTION_BTN_ICON,"Encrypt",485, 79, 134, 44);
		Decryption = new Button("",tools.DECRYPTION_BTN_ICON,"Decrypt",485, 199, 134, 44);
		Cryptonalysis = new Button("",tools.CRYPTANALYSIS_BTN_ICON,"Analysis",485, 325, 134, 44);
		Cryptonalysis.setEnabled(false);
		Exit = new Button("",tools.EXIT_BTN_ICON,"EXIT",485, 448, 134, 40);
		Encryption.addActionListener(ac);
		Decryption.addActionListener(ac);
		Exit.addActionListener(ac);
		
// Create a new background image
		BackGround_Image = new JLabel("");
		BackGround_Image.setHorizontalTextPosition(SwingConstants.CENTER);
		BackGround_Image.setHorizontalAlignment(SwingConstants.CENTER);
		BackGround_Image.setIcon(tools.BACKGROUND);
		BackGround_Image.setBounds(0, 0, 794, 571);
		

		
		Options = new JComboBox(items);
		
		Options.setToolTipText("Choose Encryption or Decryption type ");
		Options.setForeground(Color.BLACK);
		Options.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Options.setBackground(Color.LIGHT_GRAY);
		Options.setMaximumRowCount(20);
		Options.setFont(new Font("Arial Black", Font.BOLD, 16));
		Options.setBounds(38, 83, 348, 40);
		Options.setRenderer(new MyComboBoxRenderer());
		
		
		
// Set all the tools
		
		
		contentPane.add(Encryption);
		contentPane.add(Exit);
		contentPane.add(Cryptonalysis);
		contentPane.add(Decryption);
		contentPane.add(Options);
		contentPane.add(BackGround_Image);
		
		this.setVisible(true);
		
	}	
///////////////////////////////////////////////Methods//////////////////////////////////////////////////////////
		
//Create Encryption with Method
	void encryption() {
		int b = Options.getSelectedIndex();
		String a = items[b];
		a = a + "  : Encryption";
		Encryption e = new Encryption(a,b);
		e.setVisible(true);
		this.dispose();
	}
	
// create Decryption Method
	void decryption() {
		int b = Options.getSelectedIndex();
		String a = items[b];
		a = a + "  : Decryption";
		Decryption d = new Decryption(a,b);
		d.setVisible(true);
		this.dispose();
	}	
	
///////////////////////////////////// Sub Classes /////////////////////////////////////////////////////////////	
//Item Renderer for ComboBox
	class MyComboBoxRenderer extends BasicComboBoxRenderer {
		  
	    public Component getListCellRendererComponent(JList list, Object value,
	        int index, boolean isSelected, boolean cellHasFocus) {
	    	
	      if (isSelected) {
	        setBackground(list.getSelectionBackground());
	        setForeground(list.getSelectionForeground());
	        if (-1 < index) {
	          list.setToolTipText(item_tip[index]);
	        }
	      } else {
	        setBackground(list.getBackground());
	        setForeground(list.getForeground());
	      }
	      setFont(list.getFont());
	      setText((value == null) ? "" : value.toString());
	      return this;
	    }
	  }
	

	

// Create class for ActionListener
	class Action implements ActionListener{
		Action(){}
		public void actionPerformed(ActionEvent e) {
			
			String a = e.getActionCommand();
			
			switch(a) {
			
			case("EXIT"):  new OptionPane(); break;
			case("Encrypt"): encryption(); break;
			case("Decrypt"): decryption();break;
			}
			
		}
		
	}
}