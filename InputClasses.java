package main;

import javax.swing.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;

public abstract class InputClasses{
	
	protected Object[] options = {"Fall Semester", "Spring Semester", "Summer Semester"};
	protected String introframe;
	
	private Path folderpath, introframepath;
	private byte answer;
	private JTextField class1, class2, class3, class4, class5, class6;
	private String singleclassname;
	private JFrame frame;
	private HashMap<String, Integer> classes = new HashMap<String, Integer>();
	
	protected void SemesterFolder() {
		
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		
		introframe = (String) JOptionPane.showInputDialog(frame, "Choose Session", "Menu",JOptionPane.OK_CANCEL_OPTION, null, options, options[0]);
		
		introframepath = Paths.get(System.getProperty("user.home") + "/Desktop/" + introframe);
		if(Files.notExists(introframepath)){
				try {
					Files.createDirectory(introframepath);
				}catch(UnsupportedOperationException u) {
					JOptionPane.showMessageDialog(null, u);
					System.exit(0);
				}catch(FileAlreadyExistsException f) {
					JOptionPane.showMessageDialog(null, "Folder/File Already exist");
				}catch(IOException e) {
					JOptionPane.showMessageDialog(null, e);
					System.exit(0);
				}
			}else {
				return;
			}
	}
	
	private void FolderMaker(String name) {
		folderpath = Paths.get(System.getProperty("user.home") + "/Desktop/" + introframe + "/" + name);
		
		if(Files.notExists(folderpath)) {
			try {
				Files.createDirectory(folderpath);
			} catch (UnsupportedOperationException u) {
				JOptionPane.showMessageDialog(null, u);
				System.exit(0);
			}catch(FileAlreadyExistsException f) {
				JOptionPane.showMessageDialog(null, "Folder/File Already exist");
			}catch(IOException e) {
				JOptionPane.showMessageDialog(null, e);
				System.exit(0);
			}
		}else {
			return;
		}
	}

	
	protected void Classes() {
		
		class1 = new JTextField(15);
		class2 = new JTextField(15);
		class3 = new JTextField(15);
		class4 = new JTextField(15);
		class5 = new JTextField(15);
		class6 = new JTextField(15);
		
		Object[] Fields = {
			"Class 1", class1,
			"Class 2", class2,
			"Class 3", class3,
			"Class 4", class4,
			"Class 5", class5,
			"Class 6", class6
		};
		answer = (byte) JOptionPane.showConfirmDialog(null, Fields, "Input Classes for the current Semester", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		
		
		if(answer == 0) {
			SingleClassFolderMaker(listofclasses());
		};
	}
	
	protected HashMap<String, Integer> listofclasses(){
		
		classes.put(class1.getText(), 1);
		classes.put(class2.getText(), 2);
		classes.put(class3.getText(), 3);
		classes.put(class4.getText(), 4);
		classes.put(class5.getText(), 5);
		classes.put(class6.getText(), 6);
		
		return classes;
	}

	protected String getSingleclassname() {
		return singleclassname;
	}
	
	protected void SingleClassFolderMaker(HashMap<String, Integer> listedclasses) {
		for(String SelectedClass : listedclasses.keySet()) {
			switch(listedclasses.get(SelectedClass)) {
				case 1:
					FolderMaker(SelectedClass);
					continue;
				case 2:
					FolderMaker(SelectedClass);
					continue;
				case 3:
					FolderMaker(SelectedClass);
					continue;
				case 4:
					FolderMaker(SelectedClass);
					continue;
				case 5:
					FolderMaker(SelectedClass);
					continue;
				case 6:
					FolderMaker(SelectedClass);
					continue;
				default:
					break;
			}
		}
	}
	
	protected void Singleclass(HashMap<String, Integer> listedclasses) {
		for(String classname : listedclasses.keySet()) {
				singleclassname = classname;
		}
	}
}