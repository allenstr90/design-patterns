package aem.example.java.structural.adapter;
/**
 * An adapter convert the interface of a class into another interface clients expect.
 * It lets classes work together that couldn’t otherwise because of incompatible interfaces.
 *
 * System use a class, that class consume a specific type, create a class that extends of specific type and transform
 * the new type to the specific type
 *   System Class                               Adapter Class        Resource to Adapt
 *      ||                                          ||                 ||
 *      \/                                          \/                 \/
 *  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *
 * <p>
 * Explain (Use interfaces for simplicity):
 * -Publisher use a Synopsis interface to publish content ( In movie is synopsis)
 * -Need publish book synopsis ( In book is resume)
 * -No modify code
 * -Interface Resume extends of Synopsis
 * -Book implement Resume
 * -Now Publisher can publish a book synopsis
 * </p>
 *
 * https://howtodoinjava.com/design-patterns/structural/adapter-design-pattern-in-java/
 *
 *
 * The classes and/or objects participating in this pattern are listed as below:
 *
 * Target (Synopsis): It defines the application-specific interface that Client uses directly.
 * Adapter (Resume): It adapts the interface Adaptee to the Target interface. It’s middle man.
 * Adaptee (Book): It defines an existing incompatible interface that needs adapting before using in application.
 * Client: It is your application that works with Target interface.
 */