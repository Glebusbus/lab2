package ru.nsu.kravchenko.operator;

import ru.nsu.kravchenko.context.AbsractContext;


class Printer extends UnOperator {




    @Override
    protected float getResult(float a) {
        System.out.print(a+"\n");
        return a;
    }
}
