package pro.jing.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler{
	
	private Object subject;
	
	public LogHandler(Object subject) {
		this.subject = subject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("before invoke");
		Object obj = method.invoke(subject, args);
		System.out.println("after invoke");
		
		return obj;
	}
	
	

}
