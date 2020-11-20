import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class Randoms implements Iterable<Integer> {

    private int min, max;

    Random random = new Random();

    public Randoms(int min, int max) {
        this.min = min;
        this.max = max;

    }

    public Iterator<Integer> iterator() {
        return new RandomsIterator();
    }

    public class RandomsIterator implements Iterator<Integer> {

        private int count;

        public RandomsIterator() {
            this.count = Randoms.this.min;
        }

        @Override
        public boolean hasNext() {
            return this.count < Randoms.this.max;
        }

        @Override
        public Integer next() {
            if (this.hasNext()) {
                return random.nextInt((max - min) - 1) + min;
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
