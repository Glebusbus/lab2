package ru.nsu.kravchenko.parser;

import ru.nsu.kravchenko.context.AbsractContext;
import ru.nsu.kravchenko.operator.IOperFactory;
import ru.nsu.kravchenko.operator.IOperator;

import java.io.BufferedReader;
import java.io.IOException;


class ComandParser implements IComandParser{
    private IOperFactory factory;
    private String comand;
    private String[] params;

    public ComandParser(IOperFactory factory){
        this.factory = factory;
    }

    private void parseLine(String line){
        String[] lines = line.split(" ");
        comand = lines[0];
        params = new String[lines.length - 1];
        for (int i = 1; i < lines.length; i++) {
            params[i-1] = lines[i];
        }
    }
    @Override
    public void run(BufferedReader reader, AbsractContext context) {
        String line;

        while (true){
            try {
                line = reader.readLine();

                if (line == null) {
                    break;
                }

            } catch (IOException e) {
                System.out.println("Error reading input: " + e.getMessage());
                break;
            }

            if (line.trim().isEmpty()) {
                continue;
            }
            parseLine(line);
            if(comand.charAt(0) == '#'){
                continue;
            }

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
