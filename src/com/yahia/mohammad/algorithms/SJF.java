package com.yahia.mohammad.algorithms;

import com.yahia.mohammad.ProcessInstance;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Mohamed
 * Shortest job first scheduling
 */
class SJF extends schedulingAlgorithmBase
{

	protected void setComparator() {
		ready_queue = new PriorityQueue<>(Comparator.comparingInt(ProcessInstance::getBurst));

	}

}
