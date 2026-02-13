package ru.nsu.kravchenko.context;

public interface IStackContext {

    float pop();
    void push(float value);
    int stackSize();
}
