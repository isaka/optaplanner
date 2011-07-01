/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.planner.core.phase.termination;

import org.drools.planner.core.phase.AbstractSolverPhaseScope;
import org.drools.planner.core.phase.step.AbstractStepScope;

public class TimeMillisSpendTermination extends AbstractTermination {

    private long maximumTimeMillisSpend;

    public void setMaximumTimeMillisSpend(long maximumTimeMillisSpend) {
        this.maximumTimeMillisSpend = maximumTimeMillisSpend;
        if (maximumTimeMillisSpend <= 0L) {
            throw new IllegalArgumentException("Property maximumTimeMillisSpend (" + maximumTimeMillisSpend
                    + ") must be greater than 0.");
        }
    }

    // ************************************************************************
    // Worker methods
    // ************************************************************************

    public boolean isSolverTerminated(AbstractSolverPhaseScope lastSolverPhaseScope) {
        long solverTimeMillisSpend = lastSolverPhaseScope.getSolverScope().calculateTimeMillisSpend();
        return isTerminated(solverTimeMillisSpend);
    }

    public boolean isPhaseTerminated(AbstractStepScope stepScope) {
        long phaseTimeMillisSpend = stepScope.getSolverPhaseScope().calculatePhaseTimeMillisSpend();
        return isTerminated(phaseTimeMillisSpend);
    }

    private boolean isTerminated(long timeMillisSpend) {
        return timeMillisSpend >= maximumTimeMillisSpend;
    }

    public double calculateSolverTimeGradient(AbstractSolverPhaseScope lastSolverPhaseScope) {
        long solverTimeMillisSpend = lastSolverPhaseScope.getSolverScope().calculateTimeMillisSpend();
        return calculateTimeGradient(solverTimeMillisSpend);
    }

    public double calculatePhaseTimeGradient(AbstractStepScope stepScope) {
        long phaseTimeMillisSpend = stepScope.getSolverPhaseScope().calculatePhaseTimeMillisSpend();
        return calculateTimeGradient(phaseTimeMillisSpend);
    }

    private double calculateTimeGradient(double timeMillisSpend) {
        double timeGradient = ((double) timeMillisSpend) / ((double) maximumTimeMillisSpend);
        return Math.min(timeGradient, 1.0);
    }

}
