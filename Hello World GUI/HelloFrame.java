
/**
 * 
 * @author - William Chad Brown
 * 
 * Description:	This Class is used to set the elements in the GUI and the track
 * 				the users interactions with the program. 
 * 
 */

// Java Swing imports
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

// Java awt imports. 
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloFrame extends JFrame {
	
	// Global variables, Message is the String that will be changed
	// by the program, and label is where this message will be 
	private String message;
	public static JLabel label;


	// Constaints that store the size of the frame and the size of the text.
	private static int FRAME_WIDTH = 300;
	private static int FRAME_HEIGHT = 100;
	private static int DEFAULT_SIZE = 30;

	/**
	 * 
	 * Constructor that sets the default message and set options of the
	 * label. Then adds the label to the layout. 
	 * 
	 */
	public HelloFrame() {

		// Setting default message
		message = "Hello, World!";

		// Creating and setting options for the label. 
		label = new JLabel(message);
		label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		// Puttting the lable in the layout
		add(label, BorderLayout.CENTER);

		// Setting the size of the frame. 
		setSize(FRAME_WIDTH, FRAME_HEIGHT);

		createSouthPanel();

	}

	/**
	 * 
	 * Function that is used to create the remaining elements of the 
	 * users GUI. This function will create the two radio button and the 
	 * checkbox. This function also contains the sub-class that is used 
	 * to track the users input to the program. 
	 * 
	 */
	private void createSouthPanel() {

		// Creating the variables used for the buttons. 
		JRadioButton helloButton = new JRadioButton("Hello");
		JRadioButton goodbyeButton = new JRadioButton("Goodbye");
		JCheckBox cruelCheckBox = new JCheckBox("Cruel");

		// Creating a group to hold the buttons.
		ButtonGroup group = new ButtonGroup();
		group.add(helloButton);
		group.add(goodbyeButton);

		// Adding the items to the panel. 
		JPanel southPanel = new JPanel();
		southPanel.add(helloButton);
		southPanel.add(goodbyeButton);
		southPanel.add(cruelCheckBox);

		// Adding the panel to the frame.
		add(southPanel, BorderLayout.SOUTH);

		// Sets the hello button to be selected at start. 
		helloButton.setSelected(true);

		/**
		 * 
		 * Sub-class used to track the users input into the program.
		 * This single sub-class is used to track both the changes with
		 * the radio buttons and to see if the checkbox is checked. This will
		 * change the message that is shown to the user. 
		 * 
		 */
		class MessageListener implements ActionListener {

			/**
			 * 
			 * The function that is called when an element of the GUI is 
			 * changed by the user. 
			 * 
			 * @param e - when an action is preformed the button or element that 
			 * 			  the user has interacted with will call this method and 
			 * 			  submit the ActionEvent object for this parameter. 
			 * 
			 */
			public void actionPerformed(ActionEvent e) {

				// This statement will check each item of the GUI
				// to see what settings are set and it will build the 
				// string to place in the message variable that is then
				// shown to the user. 
				String message = "";
				if (helloButton.isSelected())
					message = "Hello";
				else if (goodbyeButton.isSelected())
					message = "Goodbye";

				if (cruelCheckBox.isSelected())
					message += " cruel";

				message += ", World!";
				label.setText(message);
			}
		}


		// Creates the ActionListener object and then sets the object 
		// to each of the elements of the GUI to track user input. 
		ActionListener messageListener = new MessageListener();
		helloButton.addActionListener(messageListener);
		goodbyeButton.addActionListener(messageListener);
		cruelCheckBox.addActionListener(messageListener);

	}
}