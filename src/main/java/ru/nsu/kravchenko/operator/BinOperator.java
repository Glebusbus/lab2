package ru.nsu.kravchenko.operator;


import ru.nsu.kravchenko.context.AbsractContext;
import ru.nsu.kravchenko.operator.IOperator;

abstract class BinOperator implements IOperator {
    protected abstract float getResult(float a, float b);

    @Override
    public void calculate(AbsractContext context) {
        if(context.stackSize() < 2){
            throw new RuntimeException("stack issue");
        }
        float a = context.pop();
        float b = context.pop();
        context.push(getResult(a, b));
    }
}
