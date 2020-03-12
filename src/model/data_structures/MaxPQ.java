package model.data_structures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class MaxPQ<T> implements Iterable<T> {
    private T[] pq;                 
    private int n;                      
    private Comparator<T> comparator;  

    public MaxPQ(int initCapacity) {
        pq = (T[]) new Object[initCapacity + 1];
        n = 0;
    }

    public MaxPQ() {
        this(1);
    }

    public MaxPQ(int initCapacity, Comparator<T> comparator) {
        this.comparator = comparator;
        pq = (T[]) new Object[initCapacity + 1];
        n = 0;
    }


    public MaxPQ(Comparator<T> comparator) {
        this(1, comparator);
    }

    public MaxPQ(T[] Ts) {
        n = Ts.length;
        pq = (T[]) new Object[Ts.length + 1];
        for (int i = 0; i < n; i++)
            pq[i+1] = Ts[i];
        for (int k = n/2; k >= 1; k--)
            sink(k);
        assert isMaxHeap();
    }
      
    public boolean isEmpty() {
        return n == 0;
    }

    public int darNumElementos() {
        return n;
    }

    public T darMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    private void resize(int capacity) {
        assert capacity > n;
        T[] temp = (T[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public void agregar(T x) {    	
        if (n == pq.length - 1) resize(2 * pq.length);

        pq[++n] = x;
        swim(n);
        assert isMaxHeap();
    }

    public T sacarMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        T max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null;     
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        assert isMaxHeap();
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<T>) pq[i]).compareTo(pq[j]) < 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }

    private void exch(int i, int j) {
        T swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    private boolean isMaxHeap() {
        return isMaxHeap(1);
    }

    private boolean isMaxHeap(int k) {
        if (k > n) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= n && less(k, left))  return false;
        if (right <= n && less(k, right)) return false;
        return isMaxHeap(left) && isMaxHeap(right);
    }


    public Iterator<T> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<T> {

        private MaxPQ<T> copy;

        public HeapIterator() {
            if (comparator == null) copy = new MaxPQ<T>(darNumElementos());
            else                    copy = new MaxPQ<T>(darNumElementos(), comparator);
            for (int i = 1; i <= n; i++)
                copy.agregar(pq[i]);
        }

        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.sacarMax();
        }
    }

   

}
