package main;

public class Main extends GUI {
	private static Main mainGUI = new Main();

	public static void main(String[] args) {
		mainGUI.GUIinitiatior();
	}
}


/* 
 * This file runs the GUI Initiator under a thread (public void run()), 
 * in case the GUI throws an exception it will catch it and quit the program 
 */