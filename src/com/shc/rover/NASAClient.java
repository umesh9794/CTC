package com.shc.rover;

/**
 * Created by uchaudh on 1/27/2016.
 */
public class NASAClient {

    public static void main(String[] args) {

        String input="5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM";

        String[] instrArray=input.split("\\n");

        String maxLimitforPlateau=instrArray[0];
        String initialPositionRover1=instrArray[1];
        String instructionsForRover1=instrArray[2];
        String initialPositionRover2=instrArray[3];
        String instructionsForRover2=instrArray[4];


        String[] positionRover1=initialPositionRover1.split(" ");
        String[] positionRover2=initialPositionRover2.split(" ");

        char[] instrArray1=instructionsForRover1.toCharArray();
        char[] instrArray2=instructionsForRover2.toCharArray();

        RoverMotor rover1=new RoverMotor(Integer.parseInt(positionRover1[0]),Integer.parseInt(positionRover1[1]),positionRover1[2]);
        RoverMotor rover2=new RoverMotor(Integer.parseInt(positionRover2[0]),Integer.parseInt(positionRover2[1]),positionRover2[2]);

        for(int i=0; i<instrArray1.length;i++)
        {
            rover1.executeInstruction(instrArray1[i]);
        }

        for(int i=0; i<instrArray2.length;i++)
        {
            rover2.executeInstruction(instrArray2[i]);
        }

        rover1.getPosition();
        rover2.getPosition();
    }



}
