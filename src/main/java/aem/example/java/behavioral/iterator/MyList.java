package aem.example.java.behavioral.iterator;

public interface MyList<T> {

    MyIterator<T> iterator();

    class MyListImpl<T> implements MyList {
        private T[] ts;

        public MyListImpl(T[] ts) {
            this.ts = ts;
        }

        @Override
        public MyIterator iterator() {
            return new MyIterator.MyIteratorImpl(ts);
        }
    }
}
