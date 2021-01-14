package indi.fanyun.bullscheduling.common.types;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Enums;

import java.io.IOException;

/**
 * @author tshk
 * @date 2021-01-12 15:26
 */
@JsonDeserialize(using = ErrorTypes.Deserializer.class )
@JsonSerialize(using = ErrorTypes.Serializer.class )
public enum ErrorTypes {


    SYSTEM_ERROR("系统异常", 1),
    BIZ_ERROR("业务异常", 2);

    ErrorTypes(String errorMsg,Integer code) {
        this.errorMsg=errorMsg;
        this.errorCode=code;
    }
    private final String errorMsg;

    private final Integer errorCode;

    public String getErrorMsg() {
        return errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public static class Deserializer extends JsonDeserializer<ErrorTypes> {
        public ErrorTypes deserialize(JsonParser jp, DeserializationContext ctxt ) throws IOException {
            JsonNode node = jp.getCodec().readTree( jp );
            if ( node.isTextual() ) {
                return Enums.getIfPresent( ErrorTypes.class, node.textValue() ).get();
            }
            return Enums.getIfPresent( ErrorTypes.class, node.get( "name" ).textValue() ).get();
        }
    }

    public static class Serializer extends JsonSerializer<ErrorTypes> {
        @Override
        public void serialize(ErrorTypes value, JsonGenerator jgen, SerializerProvider provider )
                throws IOException, JsonProcessingException {
            if ( null != value ) {
                jgen.writeStartObject();
                jgen.writeFieldName( "name" );
                jgen.writeObject( value.name() );
                jgen.writeFieldName( "errorMsg" );
                jgen.writeString( value.errorMsg );
                jgen.writeFieldName( "errorCode" );
                jgen.writeNumber( value.errorCode );
                jgen.writeEndObject();
            } else {
                jgen.writeNull();
            }
        }
    }
}
