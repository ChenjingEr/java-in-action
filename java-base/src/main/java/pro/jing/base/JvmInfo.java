package pro.jing.base;

public class JvmInfo {

	public static void main(String[] args) {
		String version = System.getProperty("sun.arch.data.model");
		System.out.println(version);
		
		//memory info
		Runtime runtime = Runtime.getRuntime();
		System.out.println(runtime.maxMemory());
		System.out.println(runtime.freeMemory());
		System.out.println(runtime.totalMemory());
	}
}
