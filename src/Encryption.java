import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JScrollBar;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.Icon;

public class Encryption extends JFrame {
	
	Tools tool = new Tools();
    Action ac = new Action();
    Mouse ms = new Mouse();
    EncryptionMethods en = new EncryptionMethods();
    Substitution_key_create sk;
    
    
	private JPanel main_panel,Working_Explain,Condition_panel,Process_panel;
	private JScrollPane ScrollPane;
	private Button Start_btn,Cancel_btn,Back_btn,extra_key;
	private Container contentPane;
	private JLabel Background_lbl,plainTxt_lbl,KeyTxt,Processing_animation;
	private JScrollPane scrollPane;
	private JTextArea OUTPUT_TXT;
	private JTextArea CONDITION_TXT;
	private JLabel Working_LBL;
	
	private JTextField PLAINTXT,KEYTXT;
	
	private int Encryption_type;
	private JScrollPane scrollPane_Conditions;

	/**
	 * Create the frame.
	 */
	public Encryption(String title, int type) {
		super(title);
		Encryption_type = type;
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(25, 10, 1300, 700);
		contentPane = this.getContentPane();
		contentPane.setLayout(null);
		
//Main Panel Component
		
		main_panel = new JPanel();
		main_panel.setBounds(0, 0, 578, 400);
		main_panel.setLayout(null);
		
		Background_lbl = new JLabel("");
		Background_lbl.setIcon(tool.ENCRYPTION_BACKGROUND);
		Background_lbl.setBounds(0, 0, 577, 400);
		
		
		plainTxt_lbl = new JLabel("Plain Text :");
		plainTxt_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		plainTxt_lbl.setForeground(Color.WHITE);
		plainTxt_lbl.setFont(new Font("Arial Black", Font.BOLD, 22));
		plainTxt_lbl.setBounds(196, 125, 137, 34);
		
		KeyTxt = new JLabel("Key :");
		KeyTxt.setHorizontalAlignment(SwingConstants.CENTER);
		KeyTxt.setForeground(Color.WHITE);
		KeyTxt.setFont(new Font("Arial Black", Font.BOLD, 22));
		KeyTxt.setBounds(243, 201, 117, 34);
		
		PLAINTXT = new JTextField();
		PLAINTXT.setBounds(355, 130, 208, 34);
		PLAINTXT.setColumns(10);
		PLAINTXT.addMouseListener(ms);
		
		
		KEYTXT = new JTextField();
		KEYTXT.setColumns(10);
		KEYTXT.setBounds(355, 206, 208, 34);
	    KEYTXT.addMouseListener(ms);
		
		
		
		Start_btn = new Button("Start", null, "START", 374, 312, 74, 48);
		Start_btn.setBackground(new Color(240, 240, 240));
		Start_btn.setForeground(Color.BLACK);
		Start_btn.setFont(new Font("Arial Black", Font.PLAIN, 18));
		Start_btn.addActionListener(ac);
		Start_btn.setBorder(new LineBorder(new Color(0, 255, 0), 3));
		
		Cancel_btn = new Button("Cancel", (Icon) null, "CANCEL", 374, 312, 74, 48);
		Cancel_btn.setBackground(new Color(240, 240, 240));
		Cancel_btn.setForeground(Color.BLACK);
		Cancel_btn.setFont(new Font("Arial Black", Font.PLAIN, 18));
		Cancel_btn.addActionListener(ac);
		Cancel_btn.setEnabled(false);
		Cancel_btn.setVisible(false);
		
		Back_btn = new Button("BACK", (Icon) null, "BACK", 40, 315, 80, 45);
		Back_btn.setBackground(new Color(240, 240, 240));
		Back_btn.setForeground(Color.BLACK);
		Back_btn.setFont(new Font("Arial Black", Font.PLAIN, 18));
		Back_btn.addActionListener(ac);
		Back_btn.setBorder(new LineBorder(new Color(255, 0, 0), 3));
		
		Processing_animation = new JLabel("");
		Processing_animation.setBounds(233, 14, 100, 100);
		
//// Extra key to be used on diffrent occasion
		extra_key = new Button("", null, "extra_key", 0,0,0,0);
		extra_key.setBackground(new Color(240, 240, 240));
		extra_key.setForeground(Color.BLACK);
		extra_key.setFont(new Font("Arial Black", Font.PLAIN, 18));
		extra_key.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		extra_key.setEnabled(false);
		extra_key.setVisible(false);
		
		
		main_panel.add(extra_key);
		main_panel.add(PLAINTXT);
		main_panel.add(KEYTXT);
		main_panel.add(KeyTxt);                //Add components to main Panel
		main_panel.add(plainTxt_lbl);
		main_panel.add(Start_btn);		
		main_panel.add(Cancel_btn);
		main_panel.add(Processing_animation);
		main_panel.add(Back_btn);
		main_panel.add(Background_lbl);
		contentPane.add(main_panel);
		
		
		

// Condition Panel
		Condition_panel = new JPanel();
		Condition_panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Conditions", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Condition_panel.setBackground(UIManager.getColor("Button.background"));
		Condition_panel.setBounds(577, 0, 323, 400);
		Condition_panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane_Conditions = new JScrollPane();
		scrollPane_Conditions.setViewportBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		
		CONDITION_TXT = new JTextArea();
		CONDITION_TXT.setText("");
		CONDITION_TXT.setFont(new Font("Calibri", Font.BOLD, 18));
		CONDITION_TXT.setEditable(false);
		
		scrollPane_Conditions.setViewportView(CONDITION_TXT);
		Condition_panel.add(scrollPane_Conditions);
		contentPane.add(Condition_panel);
		
//Working Panel
		Working_Explain = new JPanel();
		Working_Explain.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Working", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Working_Explain.setBounds(900, 0, 385, 700);
		Working_Explain.setLayout(new BorderLayout(0, 0));
		
		Working_LBL = new JLabel("");
		
		Working_Explain.add(Working_LBL);
		contentPane.add(Working_Explain);
		
		
		
		
// Process Panel		
   
		

		
		Process_panel = new JPanel();
		Process_panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Output", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		Process_panel.setBounds(0, 400, 900, 271);
		Process_panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		
		OUTPUT_TXT = new JTextArea();
		OUTPUT_TXT.setFont(new Font("Calibri", Font.BOLD, 18));
		OUTPUT_TXT.setText("");
		OUTPUT_TXT.setEditable(false);
		
		
		scrollPane.setViewportView(OUTPUT_TXT);		
		Process_panel.add(scrollPane);
		contentPane.add(Process_panel);
///////////////////////////////////////////////////////// ENCRYPTION /////////////////////////////////////////////////////////////////////		
		
// Conditions and working and Visibility
		switch(Encryption_type) {
		
		case(0): {
			       CONDITION_TXT.setText("  - Key should be Integer \r\n          =>  0 < b < 26\r\n   - Plain Text should be Albhabets only\r\n         =>   no Integer and spacial charachter\r\n  - For numbering A = 0 and a = 0");
			       Working_LBL.setIcon(tool.CEASERCIPHER_ENCRYPTION);
			       break;			
		         }
		case(1): {
			   CONDITION_TXT.setText("  - 'a' and 'b' should be Integer \r\n          =>  HCF(a,26) = 1\r\n          =>  0 < b < 26\r\n   - Plain Text should be Albhabets only\r\n         =>   no Integer and spacial charachter\r\n  - For numbering A = 0 and a = 0\n\r - write 'a,b' in KEY section \n\r   => If a = 11\n\r   b = 5 then \n\r write '11,5' in KEY section");
		       Working_LBL.setIcon(tool.AFFINECIPHER_ENCRYPTION);
		       break;
		}
		case(2):{
			  CONDITION_TXT.setText("Conditions:\r\n  - Every Characheter has to be manually replaced\r\n  - Every character has one to one relationship\r\n  \r\n  - Can't use Space (' ') as a charecter");
		      Working_LBL.setIcon(tool.SUBSTITUTION_ENCRYPTION);
		      KEYTXT.setVisible(false);
		      extra_key.setText("CREATE");
		      extra_key.setActionCommand("CREATE");
		      extra_key.setBounds(355, 203, 100, 34);
		      extra_key.setEnabled(true);
		      extra_key.setVisible(true);
		      extra_key.addActionListener(ac);
		      
		      break;
		}
		case(3):{
			CONDITION_TXT.setText(" - KEY length should be perfect Squareroot\r\n    => only 1,4,9,16....so on character shold be in \r\n       the KEY\r\n \r\n - Number of Input Character should be multiple of \r\n     KEY length squareroot\r\n\r\n - NO SPACIAL Character or Numbers allowed in KEY or INPUT\r\n\r\n ex : - \r\n      \r\n    INPUT = GFG   ( 3 Characters  3*1)\r\n     KEY  = HILLmagic  (9 Characters  sqroot(9) = 3 => perfect)\r\n\r\n\r\n   Output = SWK  (3 Characters = INPUT Characters) \r\n    ");
		       Working_LBL.setIcon(tool.HILLCIPHER_ENCRYPTION);
		       break;
		}
		case(4):{
			CONDITION_TXT.setText("- NO special character or numbers in\n\r  KEY or INPUT\r\n\r\n- INPUT must not end with Z\r\n\r\n- NO repitation of X in INPUT\r\n\r\n- small and Capital letters are treated\n\r   as same");
			 Working_LBL.setIcon(tool.PLAYFAIRCIPHER_ENCRYPTION);
			break;
		}
		case(5):{
			CONDITION_TXT.setText("\r\n- PlainText length >= Key text length (number of characters)\r\n\r\n- Use only alphabets in both PlainText and Key Text\r\n\r\n- A = 0, B = 1... Z = 25 for this cipher\r\n\r\n- Small and Capital letters are treated as same\r\n");
			Working_LBL.setIcon(tool.VIGNERECIPHER_ENCRYPTION);
			break;
		}
		case(6):{
			CONDITION_TXT.setText("\r\n- Length of KEY =  Length of the PLAIN TEXT\r\n- Only alphabets are allowed and no\r\n    special characters or numbers.");
		 Working_LBL.setIcon(tool.VERNAMCIPHER_ENCRYPTION);
			break;
		}
		case(7):{
			CONDITION_TXT.setText("\r\n- PlainText length >= Key text length (number of characters)\r\n\r\n- Use only alphabets in both PlainText and Key Text\r\n\r\n- A = 0, B = 1... Z = 25 for this cipher\r\n\r\n- Small and Capital letters are treated as same\r\n");
			Working_LBL.setIcon(tool.AUTOKEY_ENCRYPTION);
			break;
		}
		case(8):{
			CONDITION_TXT.setText("\r\n- PlainText length >= Key text length (number of characters)\r\n\r\n- Use only alphabets in Key Text\r\n\r\n- Character in KEY should not be repeated");
			Working_LBL.setIcon(tool.COLUMNER_TRANSPOSITION);
			break;
		}
		case(9):{
			CONDITION_TXT.setText("\r\n  - KEY > 1 and numbers only\r\n\r\n  - Plaintext can be of any character\r\n\r\n - KEY <= Plaintext length \r\n\r\n - Don't use | in Input");
			Working_LBL.setIcon(tool.RAIL_FANCE);
			break;
		}
		}
		
		
				
	}
	
	///////////////////////////////////////////////////Methods ////////////////////////////////////////////////////////
	

	void start() {
		Processing_animation.setIcon(tool.PROCESSING_GIF);
		PLAINTXT.setEditable(false);
		KEYTXT.setEditable(false);
		Start_btn.setVisible(false);
		Start_btn.setEnabled(false);
		
		Cancel_btn.setVisible(true);
		Cancel_btn.setEnabled(true);
		
		
		switch(Encryption_type) {
		case(0):  {String a = en.CeaserCipher(PLAINTXT.getText(), KEYTXT.getText());
		           OUTPUT_TXT.setText(a);
		           stop();                       // Stop process on completion
		           break;
			
		          }
		case(1):{String a = en.AffineCipher(PLAINTXT.getText(), KEYTXT.getText()); 
                 OUTPUT_TXT.setText(a);
                 stop();                       // Stop process on completion
                   break;
                   }
		case(2):{
			String a = en.SubstitutionCipher(PLAINTXT.getText(), sk.KEY) ;
            OUTPUT_TXT.setText(a);
            stop();                       // Stop process on completion
              break;
		}
		case(3):{
			String a = en.HillCipher(PLAINTXT.getText(), KEYTXT.getText());
            OUTPUT_TXT.setText(a);
            stop();                       // Stop process on completion
              break;
		}
		
		case(4):{
			String a = en.PlayFairCipher(PLAINTXT.getText(), KEYTXT.getText());
            OUTPUT_TXT.setText(a);
            stop();                       // Stop process on completion
              break;
		}
		case(5):{
			String a = en.VignereCipher(PLAINTXT.getText(), KEYTXT.getText());
            OUTPUT_TXT.setText(a);
            stop();                       // Stop process on completion
              break;
		}
		
		case(6):{
			String a = en.VernamCipher(PLAINTXT.getText(), KEYTXT.getText());
            OUTPUT_TXT.setText(a);
            stop();                       // Stop process on completion
              break;
		}
		
		case(7):{
			String a = en.AutoKey(PLAINTXT.getText(), KEYTXT.getText());
            OUTPUT_TXT.setText(a);
            stop();                       // Stop process on completion
              break;
		}
		
		case(8):{
			String a = en.ColumnTransposition(PLAINTXT.getText(), KEYTXT.getText());
            OUTPUT_TXT.setText(a);
            stop();                       // Stop process on completion
              break;
		}
		case(9):{
			String a = en.RailFance(PLAINTXT.getText(), KEYTXT.getText());
            OUTPUT_TXT.setText(a);
            stop();                       // Stop process on completion
              break;
		}
		}
		
	}
	
	void stop() {
		Processing_animation.setIcon(null);
		PLAINTXT.setEditable(true);
		KEYTXT.setEditable(true);
		Start_btn.setVisible(true);
		Start_btn.setEnabled(true);
		Cancel_btn.setVisible(false);
		Cancel_btn.setEnabled(false);
	}
	
	void back() {
		new MainFrame();
		this.dispose();
	}
	////////////////////////////////////////////////// classes //////////////////////////////////////////////////////
	
	class Action implements ActionListener{		
	@Override
	public void actionPerformed(ActionEvent e) {
		String a = e.getActionCommand();
		switch(a) {
		case("START"): start(); break;
		case("CANCEL"): stop(); break;
		case("BACK"): back(); break;
		case("CREATE"): sk = new Substitution_key_create(); break;
		}
	}
	}
	
	class Mouse implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
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
			
			PLAINTXT.setToolTipText(PLAINTXT.getText().length()+"");
	        KEYTXT.setToolTipText(KEYTXT.getText().length()+"");
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
