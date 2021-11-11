package de.vfh.algodat;

import java.lang.reflect.Array;

public class Utils {

    public static <T> void debugArray(T[] right) {
        for (int i = 0; i < right.length; i++) {
            System.out.println("[" + i + "]:" + right[i].toString());
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] rest(T[] array, Class<T> type) {
        T[] result = (T[]) Array.newInstance(type, array.length - 1);
        if (result.length == 0) {
            return result;
        }
        try {
            System.arraycopy(array, 1, result, 0, array.length - 1);
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] concat(T[] array, T value, Class<T> type) {
        T[] result = (T[]) Array.newInstance(type, array.length + 1);
        System.arraycopy(array, 0, result, 0, array.length);
        result[result.length - 1] = value;
        return result;
    }

}
