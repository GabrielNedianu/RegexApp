package ro.regex.gui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {
	public static void main(String[] args) {
		JFrame appFrame = new JFrame();
		appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		appFrame.add(new MainPanel());
		appFrame.pack();
		appFrame.setVisible(true);
	}
}
