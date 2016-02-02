package com.shc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int moveCount=0;
    static int mangoesMoved=0;
    static int equalBucketLength=0;
    static List<Integer> extraMangoes = new ArrayList<Integer>();
    static List<Integer> requiredMangoes = new ArrayList<Integer>();
    static boolean exactlyMatched= false;

    public static void main(String[] args) {
        // write your code here
        try {


            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

            String[] mangoes = bufferRead.readLine().split(" ");

            int sum = 0;
            for (String i : mangoes) {
                sum = sum + Integer.parseInt(i);
            }
            if (sum % mangoes.length == 0) {
                int mangoesPerBasket = sum / mangoes.length;
                for (String man : mangoes) {
                    int diff = Integer.parseInt(man) - mangoesPerBasket;
                    if (diff > 0)
                        extraMangoes.add(diff);
                    else if (diff < 0)
                        requiredMangoes.add(-diff);
                    else
                        equalBucketLength++;
                }

                if (equalBucketLength == mangoes.length) {

                    System.out.println("Total Mangoes Moved: " + mangoesMoved);
                    System.out.println("Total Moves: " + moveCount);
                } else {
                    exactMatch();
                    if (requiredMangoes.size() == 0) {
                        System.out.println("Total Mangoes Moved: " + mangoesMoved);
                        System.out.println("Total Moves: " + moveCount);
                        System.exit(0);
                    }

                    exactlyMatched=false;
                    int result = getMinimumMoves(extraMangoes, requiredMangoes);
                    System.out.println("Total Mangoes Moved: " + mangoesMoved);
                    System.out.println("Total Moves: " + result);


                }
            }else {
                System.out.println("-1");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        private static int getMinimumMoves(List<Integer> extraMangoesList, List<Integer> requiredMangoesList )
    {
        Collections.sort(extraMangoesList);
        Collections.sort(requiredMangoesList);

        int extra= extraMangoesList.size();
        int required= requiredMangoesList.size();

        while(requiredMangoesList.size()>0)
        {
            int i=extraMangoesList.size()-1;
            do
            {
                int maxExtra=extraMangoesList.get(i);
                while(maxExtra>0) {
                    exactlyMatched=false;
                    exactMatch();
                    i=exactlyMatched? i-1:i;
                    if (requiredMangoesList.size() == 0) {
                        break;
                    } else {
                        requiredMangoesList = requiredMangoes;
                        extraMangoesList = extraMangoes;
                        required= requiredMangoesList.size();

                        int maxRequired = requiredMangoesList.get(required - 1);
                        int remained = maxExtra - maxRequired;

                        if (remained > 0) {

                            maxExtra = remained;
                            mangoesMoved += maxRequired;
                            requiredMangoesList.remove(required - 1);
                            required--;
                            extraMangoesList.set(i, maxExtra);

                        } else {
                            mangoesMoved += maxExtra;
                            maxExtra = 0;
                            requiredMangoesList.set(required - 1, -remained);

                            extraMangoesList.remove(i);
                            Collections.sort(requiredMangoesList);
                        }
                        //TO DO: Reclaculate MaxExtra
                        moveCount++;
                    }
                }
                i--;
                }
            while (i>0);
            }

        return moveCount;
    }

    private static void exactMatch()
    {
      int i=extraMangoes.size()-1;
      do
        {
            if(requiredMangoes.contains(extraMangoes.get(i)))
            {
                int index = requiredMangoes.indexOf(extraMangoes.get(i));
                mangoesMoved+=extraMangoes.get(i);
                requiredMangoes.remove(index);
                extraMangoes.remove(i);
                moveCount++;
                exactlyMatched=true;
            }
            i--;
        }
      while ( i >=0);

    }


}
