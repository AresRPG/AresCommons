package fr.aresrpg.commons.domain.reflection;

/**
 * <p>
 * This wrapper is the "free" representation of an Object
 * </p>
 * <p>
 * It can be used as
 * 
 * <pre>
 * <code>
 * Reflected.wrap(new Foo()).replaceMethod("getFoo",()λ{}).setField("bar",value);
 * </code>
 * </pre>
 * 
 * @author Sceat {@literal <sceat@aresrpg.fr>}
 * @since 0.6
 * 
 */
public interface Reflected {

}