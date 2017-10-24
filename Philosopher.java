
public class Philosopher extends Thread {
	int id;
	Fork left;
	Fork right;
	boolean rHanded;
	int nTimes;
	long thinkMillis;
	long eatMillis;
	
	public Philosopher(int id, Fork left, Fork right, boolean rHanded,
            int nTimes, long thinkMillis, long eatMillis){
		this.id = id;
		this.left = left;
		this.right = right;
		this.rHanded = rHanded;
		this.nTimes = nTimes;
		this.thinkMillis = thinkMillis;
		this.eatMillis = eatMillis;
		start();
	}
	
	public void run(){
		for(int i = 0; i<nTimes || nTimes == 0; i+= 1){
			int thinkTime = (int) (Math.random() * thinkMillis + 1);
			//System.out.println("Philosopher " + id + " thinks for " + thinkTime + " time units.");
			try {
				Thread.sleep(thinkTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (rHanded){
				System.out.println("Philosopher " + id + " goes for right fork");
				right.acquire(this);
				System.out.println("Philosopher " + id + " has right fork.");
				Thread.yield();
				System.out.println("Philosopher " + id + " goes for left fork");
				left.acquire(this);
				System.out.println("Philosopher " + id + " has left fork.");
				Thread.yield();
			}
			if (!rHanded){
				System.out.println("Philosopher " + id + " goes for left fork");
				left.acquire(this);
				System.out.println("Philosopher " + id + " has left fork.");
				Thread.yield();
				System.out.println("Philosopher " + id + " goes for right fork");
				right.acquire(this);
				System.out.println("Philosopher " + id + " has right fork.");
				Thread.yield();
			}
			int eatTime = (int) (Math.random() * eatMillis + 1);
			System.out.println("Philosopher " + id + " eats for " + eatTime + " time units.");
			right.release();
			System.out.println("Philosopher " + id + " releases right fork.");
			left.release();
			System.out.println("Philosopher " + id + " releases left fork.");
		}
		System.out.println("Philosopher " + id + " is done eating!");
		
	}
	
}
