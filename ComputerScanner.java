package Organization;

import java.io.*;
import javax.swing.JOptionPane;
import exceptions.*;


public abstract class ComputerScanner extends Organizer {

	private Method organizemethod;
	
	protected void OrganizeMethod() {
		organizemethod = new Method();
		organizemethod.ComputerScannerMethod();
		System.exit(0);
	}
	
	private class FileFilter implements FilenameFilter{
		private String initals;
		
		public FileFilter(String initals) {
			this.initals = initals;
		}

		@Override
		public boolean accept(File dir, String name) {
			return name.contains(initals);
		}
	}
	
	private class Method{
		
		private File UserDirectory;
		private File christianfullertonDirectory;
		private File desktopDirectory;
		private FileFilter filter;
		
		private void searchDirectory(File directory) {
			
			Singleclass(listofclasses());
			
			filter = new FileFilter(getSingleclassname());
	
			File[] filesfound = directory.listFiles(filter);
			if(filesfound != null) {
				//Organize
				try {
					FileMover(filesfound, getSingleclassname());
				}catch(NoFolderException f) {
					JOptionPane.showMessageDialog(null, f);
					System.exit(0);
				}catch(NoFileException n) {
					JOptionPane.showMessageDialog(null, n);
					System.exit(0);
				}
			}else if (filesfound == null){
				JOptionPane.showInternalMessageDialog(null, "No Files found in " + directory + " Directory");
				return;
			}
		}
		
		private void ComputerScannerMethod() {
		
			UserDirectory = new File("/Users");
			christianfullertonDirectory = new File(System.getProperty("user.home"));
			desktopDirectory = new File(System.getProperty("user.home") + "/Desketop");
			
			File[] Directories = {UserDirectory, christianfullertonDirectory, desktopDirectory};
			
			for(File SelectedDirectory : Directories) {
				searchDirectory(SelectedDirectory);
			}
		}
	}
}
