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

package org.optaplanner.persistence.jaxb.api.score.buildin.simple;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.junit.jupiter.api.Test;
import org.optaplanner.core.api.score.buildin.simple.SimpleScore;
import org.optaplanner.persistence.jaxb.api.score.AbstractScoreJaxbAdapterTest;

class SimpleScoreJaxbAdapterTest extends AbstractScoreJaxbAdapterTest {

    @Test
    void serializeAndDeserialize() {
        assertSerializeAndDeserialize(null, new TestSimpleScoreWrapper(null));

        SimpleScore score = SimpleScore.of(1234);
        assertSerializeAndDeserialize(score, new TestSimpleScoreWrapper(score));

        score = SimpleScore.ofUninitialized(-7, 1234);
        assertSerializeAndDeserialize(score, new TestSimpleScoreWrapper(score));
    }

    @XmlRootElement
    public static class TestSimpleScoreWrapper extends TestScoreWrapper<SimpleScore> {

        @XmlJavaTypeAdapter(SimpleScoreJaxbAdapter.class)
        private SimpleScore score;

        @SuppressWarnings("unused")
        private TestSimpleScoreWrapper() {
        }

        public TestSimpleScoreWrapper(SimpleScore score) {
            this.score = score;
        }

        @Override
        public SimpleScore getScore() {
            return score;
        }

    }

}
