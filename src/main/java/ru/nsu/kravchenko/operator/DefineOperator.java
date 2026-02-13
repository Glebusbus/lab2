package ru.nsu.kravchenko.operator;

import ru.nsu.kravchenko.context.AbsractContext;


class DefineOperator implements IOperator {


    @Override
    public void calculate(AbsractContext context) {
        if(context.paramSize() != 2){
            throw new RuntimeException("wrong number of arguments");
        }
        try {
            float val = Float.parseFloat(context.getParam(1));
            context.initName(context.getParam(0), val);
        } catch (NumberFormatException e){
            throw new RuntimeException("invalid syntax", e);
        }
    }


}
