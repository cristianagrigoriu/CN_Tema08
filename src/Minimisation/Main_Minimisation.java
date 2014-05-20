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
			
			MinMethod mm = new MinMethod();
			System.out.print("The minimum point is ");
			double result[] = mm.findMinimum();
			if (result != null) {
				for(int i=0; i<result.length; i++)
					System.out.print(result[i] + " ");
			}
			else
				System.out.print("null");
		}
	}
}
