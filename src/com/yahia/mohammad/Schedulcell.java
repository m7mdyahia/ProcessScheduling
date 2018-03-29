package com.yahia.mohammad;

public class Schedulcell{

	public Schedulcell(ProcessInstance p, int start_time, int end_time,
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


	ProcessInstance p;
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




	public Schedulcell(ProcessInstance p, int start_time, int end_time) {
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
	public ProcessInstance getProcess() {
		return p;
	}
	/**
	 * @param p the p to set
	 */
	public void setProcess(ProcessInstance p) {
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
