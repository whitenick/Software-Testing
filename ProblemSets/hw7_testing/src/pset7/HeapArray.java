package pset7;

import java.util.HashSet;
import java.util.Set;
import gov.nasa.jpf.jvm.Verify;

public class HeapArray {
    int size;
    Integer[] array;
    HashSet<Integer> set = new HashSet<>();

    boolean repOk() {
        //check array is non-null
        if(array == null) {
            return false;
        }

        if(size < 0 || size > array.length) {
            return false;
        }

        for(int i = 0; i < size; i++) {
            //check that elements are non-null
            if(array[i] == null) {
                return false;
            }
            if(i > 0 && array[i] > array[(i-1)/2]) {
                return false;
            }
            if(!set.add(array[i])) {
                return false;
            }
        }

        // check that non-heap elements are null
        for(int i = size; i < array.length; i++) {
            if(array[i] != null) {
                return false;
            }
        }
    }
}
