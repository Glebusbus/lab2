package ru.nsu.kravchenko.context;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class Context extends AbsractContext{

    Stack<Float> stack;
    HashMap<String, Float> nameSpace;
    List<String> params;

    public Context(){
        stack = new Stack<>();
        nameSpace = new HashMap<>();
        params = new ArrayList<>();
    }

    @Override
    public boolean hasName(String name) {
        return nameSpace.containsKey(name);
    }

    @Override
    public float getValue(String name) {
        return nameSpace.get(name);
    }

    @Override
    public void initName(String name, float value) {
        nameSpace.put(name, value);
    }

    @Override
    public int paramSize() {
        return params.size();
    }

    @Override
    public String getParam(int index) {
        return params.get(index);
    }

    @Override
    public void parse(String[] line) {
        params.clear();
        for (int i = 0; i < line.length; i++) {
            params.add(line[i]);
        }
    }

    @Override
    public float pop() {
        return stack.pop();
    }

    @Override
    public void push(float value) {
        stack.push(value);
    }

    @Override
    public int stackSize() {
        return stack.size();
    }
}
