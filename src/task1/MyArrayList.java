package task1;

import java.util.Arrays;

public class MyArrayList<T> {
    private final int START_SIZE = 8;
    private final float EXPAND_MULTIPLIER = 1.5f;
    private final float TRIM_MULTIPLIER = 2.0f;
    private int size;
    private Object[] array;

    public MyArrayList(){
      this.array = new Object[START_SIZE];
      this.size = 0;
    }

    private void expandArray(){
        int newLength = (int) (array.length * EXPAND_MULTIPLIER);
        array = Arrays.copyOf(array, newLength);

        System.out.println("Expanded");
    }

    private void TrimIfNeed(){
        if (size==0) {
            return;
        }
        float multiplier = (float) array.length / size;
        if (multiplier > TRIM_MULTIPLIER) {
            int newLength = (int) (size * EXPAND_MULTIPLIER);
            if (newLength >= START_SIZE){
                trimArray(newLength);
            }
        }
    }

    private void trimArray(int newLength){
        array = Arrays.copyOf(array, newLength);
        System.out.println("Trimmed");
    }

    private void validateIndex(int index){
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
    }

    public void add(T value){
        int arraySize = array.length;
        if (size == array.length) {
            expandArray();
        }

        array[size] = value;
        size++;
    }

    public void remove(int index){
        validateIndex(index);

        size--;
        System.arraycopy(array,index+1, array, index, size - index);
        array[array.length-1] = null;

        TrimIfNeed();
    }

    public void clear(){
        this.array = new Object[START_SIZE];
        this.size = 0;
    }

    public int size(){
        return size;
    }


    public T get(int index){
        validateIndex(index);

        return (T) array[index];
    }

    @Override
    public String toString(){
        return Arrays.toString(Arrays.copyOf(array, size));
    }
}


