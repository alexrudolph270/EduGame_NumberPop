/**
 * Created by alex on 9/15/16.
 * Edited by Alinda - 9/18/16
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

import static java.awt.SystemColor.window;

public class Game extends JFrame {

    // Instantiate all of the bubbles with their numbers and their images   numbers 1 - 9
    // The number bubbles should be randomized into the game/screen
    // Every time a bubble is clicked, the method

    // Alinda 9/18/16
    // Some of these variables may or may not be used.
    int MIN_NUM = 3;                                        // There will always be at least 3 bubbles.
    int MAX_NUM = 9;                                        // Only numbers 1-9 will show up on each bubble.
    List<Bubbles> bubbles = new ArrayList<>();       // List of picked bubbles.
    List<Bubbles> playBubbles = new ArrayList<>();
    Winner winners;
    // Bubble button objects.
    //JButton[] bubbleButton = new JButton[MAX_NUM];          // Bubble button objects.

    // Alinda 9/18/16this.setVisible(true);
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
//            Bubbles b1 = new Bubbles(randomNum, "images/bubble_1.jpg");
//            bubbles.add(b1);

            // Alinda 9/18/16
            // (Testing out code we may or may not need. Not sure where we can use this.)
            //JButton button = new JButton(bubbles.get(count).getImage());
            //JButton button = new JButton(String.valueOf(randomNum));
            //bubbleButton.add(new JButton(bubbles.get(count).getImage()));
            //bubbleButton.add(new JButton(String.valueOf(randomNum)));
            Bubbles b1 = new Bubbles(1, "images/bubble_01.jpg");
            Bubbles b2 = new Bubbles(2, "images/bubble_02.jpg");
            Bubbles b3 = new Bubbles(3, "images/bubble_03.jpg");
            Bubbles b4 = new Bubbles(4, "images/bubble_04.jpg");
            Bubbles b5 = new Bubbles(5, "images/bubble_05.jpg");
            Bubbles b6 = new Bubbles(6, "images/bubble_06.jpg");
            Bubbles b7 = new Bubbles(7, "images/bubble_07.jpg");
            Bubbles b8 = new Bubbles(8, "images/bubble_08.jpg");
            Bubbles b9 = new Bubbles(9, "images/bubble_09.jpg");

            bubbles.add(b1);
            bubbles.add(b2);
            bubbles.add(b3);
            bubbles.add(b4);
            bubbles.add(b5);
            bubbles.add(b6);
            bubbles.add(b7);
            bubbles.add(b8);
            bubbles.add(b9);
        }
    }

    public Game()
    {
        super("Super Bubble POP!");

        Random random = new Random();

        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        //add bubbles to jFrame
//        this.add(bubbles.get(0));
//        this.add(bubbles.get(1));
//        this.add(bubbles.get(2));
//        this.add(bubbles.get(3));
//        this.add(bubbles.get(4));
//        this.add(bubbles.get(5));
//        this.add(bubbles.get(6));
//        this.add(bubbles.get(7));
//        this.add(bubbles.get(8));

//        int numBubbles = random.nextInt(MAX_NUM - MIN_NUM + 1) + MIN_NUM;

        for (int i = 0; i < MAX_NUM; i++)
        {
            playBubbles.add(bubbles.get(random.nextInt(MAX_NUM-1)));
        }

        for (int i = 0; i < playBubbles.size(); i++)
        {
            this.add(playBubbles.get(i));
        }

        this.setVisible(true);

        ArrayList<Bubbles> temp = (ArrayList<Bubbles>)((ArrayList<Bubbles>)playBubbles).clone();
        Winner winners = new Winner(temp);
    }

    public static void main(String[] args) {
        Game window = new Game();
    }
}