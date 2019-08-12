package aem.example.java.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public interface Observable<T> {
    void subscribe(Observer observer);

    void unSubscribe(Observer observer);

    void notify(T t);

    class MyObservable implements Observable {
        private List<Observer> observers;

        public MyObservable() {
            this.observers = new ArrayList<>();
        }

        @Override
        public void subscribe(Observer observer) {
            this.observers.add(observer);
        }

        @Override
        public void unSubscribe(Observer observer) {
            this.observers.remove(observer);
        }

        @Override
        public void notify(Object o) {
            observers.forEach(observer -> observer.update(o));
        }
    }
}
