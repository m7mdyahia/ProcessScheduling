package com.yahia.mohammad.algorithms;

import com.yahia.mohammad.ProcessInstance;

import java.util.Comparator;
import java.util.PriorityQueue;

class FCFS extends schedulingAlgorithmTemplate
{
	@Override
	protected void set_Comparator() {
		ready_queue = new PriorityQueue<ProcessInstance>(new Comparator<ProcessInstance>()
		{
			@Override
			public int compare(ProcessInstance o1, ProcessInstance o2) {

				return o1.getArrival()-o2.getArrival();
			}
		});

	}

}
