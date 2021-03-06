package fr.aresrpg.commons.domain.serialization;

import java.io.IOException;
import java.util.Map;

/**
 * An object mapper, serializer and deserializer
 *
 * @param <T>
 *            the type of object to map
 * @author Duarte David {@literal <deltaduartedavid@gmail.com>}
 */
public interface Serializer<T> {
	/**
	 * Map the object, serialize it using the passed format and write the result to the output
	 *
	 * @param output
	 *            output to write the result
	 * @param object
	 *            the object to serialize
	 * @param format
	 *            the format to use in serialization
	 * @throws IOException
	 *             if an exception occurred
	 * @param <O> the output type
	 * @throws IOException if an exception occurred
	 */
	<O> void serialize(O output, T object, Format<?, O> format) throws IOException;

	/**
	 * Map the object and deserialize it in the provided object using the passed format from the input
	 *
	 * @param input
	 *            input
	 * @param object
	 *            the object to write in
	 * @param format
	 *            the format to use in deserialization
	 * @param <I> the input type
	 * @throws IOException
	 *             if an exception occurred
	 */
	<I> void deserialize(I input, T object , Format<I, ?> format) throws IOException;

	/**
	 * Map the object and deserialize it using the passed format from the input
	 *
	 * @param input
	 *            input
	 * @param format
	 *            the format to use in deserialization
	 * @param <I> the input type
	 * @return the mapped object
	 * @throws IOException
	 *             if an exception occurred
	 */
	<I> T deserialize(I input, Format<I, ?> format) throws IOException;

	/**
	 * Map the object passed in argument
	 *
	 * @param values
	 *            the values to map
	 * @return the mapped object
	 * @throws IOException
	 *             if an exception occured
	 */
	T deserialize(Map<String, Object> values) throws IOException;

	/**
	 * Map the object passed in argument
	 *
	 * @param values
	 *            the values to map
	 * @param object the mapped object
	 * @throws IOException
	 */
	void deserialize(Map<String, Object> values , T object) throws IOException;
}
