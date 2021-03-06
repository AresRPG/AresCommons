package fr.aresrpg.commons.domain.util;

import fr.aresrpg.commons.domain.util.exception.IllegalConstructionException;

import java.util.Arrays;

/**
 * A util class for enums which act like Objects.*
 * 
 * @author Sceat {@literal <sceat@aresrpg.fr>}
 */
public class Enums {

	private Enums() {
		throw new IllegalConstructionException();
	}

	/**
	 * Equivalent to Objects.requireNonNull
	 * 
	 * @param t1
	 *            to compare
	 * @param base
	 *            enum type wanted
	 * @param <T>
	 *            the type enum
	 * @return the enum to compare
	 */
	public static <T extends Enum<T>> T requireType(T t1, T base) {
		if (t1 != base) throw new NotEqualsException("The enum t1 is not equal to base");
		return base;
	}

	/**
	 * Equivalent to Objects.requireNonNull with a "some of"
	 * 
	 * @param t1
	 *            the enum to compare
	 * @param base
	 *            the array to check
	 * @param <T>
	 *            the type
	 * @return the enum to compare
	 */
	@SafeVarargs
	public static <T extends Enum<T>> T requireTypeOr(T t1, T... base) {
		if (Arrays.stream(base).map(t1::equals).reduce((b1, b2) -> b1 || b2).get()) return t1; // NOSONAR auto closeable
		throw new NotEqualsException("The enum t1 is not equal of any from base");
	}

	static class NotEqualsException extends RuntimeException {

		public NotEqualsException() {
			super();
		}

		public NotEqualsException(String s) {
			super(s);
		}

	}

}
