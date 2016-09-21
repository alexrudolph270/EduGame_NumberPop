import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.sort;

/**
 * Created by alex on 9/15/16.
 * Edited by Alinda - 9/18/16
 */

/**
 * Alinda 9/18/16
 * Note: I have not tested out any of this code yet. They may or may not work.
 */

public class Winner
{
    public static ArrayList<Bubbles> winners;

//    // Alinda 9/18/16
//    // I changed the code to return an updated arrayList (with the correct number removed.)
//    // determine() now accepts two objects:
//    //      1. The bubble array containing all bubbles leftover.
//    //      2. The bubble the player chooses.
//    public List<Bubbles> determine(List<Bubbles> array, Bubbles choice)
//    {
//        // Compares each bubble object in the array to see if it is the smallest.   Alex
//        // If the number is the smallest, remove it.
//        // At the end of each pass, check if the arrayList  is empty.
//        // If so, set win = true.
//
//        // Alinda 9/18/16
//        // Returns the updated arrayList.
//        List<Bubbles> newArray = new ArrayList<Bubbles>();
//
//        // Alinda 9/18/16
//        // Assume number is smallest.
//        int smallest = array.get(0).getNum();
//
//        // Alinda 9/18/16
//        // Location of smallest number in array.
//        int arrayNum = 0;
//
//        // Alinda 9/18/16
//        // Check if any number is smaller than array.get(0)
//        for (int count = 1; count < array.size(); count++) {
//
//            // Alinda 9/18/16
//            // If so, new number becomes new smallest, and index is recorded.
//            // Else continues on until end of loop.
//            if (smallest > array.get(count).getNum()) {
//                smallest = array.get(count).getNum();
//                arrayNum = count;
//            }
//        }
//
//        // Alinda 9/18/16
//        // If the player's choice matches the smallest number, then remove from the array.
//        if (smallest == choice.getNum()) {
//            array.remove(arrayNum);
//
//            // Alinda 9/18/16
//            // Pop bubble here?
//
//            // Alinda 9/18/16
//            // Only need to check if empty if something was popped.
//            if (array.isEmpty()) {
//                win = true;
//            }
//            else {
//                // Alinda 9/18/16
//                // Copy old array into newArray.
//            }
//        }
//        else {
//            // Alinda 9/18/16
//            // If nothing was popped, return old array as nothing was changed.
//            return array;
//        }
//
//        // Alinda 9/18/16
//        // Updated array with removed element.
//        return newArray;
//    }
//
//    public void displayWinner()
//    {
//        // Alex
//        // Determines if the game is won and prints out a statement.
//        if(win) {
//            System.out.println("You win!");
//        }
//    }
    public Winner(ArrayList<Bubbles> bubbles)
    {
        sort(bubbles);
        this.winners = bubbles;
    }

    public boolean isCorrect(int num)
    {
        if(num == this.winners.get(0).getNum())
        {
            this.winners.remove(0);
            return true;
        }
        else
            return false;
    }

    public static int getNext()
    {
        int retval = winners.get(0).getNum();
        return retval;
    }

    public static void removeNext()
    {
        winners.remove(0);
    }

    public static boolean wisEmpty()
    {
        boolean retVal = winners.isEmpty();
        if(retVal == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}