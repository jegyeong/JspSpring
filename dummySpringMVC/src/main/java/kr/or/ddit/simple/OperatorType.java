package kr.or.ddit.simple;

public enum OperatorType{
	PLUS('+', (left, right)->{return left+right;}), 
	MINUS('-', new Operator() {
		@Override
		public double operate(double left, double right) {
			return left-right;
		}
	}), 
	MULTIPLY('*', (left, right)->{return left*right;}), 
	DIVIDE('/', (left, right)->{return left/right;});
	
	@FunctionalInterface
	public static interface Operator{
		public double operate(double left, double right);
	}
	
	private char sign;
	private Operator realOperator;
	private OperatorType(char sign, Operator realOperator) {
		this.sign = sign;
		this.realOperator = realOperator;
	}
	public double operate(double left, double right) {
		return realOperator.operate(left, right);
	}
	public char getSign() {
		return sign;
	}
}







