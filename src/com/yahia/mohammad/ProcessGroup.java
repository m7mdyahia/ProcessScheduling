package com.yahia.mohammad;

import com.yahia.mohammad.algorithms.SchedulingAlgorithm;

import java.util.Collection;

public class ProcessGroup {
    private Collection<ProcessInstance> group;
    private SchedulingAlgorithm scheduler;
    private SchedulingResult result;


    public ProcessGroup(Collection<ProcessInstance> group,
                        SchedulingAlgorithm scheduler, boolean preemptive) {
        super();
        this.group = group;
        this.scheduler = scheduler;
        this.result = new SchedulingResult();
        if (!group.isEmpty()) scheduler.schedule(group, result, preemptive);
    }


//	public boolean add_process(processInstance p)
//	{
//		boolean r=group.add(p);
//		if (r==true) scheduler.schedule(group,result,preemptive);//I can't remember why i did that?
//		return r;
//	}

    public Collection<ProcessInstance> getGroup() {
        return group;
    }

    public void setGroup(Collection<ProcessInstance> group) {
        this.group = group;
    }

    public SchedulingAlgorithm getScheduler() {
        return scheduler;
    }

    public void setScheduler(SchedulingAlgorithm scheduler) {
        this.scheduler = scheduler;
    }


    public SchedulingResult getResult() {
        return result;
    }
}
