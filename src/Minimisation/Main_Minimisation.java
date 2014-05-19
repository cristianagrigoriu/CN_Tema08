package Minimisation;

import Graphics.FileChooser;

public class Main_Minimisation {
	public static void main(String[] args) {
		/*se alege fisierul*/
		FileChooser sfc = new FileChooser();
		sfc.setVisible(true);
		String fileName = sfc.createFileChooser();
		System.out.println("Ati ales fisierul " + fileName);		
					
		if (fileName != null) {
			ReadFile rf = new ReadFile();
			rf.readFromFile(fileName);
		}
	}
}
