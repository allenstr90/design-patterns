package aem.example.java.structural.flyweight;
/*
 * Sharing of objects to support large numbers of fine-grained objects efficiently. A flyweight is a shared object
 * that can be used in multiple contexts simultaneously. The flyweight acts as an independent object in each context.
 *
 * An intrinsic state attribute is stored/shared in the flyweight object, and it is independent of flyweight’s context.
 * As the best practice, we should make intrinsic states immutable.
 *
 * An extrinsic state varies with flyweight’s context, which is why they cannot be shared. Client objects maintain
 * the extrinsic state, and they need to pass this to a flyweight object during object creation.
 *
 * https://howtodoinjava.com/design-patterns/structural/flyweight-design-pattern/
 *
 */