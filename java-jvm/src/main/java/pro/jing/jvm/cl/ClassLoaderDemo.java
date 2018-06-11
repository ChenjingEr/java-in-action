package pro.jing.jvm.cl;

public class ClassLoaderDemo {

	public static void main(String[] args) {
		System.out.println("引导类加载器加载路径:" + System.getProperty("sun.boot.class.path"));
		System.out.println("扩展类加载器加载路径:" + System.getProperty("java.ext.dirs"));
		System.out.println("系统类加载器加载路径:" + System.getProperty("java.class.path"));
	}
}
