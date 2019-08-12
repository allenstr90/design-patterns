package aem.example.java.behavioral.command;
/*
 * Command design pattern is useful to abstract the business logic into discrete actions which we call commands.
 * These command objects help in loose coupling between two classes where one class (invoker) shall call a method
 * on other class (receiver) to perform a business operation.
 *
 * Command interface – for declaring an operation.
 * Concrete command classes – which extends the Command interface, and has execute method for invoking business
 * operation methods on receiver. It internally has reference of the receiver of command.
 * Invoker – which is given the command object to carry out the operation.
 * Receiver – which execute the operation.
 *
 * https://howtodoinjava.com/design-patterns/behavioral/command-pattern/
 *
 * */