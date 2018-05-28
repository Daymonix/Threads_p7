import java.util.concurrent.locks.ReentrantLock;

public class ThreadGenerator {
	
	int current = 0;
	int fact = 0;
	int factPow = 0;
	
	boolean complete = false;
	boolean totalComplete = false;
	
	int rs = 0;
	
	public ThreadGenerator(int targ, int threads, int op) throws InterruptedException {
		targ = 2 * targ + 1;
		
		if(targ >= 0) {
			execute(targ, threads, op);
			while(!complete) {
				Thread.sleep(10);
			}
			complete = false;
			targ = fact;
			fact = 0;
			current = 0;
			factPow++;
			execute(targ, threads, op);
			
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public Pair<Integer, Integer> getResult() throws InterruptedException {
		while(!totalComplete) {
			Thread.sleep(10);
		}
		return new Pair<Integer, Integer>(fact, rs);
	}
	
	void execute(int targ, int threads, int op) {
		ReentrantLock lock = new ReentrantLock();
		try {
			for(int t = 0; t < threads; t++) {
				new Thread(
						new Runnable() {
							
							@Override
							public void run() {
								try {
									while(!complete) {
										lock.lock();
										Thread.sleep(5);
										if(current < targ) {
											current++;
											fact += current;
											if(op == 1) {
												rs += fact;
											}
											if(op == 2) {
												rs -= fact;
											}
											if(op == 3) {
												if(rs == 0) {
													rs = 1;
												}
												rs *= fact;
											}
										} else {
											complete = true;
											if(factPow > 0) {
												totalComplete = complete;
											}
										}
										lock.unlock();
									}
									
								} catch (Exception e) {
									System.out.println("Run error: " + e.getMessage());
								} finally {
//									lock.unlock();
								}
							}
						}).start();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
