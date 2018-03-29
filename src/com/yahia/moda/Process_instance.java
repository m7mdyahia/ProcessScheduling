package com.yahia.moda;
/**
 * 
 */

/**
 * @author Mohamed
 *
 */
public class Process_instance {

	Process_instance(String name, int arrival, int burst, int priroty) {
		super();
		this.name = name;
		this.burst = burst;
		this.priroty = priroty;
		this.arrival = arrival;
		this.firist_start=0;
		
		preempted=true;
	}
	public Process_instance(String name, int arrival ,int burst) {
		super();
		this.name = name;
		this.burst = burst;
		this.priroty = 0;
		this.arrival = arrival;
		this.firist_start=0;
		preempted=true;
		firist_time=true;
	}
	
	private String name;
	private int burst;
	private int priroty;
	private int arrival;
	private int firist_start;
	private int latest_start;
	private boolean preempted=true;
	boolean firist_time=true;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the burst
	 */
	public int getBurst() {
		return burst;
	}
	/**
	 * @param burst the burst to set
	 */
	public void setBurst(int burst) {
		this.burst = burst;
	}
	/**
	 * @return the priroty
	 */
	public int getPriroty() {
		return priroty;
	}
	/**
	 * @param priroty the priroty to set
	 */
	public void setPriroty(int priroty) {
		this.priroty = priroty;
	}
	/**
	 * @return the arrival
	 */
	public int getArrival() {
		return arrival;
	}
	/**
	 * @param arrival the arrival to set
	 */
	public void setArrival(int arrival) {
		this.arrival = arrival;
	}
	/**
	 * @return the remaining_time
	 */
	public int get_firist_start() {
		return firist_start;
	}
	/**
	 * @param remaining_time the remaining_time to set
	 */
	public void set_firist_start(int remaining_time) {
		this.firist_start = remaining_time;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Process_instance [name=" + name + ", burst=" + burst
				+ ", priroty=" + priroty + ", arrival=" + arrival
				+ ", remaining_time=" + firist_start + "]";
	}
	/**
	 * @return the latest_start
	 */
	public int getLatest_start() {
		return latest_start;
	}
	/**
	 * @param latest_start the latest_start to set
	 */
	public void setLatest_start(int latest_start) {
		this.latest_start = latest_start;
	}
	/**
	 * @return the preempted
	 */
	public boolean isPreempted() {
		return preempted;
	}
	/**
	 * @param preempted the preempted to set
	 */
	public void setPreempted(boolean preempted) {
		this.preempted = preempted;
	}
	/**
	 * @return the firist_start
	 */
	public int getFirist_start() {
		return firist_start;
	}
	/**
	 * @param firist_start the firist_start to set
	 */
	public void setFirist_start(int firist_start) {
		this.firist_start = firist_start;
	}
	/**
	 * @return the firist_time
	 */
	public boolean isFirist_time() {
		return firist_time;
	}
	/**
	 * @param firist_time the firist_time to set
	 */
	public void setFirist_time(boolean firist_time) {
		this.firist_time = firist_time;
	}

}

 