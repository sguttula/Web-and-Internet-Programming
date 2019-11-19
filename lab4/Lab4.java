package lab4;

public class Lab4 {
	int one, two, three, four;
	
	public Lab4(int one, int two, int three, int four) {
		super();
		this.one = 1;
		this.two = 2;
		this.three = 3;
		this.four = 4;
	}

	public int getOne() {
		return one;
	}

	public void setOne(int one) {
		this.one = one;
	}

	public int getTwo() {
		return two;
	}

	public void setTwo(int two) {
		this.two = two;
	}

	public int getThree() {
		return three;
	}

	public void setThree(int three) {
		this.three = three;
	}

	public int getFour() {
		return four;
	}

	public void setFour(int four) {
		this.four = four;
	}
	public int getA() {
		int sum = ((three + two) - one);
		return sum;
		
	}
}
