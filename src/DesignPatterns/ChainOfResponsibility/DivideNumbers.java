package DesignPatterns.ChainOfResponsibility;

public class DivideNumbers implements Chain{
	private Chain nextInChain;

	@Override
	public void setNextChain(Chain nextInChain) {
	  this.nextInChain = nextInChain;
	}

	@Override
	public void calculate(Numbers request) {
		if(request.getCalculationWanted() == "Div"){
			System.out.println(request.getNumber1() +"/"+request.getNumber2() +"="
		                +(request.getNumber1()/request.getNumber2()));
		}else{
			System.out.println("Only works for Add, Sub, Mult and Div");
		}

	}
}
