import java.awt.EventQueue;

public class Control_Main_Class {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}



/*
 *  Cotrol_main_Class is main class to run whole program
 *  Tools - keep all the image and some classes used in all the classes
 *  MainFrame - Is the frame opened when opening software
 *  Encryption : - IS frame for Encryption
 *  EncryptionMEthods - keep all the methods for Encryption
 *  
 * In Main_Frame on pressing encryption it create a new class named ENCRYPTION with two input name of cipher choosen and number of it in list
 * Then ENCRYPTION class create a new class and use function in ENCRYPTION METHODS to give input and genrate output.
 *  
 */
