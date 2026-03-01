package ru.nsu.kravchenko;

import ru.nsu.kravchenko.context.AbsractContext;
import ru.nsu.kravchenko.operator.OperFactory;
import ru.nsu.kravchenko.parser.IComandParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        String resource = "config.txt";
        AbsractContext context = AbsractContext.makeContext();
        OperFactory factory = new OperFactory();
        IComandParser parser = IComandParser.makeParser(factory);

        try (BufferedReader reader = new BufferedReader(new FileReader("config.txt"))){
            parser.run(reader, context);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }
}