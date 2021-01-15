package indi.fanyun.bullscheduling.common.types;

/**
 * @author tshk
 * @date 2021-01-12 11:03
 */

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Enums;

import java.io.IOException;

/**
 * 状态
 */
@JsonDeserialize(using = NormalStatus.Deserializer.class )
@JsonSerialize(using = NormalStatus.Serializer.class )
public enum NormalStatus {

    USING("正常"),
    DELETE("删除"),
    DISABLE("禁用");

    NormalStatus(String displayName) {
        this.displayName=displayName;
    }
    private String displayName;


    public String getDisplayName() {
        return displayName;
    }

    public static class Deserializer extends JsonDeserializer<NormalStatus> {
        public NormalStatus deserialize(JsonParser jp, DeserializationContext ctxt ) throws IOException {
            JsonNode node = jp.getCodec().readTree( jp );
            if ( node.isTextual() ) {
                return Enums.getIfPresent( NormalStatus.class, node.textValue() ).get();
            }
            return Enums.getIfPresent( NormalStatus.class, node.get( "name" ).textValue() ).get();
        }
    }

    public static class Serializer extends JsonSerializer<NormalStatus> {
        @Override
        public void serialize(NormalStatus value, JsonGenerator jgen, SerializerProvider provider )
                throws IOException, JsonProcessingException {
            if ( null != value ) {
                jgen.writeStartObject();
                jgen.writeFieldName( "name" );
                jgen.writeObject( value.name() );
                jgen.writeFieldName( "displayName" );
                jgen.writeString( value.displayName );
                jgen.writeEndObject();
            } else {
                jgen.writeNull();
            }
        }
    }
}
