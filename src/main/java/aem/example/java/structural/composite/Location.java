package aem.example.java.structural.composite;

public enum Location {
    INTERNET {
        @Override
        public double getFactor() {
            return 1.5;
        }
    },
    CINE {
        @Override
        public double getFactor() {
            return 2.8;
        }
    };

    public abstract double getFactor();
}
