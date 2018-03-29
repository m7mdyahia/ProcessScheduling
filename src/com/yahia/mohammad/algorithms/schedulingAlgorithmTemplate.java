package com.yahia.mohammad.algorithms;

import com.yahia.mohammad.*;

import java.util.*;

abstract class schedulingAlgorithmTemplate implements SchedulingAlgorithm {

    Queue<ProcessInstance> ready_queue;
    protected int q = 1;

    @Override
    public SchedulingResult schedule(Collection<ProcessInstance> group, boolean is_preemptive) {
        setComparator();
        PriorityQueue<ProcessInstance> scenario = new PriorityQueue<>(Comparator.comparingInt(ProcessInstance::getArrival));
        scenario.addAll(group);
        SchedulingResult result = new SchedulingResult();
        ProcessInstance p1;
        ProcessInstance lastWorked = new ProcessInstance("nothing", -1, 0);
        int time = 0;
        while ((!scenario.isEmpty()) || (!ready_queue.isEmpty()))//iteration over time
        {
            p1 = scenario.peek();
            while (p1 != null) {
                if (p1.getArrival() <= time) {
                    ready_queue.add(p1);
                    scenario.poll();
                } else {
                    break;//all the arrived processes were added to the ready queue
                }
                p1 = scenario.peek();
            }

            if (!ready_queue.isEmpty()) {
                if (!is_preemptive) {
                    ProcessInstance p = ready_queue.poll();
                    result.add(new Schedulcell(p, time, p.getBurst() + time));
                    time += p.getBurst();
                } else// Preemptive
                {
                    ProcessInstance p = ready_queue.poll();
                    if (p.isPreempted()) {
                        p.setLatestStart(time);
                    }
                    if (lastWorked != p && !lastWorked.getName().equals("nothing"))//context switching
                    {
                        if (lastWorked.getBurst() == 0) {
                            result.add(new Schedulcell(lastWorked, lastWorked.getLatest_start(), time, false, 0));
                            lastWorked.setPreempted(false);
                        } else {
                            result.add(new Schedulcell(lastWorked, lastWorked.getLatest_start(), time, true, 0));
                            lastWorked.setPreempted(true);
                        }
                    } else if (!lastWorked.getName().equals("nothing")) {
                        p.setPreempted(false);
                    }
                    p.setBurst(p.getBurst() - q);
                    if (p.getBurst() > 0) {
                        ready_queue.add(p);
                        p.setPreempted(false);
                    }
                    if (p.isFirist_time()) {
                        p.set_firist_start(time);
                    }
                    time = time + q;
                    p.setFiristTime(false);
                    lastWorked = p;
                }
            } else//the ready queue is empty = the processor is idle
            {
                if (!is_preemptive) {
                    result.add(new Idle_cell(time, p1.getArrival()));
                    time = p1.getArrival();//Optimization if the whole scenario is previously known
                } else {
                    result.add(new Schedulcell(lastWorked, lastWorked.getLatest_start(), time, false, 0));
                    lastWorked.setPreempted(false);
                    lastWorked = new ProcessInstance("nothing", time, 0);
                    result.add(new Idle_cell(time, p1.getArrival()));
                    time += q;
                }


            }
        }
        if (is_preemptive) {
            result.add(new Schedulcell(lastWorked, lastWorked.getLatest_start(), time, false, 0));
            lastWorked.setPreempted(false);
        }
        return result;
    }

    protected abstract void setComparator();


}
