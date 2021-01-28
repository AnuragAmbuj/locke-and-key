package oss.concurrent.structures.registers;

/**
 * Implementation of an Atomic SRSW register.
 * @param <T>
 */
public class AtomicSingleReadSingleWriteRegister<T> implements Register<T> {



    @Override
    public T read() {
        return null;
    }

    @Override
    public void write(T v) {

    }
}
