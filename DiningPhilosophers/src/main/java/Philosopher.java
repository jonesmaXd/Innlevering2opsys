public class Philosopher implements Runnable {


    // Chopsticks on the table placed on each side of the philosophers

    private Object rightChopstick;
    private Object leftChopstick;



    // Each philosopher has the access to both a left and a right chopstick.

    public Philosopher(Object rightChopstick, Object leftChopstick){
        this.rightChopstick = rightChopstick;
        this.leftChopstick = leftChopstick;
    }


    // Method "performAction()" should instruct Philosopher to perform a action,
    // this being eat, think and grab chopsticks this displayed in the run() method.

    private void performAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }


    // run() method represent the logic of a Philosopher, using the java keyword "synchronized"
    // to let multiple Philosopher threads acquire objects at the same time.
    // the thought is to first have a philosopher think, and then decide to pick up chopsticks
    // and eat before putting them back down.

    @Override
    public void run() {
        try {
            while (true){
                        performAction(System.nanoTime() + ": Thinks");
                    synchronized (rightChopstick) {
                        performAction(System.nanoTime() + ": Pick up right chopstick");
                    synchronized (leftChopstick) {
                        performAction(System.nanoTime() + ": Pick up left chopstick and start eating");
                        performAction(System.nanoTime() + ": Put down left chopstick");
                    }

            performAction(System.nanoTime() + ": Put down right chopstick and go back to thinking");
            }
        }

    } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
}
}
