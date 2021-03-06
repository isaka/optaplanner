package org.optaplanner.core.heuristic.selector.entity.decorator;

import org.optaplanner.core.domain.variable.PlanningVariableDescriptor;
import org.optaplanner.core.heuristic.selector.common.decorator.SelectionFilter;
import org.optaplanner.core.score.director.ScoreDirector;

public class NullValueReinitializeVariableEntityFilter implements SelectionFilter<Object> {

    private final PlanningVariableDescriptor variableDescriptor;

    public NullValueReinitializeVariableEntityFilter(PlanningVariableDescriptor variableDescriptor) {
        this.variableDescriptor = variableDescriptor;
    }

    public boolean accept(ScoreDirector scoreDirector, Object selection) {
        Object value = variableDescriptor.getValue(selection);
        return value == null;
    }

}
