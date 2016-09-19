/**
 * Created by alex on 9/15/16.
 * Edited by Alinda - 9/18/16
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Game extends JFrame {

    // Instantiate all of the bubbles with their numbers and their images   numbers 1 - 9
    // The number bubbles should be randomized into the game/screen
    // Every time a bubble is clicked, the method

    // Alinda 9/18/16
    // Some of these variables may or may not be used.
    int MIN_NUM = 3;                                        // There will always be at least 3 bubbles.
    int MAX_NUM = 9;                                        // Only numbers 1-9 will show up on each bubble.
    List<Bubbles> bubbles = new ArrayList<Bubbles>();       // List of picked bubbles.
    List<JButton> bubbleButton = new ArrayList<JButton>();  // Bubble button objects.
    //JButton[] bubbleButton = new JButton[MAX_NUM];          // Bubble button objects.

    // Alinda 9/18/16
    // Instantiation
    {
        // Alinda 9/18/16
        // Chooses a random array size.
        Random rand = new Random (MAX_NUM);
        int arraySize = rand.nextInt() + 1;

        // Alinda 9/18/16
        // If randomizer chose a number less than MIN_NUM, then arraySize defaults to MIN_NUM.
        // Note: This can probably be combined with initial "Random rand" to eliminate the
        //       need for these lines of code. (So rand chooses between 3-9 instead.)
        if (arraySize < MIN_NUM) {
            arraySize = MIN_NUM;
        }

        // Alinda 9/18/16
        // Creates new bubble objects and adds to arrayList.
        for (int count = 0; count < arraySize; count++) {

            // Alinda 9/18/16
            // This chooses a number from 1 - 9.
            // Note: Need to figure out how to avoid duplicates.
            int randomNum = rand.nextInt() + 1;

            // Alinda 9/18/16
            // This will allow us to select bubble images from 1-9 using a predefined
            // file name. Format is "images/bubble_NUMBER.png", with NUMBER being a number
            // from 1 - 9. (These lines are commented out in case we want to do URLs instead,
            // but this way will hopefully make it easy to loop through and create bubbles on
            // demand without needing to hardcode each bubble.)

            //String fileName = "images/bubble_" + String.valueOf(randomNum) + ".png";
            //bubbles.add(new Bubbles(randomNum, fileName));

            // Alinda 9/18/16
            // Add bubble to array.
            // For now, we are using just one placeholder, test image.
            bubbles.add(new Bubbles(randomNum, "images/bubble_1.png"));

            // Alinda 9/18/16
            // (Testing out code we may or may not need. Not sure where we can use this.)
            //JButton button = new JButton(bubbles.get(count).getImage());
            //JButton button = new JButton(String.valueOf(randomNum));
            //bubbleButton.add(new JButton(bubbles.get(count).getImage()));
            //bubbleButton.add(new JButton(String.valueOf(randomNum)));

        }
    }

    public static void main(String[] args) {

    }

}