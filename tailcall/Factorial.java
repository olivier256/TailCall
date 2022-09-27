package tailcall;

public class Factorial extends TailCallNotDone<Long> {
	private final int depth;
	private final Long startValue;

	public Factorial(int depth) {
		this(depth, 1L);
	}

	private Factorial(int depth, Long startValue) {
		this.depth = depth;
		this.startValue = startValue;
	}

	/*
	 * La méthode call() de TailCallNotDone va appeler cette méthode get(). Cette
	 * méthode renvoit soit une instance de TailCallDone quand on a fini, soit une
	 * instance de TailCallNotDone si on n'a pas fini.
	 */
	@Override
	public TailCall<Long> get() {
		if (depth == 1) {
			return new TailCallDone<>(startValue);
		} else {
			return new TailCallNotDone<Long>() {

				@Override
				public TailCall<Long> get() {
					return new Factorial(depth - 1, startValue * depth);
				}

			};
		}
	}

}
