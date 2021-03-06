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

package org.optaplanner.core.heuristic.selector.value.decorator;

import java.util.Collections;
import java.util.Iterator;

import org.optaplanner.core.heuristic.selector.common.SelectionCacheType;
import org.optaplanner.core.heuristic.selector.value.EntityIndependentValueSelector;

public class ShufflingValueSelector extends AbstractCachingValueSelector implements EntityIndependentValueSelector {

    public ShufflingValueSelector(EntityIndependentValueSelector childValueSelector, SelectionCacheType cacheType) {
        super(childValueSelector, cacheType);
    }

    // ************************************************************************
    // Worker methods
    // ************************************************************************

    public boolean isNeverEnding() {
        return false;
    }

    public Iterator<Object> iterator(Object entity) {
        return iterator();
    }

    public Iterator<Object> iterator() {
        Collections.shuffle(cachedValueList, workingRandom);
        logger.trace("    Shuffled cachedValueList with size ({}) in valueSelector({}).",
                cachedValueList.size(), this);
        return cachedValueList.iterator();
    }

    @Override
    public String toString() {
        return "Shuffling(" + childValueSelector + ")";
    }

}
