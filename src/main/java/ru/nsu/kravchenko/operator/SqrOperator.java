package ru.nsu.kravchenko.operator;

class SqrOperator extends UnOperator {

    @Override
    protected float getResult(float a) {
        return (float) Math.sqrt(a);
    }

    @Override
    public IOperator get() {
        return new SqrOperator();
    }
}
