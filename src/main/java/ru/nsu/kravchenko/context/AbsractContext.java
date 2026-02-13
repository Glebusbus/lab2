package ru.nsu.kravchenko.context;

public abstract class AbsractContext implements IParamsContext, IStackContext, INameSpace{

    public static AbsractContext makeContext(){
        return new Context();
    }
}
