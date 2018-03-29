/**
 * 
 */
package com.yahia.moda;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Mohamed
 *
 */
interface Scheduling_algorithm {
	
	public void schedule(Collection<Process_instance> group, Scheduling_result result,boolean is_preemptive);

}

abstract class Scheduling_algorithm_template implements Scheduling_algorithm {

	Queue<Process_instance> ready_queue;
	protected int q=1;
	@Override
	public void schedule(Collection<Process_instance> group, Scheduling_result result,boolean is_preemptive) {
		
		set_Comparator();
		
		PriorityQueue<Process_instance> scenario =new PriorityQueue<Process_instance>(new Comparator<Process_instance> ()
		{
			@Override
			public int compare(Process_instance o1, Process_instance o2)
			{
				return o1.getArrival()-o2.getArrival();
			}
		});
		
		scenario.addAll(group);

		result.setGant_chart(new LinkedList<Schedulcell>());
		
		Process_instance p1,last_worked=new Process_instance("nothing", -1, 0);
		int time = 0;
		while( (!scenario.isEmpty ())||(!ready_queue.isEmpty()))//iteration over time
		{			
			p1 = scenario.peek();
			while (p1!=null)
			{			
				if(p1.getArrival()<=time)
				{
					ready_queue.add(p1);
					scenario.poll();
				}
				else
				{
					break;//all the arrived processes were added to the ready queue
				}
				
				p1 = scenario.peek();
			} 
			
			if(!ready_queue.isEmpty())
			{
				if(!is_preemptive)
				{
					Process_instance p = ready_queue.poll();
					result.add(new Schedulcell(p,time,p.getBurst()+time));
					time+=p.getBurst();
				}
				else// Preemptive
				{
					Process_instance p = ready_queue.poll();
					
					if(p.isPreempted())
					{
						p.setLatest_start(time);
						
					}
					
					if(last_worked!=p && last_worked.getName()!="nothing")//context switching
					{
						if(last_worked.getBurst()==0)
						{
							result.add(new Schedulcell(last_worked,last_worked.getLatest_start(),time,false,0));
							last_worked.setPreempted(false);
						}
						else
						{
							result.add(new Schedulcell(last_worked,last_worked.getLatest_start(),time,true,0));
							last_worked.setPreempted(true);
						}
						
					}
					else if(last_worked.getName()!="nothing")
					{
						p.setPreempted(false);
						
					}
								
				
				
				p.setBurst(p.getBurst()-q);
				if(p.getBurst()>0)
				{
					ready_queue.add(p);
					p.setPreempted(false);
				}
				
				if (p.isFirist_time())
				{
					p.set_firist_start(time);
				}
				time=time+q;
				p.firist_time=false;
				last_worked=p;
				}
			}
			
			
			
			
			else//the ready queue is empty = the processor is idle
			{
				if(!is_preemptive)
				{
				result.add(new Idle_cell(time, p1.getArrival()));
				time=p1.getArrival();//Optimization if the whole scenario is previously known
				}
				else
				{
					result.add(new Schedulcell(last_worked,last_worked.getLatest_start(),time,false,0));
					last_worked.setPreempted(false);
					last_worked= new Process_instance("nothing", time, 0);
					result.add(new Idle_cell(time, p1.getArrival()));
					time+=q;
				}
			
				
			}
		}
		if(is_preemptive)
		{
			result.add(new Schedulcell(last_worked,last_worked.getLatest_start(),time,false,0));
			last_worked.setPreempted(false);
		}
	
	}
	
	protected abstract  void set_Comparator();
	
	
}

class FCFS extends Scheduling_algorithm_template
{
	@Override
	protected void set_Comparator() {
		ready_queue = new PriorityQueue<Process_instance>(new Comparator<Process_instance> ()
		{
			@Override
			public int compare(Process_instance o1, Process_instance o2) {

				return o1.getArrival()-o2.getArrival();
			}
		});
		
	}
	
}

/**
 * @author Mohamed
 * Shortest job first scheduling
 */
class SJF extends Scheduling_algorithm_template
{
	
	protected void set_Comparator() {
		ready_queue = new PriorityQueue<Process_instance>(new Comparator<Process_instance> ()
		{
			@Override
			public int compare(Process_instance o1, Process_instance o2) {

				return o1.getBurst()-o2.getBurst();
			}

		});
		
	}
	
}

class Priorty_schduling extends Scheduling_algorithm_template
{
	
	protected void set_Comparator() {
		ready_queue = new PriorityQueue<Process_instance>(new Comparator<Process_instance> ()
		{
			@Override
			public int compare(Process_instance o1, Process_instance o2) {
				
				int r=o1.getPriroty()-o2.getPriroty();
				if (r==0) r=o1.getArrival()-o2.getArrival() ;//if the same priority then FCFS
				return r; 
			}

		});
		
	}
	
}

class RoundRobin extends Scheduling_algorithm_template
{
	RoundRobin()
	{
		super();
		q=3;
	}
	
	RoundRobin(int quantum)
	{
		super();
		q=quantum;
	}
	@Override
	protected void set_Comparator() {
		ready_queue = new LinkedList<Process_instance>();
		q=3;
	}

	public void schedule(Collection<Process_instance> group, Scheduling_result result,int quantum)
	{
		q=quantum;
		super.schedule(group, result, true);
		
	}
	
	
}