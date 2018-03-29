package com.yahia.moda;
import java.util.Collection;


/**
 * 
 */

/**
 * @author Mohamed
 *
 */
public class Process_group {
	private Collection<Process_instance> group;
	private Scheduling_algorithm scheduler;
	private Scheduling_result result;
	
	
	public Process_group(Collection<Process_instance> group,
			Scheduling_algorithm scheduler, Scheduling_result result,boolean preemptive) {
		super();
		this.group = group;
		this.scheduler = scheduler;
		this.result = result;
		if (!group.isEmpty()) scheduler.schedule(group,result,preemptive);
	}


	
	
//	public boolean add_process(Process_instance p)
//	{
//		boolean r=group.add(p);
//		if (r==true) scheduler.schedule(group,result,preemptive);//I can't remember why i did that?
//		return r;
//	}
		
	public Collection<Process_instance> getGroup() {
		return group;
	}

	public void setGroup(Collection<Process_instance> group) {
		this.group = group;
	}
	
	public Scheduling_algorithm getScheduler() {
		return scheduler;
	}
	
	public void setScheduler(Scheduling_algorithm scheduler) {
		this.scheduler = scheduler;
	}

	
}
