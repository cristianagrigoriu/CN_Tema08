package Minimisation;

public class MinMethod {

	public MinMethod() {
		
	}

	double findMinimum() {
		Functions f = new Functions();
		int n = f.getNFunction1();
		double[][] w = getIdenticMatrix(n);
		double[] initialX = f.getInitialXFunction1();
		double[] g = f.getDerivateFunction1(initialX[0], initialX[1]);
		int k = 0;
		
		double[] d = new double[n];
		
		double euclideanNorm = euclideanNorm(g);
		
		while (euclideanNorm > Math.pow(10, -ReadFile.precision) && k <= 200) {
			d = getMinusArray(g); //metoda pantei maxime
		}
		
		return 0;
	}
	
	double[][] getIdenticMatrix(int n) {
		double[][] identicMatrix = new double[n][n];
		for (int i=0; i<n; i++)
			identicMatrix[i][i] = 1;
		return identicMatrix;
	}
	
	private double euclideanNorm(double[] array) {
		double euclideanNorm = 0;
		for (int i=0; i<array.length; i++)
			euclideanNorm += array[i] * array[i];
		euclideanNorm = Math.sqrt(euclideanNorm);
		return euclideanNorm;
	}
	
	private double[] getMinusArray(double[] array) {
		double[] newArray = new double[array.length];
		for(int i=0; i<array.length; i++)
			newArray[i] = -array[i];
		return newArray;
			
	}
}
