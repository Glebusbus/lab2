package ru.nsu.kravchenko.operator;


class DivOperator extends BinOperator {
    @Override
    protected float getResult(float a, float b) {
        if(b == 0){
            throw new RuntimeException("Division by zero!!!");
        }
        return a/b;
    }


}
