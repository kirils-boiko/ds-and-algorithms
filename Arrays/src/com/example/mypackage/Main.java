package com.example.mypackage;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Integer example = 5;

        ArrayList<Integer> exampleArrayList = new ArrayList<>();
        exampleArrayList.add(example);

        example = 6;

        System.out.println(exampleArrayList.get(0));
    }
}
