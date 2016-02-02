package com.shc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by uchaudh on 1/11/2016.
 */
public class Palindrome {
    static String testStr="";
    static int palindromeStart=0;
    static int palindromeEnd=0;
    static int maxPalindromeLength=0;
    static int lastIndexOfPreviousIteration=1;

    public static void main(String[] args) {

        testStr=args[0].toLowerCase();
        char[] chararray= testStr.toCharArray();


        //TODO: Add logic to get max palindrome length for case- acneCentttnecvtCentnecvtghj i.e. get all occurances of first word of palindrome
        //TODO: and test palindrome for each occurance

        for(int i=0; i<chararray.length;i++)
        {
            int lastIndex=testStr.lastIndexOf(chararray[i]);
            if(lastIndex>0 && i!=lastIndex) {
                lastIndexOfPreviousIteration=lastIndex;
                checkForPalindrome(i, lastIndex);
            }
        }

        if(palindromeEnd>0)
        {
            System.out.println("Palindrome Substring is : "+testStr.substring(palindromeStart,palindromeEnd+1) + " is of length " + ++maxPalindromeLength );
        }

    }


    /**
     * Logic to check palindrome
     * @param startIdx
     * @param lastIdx
     * @return
     */
    public static boolean checkForPalindrome(int startIdx,int lastIdx)
    {
        String substr= testStr.substring(startIdx, lastIdx + 1);
        int currentPalindromeLength = lastIdx-startIdx;
        boolean palindrome=true;
        for(int i=0;i<substr.length();i++)
        {
            if(substr.charAt(i)==substr.charAt(substr.length()-1-i))
                palindrome=true;
            else {
                palindrome = false;
                break;
            }
        }
        if(palindrome==true && currentPalindromeLength > maxPalindromeLength) {
            palindromeStart=startIdx;
            palindromeEnd=lastIdx;
            maxPalindromeLength=currentPalindromeLength;
        }

        return palindrome;
    }

}
