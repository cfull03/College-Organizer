package main;

//This File organizes all the methods into one File and shows the steps of each button.

public abstract class GUI extends WelcomeFrame {


	protected void GUIinitiatior() {
		 WelcomeFrameAnswer();
		 if(answer == 1) {
			 //Welcome Frame if statement
			 IntroductionPanes();
			 if(choice == 0) {
				 //Creates the File if statement
				FileCreatorMethod();
			 }else if (choice == 1) {
				 //Creates the Folder if statements
				FolderCreatorMethod();
			 }else if(choice == 2) {
				 //Organize the Computer
				OrganizeMethod();
			 }
		 }else {
			 System.exit(0);
		 }
	}
	
	private void IntroductionPanes() {
		SemesterFolder();
		Classes();
		ThreeOptionPane();
	}
}
