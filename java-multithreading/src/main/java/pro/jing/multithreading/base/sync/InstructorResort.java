package pro.jing.multithreading.base.sync;

/**
 * @author JING
 * @date 2018年8月22日
 * @describe 指令重排序可能引起的代码问题
 */
public class InstructorResort {

	private static boolean flag ;
	private static int number;
	
	public void fun1() {
		flag = false;
		number = 2;
	}
	
	public void fun2() {
		while(flag) {
			
		}
		
		System.out.println(number);
	}
}
