package com.amazon.pages;

import java.util.ArrayList;
import java.util.Iterator;

public class main {
    public static void main(String[] args) {

    }
    public static int sum(ArrayList<Integer> arr){

        Iterator<Integer> itr = arr.iterator();


        int sumAll=0;

        while(itr.hasNext()){

            sumAll+=itr.next();

        }


        return sumAll;

    }
}
