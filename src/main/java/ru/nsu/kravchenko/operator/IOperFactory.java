package ru.nsu.kravchenko.operator;



public interface IOperFactory {
    public IOperator getOperator(String registry_name);

    public static IOperFactory makeOperFactrory(){
        return new OperFactory();
    }
}
