package pro.jing.base.operators;

/**
 * @author JING
 * @date 2018年9月14日
 * @describe 复合操作符与一般操作的差别
 */
public class CompoundOperation {

	public static void main(String[] args) {

		// 同类型操作,没有差别
		int a1 = 1;
		int a2 = 2;
		a1 = a1 + a2;
		System.out.println("相同类型一般操作 + -> " + a1);
		int b1 = 1;
		int b2 = 2;
		b1 += b2;
		System.out.println("相同类型复合操作 += -> " + b1);

		// 不同类型操作
		int c1 = 1;
		long c2 = 10L;
		c1 = (int) (c1 + c2); // 需要强制转换，否者编译会出错
		System.out.println("不同类型一般操作，需要显式类型转换 -> " + c1);
		int d1 = 1;
		long d2 = 10L;
		d1 += d2; // 复合操作，不需要显示类型转换
		System.out.println("不同类型复合操作，不需要显式类型转换 -> " + d1);
	}
}
