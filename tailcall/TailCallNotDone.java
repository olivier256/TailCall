package tailcall;

import java.util.concurrent.Callable;
import java.util.stream.Stream;

/**
 * Pour tous les appels récursifs NON-terminés, on instancie cette classe, qui
 * propose de construire une liste des appels récursifs.
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
	 * Appelle la méthode TailCall::get en boucle tant que le TailCall renvoyé n'est
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
