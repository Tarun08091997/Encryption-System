import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Tools {
	
	// Import all images for Main Frame
		ImageIcon LOGO = new ImageIcon("Files/Logo.jpg");  // LOGO image
		ImageIcon BACKGROUND = new ImageIcon("Files/CryptoGraphy.png");   // Main Window BackGround Image
		ImageIcon ENCRYPTION_BTN_ICON = new ImageIcon("Files/Encryption_btn.png");
		ImageIcon DECRYPTION_BTN_ICON = new ImageIcon("Files/Decription_btn.jpg");
		ImageIcon CRYPTANALYSIS_BTN_ICON = new ImageIcon("Files/Cryptonalasis_btn.png");
		ImageIcon EXIT_BTN_ICON = new ImageIcon("Files/Exit.png");
		
	//for encryption panel
		
		ImageIcon ENCRYPTION_BACKGROUND = new ImageIcon("Files/Encryption.jpg");
		ImageIcon PROCESSING_GIF = new ImageIcon("Files/processing 100x100.gif");
		
	// for Encryption processes
		ImageIcon CEASERCIPHER_ENCRYPTION = new ImageIcon("Files/CeaserCipher_encryption.png");
		ImageIcon AFFINECIPHER_ENCRYPTION = new ImageIcon("Files/AffineCipher_Encryption.png");
		ImageIcon SUBSTITUTION_ENCRYPTION = new ImageIcon("Files/Substitution_Encryption.png");
		ImageIcon HILLCIPHER_ENCRYPTION = new ImageIcon("Files/HILLCIPHER.jpg");
		ImageIcon PLAYFAIRCIPHER_ENCRYPTION= new ImageIcon("Files/PlayFair_Cipher.jpg");
		ImageIcon VIGNERECIPHER_ENCRYPTION = new ImageIcon("Files/VignereCipher.jpg");
		ImageIcon VERNAMCIPHER_ENCRYPTION = new ImageIcon("Files/VERNAM.png");
		ImageIcon AUTOKEY_ENCRYPTION = new ImageIcon("Files/AutoKey.jpg");
		ImageIcon COLUMNER_TRANSPOSITION = new ImageIcon("Files/Column TransPosition.png");
		ImageIcon RAIL_FANCE = new ImageIcon("Files/RailFence.png");
		
    // Import Image for Option Pane
		ImageIcon OK_ICON = new ImageIcon("Files/Ok 50x50.png");
		ImageIcon CANCEL_ICON = new ImageIcon("Files/Cancel 50x50.png");
	// Chackbox Image
		
		ImageIcon CHACKBOX_ICON = new ImageIcon("Files/Ok 50x50.png");
		ImageIcon CHACKBOX_SELECTED_ICON = new ImageIcon("Files/ChackBox_Checked.jpg");
	}

class Button extends JButton{
	Button(String name,Icon c ,String d,int e,int f, int g, int h){
	this.setText(name);
	this.setBorder(new LineBorder(new Color(0, 75, 80), 3));
	this.setIcon(c);
	this.setActionCommand(d);
	this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	this.setBounds(e,f,g,h);
}
	}




// Option Pane for exiting the App
class OptionPane extends JFrame{
	
	Tools tool = new Tools();
	int a = -1;
	
	OptionPane(){
		this.setAlwaysOnTop(true);
		this.setType(Type.UTILITY);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(500, 300, 416, 179);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 400, 140);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel PopupMsg = new JLabel("Do you wish to EXIT ?");
		PopupMsg.setHorizontalAlignment(SwingConstants.CENTER);
		PopupMsg.setFont(new Font("Tahoma", Font.BOLD, 24));
		PopupMsg.setForeground(Color.WHITE);
		PopupMsg.setBounds(36, 11, 319, 46);
		panel.add(PopupMsg);
		
		JButton OK_btn = new JButton("");
		OK_btn.setActionCommand("OK");
		OK_btn.setIcon(tool.OK_ICON);
		OK_btn.setBounds(72, 81, 51, 46);
		OK_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
			
		});
		panel.add(OK_btn);
		
		
		JButton Cncl_btn = new JButton("");
		Cncl_btn.setIcon(tool.CANCEL_ICON);
		Cncl_btn.setActionCommand("NO");
		Cncl_btn.setBounds(229, 81, 51, 46);
		Cncl_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Close();
				
			}
			
		});
		panel.add(Cncl_btn);
		
		
		this.setVisible(true);
	
	}
	void Close() {
		this.dispose();
	}
	
	
}
