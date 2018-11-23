/**
 * 
 * @author William Chad Brown
 * 
 * Description:	This class is used to manage the users interactions with the program.
 * 				When the program starts the user is shown on screen to make a selection 
 * 				with the options along the bottom of the screen. Once the user makes a 
 * 				selection a problem will be shown on the screen. The users history will
 * 				be tracked and can be shown if the user selects the history option. 
 * 
 */

// Java swing imports for the elements of the GUI.
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

// Java awt imports for other elements of the GUI
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Other imports used to create random numbers for the equations
// and a stack to store the users history. 
import java.util.Random;
import java.util.Stack;

public class TutorFrame extends JFrame
{   
	
	// Global variables
	private String message;
	public static JLabel label;
	
	// Arrays used to hold the options for the drop down menus.
	public String[] level = {"Easy", "Moderate", "Difficult"};
	public String[] option = {"Addition", "Subtraction", "Multiplication", "Division"};
	
	// used to show the numbers to the user, and to store the users input. 
	public int x = 0;
	public int y = 0;
	public int userA = 0;
	
	// Variables use to create random numbers for the problems shown to the user
	public Random rand = new Random();
	
	// Stack that is used to hold the users answer history. 
	public Stack<AnswerHistory> historyStack = new Stack<AnswerHistory>();

	// Constants used to set the size of the frame. 
	private static int FRAME_WIDTH = 500;
	private static int FRAME_HEIGHT = 300;
	private static int DEFAULT_SIZE = 30;

	/**
	 * 
	 * Constructor used to create the GUI, and also contains the sub-classes used to track
	 * the users actions. 
	 * 
	 */
	public TutorFrame()
	{
		
		// Sets the message in the center of the screen take asks the user
		// to make a selection below to start. As well as sets attributes of 
		// the label. 
		message = "Choose Options Below";
		label = new JLabel(message);
		label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
		
		// Sets the layout information of the frame. 
		setLayout(new BorderLayout());
		setSize(FRAME_WIDTH, FRAME_HEIGHT);

		// Creates that text area that the user will place there answers in.
		JTextArea answer = new JTextArea(1, 10);
		answer.setFont(answer.getFont().deriveFont(20f));
		
		// Creates the submit button. 
		JButton submit = new JButton("Submit");
		
		// North panel creation used to add the label,
		// text area, and submit button into the frame. 
		JPanel north = new JPanel();
		north.add(label);
		north.add(answer);
		north.add(submit);
		add(north, BorderLayout.NORTH);
		
		// Creates the combo boxes for the difficulty or levels and the operand type. 
		JComboBox<String> levels = new JComboBox<String>(level);
		JComboBox<String> options = new JComboBox<String>(option);
		
		// Creates the button to show the history. 
		JButton history = new JButton("History");
		
		// South panel is used to add and show the combo boxes and the history button. 
		JPanel south = new JPanel();
		south.add(levels);
		south.add(options);
		south.add(history);
		add(south, BorderLayout.SOUTH);

		/**
		 * 
		 * Sub-class used to listen for the input by the user for the combo boxes. This 
		 * sub-class tracks changes made to the levels and options combo boxes. In order for 
		 * the program to star the user much change or conform one of these options.  
		 *
		 */
		class ComboListener implements ActionListener{
			
			/**
			 * 
			 * Action Performed listener. When a change to one of the combo boxes
			 * is changed then this function checks the information in the boxes and 
			 * creates a problem for the user to solve. 
			 * 
			 */
			public void actionPerformed(ActionEvent e){
				
				// If statement that will change the level of difficulty of 
				// the problem to be solved. This will change the size of the numbers
				// shown to the user. 
				if(levels.getSelectedItem().toString().equals("Easy")){
					
					// Switch statement to show the correct problem off the 
					// options combo box. This will change off of addition, subtraction,
					// division, and multiplication. 
					switch(options.getSelectedIndex()){

					// Addition case. Numbers will be created from 0-49.
					case 0:
						x = rand.nextInt(49) + 1;
						y = rand.nextInt(49) + 1;
						label.setText(x + " + " + y + " =");
						break;
						
					// Subtraction case, numbers are arranged in a way that the answer will not be 
					// negative. Numbers are created from 0-49 
					case 1:
						x = rand.nextInt(49) + 1;
						y = rand.nextInt(49) + 1;

						if(x > y)
							label.setText(x + " - " + y + " =");
						else
							label.setText(y + " - " + y + " =");

						break;
					// Multiplication case, Numbers will be created from 1-10 
					case 2:
						x = rand.nextInt(11) + 1;
						y = rand.nextInt(11) + 1;
						label.setText(x + " * " + y + " =");
						break;
						
					// Division case, Numbers are shown as to try and prevent fractions. This is not 
					// a 100%. All answers are only integers, so the user will round down for all answers.
					// Numbers are created between 1-10.
					case 3:
						x = rand.nextInt(11) + 1;
						y = rand.nextInt(11) + 1;

						if(x > y)
							label.setText(x + " / " + y + " =");
						else
							label.setText(y + " / " + y + " =");

						break;
					default:
						break;
					}
				}
				else if(levels.getSelectedItem().toString().equals("Moderate")){
					switch(options.getSelectedIndex()){
					
					// Addition case. Numbers will be created from 9-89.
					case 0:
						x = rand.nextInt(90) + 10;
						y = rand.nextInt(90) + 10;
						label.setText(x + " + " + y + " =");
						break;
						
					// Subtraction case, numbers are arranged in a way that the answer will not be 
					// negative. Numbers are created from 9-89
					case 1:
						x = rand.nextInt(90) + 10;
						y = rand.nextInt(90) + 10;

						if(x > y)
							label.setText(x + " - " + y + " =");
						else
							label.setText(y + " - " + y + " =");

						break;
					
					// Multiplication case, Numbers will be created from 9-39 
					case 2:
						x = rand.nextInt(40) + 10;
						y = rand.nextInt(40) + 10;
						label.setText(x + " * " + y + " =");
						break;
					// Division case, Numbers are shown as to try and prevent fractions. This is not 
					// a 100%. All answers are only integers, so the user will round down for all answers.
					// Numbers are created between 9-49.
					case 3:
						x = rand.nextInt(40) + 10;
						y = rand.nextInt(40) + 10;

						if(x > y)
							label.setText(x + " / " + y + " =");
						else
							label.setText(y + " / " + y + " =");

						break;
					default:
						break;
					}
				}
				else if(levels.getSelectedItem().toString().equals("Difficult")){
					switch(options.getSelectedIndex()){
					
					// Addition case. Numbers will be created from 99-899.
					case 0:
						x = rand.nextInt(900) + 100;
						y = rand.nextInt(900) + 100;
						label.setText(x + " + " + y + " =");
						break;
						
					// Subtraction case, numbers are arranged in a way that the answer will not be 
					// negative. Numbers are created from 99-899
					case 1:
						x = rand.nextInt(900) + 100;
						y = rand.nextInt(900) + 100;

						if(x > y)
							label.setText(x + " - " + y + " =");
						else
							label.setText(y + " - " + y + " =");

						break;
					// Multiplication case, Numbers will be created from 9-989 
					case 2:
						x = rand.nextInt(990) + 10;
						y = rand.nextInt(990) + 10;
						label.setText(x + " * " + y + " =");
						break;
						
					// Division case, Numbers are shown as to try and prevent fractions. This is not 
					// a 100%. All answers are only integers, so the user will round down for all answers.
					// Numbers are created between 9-999.
					case 3:
						x = rand.nextInt(990) + 10;
						y = rand.nextInt(990) + 10;

						if(x > y)
							label.setText(x + " / " + y + " =");
						else
							label.setText(y + " / " + y + " =");

						break;
					default:
						break;
					}
				}
			}
		}
		
		// Adds the actions listeners to each element. 
		ActionListener comboListener = new ComboListener();
		submit.addActionListener(comboListener);
		levels.addActionListener(comboListener);
		options.addActionListener(comboListener);
		history.addActionListener(comboListener);
		
		/**
		 * 
		 * Sub-class used to track the actions of the submit button.
		 * This class only tracks the actions of this button. 
		 *
		 */
		class ButtonListener implements ActionListener{

			/**
			 * 
			 * Action Performed function that will take the user input and see if the information is correct. 
			 * Division will only be a integer. so the answers will be rounded down. And subtraction problems 
			 * will be set to not have negative numbers. 
			 * 
			 */
			public void actionPerformed(ActionEvent e) {
				
				// String that will contain the information to pass to the AnswerHistory class. 
				String s = "";
				
				// This will check the answer the user entered based off the options selected.
				// Checks users addition, and will show the user if they are correct or not. 
				// Then push the problem to the stack holder the users history. 
				if(options.getSelectedIndex() == 0){
					if((x+y) == Integer.parseInt(answer.getText().trim())){
						s = "Correct!!";
						historyStack.push(new AnswerHistory(x, y, options.getSelectedIndex(), Integer.parseInt(answer.getText().trim()), true));
					}
					else{
						s = "Incorrect!!";
						historyStack.push(new AnswerHistory(x, y, options.getSelectedIndex(), Integer.parseInt(answer.getText().trim()), false));
					}
				
				// Checks users subtraction problems. 
				} else if(options.getSelectedIndex() == 1){
					if(((x-y) == Integer.parseInt(answer.getText().trim())) || ((y-x) == Integer.parseInt(answer.getText().trim()))){
						s = "Correct!!";
						historyStack.push(new AnswerHistory(x, y, options.getSelectedIndex(), Integer.parseInt(answer.getText().trim()), true));
					}
					else{
						s = "Incorrect!!";
						historyStack.push(new AnswerHistory(x, y, options.getSelectedIndex(), Integer.parseInt(answer.getText().trim()), false));
					}
				
				// Checks the users multiplication problems. 
				} else if(options.getSelectedIndex() == 2){
					if((x*y) == Integer.parseInt(answer.getText().trim())){
						s = "Correct!!";
						historyStack.push(new AnswerHistory(x, y, options.getSelectedIndex(), Integer.parseInt(answer.getText().trim()), true));
					}
					else{
						s = "Incorrect!!";
						historyStack.push(new AnswerHistory(x, y, options.getSelectedIndex(), Integer.parseInt(answer.getText().trim()), false));
					}
			
				// Checks the users division problems. 
				} else if(options.getSelectedIndex() == 3){
					if(((x/y) == Integer.parseInt(answer.getText().trim())) || ((y/x) == Integer.parseInt(answer.getText().trim()))){
						s = "Correct!!";
						historyStack.push(new AnswerHistory(x, y, options.getSelectedIndex(), Integer.parseInt(answer.getText().trim()), true));
					}
					else{
						s = "Incorrect!!";
						historyStack.push(new AnswerHistory(x, y, options.getSelectedIndex(), Integer.parseInt(answer.getText().trim()), false));
					}
				}
				
				// Updates the GUI to show it the answer is correct. 
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				JOptionPane.showMessageDialog(frame, s, "Solution", JOptionPane.PLAIN_MESSAGE);
			}



		}
		
		// Adds the actions listeners to the submit button. 
		ActionListener buttonListener = new ButtonListener();
		submit.addActionListener(buttonListener);

		/**
		 * 
		 * Sub-class that tracks users input with the history button.
		 * If the history button is pressed then a new window is generated
		 * and shows the users there history. 
		 *
		 */
		class HistoryButton implements ActionListener{

			/**
			 * 
			 * Action Performed function that tracks the user pressing the 
			 * history button. When the button is press a new window will show the
			 * user their history of answers. 
			 * 
			 */
			public void actionPerformed(ActionEvent e) {
				
				// Creates the new window to show the user history.
				JFrame historyFrame = new JFrame("History");
				
				// Sets the exit button to just close the history window and not the 
				// whole program. 
				historyFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
				// Sets the options of the window.
				historyFrame.setSize(300,300);
				historyFrame.setLocationRelativeTo(null);
				
				// Text Area where the history is printed. 
				JTextArea historyList = new JTextArea(200,200);
				
				// Adds the text area the to the frame and sets the boarder layout.
				historyFrame.add(historyList,BorderLayout.CENTER);
				String list = "";
				
				// Goes to the stack and pops all the items. 
				while(!historyStack.empty()){
					list += historyStack.pop().toString() + "\n";
				}
				
				// Makes the window visible. 
				historyList.setText(list);
				historyFrame.setVisible(true);
			}

		}
		
		// Adds the action listener to the button. 
		ActionListener historyButton = new HistoryButton();
		history.addActionListener(historyButton);
	}  

}