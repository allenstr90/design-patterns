package aem.example.java.behavioral.chainresponsibility;
/*
 * Chain of responsibility design pattern gives more than one object an opportunity to handle a request by linking
 * receiving objects together in form of a chain.
 * This pattern is recommended when multiple objects can handle a request and the handler doesn’t have to be a specific
 * object. Also, handler is determined at runtime. Please note that that a request not handled at all by any handler is
 * a valid use case.
 *
 * BookSaver -> DigitalSaver -> DefaultSaver
 *
 * https://howtodoinjava.com/design-patterns/behavioral/chain-of-responsibility-design-pattern/
 *
 * */