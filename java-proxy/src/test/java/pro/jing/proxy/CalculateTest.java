package pro.jing.proxy;

import java.lang.reflect.Proxy;

import org.junit.Test;

import pro.jing.proxy.jdk.Calculator;
import pro.jing.proxy.jdk.ICalculator;
import pro.jing.proxy.jdk.LogHandler;

public class CalculateTest {

	@Test
	public void testCalculate() {
		Calculator cal = new Calculator();
		LogHandler handler = new LogHandler(cal);
		ICalculator proxy = (ICalculator) Proxy.newProxyInstance(Calculator.class.getClassLoader(), cal.getClass().getInterfaces(), handler);
		proxy.add(1, 1);
		proxy.sub(3, 2);
		proxy.div(2, 1);
		proxy.mul(3, 2);
	}
}
