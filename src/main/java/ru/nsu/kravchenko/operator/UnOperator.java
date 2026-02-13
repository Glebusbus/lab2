package ru.nsu.kravchenko.operator;

import ru.nsu.kravchenko.context.AbsractContext;
import ru.nsu.kravchenko.operator.IOperator;


abstract class UnOperator implements IOperator {

    protected abstract float getResult(float a);

    @Override
    public void calculate(AbsractContext context) {
        if(context.stackSize() < 1){
            throw new RuntimeException("stack issue");
        }
        float a = context.pop();
        context.push(getResult(a));
    }
}
