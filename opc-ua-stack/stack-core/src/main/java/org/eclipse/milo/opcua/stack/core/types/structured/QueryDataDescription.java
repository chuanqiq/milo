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
import org.eclipse.milo.opcua.stack.core.serialization.UaStructure;
import org.eclipse.milo.opcua.stack.core.serialization.codec.OpcBinaryDataTypeCodec;
import org.eclipse.milo.opcua.stack.core.serialization.codec.OpcBinaryStreamReader;
import org.eclipse.milo.opcua.stack.core.serialization.codec.OpcBinaryStreamWriter;
import org.eclipse.milo.opcua.stack.core.serialization.codec.OpcXmlDataTypeCodec;
import org.eclipse.milo.opcua.stack.core.serialization.codec.OpcXmlStreamReader;
import org.eclipse.milo.opcua.stack.core.serialization.codec.OpcXmlStreamWriter;
import org.eclipse.milo.opcua.stack.core.serialization.codec.SerializationContext;
import org.eclipse.milo.opcua.stack.core.types.UaDataType;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;

@UaDataType("QueryDataDescription")
public class QueryDataDescription implements UaStructure {

    public static final NodeId TypeId = Identifiers.QueryDataDescription;
    public static final NodeId BinaryEncodingId = Identifiers.QueryDataDescription_Encoding_DefaultBinary;
    public static final NodeId XmlEncodingId = Identifiers.QueryDataDescription_Encoding_DefaultXml;

    protected final RelativePath _relativePath;
    protected final UInteger _attributeId;
    protected final String _indexRange;

    public QueryDataDescription() {
        this._relativePath = null;
        this._attributeId = null;
        this._indexRange = null;
    }

    public QueryDataDescription(RelativePath _relativePath, UInteger _attributeId, String _indexRange) {
        this._relativePath = _relativePath;
        this._attributeId = _attributeId;
        this._indexRange = _indexRange;
    }

    public RelativePath getRelativePath() { return _relativePath; }

    public UInteger getAttributeId() { return _attributeId; }

    public String getIndexRange() { return _indexRange; }

    @Override
    public NodeId getTypeId() { return TypeId; }

    @Override
    public NodeId getBinaryEncodingId() { return BinaryEncodingId; }

    @Override
    public NodeId getXmlEncodingId() { return XmlEncodingId; }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("RelativePath", _relativePath)
            .add("AttributeId", _attributeId)
            .add("IndexRange", _indexRange)
            .toString();
    }

    public static class BinaryCodec implements OpcBinaryDataTypeCodec<QueryDataDescription> {
        @Override
        public QueryDataDescription decode(SerializationContext context, OpcBinaryStreamReader reader) throws UaSerializationException {
            RelativePath _relativePath = (RelativePath) context.decode(OpcUaDataTypeManager.BINARY_NAMESPACE_URI, "RelativePath", reader);
            UInteger _attributeId = reader.readUInt32();
            String _indexRange = reader.readString();

            return new QueryDataDescription(_relativePath, _attributeId, _indexRange);
        }

        @Override
        public void encode(SerializationContext context, QueryDataDescription encodable, OpcBinaryStreamWriter writer) throws UaSerializationException {
            context.encode(OpcUaDataTypeManager.BINARY_NAMESPACE_URI, "RelativePath", encodable._relativePath, writer);
            writer.writeUInt32(encodable._attributeId);
            writer.writeString(encodable._indexRange);
        }
    }

    public static class XmlCodec implements OpcXmlDataTypeCodec<QueryDataDescription> {
        @Override
        public QueryDataDescription decode(SerializationContext context, OpcXmlStreamReader reader) throws UaSerializationException {
            RelativePath _relativePath = (RelativePath) context.decode(OpcUaDataTypeManager.BINARY_NAMESPACE_URI, "RelativePath", reader);
            UInteger _attributeId = reader.readUInt32("AttributeId");
            String _indexRange = reader.readString("IndexRange");

            return new QueryDataDescription(_relativePath, _attributeId, _indexRange);
        }

        @Override
        public void encode(SerializationContext context, QueryDataDescription encodable, OpcXmlStreamWriter writer) throws UaSerializationException {
            context.encode(OpcUaDataTypeManager.BINARY_NAMESPACE_URI, "RelativePath", encodable._relativePath, writer);
            writer.writeUInt32("AttributeId", encodable._attributeId);
            writer.writeString("IndexRange", encodable._indexRange);
        }
    }

}
