import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bubble extends JButton
{
    private String number;  // Declares which bubble it is
    private ImageIcon image;
    private int value;  // The value of its assigned number
    private boolean onClick = false;

    public Bubble(String newNum, ImageIcon newImage, int newVal)
    {
        this.number = newNum;
        this.image = newImage;
        this.value = newVal;
        this.onClick = false;

        //

        this.setBackground(Color.WHITE);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(!onClick)  // Determine if the icon is clicked and react accordingly
                {
                    onClick = true;
                    setBackground(Color.green);
                }
                else
                {
                    onClick = false;
                    setBackground(Color.darkGray);
                }
            }
        });
    }

    // Return the value of the bubble
    public int getVal()
    {
        return this.value;
    }
}

