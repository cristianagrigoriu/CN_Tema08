package Minimisation;

public class Functions {

	double getFunction1(double x1, double x2) {
		return 10 * Math.pow((x2 - x1*x1), 2) + Math.pow(x1 - 1, 2);
	}
	
	double[] getInitialXFunction1() {
		return new double[]{0.1, -1.3};
	}
	
	int getNFunction1(){
		return 2;
	}
	
	double[] getDerivateFunction1(double x1, double x2) {
		double firstTerm = -40*x1*(x2 - x1*x1) + 2*(x1 - 1);
		double secondTerm = 20*(x2 - x1*x1);
		return new double[] {firstTerm, secondTerm};
	}
	
	double getFunction2(double x1, double x2, double x3) {
		return 2*x1*x1 + x1*x2 + x2*x2 + x2*x3 + x3*x3 - 6*x1 - 7*x2 - 8*x3 + 9;
	}
	
	double[] getInitialXFunction2() {
		return new double[]{1.1, 1.3, 3.5};
	}
	
	int getNFunction2(){
		return 3;
	}
	
	double[] getDerivateFunction2(double x1, double x2, double x3) {
		double firstTerm = 4*x1 + x2 - 6;
		double secondTerm = x1 + 2*x2 + x3 - 7;
		double thirdTerm = x2 + 2*x3 - 8;
		return new double[] {firstTerm, secondTerm, thirdTerm};
	}
	
	double getFunction3(double x1, double x2) {
		return Math.pow(Math.E, x1) * (4*x1*x1 + 2*x2*x2 + 4*x1*x2 + 2*x2 + 1); 
	}
	
	double[] getInitialXFunction3() {
		return new double[]{0.1, -1.3};
	}
	
	int getNFunction3(){
		return 2;
	}
	
	double[] getDerivateFunction3(double x1, double x2) {
		double firstTerm = getFunction3(x1, x2) + Math.pow(Math.E, x1) * (8*x1 + 4*x2);
		double secondTerm = Math.pow(Math.E, x1) * (4*x2 + 4*x1 + 2);
		return new double[] {firstTerm, secondTerm};
	}
}
