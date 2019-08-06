package aem.example.java.structural.bridge;
/**
 * Bridge design pattern is used to decouple a class into two parts – abstraction and it’s implementation – so
 * that both can evolve in future without affecting each other. It increases the loose coupling between
 * class abstraction and it’s implementation.
 * Bridge design pattern is most applicable in applications where you need to provide platform independence.
 * Explain:
 * -Segregation interface
 * -An interface X to do an action
 * -An implementation of X that use a Specialization S of X
 * -Multiple implementation S that do the job in different environments
 *
 * Bridge pattern decouple an abstraction from its implementation so that the two can vary independently.
 * It is used mainly for implementing platform independence feature.
 * It adds one more method level redirection to achieve the objective.
 * Publish abstraction interface in separate inheritance hierarchy, and put implementation in its own inheritance hierarchy.
 * Use bridge pattern to run-time binding of the implementation.
 * Use bridge pattern to map orthogonal class hierarchies
 * Bridge is designed up-front to let the abstraction and the implementation vary independently.
 *
 * https://howtodoinjava.com/design-patterns/structural/bridge-design-pattern/
 */