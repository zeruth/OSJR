package discord;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Backoff implementation
 */
public class Backoff {
	private long current;
	private final long maxAmount;

	private final long minAmount;

	private final Random random;

	/**
	 * Backoff constructor
	 *
	 * @param minAmount
	 *            Minimum amount of time
	 * @param maxAmount
	 *            Maximum amount of time
	 */
	public Backoff(long minAmount, long maxAmount) {
		this.minAmount = minAmount;
		this.maxAmount = maxAmount;

		this.random = new SecureRandom();

		this.current = minAmount;
	}

	/**
	 * Calculate the next delay based on previous results
	 *
	 * @return Next Delay
	 */
	public long nextDelay() {
		long delay = (long) (this.current * 2.0D * this.random.nextDouble());

		this.current = Math.min(this.current + delay, this.maxAmount);

		return this.current;
	}

	/**
	 * Reset the backoff
	 */
	public void reset() {
		this.current = this.minAmount;
	}
}
