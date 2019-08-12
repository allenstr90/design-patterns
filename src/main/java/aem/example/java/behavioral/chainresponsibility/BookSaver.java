package aem.example.java.behavioral.chainresponsibility;

public class BookSaver implements Store {

    private Store nextStore;

    @Override
    public boolean store(Resource resouce) {
        return nextStore.store(resouce);
    }

    public BookSaver setNextStore(Store nextStore) {
        this.nextStore = nextStore;
        return this;
    }


}
