public class Philosopher implements Runnable {

    //Chopsticks on the table placed on each side of the philosophers

    private Object rightChopstick;
    private Object leftChopstick;


    //Each philosopher has the access to both a left and a right chopstick.

    public Philosopher(Object rightChopstick, Object leftChopstick){
        this.rightChopstick = rightChopstick;
        this.leftChopstick = leftChopstick;
    }

    @Override
    public void run() {

    }
}
