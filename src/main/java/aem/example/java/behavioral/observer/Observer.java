package aem.example.java.behavioral.observer;

public interface Observer<T> {

    void update(T t);

    class MyObserver implements Observer {
        private String name;

        public MyObserver(String name) {
            this.name = name;
        }

        @Override
        public void update(Object o) {
            System.out.println(String.format("Observer %s get a %s", this.name, o));
        }
    }
}
