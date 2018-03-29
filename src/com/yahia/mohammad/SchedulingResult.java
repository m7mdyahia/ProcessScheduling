/**
 *
 */
package com.yahia.mohammad;

import java.util.Collection;

/**
 * @author Mohamed Yahia
 */
public class SchedulingResult {

    Collection<Schedulcell> gant_chart;

    public boolean add(Schedulcell e) {
        return gant_chart.add(e);
    }

    public float avg_turnaround() {
        float avarage = 0;

        for (Schedulcell s : gant_chart) {
            if (!s.is_preempted())

                avarage += s.getTurnaround();
        }
        return avarage / gant_chart.size();
    }

    public float avg_Waiting() {
        float avarage = 0;

        for (Schedulcell s : gant_chart) {
            if (!s.is_preempted())
                avarage += s.getWaiting();
        }
        return avarage / gant_chart.size();
    }

    public float avg_Response() {
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

