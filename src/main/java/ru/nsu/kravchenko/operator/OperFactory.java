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
    public final Supplier<IOperator> MULL = registerOperator("*", MulOperator::new);
    public final Supplier<IOperator> ADD = registerOperator("+", AddOperator::new);
    public final Supplier<IOperator> DIV = registerOperator("/", DivOperator::new);
    public final Supplier<IOperator> SUB = registerOperator("-", SubOperator::new);
    public final Supplier<IOperator> SQRT = registerOperator("SQRT", SqrOperator::new);
    public final Supplier<IOperator> PRINT = registerOperator("PRINT", Printer::new);
    public final Supplier<IOperator> POP = registerOperator("POP", PopOperator::new);
    public final Supplier<IOperator> PUSH = registerOperator("PUSH", PushOperator::new);
    public final Supplier<IOperator> DEFINE = registerOperator("DEFINE", DefineOperator::new);

    @Override
    public IOperator getOperator(String registry_name) {
        if(!operators.containsKey(registry_name)){
            throw new RuntimeException("no such registry name: " + registry_name);
        }
        return operators.get(registry_name).get();
    }
}
