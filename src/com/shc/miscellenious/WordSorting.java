package com.shc.miscellenious;

import com.fasterxml.jackson.databind.ser.std.MapProperty;
import sun.net.www.protocol.gopher.GopherClient;

import java.util.*;

/**
 * Created by uchaudh on 1/27/2016.
 */
public class WordSorting {

    static boolean isDouble=false;
    static int ROccurrence=0;
    static int GOccurrence=0;
    static int BOccurrence=0;

    public static void main(String[] args) {

        Random rnd=new Random();
        int random = rnd.nextInt(10)+1;


        String input= "RRGBGS";
        int length=input.length();

        if(length%2==0)
        {
            getAllInstances(input);
            if((ROccurrence%2==0) && (GOccurrence %2==0) && (BOccurrence%2==0))
              isDouble= true;

        }
        else
        isDouble=false;


        System.out.println("Is double : "+ isDouble);
        new WordSorting().sortWords();
    }

    private static void getAllInstances(String input)
    {
        char[] inputChars=input.toCharArray();
        for(int i=0;i< inputChars.length;i++)
        {
            switch (inputChars[i])
            {
                case 'R':ROccurrence++;
                    break;
                case  'G':GOccurrence++;
                    break;
                case 'B':BOccurrence++;
                    break;
            }
        }
    }

    private void sortWords()
    {
        String input="This is a word";
        String[] words= input.toLowerCase().split(" ");
        Arrays.sort(words);

        TreeSet<String> ts=new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });

        ts.addAll(Arrays.asList(words));

        System.out.println("Sorted words are : " + Arrays.toString(words));


    }

}
