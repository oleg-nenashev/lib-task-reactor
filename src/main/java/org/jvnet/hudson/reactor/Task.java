package org.jvnet.hudson.reactor;

import java.util.Collection;

/**
 * One initialization task
 *
 * @author Kohsuke Kawaguchi
 */
public interface Task extends Runnable {
    /**
     * Indicates the milestones necessary before executing this.
     */
    Collection<?> requires();

    /**
     * Indicates the milestones that this initializer contributes.
     *
     * A milestone is considered attained if all the initializers that attains the given milestone
     * completes. So it works as a kind of join.
     */
    Collection<?> attains();

    /**
     * Human readable description of this task. Used for progress report.
     */
    String getDisplayName();
}