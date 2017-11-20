package os.jr.hooks.model;

import java.lang.reflect.Field;
import java.math.BigInteger;

public class RSField {
	private String refactoredName;
	private int multiplier;
	private Field field;
	private int inverseMultiplier;

	public RSField(String refactoredName, Field field, int multiplier) {
		this.multiplier = multiplier;
		this.field = field;
		this.refactoredName = refactoredName;
		this.inverseMultiplier = modInverse(multiplier + "");
		field.setAccessible(true);

	}

	public int getInverseMultiplier() {
		return inverseMultiplier;
	}

	public String getRefactoredName() {
		return refactoredName;
	}

	public int getMultiplier() {
		return multiplier;
	}

	public Field getField() {
		return field;
	}

	public Object getValue(Object reference) {
		if (reference == null)
			return null;

		try {
			if (multiplier!=1) {
				return (int) field.get(reference)*multiplier;
			}
			return field.get(reference);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static int modInverse(String integer) {
		BigInteger modulus = new BigInteger(String.valueOf(4294967296L));
		BigInteger m1 = new BigInteger(integer);
		return m1.modInverse(modulus).intValue();
	}

}
