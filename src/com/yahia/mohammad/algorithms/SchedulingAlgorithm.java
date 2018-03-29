/**
 *
 */
package com.yahia.mohammad.algorithms;

import com.yahia.mohammad.ProcessInstance;
import com.yahia.mohammad.SchedulingResult;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Mohamed
 */
public interface SchedulingAlgorithm {

    void schedule(Collection<ProcessInstance> group, SchedulingResult result, boolean is_preemptive);

}

