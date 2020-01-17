package ua.nure.panchenko.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {

    private Object[] values = {};

    @Override
    public void add(Object element) {
       Object[] temp = new Object[values.length +1];
       System.arraycopy(values, 0, temp, 0, values.length);
       temp[temp.length - 1] = element;
       values = temp;
    }

    @Override
    public void set(int index, Object element) {
        Object[] temp = values;
        values = new Object[temp.length];
        System.arraycopy(temp, 0, values, 0, index);
        values[index] = element;
        System.arraycopy(temp, index + 1, values, index + 1, temp.length - index -1);

    }

    @Override
    public Object get(int index) {
        try {
            return values[index];
        } catch (ArrayIndexOutOfBoundsException ex) {
            return ex.getStackTrace();
        }
    }

    @Override
    public int indexOf(Object element) {
        int position = -1;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == element) {
                position = i;
            }
        }
        return position;
    }

    @Override
    public void remove(int index) {
        try {
            Object[] temp = values;
            values = new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            System.arraycopy(temp, index + 1, values, index, temp.length - index -1);

        } catch (ArrayIndexOutOfBoundsException ex) {
            ex.getStackTrace();
        }

    }

    @Override
    public void clear() {
        values = new Object[] {};
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (values.length == 0) {
            sb.append("[]");
        } else {
            sb.append("[");
            for (int i = 0; i < values.length - 1; i++) {
                sb.append(values[i] + ", ");
            }
            sb.append(values[values.length-1]);
            sb.append("]");
        }
        return sb.toString();
    }
    private class IteratorImpl implements Iterator<Object> {

        private int iterator = -1;

        public IteratorImpl() {
        }

        @Override
        public boolean hasNext() {
            return iterator < size() - 1;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            iterator++;
            return values[iterator];
        }

        @Override
        public void remove() {
            if (iterator == -1) {
                throw new IllegalStateException();
            }
            values[iterator] = new Object();
            ArrayImpl.this.remove(iterator);
            iterator -= 1;
        }
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }
}
