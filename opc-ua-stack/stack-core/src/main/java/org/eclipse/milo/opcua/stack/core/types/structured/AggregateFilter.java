/*
 * Copyright (c) 2016 Kevin Herron
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution.
 *
 * The Eclipse Public License is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 *   http://www.eclipse.org/org/documents/edl-v10.html.
 */

package org.eclipse.milo.opcua.stack.core.types.structured;

import com.google.common.base.MoreObjects;
import org.eclipse.milo.opcua.stack.core.Identifiers;
import org.eclipse.milo.opcua.stack.core.UaSerializationException;
import org.eclipse.milo.opcua.stack.core.serialization.OpcUaDataTypeManager;
import org.eclipse.milo.opcua.stack.core.serialization.codec.OpcBinaryDataTypeCodec;
import org.eclipse.milo.opcua.stack.core.serialization.codec.OpcBinaryStreamReader;
import org.eclipse.milo.opcua.stack.core.serialization.codec.OpcBinaryStreamWriter;
import org.eclipse.milo.opcua.stack.core.serialization.codec.OpcXmlDataTypeCodec;
import org.eclipse.milo.opcua.stack.core.serialization.codec.OpcXmlStreamReader;
import org.eclipse.milo.opcua.stack.core.serialization.codec.OpcXmlStreamWriter;
import org.eclipse.milo.opcua.stack.core.serialization.codec.SerializationContext;
import org.eclipse.milo.opcua.stack.core.types.UaDataType;
import org.eclipse.milo.opcua.stack.core.types.builtin.DateTime;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;

@UaDataType("AggregateFilter")
public class AggregateFilter extends MonitoringFilter {

    public static final NodeId TypeId = Identifiers.AggregateFilter;
    public static final NodeId BinaryEncodingId = Identifiers.AggregateFilter_Encoding_DefaultBinary;
    public static final NodeId XmlEncodingId = Identifiers.AggregateFilter_Encoding_DefaultXml;

    protected final DateTime _startTime;
    protected final NodeId _aggregateType;
    protected final Double _processingInterval;
    protected final AggregateConfiguration _aggregateConfiguration;

    public AggregateFilter() {
        super();
        this._startTime = null;
        this._aggregateType = null;
        this._processingInterval = null;
        this._aggregateConfiguration = null;
    }

    public AggregateFilter(DateTime _startTime, NodeId _aggregateType, Double _processingInterval, AggregateConfiguration _aggregateConfiguration) {
        super();
        this._startTime = _startTime;
        this._aggregateType = _aggregateType;
        this._processingInterval = _processingInterval;
        this._aggregateConfiguration = _aggregateConfiguration;
    }

    public DateTime getStartTime() { return _startTime; }

    public NodeId getAggregateType() { return _aggregateType; }

    public Double getProcessingInterval() { return _processingInterval; }

    public AggregateConfiguration getAggregateConfiguration() { return _aggregateConfiguration; }

    @Override
    public NodeId getTypeId() { return TypeId; }

    @Override
    public NodeId getBinaryEncodingId() { return BinaryEncodingId; }

    @Override
    public NodeId getXmlEncodingId() { return XmlEncodingId; }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("StartTime", _startTime)
            .add("AggregateType", _aggregateType)
            .add("ProcessingInterval", _processingInterval)
            .add("AggregateConfiguration", _aggregateConfiguration)
            .toString();
    }

    public static class BinaryCodec implements OpcBinaryDataTypeCodec<AggregateFilter> {
        @Override
        public AggregateFilter decode(SerializationContext context, OpcBinaryStreamReader reader) throws UaSerializationException {
            DateTime _startTime = reader.readDateTime();
            NodeId _aggregateType = reader.readNodeId();
            Double _processingInterval = reader.readDouble();
            AggregateConfiguration _aggregateConfiguration = (AggregateConfiguration) context.decode(OpcUaDataTypeManager.BINARY_NAMESPACE_URI, "AggregateConfiguration", reader);

            return new AggregateFilter(_startTime, _aggregateType, _processingInterval, _aggregateConfiguration);
        }

        @Override
        public void encode(SerializationContext context, AggregateFilter encodable, OpcBinaryStreamWriter writer) throws UaSerializationException {
            writer.writeDateTime(encodable._startTime);
            writer.writeNodeId(encodable._aggregateType);
            writer.writeDouble(encodable._processingInterval);
            context.encode(OpcUaDataTypeManager.BINARY_NAMESPACE_URI, "AggregateConfiguration", encodable._aggregateConfiguration, writer);
        }
    }

    public static class XmlCodec implements OpcXmlDataTypeCodec<AggregateFilter> {
        @Override
        public AggregateFilter decode(SerializationContext context, OpcXmlStreamReader reader) throws UaSerializationException {
            DateTime _startTime = reader.readDateTime("StartTime");
            NodeId _aggregateType = reader.readNodeId("AggregateType");
            Double _processingInterval = reader.readDouble("ProcessingInterval");
            AggregateConfiguration _aggregateConfiguration = (AggregateConfiguration) context.decode(OpcUaDataTypeManager.BINARY_NAMESPACE_URI, "AggregateConfiguration", reader);

            return new AggregateFilter(_startTime, _aggregateType, _processingInterval, _aggregateConfiguration);
        }

        @Override
        public void encode(SerializationContext context, AggregateFilter encodable, OpcXmlStreamWriter writer) throws UaSerializationException {
            writer.writeDateTime("StartTime", encodable._startTime);
            writer.writeNodeId("AggregateType", encodable._aggregateType);
            writer.writeDouble("ProcessingInterval", encodable._processingInterval);
            context.encode(OpcUaDataTypeManager.BINARY_NAMESPACE_URI, "AggregateConfiguration", encodable._aggregateConfiguration, writer);
        }
    }

}
