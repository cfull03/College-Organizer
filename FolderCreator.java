package directoryfiles;

import java.nio.file.*;
import java.util.ArrayList;
import java.io.*;
import javax.swing.JOptionPane;
import Organization.*;
import exceptions.*;



public abstract class FolderCreator extends ComputerScanner {
	
	private String foldername;
	private Path folderpath;
	private File directory;
	private File[] semesterfolder;
	private ArrayList<String> SemesterFolders = new ArrayList<String>();
	private final FilenameFilter filter = (dir, name) -> name.contains("Semester");

	
	private String selectedfolder() {
		Object[] finalfolder = existingfolder();
		String selectedfolder = (String) JOptionPane.showInputDialog(null, "Choose Folder", "Menu", 
				JOptionPane.INFORMATION_MESSAGE, null, finalfolder, finalfolder[0]);
			
			return selectedfolder;
		}
	
	private void FolderFrameName() throws InvalidNameException{
		foldername = JOptionPane.showInputDialog("Folder Name");
		if(foldername == null) {
			throw new InvalidNameException("Input a Name ", new RuntimeException());
		}
	}

	protected void FolderCreatorMethod() {
		try{
			FolderFrameName();
		}catch(InvalidNameException i) {
			JOptionPane.showMessageDialog(null, i);
			System.exit(0);
		}
		
		String selecteddirectory = selectedfolder();
		folderpath = Paths.get(System.getProperty("user.home") + "/Desktop/" + selecteddirectory + "/" + foldername);
		
		
		try {
			Files.createDirectories(folderpath);
		}catch(UnsupportedOperationException u) {
			JOptionPane.showMessageDialog(null, u);
			System.exit(0);
		}catch(FileAlreadyExistsException f) {
			JOptionPane.showMessageDialog(null, f);
			return;
		}catch (IOException e) {
			JOptionPane.showMessageDialog(null, e);
			System.exit(0);
		}
		System.exit(0);
	}
	private Object[] existingfolder() {
		directory = new File(System.getProperty("user.home") + "/Desktop");
		semesterfolder = directory.listFiles(filter);
		for(File i : semesterfolder) {
			if(i.isDirectory()) {
				SemesterFolders.add(i.getName());
				continue;
			}
		}
		Object[] listedfolder = SemesterFolders.toArray();
		return listedfolder;
	}
}
