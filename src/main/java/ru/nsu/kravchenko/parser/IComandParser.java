package ru.nsu.kravchenko.parser;

import ru.nsu.kravchenko.context.AbsractContext;
import ru.nsu.kravchenko.operator.IOperFactory;

import java.io.BufferedReader;
import java.io.IOException;

public interface IComandParser {
    void run(BufferedReader reader, AbsractContext context);
    static IComandParser makeParser(IOperFactory factory){
        return new ComandParser(factory);
    }


}
