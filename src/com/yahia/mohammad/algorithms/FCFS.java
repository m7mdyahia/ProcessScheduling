package com.yahia.mohammad.algorithms;

import com.yahia.mohammad.ProcessInstance;

import java.util.Comparator;
import java.util.PriorityQueue;

class FCFS extends schedulingAlgorithmTemplate
{
	@Override
	protected void setComparator() {
		ready_queue = new PriorityQueue<>(Comparator.comparingInt(ProcessInstance::getArrival));

	}

}
