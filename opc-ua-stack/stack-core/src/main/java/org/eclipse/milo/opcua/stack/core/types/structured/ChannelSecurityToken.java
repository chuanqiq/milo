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
import org.eclipse.milo.opcua.stack.core.serialization.UaStructure;
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
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;

@UaDataType("ChannelSecurityToken")
public class ChannelSecurityToken implements UaStructure {

    public static final NodeId TypeId = Identifiers.ChannelSecurityToken;
    public static final NodeId BinaryEncodingId = Identifiers.ChannelSecurityToken_Encoding_DefaultBinary;
    public static final NodeId XmlEncodingId = Identifiers.ChannelSecurityToken_Encoding_DefaultXml;

    protected final UInteger _channelId;
    protected final UInteger _tokenId;
    protected final DateTime _createdAt;
    protected final UInteger _revisedLifetime;

    public ChannelSecurityToken() {
        this._channelId = null;
        this._tokenId = null;
        this._createdAt = null;
        this._revisedLifetime = null;
    }

    public ChannelSecurityToken(UInteger _channelId, UInteger _tokenId, DateTime _createdAt, UInteger _revisedLifetime) {
        this._channelId = _channelId;
        this._tokenId = _tokenId;
        this._createdAt = _createdAt;
        this._revisedLifetime = _revisedLifetime;
    }

    public UInteger getChannelId() { return _channelId; }

    public UInteger getTokenId() { return _tokenId; }

    public DateTime getCreatedAt() { return _createdAt; }

    public UInteger getRevisedLifetime() { return _revisedLifetime; }

    @Override
    public NodeId getTypeId() { return TypeId; }

    @Override
    public NodeId getBinaryEncodingId() { return BinaryEncodingId; }

    @Override
    public NodeId getXmlEncodingId() { return XmlEncodingId; }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("ChannelId", _channelId)
            .add("TokenId", _tokenId)
            .add("CreatedAt", _createdAt)
            .add("RevisedLifetime", _revisedLifetime)
            .toString();
    }

    public static class BinaryCodec implements OpcBinaryDataTypeCodec<ChannelSecurityToken> {
        @Override
        public ChannelSecurityToken decode(SerializationContext context, OpcBinaryStreamReader reader) throws UaSerializationException {
            UInteger _channelId = reader.readUInt32();
            UInteger _tokenId = reader.readUInt32();
            DateTime _createdAt = reader.readDateTime();
            UInteger _revisedLifetime = reader.readUInt32();

            return new ChannelSecurityToken(_channelId, _tokenId, _createdAt, _revisedLifetime);
        }

        @Override
        public void encode(SerializationContext context, ChannelSecurityToken encodable, OpcBinaryStreamWriter writer) throws UaSerializationException {
            writer.writeUInt32(encodable._channelId);
            writer.writeUInt32(encodable._tokenId);
            writer.writeDateTime(encodable._createdAt);
            writer.writeUInt32(encodable._revisedLifetime);
        }
    }

    public static class XmlCodec implements OpcXmlDataTypeCodec<ChannelSecurityToken> {
        @Override
        public ChannelSecurityToken decode(SerializationContext context, OpcXmlStreamReader reader) throws UaSerializationException {
            UInteger _channelId = reader.readUInt32("ChannelId");
            UInteger _tokenId = reader.readUInt32("TokenId");
            DateTime _createdAt = reader.readDateTime("CreatedAt");
            UInteger _revisedLifetime = reader.readUInt32("RevisedLifetime");

            return new ChannelSecurityToken(_channelId, _tokenId, _createdAt, _revisedLifetime);
        }

        @Override
        public void encode(SerializationContext context, ChannelSecurityToken encodable, OpcXmlStreamWriter writer) throws UaSerializationException {
            writer.writeUInt32("ChannelId", encodable._channelId);
            writer.writeUInt32("TokenId", encodable._tokenId);
            writer.writeDateTime("CreatedAt", encodable._createdAt);
            writer.writeUInt32("RevisedLifetime", encodable._revisedLifetime);
        }
    }

}
