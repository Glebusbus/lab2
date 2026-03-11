package ru.nsu.kravchenko;

import ru.nsu.kravchenko.context.AbsractContext;
import ru.nsu.kravchenko.operator.OperFactory;
import ru.nsu.kravchenko.parser.IComandParser;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



       if(args.length == 1){
           try(BufferedReader r = new BufferedReader(new FileReader(args[0]))){
               run(r);
           } catch (Exception e) {
               System.out.println(e.getMessage());
           }


       }else if (args.length == 0) {
           try(BufferedReader r = new BufferedReader(new InputStreamReader(System.in))){
               run(r);
           } catch (Exception e) {
               System.out.println(e.getMessage());
           }
       } else {
           System.out.println("Ivalid arguments");
       }

    }

    private static void run(BufferedReader reader){
        AbsractContext context = AbsractContext.makeContext();
        OperFactory factory = new OperFactory();
        IComandParser parser = IComandParser.makeParser(factory);

        parser.run(reader, context);
    }




}