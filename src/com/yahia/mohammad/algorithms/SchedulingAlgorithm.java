/**
 *
 */
package com.yahia.mohammad.algorithms;

import com.yahia.mohammad.ProcessInstance;
import com.yahia.mohammad.SchedulingResult;

import javax.naming.directory.SearchResult;
import java.util.Collection;

/**
 * @author Mohamed
 */
public interface SchedulingAlgorithm {

    SchedulingResult schedule(Collection<ProcessInstance> group, boolean is_preemptive);

}

