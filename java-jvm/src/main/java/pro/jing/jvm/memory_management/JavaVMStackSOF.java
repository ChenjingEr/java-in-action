package pro.jing.jvm.memory_management;

/**
 * @author JING
 * @Date 2018年6月16日
 * @description 栈内存溢出 VM args -Xss128k
 */
public class JavaVMStackSOF {

	private int stackLength = 1;
	
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Exception e) {
			System.out.println(oom.stackLength);
			throw e;
		}
	}

}
