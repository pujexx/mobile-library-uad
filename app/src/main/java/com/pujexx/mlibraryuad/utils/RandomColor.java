package com.pujexx.mlibraryuad.utils;

import com.pujexx.mlibraryuad.R;

import java.util.Random;

/**
 * Created by pujexx on 11/12/14.
 */
public class RandomColor {

    public int getRandomColor(){
        int rand = randInt(1,4);
        int color = R.color.green;
        switch (rand){
            case 1:
                color = R.color.green;
                break;
            case 2 :
                color = R.color.orange;
                break;
            case 3:
                color = R.color.purple;
                break;
            case 4:
                color = R.color.red;
                break;
            default:
                color = R.color.red;
                break;
        }
        return color;
    }

    public static int randInt(int min, int max) {

       Random rand = new Random();
       int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}

