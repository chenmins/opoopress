/*
 * Copyright 2013-2015 Alex Lin.
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
package org.opoo.press.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.opoo.press.ListHolder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Alex Lin
 */
public class ListHolderImpl<T> implements ListHolder<T>, Serializable {
    private Map<String, List<T>> map = Maps.newHashMap();

    @Override
    public List<T> get(String metaName) {
        List<T> list = map.get(metaName);
        if (list == null) {
            list = Lists.newArrayList();
            map.put(metaName, list);
        }
        return list;
    }

    @Override
    public ListHolderImpl<T> add(String metaName, T e) {
        get(metaName).add(e);
        return this;
    }

    @Override
    public String[] getKeys() {
        Set<String> set = map.keySet();
        return set.toArray(new String[set.size()]);
    }

    @Override
    public void clear() {
        map.clear();
    }
}
