package ru.nsu.kravchenko.operator;

import java.util.HashMap;
import java.util.function.Supplier;

public class OperFactory implements IOperFactory {
    private final HashMap<String, Supplier<IOperator>> operators = new HashMap<>();

    private Supplier<IOperator> registerOperator(String registry_name, Supplier<IOperator> operator){
        operators.put(registry_name, operator);
        return operator;
    }
    //registration start
    public final Supplier<IOperator> MULL = registerOperator("*", new MulOperator());
    public final Supplier<IOperator> ADD = registerOperator("+", new AddOperator());
    public final Supplier<IOperator> DIV = registerOperator("/", new DivOperator());
    public final Supplier<IOperator> SUB = registerOperator("-", new SubOperator());
    public final Supplier<IOperator> SQRT = registerOperator("SQRT", new SqrOperator());
    public final Supplier<IOperator> PRINT = registerOperator("PRINT", new Printer());
    public final Supplier<IOperator> POP = registerOperator("POP", new PopOperator());
    public final Supplier<IOperator> PUSH = registerOperator("PUSH", new PushOperator());
    public final Supplier<IOperator> DEFINE = registerOperator("DEFINE", new DefineOperator());

    @Override
    public IOperator getOperator(String registry_name) {
        if(!operators.containsKey(registry_name)){
            throw new RuntimeException("no such registry name: " + registry_name);
        }
        return operators.get(registry_name).get();
    }
}
