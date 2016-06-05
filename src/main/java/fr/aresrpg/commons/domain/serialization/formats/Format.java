package fr.aresrpg.commons.domain.serialization.formats;

import fr.aresrpg.commons.domain.serialization.SerializationContext;
import fr.aresrpg.commons.domain.types.TypeEnum;

import java.io.IOException;
import java.util.Map;

public interface Format<I , O>{
	void writeBegin(O out) throws IOException;
	void writeValue(O out , String name , TypeEnum type , Object value , SerializationContext<I , O> context) throws IOException;
	void writeBeginObject(O out) throws IOException;
	void writeFieldSeparator(O out , boolean firstField , boolean lastField) throws IOException;
	void writeEndObject(O out) throws IOException;
	void writeEnd(O out) throws IOException;

	void read(I in , Map<String , Object> container , SerializationContext<I , O> context) throws IOException;
}
