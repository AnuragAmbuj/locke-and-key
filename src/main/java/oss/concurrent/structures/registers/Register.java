package oss.concurrent.structures.registers;

/**
 * At hardware level threads communicate by reading and writing
 * shared memory. A good way to understand inter-thread communication is to abstract
 * away from hardware primitives and think about communication as happening through
 * <i>shared concurrent objects</i>. Two key properties that define <i>shared concurrent objects</i>
 * are:<br>
 *     <ul>
 *         <li>Safety, defined by consistency conditions</li>
 *         <li>Liveness, defined by progress conditions</li>
 *     </ul>
 * A read-write register, or just a <i>Register</i>, is an object that encapsulates a value
 * that can be observed by <i>read()</i> method and modified by <i>write()</i> method.
 * Following interface is a register contract where T is typically an {@link Integer},{@link Boolean}
 * or a reference to an object.
 * <hr>
 * <b>Note: Above documentation has been taken directly from book "The Art of
 * Multiprocessor Programming" by Maurice Herlihy and Nir Shavit (Published by Morgan Kaufman).
 * Kindly read this book for a very detailed explanation of concepts.</b>
 * @param <T> Typically one of {@link Integer},{@link Boolean} or a reference to an object,
 * but can be user defined.
 */
public interface Register<T> {
    T read();
    void write(T v);
}
