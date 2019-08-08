package aem.example.java.structural.decorator;
/*
 * Decorator design pattern is used to add additional features or behaviors to a particular instance of a class,
 * while not modifying the other instances of same class.
 *
 * When we have an object that requires the extension but by design that is not suitable, go for decoration.
 *
 * Component – this is the wrapper which can have additional responsibilities associated with it at runtime.
 * Concrete component– is the original object to which the additional responsibilities are added in program.
 * Decorator-this is an abstract class which contains a reference to the component object and also implements the component interface.
 * Concrete decorator-they extend the decorator and builds additional functionality on top of the Component class.
 *
 *
 *                          Publisher
 *                      /                 \
 *              BookPublisher         PublisherDecorator
 *                                          |
 *                                     SupportFileSystemPublish
 *
 * https://howtodoinjava.com/design-patterns/structural/decorator-design-pattern/
 *
 */