/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.optaplanner.persistence.jsonb.api.score.buildin.hardsoftbigdecimal;

import java.math.BigDecimal;

import jakarta.json.bind.annotation.JsonbTypeAdapter;

import org.junit.jupiter.api.Test;
import org.optaplanner.core.api.score.buildin.hardsoftbigdecimal.HardSoftBigDecimalScore;
import org.optaplanner.persistence.jsonb.api.score.AbstractScoreJsonbAdapterTest;

class HardSoftBigDecimalScoreJsonbAdapterTest extends AbstractScoreJsonbAdapterTest {

    @Test
    void serializeAndDeserialize() {
        assertSerializeAndDeserialize(null, new TestHardSoftBigDecimalScoreWrapper(null));
        HardSoftBigDecimalScore score = HardSoftBigDecimalScore.of(new BigDecimal("1200.0021"), new BigDecimal("34.4300"));
        assertSerializeAndDeserialize(score, new TestHardSoftBigDecimalScoreWrapper(score));
        score = HardSoftBigDecimalScore.ofUninitialized(-7, new BigDecimal("1200.0021"), new BigDecimal("34.4300"));
        assertSerializeAndDeserialize(score, new TestHardSoftBigDecimalScoreWrapper(score));
    }

    public static class TestHardSoftBigDecimalScoreWrapper extends TestScoreWrapper<HardSoftBigDecimalScore> {

        @JsonbTypeAdapter(HardSoftBigDecimalScoreJsonbAdapter.class)
        private HardSoftBigDecimalScore score;

        // Empty constructor required by JSON-B
        @SuppressWarnings("unused")
        public TestHardSoftBigDecimalScoreWrapper() {
        }

        public TestHardSoftBigDecimalScoreWrapper(HardSoftBigDecimalScore score) {
            this.score = score;
        }

        @Override
        public HardSoftBigDecimalScore getScore() {
            return score;
        }

        @Override
        public void setScore(HardSoftBigDecimalScore score) {
            this.score = score;
        }

    }
}
