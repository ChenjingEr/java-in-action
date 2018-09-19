package pro.jing.base.util;

public class PrintConvert {

	public static String toCompleteBinaryString(int val) {
		int[] buffer = new int[Integer.SIZE];
		for (int i = (Integer.SIZE - 1); i >= 0; i--) {
			buffer[i] = val >> i & 1;
		} 
		String s = "";
		for (int j = (Integer.SIZE - 1); j >= 0; j--) {
			s = s + buffer[j];
		}
		return s;

	}
	
	public static void main(String[] args) {
		System.out.println(PrintConvert.toCompleteBinaryString(1));
	}
}
