package com.yahia.mohammad.algorithms;

import com.yahia.mohammad.ProcessInstance;

import java.util.Comparator;
import java.util.PriorityQueue;

class Priorty_schduling extends schedulingAlgorithmTemplate
{

	protected void set_Comparator() {
		ready_queue = new PriorityQueue<ProcessInstance>(new Comparator<ProcessInstance>()
		{
			@Override
			public int compare(ProcessInstance o1, ProcessInstance o2) {

				int r=o1.getPriroty()-o2.getPriroty();
				if (r==0) r=o1.getArrival()-o2.getArrival() ;//if the same priority then FCFS
				return r;
			}

		});

	}

}
