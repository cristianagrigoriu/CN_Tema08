package Minimisation;

public class MinMethod {

	double[] findMinimum() {
		Functions f = new Functions();
		int n = f.getNFunction2();
		//double[][] w = getIdenticMatrix(n);
		double[] initialX = f.getInitialXFunction2();
		double[] g = f.getDerivateFunction2(initialX[0], initialX[1], initialX[2]);
		int k = 0;
		
		double[] d = new double[n];
		double t;
		
		double euclideanNorm = euclideanNorm(g);
		
		while (euclideanNorm > Math.pow(10, -ReadFile.precision) && k <= 100) {
			d = getMinusArray(g); //metoda pantei maxime
			
			t = linesearch(initialX, d);
			while(t == -1)
				t = linesearch(initialX, d);
			initialX = getSumOfVectors(initialX, multiplyVectorWithScalar(t, d));
				
			g = f.getDerivateFunction2(initialX[0], initialX[1], initialX[2]);
			k++;
			euclideanNorm = euclideanNorm(g);
		}
		
		//if(euclideanNorm <= Math.pow(10, -ReadFile.precision))
			return initialX;
		//else 
			//return null;
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
	
	private double linesearch(double[] x, double[] d) {
		double y0 = Math.random(), y1 = Math.random();
		
		//System.out.println("y0 = " + y0 + " y1 = " + y1);
		
		int k = 1;
		double deltaY;
		
		do {
			deltaY = computeDeltaY(y0, y1, x, d);
			if (Math.abs(computeDenominator(y0, y1, x, d)) <= Math.pow(10, -ReadFile.precision))
				deltaY = Math.pow(10, -3);
			y0 = y1;
			y1 = y1 - deltaY;
			k++;
		} while(Math.abs(deltaY) >= Math.pow(10, -6) && k<=200 && Math.abs(deltaY) <= Math.pow(10, 8));
		
		if (Math.abs(deltaY) < Math.pow(10, -6))
			return y1;
		else 
			return -1;
	}
	
	private double computeDeltaY(double y0, double y1, double[] x, double[] d) {
		double qPrimeYM = getQPrime(y1, x, d);
		double qPrimeYMM = getQPrime(y0, x, d);
		return qPrimeYM * (y1 - y0) / (qPrimeYM - qPrimeYMM);
	}
	
	private double computeDenominator(double y0, double y1, double[] x, double[] d) {
		double qPrimeYM = getQPrime(y1, x, d);
		double qPrimeYMM = getQPrime(y0, x, d);
		return qPrimeYM - qPrimeYMM;
	}
	
	private double getQPrime(double y, double[] x, double[] d) {
		double[] sum = getSumOfVectors(x, multiplyVectorWithScalar(y, d));
		
		Functions f = new Functions();
		double nablaF[] = f.getDerivateFunction2(sum[0], sum[1], sum[2]);
		
		return multiplyVectors(nablaF, d);
	}
	
	private double[] getSumOfVectors(double[] x, double[] d) {
		double[] result = new double[x.length];
		for (int i=0; i<x.length; i++)
			result[i] = x[i] + d[i];
		return result;
	}
	
	private double[] multiplyVectorWithScalar(double number, double[] vector) {
		double[] result = new double[vector.length];
		for (int i=0; i<vector.length; i++)
			result[i] = number * vector[i];
		return result;
	}
	
	private double multiplyVectors(double[] vector1, double[] vector2) {
		double result = 0;
		for (int i=0; i<vector1.length; i++)
			result += vector1[i] * vector2[i];
		return result;
	}
}
