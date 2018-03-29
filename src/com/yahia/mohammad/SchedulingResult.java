/**
 *
 */
package com.yahia.mohammad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * @author Mohamed Yahia
 */
public class SchedulingResult {
    public SchedulingResult(Collection<Schedulcell> gant_chart) {
        this.gant_chart = gant_chart;
    }

    public SchedulingResult() {
        gant_chart = new LinkedList<>();
    }

    private Collection<Schedulcell> gant_chart;

    public void add(Schedulcell e) {
        gant_chart.add(e);
    }

    private float avg_turnaround() {
        float avarage = 0;

        for (Schedulcell s : gant_chart) {
            if (!s.is_preempted())

                avarage += s.getTurnaround();
        }
        return avarage / gant_chart.size();
    }

    private float avg_Waiting() {
        float avarage = 0;

        for (Schedulcell s : gant_chart) {
            if (!s.is_preempted())
                avarage += s.getWaiting();
        }
        return avarage / gant_chart.size();
    }

    private float avg_Response() {
        float avarage = 0;

        for (Schedulcell s : gant_chart) {
            if (!s.is_preempted())
                avarage += s.getResponse();
        }
        return avarage / gant_chart.size();
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
        return gant_chart.toString()
                + "\n avg_turnaround()=" + avg_turnaround() + "\n avg_Waiting()="
                + avg_Waiting() + "\n avg_Response()=" + avg_Response();
    }
}

