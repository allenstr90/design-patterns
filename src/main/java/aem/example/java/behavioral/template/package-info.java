package aem.example.java.behavioral.template;
/*
 * Template method pattern defines the sequential steps to execute a multi-step algorithm and optionally can provide
 * a default implementation as well (based on requirements).
 * Mark template method as final so that implementing class can’t override and change the order of steps.
 * In base class, implement all the methods with default implementation so the derived classes need not to define them.
 * Mark all methods abstract which derived classes must implement.
 *
 * Template pattern is a very easy design pattern which is used to define and enforcing certain sequential algorithm
 * steps in programming paradigm. It helps in defining the skeleton of an algorithm, which shall not be overridden
 * in sub classes.
 *
 * https://howtodoinjava.com/design-patterns/behavioral/template-method-pattern/
 * */