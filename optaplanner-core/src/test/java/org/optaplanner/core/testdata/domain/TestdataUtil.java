/*
 * Copyright 2013 JBoss Inc
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

package org.optaplanner.core.testdata.domain;

import org.optaplanner.core.domain.entity.PlanningEntityDescriptor;
import org.optaplanner.core.domain.solution.SolutionDescriptor;
import org.optaplanner.core.solution.Solution;

public class TestdataUtil {

    public static SolutionDescriptor buildSolutionDescriptor(Class<? extends Solution> solutionClass,
            Class<?> ... entityClasses) {
        SolutionDescriptor solutionDescriptor = new SolutionDescriptor(solutionClass);
        solutionDescriptor.processAnnotations();
        for (Class<?> entityClass : entityClasses) {
            PlanningEntityDescriptor entityDescriptor = new PlanningEntityDescriptor(
                    solutionDescriptor, entityClass);
            solutionDescriptor.addPlanningEntityDescriptor(entityDescriptor);
            entityDescriptor.processAnnotations();
        }
        return solutionDescriptor;
    }

    private TestdataUtil() {
    }

}
