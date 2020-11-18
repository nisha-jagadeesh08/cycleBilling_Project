package com.PriceEngine.ThreadImplementation;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static int MAX_CYCLE_COUNT = 1000;  //number of cycles for which price has to be calculated
    private static final int NO_OF_THREADS = 10;

    public static void main(String args[]) {
        final ArrayBlockingQueue<Object[]> queue = new ArrayBlockingQueue<>(MAX_CYCLE_COUNT+1);

        //Fixed Thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(NO_OF_THREADS);

        MyProducer producer = new MyProducer(queue, MAX_CYCLE_COUNT, ThreadColor.ANSI_CYAN);
        MyConsumer consumer1 = new MyConsumer(queue, MAX_CYCLE_COUNT,ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(queue, MAX_CYCLE_COUNT,ThreadColor.ANSI_YELLOW);

        //Execute threads
        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        //terminate
        executorService.shutdown();
    }
}

/*
    Definition: Produces input for given number of cycle with random configurations,
                adds them to queue
 */
class MyProducer implements Runnable{

    private ArrayBlockingQueue<Object[]> queue;
    private String color;
    private static int MAX_CYCLE_COUNT;
    int i;
    ArrayList<String> availableFrameMaterial = new ArrayList<String>();
    ArrayList<String> availableSeatingType = new ArrayList<String>();
    ArrayList<String> availableHandleBarType = new ArrayList<String>();
    ArrayList<String> availableTyreType = new ArrayList<String>();

    public MyProducer(ArrayBlockingQueue<Object[]> queue, int MAX_CYCLE_COUNT, String color) {
        this.queue = queue;
        this.MAX_CYCLE_COUNT = MAX_CYCLE_COUNT;
        this.color = color;
        addAvailableConfig();
    }

    public void run(){
        Random random = new Random();

        try{
            for(i=1;i<=MAX_CYCLE_COUNT;i++) {
                //Object[] input = {i,"2014-02-14","Steel","Racing saddles","Flat Bars",4,"Tubeless"};

                Object[] config = {i, "2014-02-14",
                        availableFrameMaterial.get(random.nextInt(availableFrameMaterial.size())),
                        availableSeatingType.get(random.nextInt(availableSeatingType.size())),
                                availableHandleBarType.get(random.nextInt(availableHandleBarType.size())),
                                        random.nextInt(10)+1,
                                        availableTyreType.get(random.nextInt(availableTyreType.size()))
                                };

                System.out.println(color + Thread.currentThread().getName()+ " Running: Adding configuration for Cycle "+i);
                queue.put(config);
                Thread.sleep(random.nextInt(1500));
            }

        }catch(InterruptedException e){
            System.out.println("Producer was interrupted");
        }
        System.out.println(color + Thread.currentThread().getName()+ " Running: Adding EOF and Exiting");
        try {
            Object[] EOF = {MAX_CYCLE_COUNT+1,"EOF"};
            queue.put(EOF);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //adding available configurations
    public void addAvailableConfig(){
        availableFrameMaterial.add("steel");
        availableFrameMaterial.add("aluminium");
        availableSeatingType.add("racing saddles");
        availableSeatingType.add("comfort saddles");
        availableHandleBarType.add("flat bars");
        availableHandleBarType.add("riser bars");
        availableHandleBarType.add("drop bars");
        availableTyreType.add("tubeless");
        availableTyreType.add("tubed");
    }
}


/*
    Definition: Dequeue and calculate price of given configuration
 */
class MyConsumer implements Runnable {
    private ArrayBlockingQueue<Object[]> queue;
    private static int MAX_CYCLE_COUNT;
    private String color;
    private static int currCycle;
    private Object[] currQueue;

    public CycleThreadImpl cycleThreadImpl = new CycleThreadImpl();

    public MyConsumer(ArrayBlockingQueue<Object[]> queue, int MAX_CYCLE_COUNT, String color) {
        this.queue = queue;
        this.MAX_CYCLE_COUNT = MAX_CYCLE_COUNT;
        this.color = color;
    }

    public void run() {

        while (true) {
            synchronized (queue) {
                if (queue.isEmpty()) {
                    continue;
                }
                //System.out.println(color +Thread.currentThread().getName()+ ": In consumer ");

                try {
                    currQueue = queue.peek();
                    currCycle = (int) currQueue[0];

                    if (currCycle > MAX_CYCLE_COUNT) {
                        System.out.println(color+Thread.currentThread().getName()+ " Running: Exiting ");
                        break;
                    } else {

                        cycleThreadImpl.calculateCyclePrice("Cycle "+currCycle, String.valueOf(currQueue[1]),
                                String.valueOf(currQueue[2]), String.valueOf(currQueue[3]), String.valueOf(currQueue[4]),
                                (int) currQueue[5],String.valueOf(currQueue[6]),color);

                        queue.take();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

