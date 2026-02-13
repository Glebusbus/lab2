package ru.nsu.kravchenko.operator;

import ru.nsu.kravchenko.context.AbsractContext;


import java.util.function.Supplier;

public interface IOperator extends Supplier<IOperator> {
    void calculate(AbsractContext context);
}
