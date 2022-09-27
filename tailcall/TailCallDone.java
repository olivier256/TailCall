package tailcall;

/**
 * Quand un appel r�cursif est termin�, quand il n'y a plus de profondeur �
 * creuser, on renvoie une instance de cette classe, qui pr�cise qu'on est
 * <I>done</I>, et qui propose un <CODE>result</CODE>.
 * 
 * @author obrosseron
 *
 * @param <T>
 */
public final class TailCallDone<T> implements TailCall<T> {
	private final T value;

	public TailCallDone(T value) {
		this.value = value;
	}

	@Override
	public TailCall<T> get() {
		throw new TailCallError("not implemented");
	}

	@Override
	public boolean isDone() {
		return true;
	}

	@Override
	public T result() {
		return value;
	}

}
