package com.example.visagca.realworld.sample;

//the Queue ID-Check simulation so it reports both the last person’s start time and finish time. This way, you can see either:
//Start time → when they begin the check
//Finish time → when they fully enter the secure area

import java.util.LinkedList;
import java.util.Queue;

public class QueueIDCheckDual {

    public void simulateQueue(int[] arrivals, int maxQueueLen) {
        Queue<Integer> queue = new LinkedList<>(); // store arrival times
        int currentTime = 0;
        int lastStartTime = 0;  // when last person starts check
        int lastFinishTime = 0; // when last person finishes
        int index = 0;

        System.out.println("Simulation Start");
        System.out.println("================");

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
                System.out.printf("Time %d: START check for Person%d (arrived at %d)\n",
                        currentTime, index, arrivalTime);

                lastStartTime = currentTime;
                currentTime += 5; // check duration
                System.out.printf("Time %d: FINISH check for Person%d (arrived at %d)\n",
                        currentTime, index, arrivalTime);

                lastFinishTime = currentTime;
            } else {
                // Jump to next arrival if queue empty
                if (index < arrivals.length) {
                    System.out.printf("Time %d: No one in queue, jump to time %d (next arrival)\n",
                            currentTime, arrivals[index]);
                    currentTime = arrivals[index];
                }
            }
        }

        System.out.println("================");
        System.out.printf("Last person STARTED check at: %d minutes\n", lastStartTime);
        System.out.printf("Last person FINISHED check at: %d minutes\n", lastFinishTime);
    }

    public static void main(String[] args) {
        QueueIDCheckDual sim = new QueueIDCheckDual();

        int[] arrivals1 = {0, 0, 3, 5, 9, 10};
        System.out.println("Test Case 1:");
        sim.simulateQueue(arrivals1, 3);

        System.out.println("\n--- Another Test ---\n");

        int[] arrivals2 = {0, 1, 1, 1, 6};
        System.out.println("Test Case 2:");
        sim.simulateQueue(arrivals2, 2);
    }
}
