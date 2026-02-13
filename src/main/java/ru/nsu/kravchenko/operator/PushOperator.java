package ru.nsu.kravchenko.operator;

import ru.nsu.kravchenko.context.AbsractContext;


class PushOperator implements IOperator {




    @Override
    public void calculate(AbsractContext context) {
        if(context.paramSize() != 1){
            throw new RuntimeException("wrong number of arguments");
        }
        if(context.hasName(context.getParam(0))){
            context.push(context.getValue(context.getParam(0)));
        } else {
            try {
                float val = Float.parseFloat(context.getParam(0));
                context.push(val);
            } catch (NumberFormatException e){
                throw  new RuntimeException("invalid syntax", e);
            }
        }
    }

    @Override
    public IOperator get() {
        return new PushOperator();
    }
}
