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

package com.hazelcast.cp.internal.raft.impl.persistence;

import javax.annotation.Nonnull;
import java.io.IOException;

/**
 * Defines the contract of restoring persisted Raft state from storage layer
 */
public interface RaftStateLoader {

    /**
     * Restores the persisted Raft state from the storage layer and returns
     * a fully initialized {@link RestoredRaftState} object.
     *
     * @throws IOException if any IO error occurs while reading from storage
     */
    @Nonnull
    RestoredRaftState load() throws IOException;
}
