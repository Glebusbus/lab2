package ru.nsu.kravchenko.operator;


class AddOperator extends BinOperator {

    @Override
    protected float getResult(float a, float b) {
        return a+b;
    }

    @Override
    public IOperator get() {
        return new AddOperator();
    }
}
