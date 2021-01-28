package oss.concurrent.structures.registers;

public class SequentialRegister<T> implements Register<T> {
    private T v;

    @Override
    public T read() {
        return v;
    }

    @Override
    public void write(T v) {
        this.v = v;
    }
}
