package com.example.visagca.realworld.sample;


import java.util.LinkedList;
import java.util.Queue;

public class QueueIDCheck {

    public int lastPersonEntryTime(int[] arrivals, int maxQueueLen) {
        Queue<Integer> queue = new LinkedList<>(); // store arrival times
        int currentTime = 0;  // simulation clock
        int lastEntryTime = 0; // last finish time
        int index = 0; // next arrival index

        System.out.println("Simulation Start");
        System.out.println("================");

        // Loop until all processed
        while (index < arrivals.length || !queue.isEmpty()) {

            // Add people who have arrived and queue has space
            while (index < arrivals.length &&
                   arrivals[index] <= currentTime &&
                   queue.size() < maxQueueLen) {
                queue.offer(arrivals[index]);
                System.out.printf("Time %d: Person%d ARRIVES and JOINS queue (queue size=%d)\n",
                        arrivals[index], index + 1, queue.size());
                index++;
            }

            // Process one person if available
            if (!queue.isEmpty()) {
                int arrivalTime = queue.poll();
                System.out.printf("Time %d: START check for person (arrived at %d)\n",
                        currentTime, arrivalTime);

                currentTime += 5; // takes 5 min
                System.out.printf("Time %d: FINISH check for person (arrived at %d)\n",
                        currentTime, arrivalTime);

                lastEntryTime = currentTime;
            } else {
                // If queue empty, jump to next arrival
                if (index < arrivals.length) {
                    System.out.printf("Time %d: No one in queue, jump to time %d (next arrival)\n",
                            currentTime, arrivals[index]);
                    currentTime = arrivals[index];
                }
            }
        }

        System.out.println("================");
        System.out.printf("Last person entered at time %d minutes\n", lastEntryTime);
        return lastEntryTime;
    }

    // Test the debug version
    public static void main(String[] args) {
    	QueueIDCheck sim = new QueueIDCheck();

        int[] arrivals1 = {0, 0, 3, 5, 9, 10};
        sim.lastPersonEntryTime(arrivals1, 3);

        System.out.println("\n--- Another Test ---\n");

        int[] arrivals2 = {0, 1, 1, 1, 6};
        sim.lastPersonEntryTime(arrivals2, 2);
    }
}
