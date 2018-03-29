package com.yahia.mohammad.algorithms;

import com.yahia.mohammad.ProcessInstance;

import java.util.Comparator;
import java.util.PriorityQueue;

class priortyschduling extends schedulingAlgorithmTemplate
{

	protected void setComparator() {
		ready_queue = new PriorityQueue<>((o1, o2) -> {
			int r = o1.getPriroty() - o2.getPriroty();
			if (r == 0) r = o1.getArrival() - o2.getArrival();//if the same priority then FCFS
			return r;
		});

	}

}
