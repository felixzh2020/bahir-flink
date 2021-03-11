/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.flink.streaming.connectors.influxdb.util;

import com.influxdb.client.write.Point;
import org.apache.flink.api.connector.sink.SinkWriter.Context;
import org.apache.flink.streaming.connectors.influxdb.sink.writer.InfluxDBSchemaSerializer;
import org.jetbrains.annotations.Nullable;

public class InfluxDBTestSerializer implements InfluxDBSchemaSerializer<Long> {

    @Override
    public Point serialize(final Long element, @Nullable final Context context) {
        final Point dataPoint = new Point("test");
        dataPoint.addTag("longValue", String.valueOf(element));
        dataPoint.addField("fieldKey", "fieldValue");
        return dataPoint;
    }
}