package com.shc.rover;

/**
 * Created by uchaudh on 1/27/2016.
 */
public class RoverMotor {

private Position currentPos=new Position();
//private Coordinates coord;

    public RoverMotor(final int x,final int y, final String headDir)
    {

        currentPos.currentHeadDirection=headDir;
        currentPos.xPos=x;
        currentPos.yPos=y;
    }

public void getPosition()
{
    System.out.println("My current position is "+ currentPos.xPos +" "+currentPos.yPos+" "+currentPos.currentHeadDirection);

}


public void executeInstruction(final char ins)
{
    switch(ins) {
        case 'L': moveLeft();
            break;
        case 'R': moveRight();
            break;
        case 'M': moveAhead();
    }

}

    private void moveLeft()
    {
        char currentHead= currentPos.currentHeadDirection.toCharArray()[0];

        switch(currentHead)
        {
            case 'N' : currentPos.currentHeadDirection="W";
                break;
            case 'S' : currentPos.currentHeadDirection="E";
                break;
            case 'W' : currentPos.currentHeadDirection="S";
                break;
            case 'E' : currentPos.currentHeadDirection="N";
        }
    }

    private void moveRight()
    {
        char currentHead= currentPos.currentHeadDirection.toCharArray()[0];

        switch(currentHead)
        {
            case 'N' : currentPos.currentHeadDirection="E";
                break;
            case 'S' : currentPos.currentHeadDirection="W";
                break;
            case 'W' : currentPos.currentHeadDirection="N";
                break;
            case 'E' : currentPos.currentHeadDirection="S";
        }
    }

    private void moveAhead()
    {
        //TODO : Check for max and min boundary conditions for plateau

        char currentHead= currentPos.currentHeadDirection.toCharArray()[0];
        switch(currentHead)
        {
            case 'N' : currentPos.yPos++;
                break;
            case 'S' : currentPos.yPos--;
                break;
            case 'W' : currentPos.xPos--;
                break;
            case 'E' : currentPos.xPos++;
        }
    }

}
