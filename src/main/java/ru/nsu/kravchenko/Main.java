package ru.nsu.kravchenko;

import ru.nsu.kravchenko.context.AbsractContext;
import ru.nsu.kravchenko.operator.OperFactory;
import ru.nsu.kravchenko.parser.IComandParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String resource = "config.txt";
        AbsractContext context = AbsractContext.makeContext();
        OperFactory factory = new OperFactory();
        IComandParser parser = IComandParser.makeParser(factory);
        Scanner scanner;
        try {
            scanner = new Scanner(new File(resource));
        } catch (FileNotFoundException e) {
            System.out.println("No such file: " + resource);
            return;
        }
        parser.run(scanner, context);


    }
}