import java.util.LinkedList;

public class Fork {
	private boolean isBusy;
	private int id;
    private LinkedList<Philosopher> waitList = new LinkedList<>();
	public Fork(int id){
		this.id = id;
		isBusy = false;
	}
	public void acquire(Philosopher id) {
        waitList.add(id);
        synchronized (id) {
            while (isBusy) {
                try {
                    id.wait();
                } catch (InterruptedException e) {
                    System.out.println("FAILED TO WAIT FOR FORK");
                }
            }
            if (!isBusy) {
                waitList.remove(id);
                isBusy = true;
            }
        }

    }

	
	public void release(){
        if (waitList.size() != 0){
            Philosopher id = waitList.pop();
            synchronized (id) {
                try {
                    id.notify();
                } catch (IllegalMonitorStateException e) {
                    System.out.println("FAILED TO NOTIFY");
                }
            }
        }
        isBusy = false;
    }
	

}
