package Organization;

import main.InputClasses;
import exceptions.*;
import java.io.*;
import javax.swing.JOptionPane;
import java.nio.file.*;

public abstract class Organizer extends InputClasses {
	private Path path;

	protected void FileMover(File[] files, String foldername) throws NoFileException, NoFolderException {
		for(File SelectedFile : files) {
			try {
				path = Files.move(Paths.get(SelectedFile.getAbsolutePath()),Paths.get("Users/christianfullerton/Desktop/" + foldername));
				if(path == null) {
					throw new NoFolderException("No Folder Exist");
				}else if(files == null) {
					throw new NoFileException("No Files to Organize");
				}
			}catch(IOException e) {
				JOptionPane.showMessageDialog(null, e + "\nIOExcpetion at the Organize Method");
				System.exit(0);
			}
		}
	}
}
