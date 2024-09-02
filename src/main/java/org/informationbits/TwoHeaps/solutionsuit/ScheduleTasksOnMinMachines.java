package org.informationbits.TwoHeaps.solutionsuit;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Similar Questions -
 * https://medium.com/data-structures-and-algorithms-dsa/schedule-tasks-on-minimum-machines-0d367e8000b2
 **/


public class ScheduleTasksOnMinMachines {
    public static int tasks(List<List<Integer>> tasksList) {
        PriorityQueue<Integer> machines = new PriorityQueue<Integer>();
        Collections.sort(tasksList, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });

        for (List<Integer> task : tasksList) {
            assert (task.size() == 2);
            int taskStartTime = task.get(0);
            int taskEndTime = task.get(1);
            if (machines.size() > 0 && machines.peek() <= taskStartTime) {
                machines.poll();
            }
            machines.add(taskEndTime);
        }
        return machines.size();
    }
}
