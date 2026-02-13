package ru.nsu.kravchenko.operator;

import ru.nsu.kravchenko.context.AbsractContext;


class Printer extends UnOperator {


    @Override
    public IOperator get() {
        return new Printer();
    }

    @Override
    protected float getResult(float a) {
        System.out.println(a);
        return a;
    }
}
