package ru.nsu.kravchenko.operator;

import org.junit.Test;
import ru.nsu.kravchenko.context.AbsractContext;

import static org.junit.jupiter.api.Assertions.*;

class MyTest {
    @Test
    void test_1(){
        AbsractContext context = AbsractContext.makeContext();
        IOperFactory factory = IOperFactory.makeOperFactrory();

        context.push(5);
        context.push(3);

        factory.getOperator("+").calculate(context);

        assertEquals(8, context.pop());

    }

}