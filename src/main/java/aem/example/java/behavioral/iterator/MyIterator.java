package aem.example.java.behavioral.iterator;

public interface MyIterator<T> {

    boolean hasNext();

    T next();

    T current();

    void reset();

    class MyIteratorImpl<T> implements MyIterator {

        private T[] ts;
        private int position;

        public MyIteratorImpl(T[] ts) {
            this.ts = ts;
            this.position = 0;
        }

        @Override
        public boolean hasNext() {
            return position < ts.length - 1;
        }

        @Override
        public Object next() {
            return ts[hasNext() ? ++position : position];
        }

        @Override
        public Object current() {
            return ts[position];
        }

        @Override
        public void reset() {
            position = 0;
        }
    }
}
