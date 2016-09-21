import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InterruptedIOException;

public class Bubbles extends JButton implements Comparable<Bubbles>
{
    private final int DEFAULT_SIZE = 200;
    private Image popped;
    private Image winMag;

    //private ImageIcon image;
    private int value;  // The value of its assigned number
    private boolean onClick = false;



    public Bubbles(int newVal, String imageLocation)
    {
        this.value = newVal;
        try
        {
            // load bubble unpopped image
            Image img = ImageIO.read(getClass().getResource(imageLocation));
            Image dimg = img.getScaledInstance(DEFAULT_SIZE, DEFAULT_SIZE, Image.SCALE_SMOOTH);
            this.setIcon(new ImageIcon(dimg));

            Image pimg = ImageIO.read(getClass().getResource("images/bubble_blank.jpg"));
            Image dpimg = pimg.getScaledInstance(DEFAULT_SIZE, DEFAULT_SIZE, Image.SCALE_SMOOTH);
            popped = dpimg;

            Image wimg = ImageIO.read(getClass().getResource("images/bubble_winner.jpg"));
            Image dwimg = wimg.getScaledInstance(DEFAULT_SIZE, DEFAULT_SIZE, Image.SCALE_SMOOTH);
            winMag = dwimg;
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        this.setBackground(Color.WHITE);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(Winner.getNext() == value)  // Determine if the icon is clicked and react accordingly
                {
                    onClick = true;
                    Winner.removeNext();
                    //    Winner.remove() or something like that

                    // Alex's attempt
                    if(Winner.wisEmpty() == true)
                    {
                        setIcon(new ImageIcon(winMag));
                    }
                    else
                    {
                        setIcon(new ImageIcon(popped));
                    }
                }
                else
                {
                    // Winner.tryAgain() or somethin like that
                    onClick = false;
                    setBackground(Color.red);
                }
            }
        });
    }

    // Return the value of the bubble
    public int getNum()
    {
        return this.value;
    }

    public int compareTo(Bubbles bub)
    {
        return this.getNum() - bub.getNum();
    }
}

