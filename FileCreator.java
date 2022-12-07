package directoryfiles;

import java.io.*;
import java.text.*;
import java.util.*;
import java.nio.file.*;
import exceptions.*;
import javax.swing.JOptionPane;

public abstract class FileCreator extends FolderCreator {
	
	protected String filename;
	
	private Path filepath;
	private FileWriter filepreparerHEADING,filepreparerTITLE;
	private FileTitles[] filetypes;
	private FileTitles title;
	private ArrayList<String> classesindirectory = new ArrayList<String>();
	private ArrayList<String> semestersindirectory = new ArrayList<String>();
	private File directorysemester, directoryclass;
	private File[] foldersindirectoryclass, foldersindirectorysemester;
	private Object[] existingclasses, existingsemesters;
	private String selectedclassfolder, selectedsemesterfolder;
	
	private final FilenameFilter filter = (dir, name) -> name.contains("Semester");
	
	@SuppressWarnings("unused")
	private final Indentation RightIndentation = new Indentation(100, Position.RIGHT);
	private final Indentation MiddleIndentation = new Indentation(100, Position.MIDDLE);
	private final Indentation LeftIndentation = new Indentation(100, Position.LEFT);
	private final Date currentDate = new Date();
	private final SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyy");
	
	private void FileFrameClass() {
		existingclasses();
		selectedclassfolder = (String) JOptionPane.showInputDialog(null, "Choose Folder", "Menu", 
				JOptionPane.INFORMATION_MESSAGE, null, existingclasses, existingclasses[0]);
	}
	
	private void FileFrameSemester() {
		existingsemester();
		selectedsemesterfolder = (String) JOptionPane.showInputDialog(null, "Choose Folder", "Menu", 
				JOptionPane.INFORMATION_MESSAGE, null, existingsemesters, existingsemesters[0]);
	}
	
	protected void FileCreatorMethod() {
		try {
			FileFrame();
		} catch(InvalidNameException i) {
			JOptionPane.showMessageDialog(null, i);
			System.exit(0);
		}
		FileFrameSemester();
		FileFrameClass();
		filepath = Paths.get(System.getProperty("user.home") + "/Desktop/" + selectedsemesterfolder + "/" + selectedclassfolder + "/" + filename + ".docx");
		
		try {
			Files.createFile(filepath);
		}catch (FileAlreadyExistsException f) {
			JOptionPane.showMessageDialog(null, f);
			System.exit(0);
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, e);
			System.exit(0);
		}
		
		TypeOfFile(filename);
		System.exit(0);
	}
	
	private void TypeOfFile(String filename) {
		filetypes = FileTitles.values();
		String date = DateFormatter.format(currentDate);
		try {
			filepreparerHEADING = new FileWriter(filename + ".docx");
			filepreparerHEADING.write(LeftIndentation.format(date));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e);
			System.exit(0);
		}
		title = (FileTitles) JOptionPane.showInputDialog(null, "Type of File", "Menu", 
				JOptionPane.INFORMATION_MESSAGE, null, filetypes, filetypes[0]);
		switch(title) {
		case Homework:
			try {
				filepreparerTITLE = new FileWriter(filename + ".docx");
				filepreparerTITLE.write(MiddleIndentation.format(title.toString()));
				filepreparerTITLE.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e);
				System.exit(0);
			}
			break;
		case Miscellaneous:
			try {
				filepreparerTITLE = new FileWriter(filename + ".docx");
				filepreparerTITLE.write(MiddleIndentation.format(title.toString()));
				filepreparerTITLE.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e);
				System.exit(0);
			}
			break;
		case Notes:
			try {
				filepreparerTITLE = new FileWriter(filename + ".docx");
				filepreparerTITLE.write(MiddleIndentation.format(title.toString()));
				filepreparerTITLE.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e);
				System.exit(0);
			}
			break;
		default:
			break;
		}
	}
	
	private void FileFrame() throws InvalidNameException {
		filename = JOptionPane.showInputDialog("File Name");
		if(filename == null) {
			throw new InvalidNameException("Input File name", new RuntimeException());
		}
	}
	
	private void existingclasses() {
		directoryclass = new File(System.getProperty("user.home") + "/Desktop/" + selectedsemesterfolder);
		foldersindirectoryclass = directoryclass.listFiles();
		for(File i : foldersindirectoryclass) {
			if(i.isDirectory()) {
				String name = i.getName();
				classesindirectory.add(name);
				continue;
			}
		}
		existingclasses = classesindirectory.toArray();
	}
	
	private void existingsemester() {
		directorysemester = new File(System.getProperty("user.home") + "/Desktop");
		foldersindirectorysemester = directorysemester.listFiles(filter);
		for(File i : foldersindirectorysemester) {
			if(i.isDirectory()) {
				String name = i.getName();
				semestersindirectory.add(name);
				continue;
			}
		}
		existingsemesters = semestersindirectory.toArray();
		
	}
	
	private class Indentation extends Format{

		private static final long serialVersionUID = 1L;
		private Position currentPosition;
		private int maxCharacters;
		
		private Indentation(int maxCharacters, Position currentPosition) {
			switch(currentPosition) {
				case LEFT:
					this.currentPosition = currentPosition;
					break;
				case MIDDLE:
					this.currentPosition = currentPosition;
					break;
				case RIGHT:
					this.currentPosition = currentPosition;
					break;
				default:
					throw new IllegalArgumentException("invalid Arguement");
			}
			if(maxCharacters < 0) {
				throw new IllegalArgumentException("Characters must me positive");
			}
			this.maxCharacters = maxCharacters;
		}

		@Override
		public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
			String s = obj.toString();
			List<String> strings = SplitInputString(s);
			ListIterator<String> listiterator = strings.listIterator();
			while(listiterator.hasNext()) {
				String SelectedElement = listiterator.next();
				switch(currentPosition) {
					case LEFT:
						toAppendTo.append(SelectedElement);
						pad(toAppendTo, maxCharacters - SelectedElement.length());
						break;
					case MIDDLE:
						int middle = maxCharacters - SelectedElement.length();
						pad(toAppendTo, middle / 2);
						toAppendTo.append(SelectedElement);
						pad(toAppendTo, middle - middle / 2);
						break;
					case RIGHT:
						pad(toAppendTo, maxCharacters - SelectedElement.length());
						toAppendTo.append(SelectedElement);
						break;
				}
				toAppendTo.append("\n");
			}
			return toAppendTo;
		}
		
		String format(String s) {
			return format(s, new StringBuffer(), null).toString();
		}

		@Override
		public Object parseObject(String source, ParsePosition pos) {
			// TODO Auto-generated method stub
			return source;
		}
		
		private List<String> SplitInputString(String string){
			List<String> list = new ArrayList<String>();
			if(string == null) {
				return list;
			}
			for(int i = 0; i < string.length(); i = i + maxCharacters) {
				int finalindex = Math.min(i + maxCharacters, string.length());
				list.add(string.substring(i, finalindex));
			}
			return list;
		}
		
		 protected final void pad(StringBuffer to, int howMany) {
			    for (int i = 0; i < howMany; i++)
			      to.append(' ');
			  }
	}
}


