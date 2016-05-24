package fr.aresrpg.commons.reflection;

import fr.aresrpg.commons.Iterators;
import fr.aresrpg.commons.Value;
import fr.aresrpg.commons.util.Types;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Objects;

public class ParametrizedClass<T> implements Value<Class<T>> {
	private final Type type;
	private final Class<T> raw;

	protected ParametrizedClass() {
		if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
			this.type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			this.raw = Types.getClazz(type);
		} else
			throw new IllegalStateException("Cannot get superclass type parameters");

	}

	public ParametrizedClass(Type type) {
		this.type = type;
		this.raw = Types.getClazz(type);
	}

	public final Type getType() {
		return this.type;
	}

	public final Class<T> getRaw(){
		return raw;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ParametrizedClass<?> that = (ParametrizedClass<?>) o;
		return Objects.equals(type, that.type);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type);
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public Class<T> get() {
		return getRaw();
	}

	@Override
	public Iterator<Class<T>> iterator() {
		return Iterators.of(get());
	}

}