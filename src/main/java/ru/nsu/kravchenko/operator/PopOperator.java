package ru.nsu.kravchenko.operator;

import ru.nsu.kravchenko.context.AbsractContext;

public class PopOperator implements IOperator {




    @Override
    public void calculate(AbsractContext context) {
        if(context.paramSize() > 1){
            throw  new RuntimeException("wrong number of arguments");
        }
        if(context.paramSize() == 0){
            context.pop();
        }else {
            float val = context.pop();
            context.initName(context.getParam(0), val);
        }
    }
}
