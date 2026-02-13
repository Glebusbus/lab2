package ru.nsu.kravchenko.context;

public interface IParamsContext {
    int paramSize();
    String getParam(int index);

    void parse(String[] line);
}
