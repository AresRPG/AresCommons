package fr.aresrpg.commons.domain.serialization;

import fr.aresrpg.commons.domain.types.TypeEnum;

import java.io.IOException;

/**
 * A serialization format
 *
 * @param <I>
 *            the input type
 * @param <O>
 *            the output type
 * @author Duarte David {@literal <deltaduartedavid@gmail.com>}
 */
public interface Format<I, O> {
	/**
	 * Called on the beginning of a serialization
	 *
	 * @param out
	 *            the output
	 * @throws IOException
	 *             if an error occurred during writing
	 */
	void writeBegin(O out) throws IOException;

	/**
	 * Write a field value
	 *
	 * @param out
	 *            the output
	 * @param name
	 *            the name or null if this is a solo value
	 * @param type
	 *            the type of the value
	 * @param value
	 *            the value
	 * @param context
	 *            the context of the serialization
	 * @throws IOException
	 *             if an error occurred during writing
	 */
	void writeValue(O out, String name, TypeEnum type, Object value, SerializationContext context) throws IOException;

	/**
	 * Called before an object's writing
	 *
	 * @param out
	 *            the output
	 * @throws IOException
	 *             if an error occurred during writing
	 */
	void writeBeginObject(O out) throws IOException;

	/**
	 * Called on separation of fields
	 *
	 * @param out
	 *            the output
	 * @param firstField
	 *            if is the first field of the object
	 * @param lastField
	 *            if is the last field of the object
	 * @throws IOException
	 *             if an error occurred during writing
	 */
	void writeFieldSeparator(O out, boolean firstField, boolean lastField) throws IOException;

	/**
	 * Called after the writing of an object
	 *
	 * @param out
	 *            the output
	 * @throws IOException
	 *             if an error occurred during writing
	 */
	void writeEndObject(O out) throws IOException;

	/**
	 * Called at the end of a serialization
	 *
	 * @param out
	 *            the output
	 * @throws IOException
	 *             if an error occurred during writing
	 */
	void writeEnd(O out) throws IOException;

	/**
	 * Read an object from input
	 *
	 * @param in
	 *            the input
	 * @return an object of representing type (For object an Map is returned)
	 * @throws IOException
	 *             if an error occurred during reading
	 */
	Object read(I in) throws IOException;
}
