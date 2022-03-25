public class DiningPhilosophers {

    public static void main(String[] args) throws Exception {

        final Philosopher[] philosophers = new Philosopher[5];
        Object[] chopsticks = new Object[philosophers.length];

        for (int i = 0; i < chopsticks.length; i++) {
            chopsticks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {
            Object rightChopstick = chopsticks[i];
            Object leftChopstick = chopsticks[(i + 1) % chopsticks.length];

            if (i == philosophers.length - 1) {

                // The last philosopher picks up the left chopstick first
                philosophers[i] = new Philosopher(leftChopstick, rightChopstick);
            } else {
                philosophers[i] = new Philosopher(rightChopstick, leftChopstick);
            }

            Thread t
                    = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}
