package tailcall;

import java.util.concurrent.Callable;
import java.util.stream.Stream;

/**
 * Pour tous les appels r�cursifs NON-termin�s, on instancie cette classe, qui
 * propose de construire une liste des appels r�cursifs.
 * 
 * @author obrosseron
 *
 * @param <T>
 */
public abstract class TailCallNotDone<T> implements TailCall<T>, Callable<T> {

	@Override
	public final boolean isDone() {
		return false;
	}

	@Override
	public final T result() {
		throw new TailCallError("not implemented");
	}

	/*
	 * Appelle la m�thode TailCall::get en boucle tant que le TailCall renvoy� n'est
	 * pas un TailCallDone
	 */
	@Override
	public T call() {
		return Stream.iterate(this, TailCall<T>::get) //
				.filter(TailCall::isDone) //
				.findFirst() //
				.map(TailCall::result) //
				.orElse(null);
	}

}
