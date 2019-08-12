package aem.example.java.behavioral.chainresponsibility;

public class DigitalSaver implements Store {

    private Store nextStore;

    public DigitalSaver(Store nextStore) {
        this.nextStore = nextStore;
    }

    @Override
    public boolean store(Resource resouce) {
        if (resouce.getType() == ResourceType.DIGITAL) {
            System.out.println("DigitalSaver:store Saving resource type " + resouce.getType().name());
            return true;
        }
        System.out.println("DigitalSaver -> passing to next store");
        return nextStore.store(resouce);
    }

    public Store getNextStore() {
        return nextStore;
    }
}
