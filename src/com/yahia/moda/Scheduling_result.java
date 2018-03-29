/**
 * 
 */
package com.yahia.moda;

import java.util.Collection;

/**
 * @author Mohamed Yahia
 *
 */
public class Scheduling_result {
	
	Collection<Schedulcell> gant_chart;
	public boolean add(Schedulcell e)
	{
		return gant_chart.add(e);
	}
	
	public float avg_turnaround()
	{
		float avarage=0;
		
		for(Schedulcell s: gant_chart)
		{
			if(!s.is_preempted())
			
			avarage+=s.getTurnaround();
		}
		return avarage/gant_chart.size();
	}
	
	public float avg_Waiting()
	{
		float avarage=0;
		
		for(Schedulcell s: gant_chart)
		{
			if(!s.is_preempted())
			avarage+=s.getWaiting();
		}
		return avarage/gant_chart.size();
	}
	public float avg_Response()
	{
float avarage=0;
		
		for(Schedulcell s: gant_chart)
		{
			if(!s.is_preempted())
			avarage+=s.getResponse();
		}
		return avarage/gant_chart.size();
	}

	

	/**
	 * @return the gant_chart
	 */
	public Collection<Schedulcell> getGant_chart() {
		return gant_chart;
	}

	/**
	 * @param gant_chart the gant_chart to set
	 */
	public void setGant_chart(Collection<Schedulcell> gant_chart) {
		this.gant_chart = gant_chart;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  gant_chart.toString()
				+ "\n avg_turnaround()=" + avg_turnaround() + "\n avg_Waiting()="
				+ avg_Waiting() + "\n avg_Response()=" + avg_Response() ;
	}
}

class Schedulcell{
	
	public Schedulcell(Process_instance p, int start_time, int end_time,
			boolean preempted, int firist_start_time) {
		super();
		this.p = p;
		this.start_time = start_time;
		this.end_time = end_time;
		this.preempted = preempted;
		this.firist_start_time = firist_start_time;
		preempted=p.isPreempted();
		firist_start_time=start_time;
		turnaround=end_time-p.getArrival();
		waiting=end_time-p.getArrival()-p.getBurst();
		response=firist_start_time-p.getArrival();
	}


	Process_instance p;
	protected int start_time,end_time,firist_start_time ,turnaround,waiting,response;
	private boolean preempted,firist_ocuurence;
	
	boolean is_firist_ocuurence()
	{
		return firist_ocuurence;
	}
	boolean is_preempted()
	{
		return preempted;
	}
	
	public Schedulcell()
	{
		super();
		
	}
	
	
	
	
	public Schedulcell(Process_instance p, int start_time, int end_time) {
		super();
		this.p = p;
		this.start_time = start_time;
		
		this.end_time = end_time;
		preempted=p.isPreempted();
		firist_start_time=start_time;
		
		turnaround=end_time-p.getArrival();
		
		waiting=end_time-p.getArrival()-p.getBurst();
		
		response=start_time-p.getArrival();
	}
	
	
	/**
	 * @return the p
	 */
	public Process_instance getProcess() {
		return p;
	}
	/**
	 * @param p the p to set
	 */
	public void setProcess(Process_instance p) {
		this.p = p;
	}
	/**
	 * @return the start_time
	 */
	public int getStart_time() {
		return start_time;
	}
	/**
	 * @param start_time the start_time to set
	 */
	public void setStart_time(int start_time) {
		this.start_time = start_time;
	}
	/**
	 * @return the end_time
	 */
	public int getEnd_time() {
		return end_time;
	}
	/**
	 * @param end_time the end_time to set
	 */
	public void setEnd_time(int end_time) {
		this.end_time = end_time;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  "["+start_time+":"+p.getName() +":"+end_time+"]" ;
	}


	/**
	 * @return the turnaround
	 */
	public int getTurnaround() {
		return turnaround;
	}


	/**
	 * @return the waiting
	 */
	public int getWaiting() {
		return waiting;
	}


	/**
	 * @return the response
	 */
	public int getResponse() {
		return response;
	}
	
	
}

class Idle_cell extends Schedulcell
{
	Idle_cell(int start_time, int end_time)
	{
		this.p = new Process_instance("**Idle**", end_time - start_time, start_time);
		this.start_time = start_time;
		this.end_time = end_time;
		turnaround=0;
		waiting=0;
		response=0;
	}
	
	
}