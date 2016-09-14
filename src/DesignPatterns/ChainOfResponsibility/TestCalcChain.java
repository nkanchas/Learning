package DesignPatterns.ChainOfResponsibility;

public class TestCalcChain {
//https://www.youtube.com/watch?v=jDX6x8qmjbA
	public static void main(String[] args) {
		Chain calcChain1 = new AddNumbers();
		Chain calcChain2 = new SubstractNumbers();
		Chain calcChain3 = new MultiplyNumbers();
		Chain calcChain4 = new DivideNumbers();
		
		calcChain1.setNextChain(calcChain2);
		calcChain2.setNextChain(calcChain3);
		calcChain3.setNextChain(calcChain4);
		
		Numbers request = new Numbers(4, 2, "Mult");
		
		calcChain1.calculate(request);	
		
		

	}

}
