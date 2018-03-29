package com.yahia.mohammad.algorithms;

import com.yahia.mohammad.ProcessInstance;
import com.yahia.mohammad.SchedulingResult;

import java.util.Collection;
import java.util.LinkedList;

public class RoundRobin extends schedulingAlgorithmBase
{
	RoundRobin()
	{
		super();
		q=3;
	}

	public RoundRobin(int quantum)
	{
		super();
		q=quantum;
	}
	@Override
	protected void setComparator() {
		ready_queue = new LinkedList<>();
		q=3;
	}

	public void schedule(Collection<ProcessInstance> group, SchedulingResult result, int quantum)
	{
		q=quantum;
		super.schedule(group, true);

	}


}
