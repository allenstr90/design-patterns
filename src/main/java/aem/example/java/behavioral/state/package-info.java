package aem.example.java.behavioral.state;
/*
 * Always try to make state objects singletons.
 *
 * State – The interface define operations which each state must handle.
 * Concrete States – The classes which contain the state specific behavior.
 * Context – Defines an interface to client to interact. It maintains references to concrete state object which
 * may be used to define current state of object. It delegates state-specific behavior to different State objects.
 *
 * https://howtodoinjava.com/design-patterns/behavioral/state-design-pattern/
 *
 * */