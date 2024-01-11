/*
 * Copyright (c) 2008-2024, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.client.cp.internal.datastructures.semaphore;

import com.hazelcast.client.impl.clientside.HazelcastClientProxy;
import com.hazelcast.client.test.TestHazelcastFactory;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.cp.ISemaphore;
import com.hazelcast.cp.internal.RaftGroupId;
import com.hazelcast.cp.internal.datastructures.semaphore.UnsafeSessionAwareSemaphoreBasicTest;
import com.hazelcast.cp.internal.session.AbstractProxySessionManager;
import com.hazelcast.test.HazelcastParallelClassRunner;
import com.hazelcast.test.TestHazelcastInstanceFactory;
import com.hazelcast.test.annotation.ParallelJVMTest;
import com.hazelcast.test.annotation.QuickTest;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@RunWith(HazelcastParallelClassRunner.class)
@Category({QuickTest.class, ParallelJVMTest.class})
public class UnsafeSessionAwareSemaphoreClientBasicTest extends UnsafeSessionAwareSemaphoreBasicTest {

    private TestHazelcastFactory factory = new TestHazelcastFactory();
    private HazelcastInstance client;

    @Override
    protected TestHazelcastInstanceFactory createTestFactory() {
        return factory;
    }

    @Override
    protected HazelcastInstance[] createInstances() {
        HazelcastInstance[] instances = super.createInstances();
        client = factory.newHazelcastClient();
        return instances;
    }

    @Override
    protected HazelcastInstance getProxyInstance() {
        return client;
    }

    @Override
    protected AbstractProxySessionManager getSessionManager(HazelcastInstance instance) {
        return (((HazelcastClientProxy) client).client).getProxySessionManager();
    }

    @Override
    protected RaftGroupId getGroupId(ISemaphore semaphore) {
        return (RaftGroupId) ((SessionAwareSemaphoreProxy) semaphore).getGroupId();
    }
}
