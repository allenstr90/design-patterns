package aem.example.java.behavioral.mediator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProcessorPool {

    private Map<String, Processor> map;

    public ProcessorPool() {
        this.map = new HashMap<>();
    }

    public void add(Processor processor) {
        this.map.put(processor.getId(), processor);
    }

    public void send(String s, String id) {
        System.out.println("Finding processor...");
        Optional.ofNullable(map.get(id)).ifPresent(processor -> processor.process(s));
    }
}
