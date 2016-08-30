package fr.aresrpg.commons.domain.functional.consumer;

/**
 * A consumer with 2 arguments
 * @param <A> the first argument type
 * @param <B> the second argument type
 * @author Duarte David {@literal <deltaduartedavid@gmail.com>}
 */
@FunctionalInterface
public interface BiConsumer<A , B> {
    /**
     * Execute an action
     * @param a the first argument
     * @param b the second argument
     */
    void accept(A a , B b);

    /**
     * Create an new consumer that execute this consumer an after an other
     * @param after the consumer to execute after
     * @return a new consumer
     */
    default BiConsumer<A , B> then(BiConsumer<A , B> after){
        return (a , b) -> {
            accept(a , b);
            after.accept(a , b);
        };
    }

	/**
     * Create a new consumer with reversed arguments
     * @return a new consumer
     */
    default BiConsumer<B , A> reverse(){
        return (b , a) -> accept(a , b);
    }

	/**
     * Create a new empty consumer
     * @param <A> the first argument type
     * @param <B> the second argument type
     * @return an new consumer
     */
    static <A , B> BiConsumer<A , B> empty(){
        return (a , b) ->{
            //Empty
        };
    }

	/**
     * Create a new BiConsumer with two consumers
     * @param wa the first consumer
     * @param wb the second consumer
     * @param <A> the first argument type
     * @param <B> the second argument type
     * @return a new consumer
     */
    static  <A, B> BiConsumer<A, B> both(Consumer<A> wa, Consumer<B> wb) {
        return (A a, B b) -> {
            wa.accept(a);
            wb.accept(b);
        };
    }

	/**
     * Transform this consumer to the java type
     * @return a new consumer
     */
    default java.util.function.BiConsumer<A , B> toNative(){
        return this::accept;
    }
}
