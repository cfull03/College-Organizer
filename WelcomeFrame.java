package main;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public abstract class WelcomeFrame extends OptionFrame {
	protected byte answer;
	protected Object[] options = {"Fall Semester", "Spring Semester", "Summer Semester"};
	
	private Object[] responses = {"Exit", "Continue"};
	
	
	protected int WelcomeFrameAnswer() {
	
		try{
			answer = (byte) JOptionPane.showOptionDialog(null, "Welcome to the School Organizer", "Organzier", 
					JOptionPane.DEFAULT_OPTION, 0, null, responses, 0);
		}catch (HeadlessException e) {
			JOptionPane.showMessageDialog(null, e + "\nHeadLess exception Occured at the 1st Frame.");
			System.exit(0);
		}
		
		return answer;
	}
}