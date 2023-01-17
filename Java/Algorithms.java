package oy.tol.tra;
import java.util.function.Predicate;

public class Algorithms {
    /** Sorts a generic array using a exchange sort
    * 
    * @param array to be sorted
    */
    public static <T extends Comparable<T>> void sort(T [] array){
        int i = 0;
        while (i < array.length-1){
            for (int j = i+1; j <= array.length-1; j++) {
                if (array[j].compareTo(array[i])<=0) {
                    swap(array, i, j);
                }
            }  
            i++;
        }
      
    }
    // swaps generic array the first half values on the array with the other half values
    public static <T> void reverse(T [] array){
        int i = 0;
        while (i < array.length/2) {
            swap(array, i, array.length-i-1);
            i++;
        }
    }
    // Swaps two values in array with the provided index values first and second
    public static <T> void swap(T [] array, int first, int second){
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
    /**
     * class for mode search
     */
    public static class ModeSearchResult<T> {
        public T theMode;
        public int count = 0;
    }
    /**
     * Mode search algotrithm that uses sort method for sorting
     * @param array where to find mode of
     * @return ModeSearchResult
     */
    public static <T extends Comparable<T>> ModeSearchResult<T> findMode(T [] array) {
        ModeSearchResult<T> result = new ModeSearchResult<>();
        result.theMode = null;
        result.count = -1;
        if (array == null || array.length < 2){
            return result;
        }
        sort(array);

        result.theMode = array[0];
        result.count = 1;
        
        int mostFrequency = 1;
        int tempFrequency = 1;
        int index = 1;
        // 1 1 1 1 2 2 3 4 4 5 6 6
        while (index < array.length){
            if (array[index].compareTo(array[index - 1]) == 0){
                tempFrequency++;
            } else {
                if (tempFrequency > mostFrequency){
                    result.count = tempFrequency;
                    result.theMode = array[index - 1];
                    mostFrequency = tempFrequency;
                }
                tempFrequency = 1;
            }
            index++;
        }
        if (tempFrequency > mostFrequency){
            result.count = tempFrequency;
            result.theMode = array[index - 1];
            mostFrequency = tempFrequency;
        }
        return result;
    }

    public static <T> int partitionByRule(T [] array, int count, Predicate<T> rule){
        if(array == null){
            return -1;
        }
        int index = 0;
        for (;index < count; index++)
            if(rule.test(array[index])){
                break;
            }
        if(index >= count){
            return count;
        }
        int nextIndex = index + 1;
        
        while (nextIndex < count){
            if(!(rule.test(array[nextIndex]))){
                swap(array,index, nextIndex);
                index++;
            }
            nextIndex++;
        }   
        return index;
    }

    public static <T extends Comparable<T>> int binarySearch(T aValue, T [] fromArray, int fromIndex, int toIndex) {
        if(fromIndex == toIndex){
            if(fromArray[fromIndex].compareTo(aValue) == 0){
                return fromIndex;
            } else {
                return -1;
            }
        } else {
            int middle = fromIndex + (toIndex - fromIndex) / 2;
            if (aValue.compareTo(fromArray[middle]) <= 0){
                return binarySearch(aValue, fromArray, fromIndex, middle);
            } else {
                return binarySearch(aValue, fromArray, middle + 1, toIndex);
            }
        }
    }
    /**
     * sorts an array using quicksort
     * @param <E>
     * @param array
     */
    public static <E extends Comparable<E>> void fastSort(E [] array){
        quickSort(array,0 ,array.length - 1);    
    }

    private static <E extends Comparable<E>> void quickSort(E [] array, int ala, int yla){
        if(ala < yla){
            int partitionIndex = partition(array, ala, yla);
            quickSort(array, ala, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, yla);
        }
    }

    private static <E extends Comparable<E>> int partition(E [] array, int ala, int yla){
        E loppuArvo = array[yla];
        int i = ala - 1;
        for (int j = ala; j < yla; j++){
            if (array[j].compareTo(loppuArvo) < 0){
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i+1, yla);
        return i + 1;
    }

}
