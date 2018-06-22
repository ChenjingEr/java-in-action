package pro.jing.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentPerformanceTestTool extends ThreadPoolExecutor {


	private AtomicInteger count = new AtomicInteger(0); // 统计执行的次数
	public long startTime = 0;
	public String funcname = "";
	public Integer taskCount;

	public ConcurrentPerformanceTestTool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	public void setPerformanceIndicators(long startTime, String funcname, int taskCount) {
		this.startTime = startTime;
		this.funcname = funcname;
		this.taskCount = taskCount;
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		int l = count.addAndGet(1);
		if (l == taskCount) {
			System.out.println(funcname + " spend time : " + (System.currentTimeMillis() - startTime));
		}
	}

}
