package main;

import javax.swing.JOptionPane;
import directoryfiles.FileCreator;

public abstract class OptionFrame extends FileCreator {

	protected Object option;
	protected Object choice_response;
	protected byte choice;

	protected Object ThreeOptionPane() {
		Object[] responses = {"Create a File", "Create a Folder", "Organzie"};
		
		choice = (byte) JOptionPane.showOptionDialog(null, "Choose and Option", "Organzier", 
				JOptionPane.INFORMATION_MESSAGE, 0, null, responses, 0);
		
		return choice;
	}
		
}
