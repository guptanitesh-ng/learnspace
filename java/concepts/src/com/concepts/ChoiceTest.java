package com.concepts;

import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChoiceTest {

	private static final int button_count = 10;
	 
    // Declare a Frame type variable
    Frame frame;
    MenuBar menuBar;
    Menu fileMenu, optionsMenu, helpMenu;
    Panel panelUpperSection, panelLowerSection;
    
    Choice choice;
 
    // Create an array of Button type Objects
    Button [] button = new Button[button_count];
 
    public ChoiceTest() {
        // Create Frame Object and pass in the Frame Name / title
        frame = new Frame("AWT GUI EXAMPLE");
 
        // Create a panel object for organizing content
        panelUpperSection = new Panel();
        panelLowerSection = new Panel();
 
        // Use for loop to instantiate every button object
        for(int i = 0; i < button_count; ++i){
            button[i] = new Button( "" + i );
        }
 
        choice = new Choice();
        choice.add("Yes");
        choice.add("No");
        // Create MenuBar Object
        menuBar = new MenuBar();
 
        // Create Menu objects to add to the MenuBar
        fileMenu = new Menu("File");
        optionsMenu = new Menu("Options");
        helpMenu = new Menu("Exit");
    }
 
    public static void main(String[] args) {
 
        // Create an instance of SimpleAwtGui
    	ChoiceTest window = new ChoiceTest();
 
        // call the showFrame() function to display the window
        window.showFrame();
 
    }
 
    // Not necessary but good practice all codes inside this can be written inside main
    public void showFrame() {
        // set the size of the window
        frame.setSize(400, 400);
 
        // set the layout for the window
        frame.setLayout(new GridLayout(2, 1));
 
        // Add panel to the frame
        frame.add(panelUpperSection);
        frame.add(panelLowerSection);
 
        // Set Layout for the panels
        panelUpperSection.setLayout(new FlowLayout());
        panelLowerSection.setLayout(new GridLayout());
 
        panelUpperSection.add(choice);
        
        // Add all of the buttons to the layout
        for(int i = 0; i < button_count; ++i) {
            panelLowerSection.add(button[i]);
        }
 
        // Register window listener event to the frame without implementing WindowListener
        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
 
        // Add Menu to the MenuBar
        menuBar.add(fileMenu);
        menuBar.add(optionsMenu);
        menuBar.add(helpMenu);
 
        /**
         * Add MenuItem to Menu
         */
 
        // Add items to File Menu
        fileMenu.add(new MenuItem("New"));
        fileMenu.add(new MenuItem("Open"));
        fileMenu.add(new MenuItem("Exit"));
 
        // Add items to File Menu
        optionsMenu.add(new MenuItem("Options"));
 
        // Add items to File Menu
        helpMenu.add(new MenuItem("Help"));
        helpMenu.add(new MenuItem("About"));
 
        // Add MenuBar to the Frame
        frame.setMenuBar(menuBar);
 
        // set the frame visible otherwise nothing will be shown
        frame.setVisible(true);
    }

}
