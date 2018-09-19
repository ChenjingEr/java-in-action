package pro.jing.proxy.jdk;

public class Calculator implements ICalculator {

	@Override
	public void add(int i, int j) {
		System.out.println("i + j ->" + (i + j));
	}

	@Override
	public void sub(int i, int j) {
		System.out.println("i - j -> " + (i - j));
	}

	@Override
	public void mul(int i, int j) {
		System.out.println("i * j -> " + (i * j));
	}

	@Override
	public void div(int i, int j) {
		System.out.println("i / j -> " + (i / j));
	}

}
