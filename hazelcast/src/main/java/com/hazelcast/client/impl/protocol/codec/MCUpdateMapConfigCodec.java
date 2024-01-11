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

package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.Generated;
import com.hazelcast.client.impl.protocol.codec.builtin.*;
import com.hazelcast.client.impl.protocol.codec.custom.*;

import javax.annotation.Nullable;

import static com.hazelcast.client.impl.protocol.ClientMessage.*;
import static com.hazelcast.client.impl.protocol.codec.builtin.FixedSizeTypesCodec.*;

/*
 * This file is auto-generated by the Hazelcast Client Protocol Code Generator.
 * To change this file, edit the templates or the protocol
 * definitions on the https://github.com/hazelcast/hazelcast-client-protocol
 * and regenerate it.
 */

/**
 * Updates the config of a map on the member it's called on.
 */
@SuppressWarnings("unused")
@Generated("b58e85f8aafd359fac7d31ff882346f5")
public final class MCUpdateMapConfigCodec {
    //hex: 0x200400
    public static final int REQUEST_MESSAGE_TYPE = 2098176;
    //hex: 0x200401
    public static final int RESPONSE_MESSAGE_TYPE = 2098177;
    private static final int REQUEST_TIME_TO_LIVE_SECONDS_FIELD_OFFSET = PARTITION_ID_FIELD_OFFSET + INT_SIZE_IN_BYTES;
    private static final int REQUEST_MAX_IDLE_SECONDS_FIELD_OFFSET = REQUEST_TIME_TO_LIVE_SECONDS_FIELD_OFFSET + INT_SIZE_IN_BYTES;
    private static final int REQUEST_EVICTION_POLICY_FIELD_OFFSET = REQUEST_MAX_IDLE_SECONDS_FIELD_OFFSET + INT_SIZE_IN_BYTES;
    private static final int REQUEST_READ_BACKUP_DATA_FIELD_OFFSET = REQUEST_EVICTION_POLICY_FIELD_OFFSET + INT_SIZE_IN_BYTES;
    private static final int REQUEST_MAX_SIZE_FIELD_OFFSET = REQUEST_READ_BACKUP_DATA_FIELD_OFFSET + BOOLEAN_SIZE_IN_BYTES;
    private static final int REQUEST_MAX_SIZE_POLICY_FIELD_OFFSET = REQUEST_MAX_SIZE_FIELD_OFFSET + INT_SIZE_IN_BYTES;
    private static final int REQUEST_INITIAL_FRAME_SIZE = REQUEST_MAX_SIZE_POLICY_FIELD_OFFSET + INT_SIZE_IN_BYTES;
    private static final int RESPONSE_INITIAL_FRAME_SIZE = RESPONSE_BACKUP_ACKS_FIELD_OFFSET + BYTE_SIZE_IN_BYTES;

    private MCUpdateMapConfigCodec() {
    }

    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
    public static class RequestParameters {

        /**
         * Name of the map.
         */
        public java.lang.String mapName;

        /**
         * Time to live seconds for the map entries.
         */
        public int timeToLiveSeconds;

        /**
         * Maximum idle seconds for the map entries.
         */
        public int maxIdleSeconds;

        /**
         * The eviction policy of the map:
         * 0 - LRU
         * 1 - LFU
         * 2 - NONE
         * 3 - RANDOM
         */
        public int evictionPolicy;

        /**
         * Whether reading from backup data is allowed.
         */
        public boolean readBackupData;

        /**
         * Maximum size of the map.
         */
        public int maxSize;

        /**
         * The maximum size policy of the map:
         * 0 - PER_NODE
         * 1 - PER_PARTITION
         * 2 - USED_HEAP_PERCENTAGE
         * 3 - USED_HEAP_SIZE
         * 4 - FREE_HEAP_PERCENTAGE
         * 5 - FREE_HEAP_SIZE
         * 6 - USED_NATIVE_MEMORY_SIZE
         * 7 - USED_NATIVE_MEMORY_PERCENTAGE
         * 8 - FREE_NATIVE_MEMORY_SIZE
         * 9 - FREE_NATIVE_MEMORY_PERCENTAGE
         */
        public int maxSizePolicy;
    }

    public static ClientMessage encodeRequest(java.lang.String mapName, int timeToLiveSeconds, int maxIdleSeconds, int evictionPolicy, boolean readBackupData, int maxSize, int maxSizePolicy) {
        ClientMessage clientMessage = ClientMessage.createForEncode();
        clientMessage.setRetryable(false);
        clientMessage.setOperationName("MC.UpdateMapConfig");
        ClientMessage.Frame initialFrame = new ClientMessage.Frame(new byte[REQUEST_INITIAL_FRAME_SIZE], UNFRAGMENTED_MESSAGE);
        encodeInt(initialFrame.content, TYPE_FIELD_OFFSET, REQUEST_MESSAGE_TYPE);
        encodeInt(initialFrame.content, PARTITION_ID_FIELD_OFFSET, -1);
        encodeInt(initialFrame.content, REQUEST_TIME_TO_LIVE_SECONDS_FIELD_OFFSET, timeToLiveSeconds);
        encodeInt(initialFrame.content, REQUEST_MAX_IDLE_SECONDS_FIELD_OFFSET, maxIdleSeconds);
        encodeInt(initialFrame.content, REQUEST_EVICTION_POLICY_FIELD_OFFSET, evictionPolicy);
        encodeBoolean(initialFrame.content, REQUEST_READ_BACKUP_DATA_FIELD_OFFSET, readBackupData);
        encodeInt(initialFrame.content, REQUEST_MAX_SIZE_FIELD_OFFSET, maxSize);
        encodeInt(initialFrame.content, REQUEST_MAX_SIZE_POLICY_FIELD_OFFSET, maxSizePolicy);
        clientMessage.add(initialFrame);
        StringCodec.encode(clientMessage, mapName);
        return clientMessage;
    }

    public static MCUpdateMapConfigCodec.RequestParameters decodeRequest(ClientMessage clientMessage) {
        ClientMessage.ForwardFrameIterator iterator = clientMessage.frameIterator();
        RequestParameters request = new RequestParameters();
        ClientMessage.Frame initialFrame = iterator.next();
        request.timeToLiveSeconds = decodeInt(initialFrame.content, REQUEST_TIME_TO_LIVE_SECONDS_FIELD_OFFSET);
        request.maxIdleSeconds = decodeInt(initialFrame.content, REQUEST_MAX_IDLE_SECONDS_FIELD_OFFSET);
        request.evictionPolicy = decodeInt(initialFrame.content, REQUEST_EVICTION_POLICY_FIELD_OFFSET);
        request.readBackupData = decodeBoolean(initialFrame.content, REQUEST_READ_BACKUP_DATA_FIELD_OFFSET);
        request.maxSize = decodeInt(initialFrame.content, REQUEST_MAX_SIZE_FIELD_OFFSET);
        request.maxSizePolicy = decodeInt(initialFrame.content, REQUEST_MAX_SIZE_POLICY_FIELD_OFFSET);
        request.mapName = StringCodec.decode(iterator);
        return request;
    }

    public static ClientMessage encodeResponse() {
        ClientMessage clientMessage = ClientMessage.createForEncode();
        ClientMessage.Frame initialFrame = new ClientMessage.Frame(new byte[RESPONSE_INITIAL_FRAME_SIZE], UNFRAGMENTED_MESSAGE);
        encodeInt(initialFrame.content, TYPE_FIELD_OFFSET, RESPONSE_MESSAGE_TYPE);
        clientMessage.add(initialFrame);

        return clientMessage;
    }
}
