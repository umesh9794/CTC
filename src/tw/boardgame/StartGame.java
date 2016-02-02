package tw.boardgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by uchaudh on 1/30/2016.
 */
public class StartGame {

    static String computerReply;

    public static void main(String[] args) {

        try {
            Computer computerPlayer=new Computer();
            boolean isGameOver = false;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (!isGameOver) {
                System.out.println("Enter a coordinate: ");
                String input = br.readLine();
                computerReply=computerPlayer.chekForHitOrMiss(input);
                System.out.println(computerReply);
                isGameOver=(computerReply.equals("YOU WIN")|| input.equals("I LOSE")? true:false);
            }
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }

    }
}
