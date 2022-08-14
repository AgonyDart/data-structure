package queue;

public interface Queue {
    void add(Work task);
    void remove();
    Work get();
}
