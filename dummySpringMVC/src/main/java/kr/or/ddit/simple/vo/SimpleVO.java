package kr.or.ddit.simple.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import kr.or.ddit.simple.OperatorType;

public class SimpleVO {
	@Min(Integer.MIN_VALUE)
	@Max(Integer.MAX_VALUE)
	private int leftOp;
	private int rightOp;
	@NotNull
	private OperatorType operator;
	public OperatorType getOperator() {
		return operator;
	}
	public void setOperator(OperatorType operator) {
		this.operator = operator;
	}
	private int result;

	public int getLeftOp() {
		return leftOp;
	}

	public void setLeftOp(int leftOp) {
		this.leftOp = leftOp;
	}

	public int getRightOp() {
		return rightOp;
	}

	public void setRightOp(int rightOp) {
		this.rightOp = rightOp;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	
}
