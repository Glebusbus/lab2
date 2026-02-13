package ru.nsu.kravchenko.context;

public interface INameSpace {
    boolean hasName(String name);
    float getValue(String name);
    void initName(String name, float value);
}
