/*
 * Copyright 2011 JBoss Inc
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

package org.optaplanner.examples.travelingtournament;

import java.io.File;

import org.optaplanner.config.EnvironmentMode;
import org.optaplanner.examples.common.app.SolverPerformanceTest;
import org.optaplanner.examples.common.persistence.SolutionDao;
import org.optaplanner.examples.travelingtournament.persistence.TravelingTournamentDaoImpl;
import org.junit.Test;

public class TravelingTournamentPerformanceTest extends SolverPerformanceTest {

    @Override
    protected String createSolverConfigResource() {
        return "/org/optaplanner/examples/travelingtournament/solver/travelingTournamentSolverConfig.xml";
    }

    @Override
    protected SolutionDao createSolutionDao() {
        return new TravelingTournamentDaoImpl();
    }

    // ************************************************************************
    // Tests
    // ************************************************************************

    @Test(timeout = 600000)
    public void solveComp01_initialized() {
        File unsolvedDataFile = new File("data/travelingtournament/unsolved/1-nl10.xml");
        runSpeedTest(unsolvedDataFile, "0hard/-75968soft");
    }

    @Test(timeout = 600000)
    public void solveTestdata01_initializedFastAssert() {
        File unsolvedDataFile = new File("data/travelingtournament/unsolved/1-nl10.xml");
        runSpeedTest(unsolvedDataFile, "0hard/-77619soft", EnvironmentMode.FAST_ASSERT);
    }

}
