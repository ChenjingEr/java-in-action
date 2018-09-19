package pro.jing.base.operators;

import pro.jing.base.util.PrintConvert;

/**
 * @author JING
 * @date 2018年9月14日
 * @describe 位移操作
 */
public class ShiftOperators {

	public static void main(String[] args) {
		// >> 右移 -> /2^n
		int a1 = -10;
		int before = a1;
		System.out.println("右移之前  -> " + PrintConvert.toCompleteBinaryString(a1));
		a1 >>= 1;
		int after = a1;
		System.out.println("右移之后 -> " + PrintConvert.toCompleteBinaryString(a1));
		System.out.println(before + " 右移1位之后  " + after);

		// 逻辑右移,高位补0
		int c1 = -10;
		int cb = a1;
		System.out.println("右移之前  -> " + PrintConvert.toCompleteBinaryString(c1));
		c1 >>>= 1;
		int ab = c1;
		System.out.println("右移之后 -> " + PrintConvert.toCompleteBinaryString(c1));
		System.out.println(cb + " 右移1位之后  " + ab);

		// << 左移 -> *(2^n)
		int b1 = 10;
		int bef = b1;
		System.out.println("左移动之前 -> " + PrintConvert.toCompleteBinaryString(b1));
		b1 <<= 1;
		int af = b1;
		System.out.println("左移动之后 -> " + PrintConvert.toCompleteBinaryString(b1));
		System.out.println(bef + " 右移1位之后  " + af);

	}
}
