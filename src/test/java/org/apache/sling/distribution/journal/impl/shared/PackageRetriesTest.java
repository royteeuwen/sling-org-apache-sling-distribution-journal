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
package org.apache.sling.distribution.journal.impl.shared;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PackageRetriesTest {

    @Test
    public void testRetries() throws Exception {
        String entryId = "some-entry";
        PackageRetries retries = new PackageRetries();
        assertEquals(0, retries.get(entryId));
        retries.increase(entryId);
        assertEquals(1, retries.get(entryId));
        retries.increase(entryId);
        assertEquals(2, retries.get(entryId));
        retries.increase(entryId);
        assertEquals(3, retries.get(entryId));
        retries.clear(entryId);
        assertEquals(0, retries.get(entryId));
    }
}