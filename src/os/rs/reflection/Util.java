package os.rs.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class Util {

	public static Object[][][] get3DArray(Object reference, Field field) {

		Object[] arr1D = getArray(reference, field);
		if (arr1D == null)
			return null;

		Object[][][] arr3D = new Object[arr1D.length][0][0];

		for (int i = 0; i < arr1D.length; i++) {
			if (arr1D[i] != null) {
				int length = Array.getLength(arr1D[i]);
				Object[] temp = new Object[length];
				arr3D[i] = new Object[length][0];
				for (int j = 0; j < length; j++) {
					temp[j] = Array.get(arr1D[i], j);
					int length2 = Array.getLength(temp[j]);
					arr3D[i][j] = new Object[length2];

					for (int k = 0; k < length; k++) {
						arr3D[i][j][k] = Array.get(temp[j], k);
					}

				}

			}

		}
		return arr3D;
	}

	public static Object[] getArray(Object obj, Field field) {
		try {
			Object array = field.get(obj);

			if (array == null)
				return null;

			int length = Array.getLength(array);
			Object[] arr = new Object[length];
			for (int i = 0; i < length; i++) {
				arr[i] = Array.get(array, i);

			}
			return arr;
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return null;
	}
}
