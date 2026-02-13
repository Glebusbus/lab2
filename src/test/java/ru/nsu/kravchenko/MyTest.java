package ru.nsu.kravchenko;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.nsu.kravchenko.context.AbsractContext;
import ru.nsu.kravchenko.operator.IOperFactory;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MyTest {







    @Test
    public void test_1(){
        AbsractContext context = AbsractContext.makeContext();
        IOperFactory factory = IOperFactory.makeOperFactrory();

        context.push(5);
        context.push(3);

        factory.getOperator("+").calculate(context);

        assertEquals(8, context.pop());
    }
    @Test
    public void test_2(){
        AbsractContext context = AbsractContext.makeContext();
        IOperFactory factory = IOperFactory.makeOperFactrory();

        context.push(5);
        context.push(3);

        factory.getOperator("-").calculate(context);

        assertEquals(-2, context.pop());
    }
    @Test
    public void test_3(){
        AbsractContext context = AbsractContext.makeContext();
        IOperFactory factory = IOperFactory.makeOperFactrory();

        context.push(5);
        context.push(3);

        factory.getOperator("*").calculate(context);

        assertEquals(15, context.pop());
    }

    @Test
    public void test_4(){
        AbsractContext context = AbsractContext.makeContext();
        IOperFactory factory = IOperFactory.makeOperFactrory();

        context.push(2);
        context.push(21);

        factory.getOperator("/").calculate(context);

        assertEquals(10.5f, context.pop());
    }

    @Test
    public void test_5(){
        AbsractContext context = AbsractContext.makeContext();
        IOperFactory factory = IOperFactory.makeOperFactrory();

        context.push(9);


        factory.getOperator("SQRT").calculate(context);

        assertEquals(3, context.pop());
    }

    @Test
    public void test_6(){
        AbsractContext context = AbsractContext.makeContext();
        IOperFactory factory = IOperFactory.makeOperFactrory();

        context.push(5);
        context.push(3);

        factory.getOperator("+").calculate(context);

        assertEquals(8, context.pop());
    }

    @Test
    public void test_7(){
        AbsractContext context = AbsractContext.makeContext();
        IOperFactory factory = IOperFactory.makeOperFactrory();

        context.parse(new String[]{"a", "12345.6"});

        factory.getOperator("DEFINE").calculate(context);

        context.parse(new String[]{"a"});

        factory.getOperator("PUSH").calculate(context);

        assertEquals(12345.6f, context.pop());
    }
    @Test
    public void test_8(){
        AbsractContext context = AbsractContext.makeContext();
        IOperFactory factory = IOperFactory.makeOperFactrory();

        context.push(5);
        context.push(3);

        factory.getOperator("POP").calculate(context);

        assertEquals(5, context.pop());
    }

    @Test
    public void test_9(){
        AbsractContext context = AbsractContext.makeContext();
        IOperFactory factory = IOperFactory.makeOperFactrory();

        context.push(5);
        context.parse(new String[]{"a"});

        factory.getOperator("POP").calculate(context);

        factory.getOperator("PUSH").calculate(context);
        factory.getOperator("PUSH").calculate(context);
        factory.getOperator("*").calculate(context);

        assertEquals(25, context.pop());
    }
    @Test
    public void test_10(){
        AbsractContext context = AbsractContext.makeContext();
        IOperFactory factory = IOperFactory.makeOperFactrory();

        context.push(420);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(outContent));

        factory.getOperator("PRINT").calculate(context);

        System.setOut(originalOut);

        String out = outContent.toString();
        assertEquals("420.0 ", out);
    }

}