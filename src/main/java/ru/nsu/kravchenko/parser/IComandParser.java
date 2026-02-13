package ru.nsu.kravchenko.parser;

import ru.nsu.kravchenko.context.AbsractContext;
import ru.nsu.kravchenko.operator.IOperFactory;

import java.util.Scanner;

public interface IComandParser {
    void run(Scanner scanner, AbsractContext context);
    static IComandParser makeParser(IOperFactory factory){
        return new ComandParser(factory);
    }


}
