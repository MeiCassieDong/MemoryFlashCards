package dragonwarrior.memorycard.model;

public class DataPair<T, D> {
    T m_a;
    D m_b;
    public DataPair(T t, D d) {
        m_a = t;
        m_b = d;
    }
    public T getA() {
        return m_a;
    }
    public D getB() {
        return m_b;
    }
}
