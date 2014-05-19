package Minimisation;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ReadFile {
	static int precision;
	
	public void readFromFile(String fileName) {
		
		try
		{
			FileInputStream fstream = new FileInputStream(fileName);
			/*get the object of DataInputStream*/
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			/*read the first line of the file*/
			while ((strLine = br.readLine()) != null) {
				precision = Integer.parseInt(strLine);
			}
			
			/*close the input stream*/
			in.close();
			
			System.out.println("precision = " + precision);
			
			/*catch exception if any*/
			}catch (Exception e){
				System.err.println("Error: " + e.getMessage());
		}
	}
}
