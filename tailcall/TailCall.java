package tailcall;

import java.util.function.Supplier;

/**
 * Cette interface fait deux promesses :
 * <UL>
 * <LI>Elle va renvoyer une fonction, qui va renvoyer une fonction, qui va
 * renvoyer une fonction, ... de son propre type
 * <LI>À un moment, cette fonction sera <I>done</I> et proposera un
 * <CODE>result</CODE>
 * </UL>
 * 
 * @author obrosseron
 *
 * @param <T>
 * 
 * @see https://stackoverflow.com/a/53787951/16067055
 * @see https://blog.knoldus.com/tail-recursion-in-java-8/
 * @see https://github.com/jonckvanderkogel/java-tail-recursion
 */
public interface TailCall<T> extends Supplier<TailCall<T>> {

	boolean isDone();

	T result();

}
