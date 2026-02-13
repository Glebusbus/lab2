package ru.nsu.kravchenko.parser;

import ru.nsu.kravchenko.context.AbsractContext;
import ru.nsu.kravchenko.operator.IOperFactory;
import ru.nsu.kravchenko.operator.IOperator;

import java.util.Scanner;

class ComandParser implements IComandParser{
    private IOperFactory factory;
    private String comand;
    private String[] params;

    public ComandParser(IOperFactory factory){
        this.factory = factory;
    }

    private void parseLine(Scanner scanner){
        String[] line = scanner.nextLine().split(" ");
        comand = line[0];
        params = new String[line.length - 1];
        for (int i = 1; i < line.length; i++) {
            params[i-1] = line[i];
        }
    }
    @Override
    public void run(Scanner scanner, AbsractContext context) {
        while (scanner.hasNext()){
            parseLine(scanner);

            IOperator operator;

            try {
                operator = factory.getOperator(comand);
            } catch (Throwable e){
                System.out.println("Error while parsing comand-operator: ");
                System.out.println(e.getMessage());
                continue;
            }

            context.parse(params);
            try {
                operator.calculate(context);
            } catch (Throwable e) {
                System.out.println("Error while calculating comand-operator: ");
                System.out.println(e.getMessage());
            }



        }
    }
}
