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
 * @date 2021-01-12 11:37
 */
@JsonDeserialize(using = ResultsStatus.Deserializer.class )
@JsonSerialize(using = ResultsStatus.Serializer.class )
public enum ResultsStatus {

    USING("正常"),
    ABNORMAL("异常");

    ResultsStatus(String displayName) {
        this.displayName=displayName;
    }
    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    public static class Deserializer extends JsonDeserializer<ResultsStatus> {
        public ResultsStatus deserialize(JsonParser jp, DeserializationContext ctxt ) throws IOException {
            JsonNode node = jp.getCodec().readTree( jp );
            if ( node.isTextual() ) {
                return Enums.getIfPresent( ResultsStatus.class, node.textValue() ).get();
            }
            return Enums.getIfPresent( ResultsStatus.class, node.get( "name" ).textValue() ).get();
        }
    }

    public static class Serializer extends JsonSerializer<ResultsStatus> {
        @Override
        public void serialize(ResultsStatus value, JsonGenerator jgen, SerializerProvider provider )
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
