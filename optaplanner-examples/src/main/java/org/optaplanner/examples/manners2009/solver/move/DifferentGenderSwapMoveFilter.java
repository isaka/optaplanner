/*
 * Copyright 2012 JBoss Inc
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

package org.optaplanner.examples.manners2009.solver.move;

import org.optaplanner.core.heuristic.selector.common.decorator.SelectionFilter;
import org.optaplanner.core.heuristic.selector.move.generic.SwapMove;
import org.optaplanner.core.score.director.ScoreDirector;
import org.optaplanner.examples.manners2009.domain.SeatDesignation;

public class DifferentGenderSwapMoveFilter implements SelectionFilter<SwapMove> {

    public boolean accept(ScoreDirector scoreDirector, SwapMove move) {
        SeatDesignation leftSeatDesignation = (SeatDesignation) move.getLeftEntity();
        SeatDesignation rightSeatDesignation = (SeatDesignation) move.getRightEntity();
        return leftSeatDesignation.getGuest().getGender()
                == rightSeatDesignation.getGuest().getGender();
    }

}
