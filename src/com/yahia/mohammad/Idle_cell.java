package com.yahia.mohammad;

public class Idle_cell extends Schedulcell
{
	public Idle_cell(int start_time, int end_time)
	{
		this.p = new ProcessInstance("**Idle**", end_time - start_time, start_time);
		this.start_time = start_time;
		this.end_time = end_time;
		turnaround=0;
		waiting=0;
		response=0;
	}


}
