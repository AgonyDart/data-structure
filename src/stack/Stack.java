package stack;

public interface Stack {
    void push(URL url);
    void pop();
    URL get();
    int length();
    boolean isEmpty();
}
