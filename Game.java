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
    // There will always be at least 3 bubbles.
    int MAX_NUM = 9;                                        // Only numbers 1-9 will show up on each bubble.
    List<Bubbles> bubbles = new ArrayList<>();       // List of picked bubbles.
    List<Bubbles> playBubbles = new ArrayList<>();
    Winner winners;

    public Game()
    {
        super("Super Bubble POP!");

        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        Random random = new Random();

        for (int i = 1; i <= MAX_NUM; i++)
        {
            String fileLocation = "images/bubble_0" + Integer.toString(i) + ".jpg";
            bubbles.add(new Bubbles(i, fileLocation));
        }


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

       for (int i = 0; i < bubbles.size(); i++)
       {
            playBubbles.add(bubbles.get(i));
       }

        // Alex said to make an arbitrary amount of swaps
        for (int i = 0; i < 5; i++)
        {
            int r1 = random.nextInt(9);
            int r2 = random.nextInt(9);

            if(r2 == r1)
            {
                i--;
            }
            else
            {
                Bubbles temp = playBubbles.set(r1, playBubbles.get(r2));
                playBubbles.set(r2, temp);
            }
        }

        for (int i = 0; i < playBubbles.size(); i++)
        {
            this.add(playBubbles.get(i));
        }

        this.setVisible(true);

        ArrayList<Bubbles> temp = (ArrayList<Bubbles>)((ArrayList<Bubbles>)playBubbles).clone();
        Winner winners = new Winner(temp);
    }

    public void youWin()
    {
        System.out.println("You win");
    }

    public static void main(String[] args) {
        Game window = new Game();
    }
}