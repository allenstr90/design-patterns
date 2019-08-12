package aem.example.java.behavioral.mediator;

public class Processor {
    private String id;
    private ProcessorPool pool;

    public Processor(String id, ProcessorPool pool) {
        this.id = id;
        this.pool = pool;
    }

    public String getId() {
        return id;
    }

    public void process(String s) {
        System.out.println(String.format("Processor %s process %s", this.id, s));
    }

    public void send(String s, String id) {
        System.out.println(String.format("Processor %s send %s", this.id, s));
        pool.send(s, id);
    }
}
