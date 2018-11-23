
/**
 * 
 * @author - William Chad Brown
 * 
 * Description: This is a progrma that is ment to give an introduction to Java GUI
 *              items. This progrma is a graphical verson of the Hello World program.
 *              This program gives the user a box that shows hello world, and this message
 *              can be changed with the radio buttons, and check box along the bottom of the 
 *              screen. 
 * 
 */

import javax.swing.JFrame;

public class HelloViewer {

    public static void main(String[] args) {

        // Creates the main frame to hold the elements in the GUI.
        // Then sets the frame options. 
        JFrame frame = new HelloFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Hello Viewer");
        frame.setVisible(true);
    }
}
