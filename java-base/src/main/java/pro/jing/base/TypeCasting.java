package pro.jing.base;

/**
 * @author JING
 * @date 2018年9月4日
 * @describe 类型操作需要注意转型问题(取值范围，大->小的强转换问题，小->大的隐式转换问题)
 */
public class TypeCasting {

	public static void main(String[] args) {
		
		// 大->小的强制转换
		int a = 10;
		int b = 10;
		byte ab = (byte) (a + b); // 编译报错，需要强制转换
		System.out.println(ab);
		
		byte c = 10;
		byte d = 10;
		int cd = c + d;  //发生隐式转换
		System.out.println(cd);
		
		//结合操作符的隐式转换
		c += a; // 发生了隐式转换
		System.out.println(c);

	}
}
