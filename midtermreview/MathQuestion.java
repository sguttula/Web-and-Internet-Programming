
package midtermreview;

public class MathQuestion {

	int op1, op2;

	public MathQuestion() {
		super();
		// Randomly generate op1 and op2
		op1 = (int) (Math.random() * 10);
		op2 = (int) (Math.random() * 10);
	}

	public int getOp1() {
		return op1;
	}

	public int getOp2() {
		return op2;
	}
	
	public int getAnswer() {
		return op1 + op2;
	}
	
	
	
}