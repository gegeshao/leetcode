package homework.taxibilling.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TraceThreadPoolExecutor extends ThreadPoolExecutor{

	public TraceThreadPoolExecutor(int corePoolSize,int maxmumPollSize,long keepAliveTime,TimeUnit unit,BlockingQueue<Runnable> workQueue){
		super(corePoolSize, maxmumPollSize, keepAliveTime, unit, workQueue);
	}
	
	private Exception clientTrace(){
		return new Exception("client stack trace");
	}
	
	@Override
	public void execute(Runnable task) {
		super.execute(wrap(task, clientTrace(), Thread.currentThread().getName()));
	}
	
	@Override
	public  Future<?> submit(Runnable task) {
	
		return super.submit(wrap(task, clientTrace(), Thread.currentThread().getName()));
	}
	
	private Runnable wrap(final Runnable task,final Exception clientStack,String clientTreadName){
		return new Runnable() {
			
			public void run() {
				try {
					task.run();
				} catch (Exception e) {
					clientStack.printStackTrace();
					try {
						throw e;
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				
			}
		};
	}
	
}
