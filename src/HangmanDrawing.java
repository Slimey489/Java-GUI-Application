import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;


class HangmanDrawing {

    static class Canvas extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D) g;
            switch (DrawingFrame.guessNumber) {
                case 0->{
                }

                //Ground
                case 1 -> {
                    g2.draw(new Line2D.Double(1, 155, 299, 155));
                }

                //Vertical Strut
                case 2 -> {
                    g2.draw(new Line2D.Double(1, 155, 299, 155));
                    g2.draw(new Rectangle2D.Double(120, 20, 5, 135));
                }

                //Right Lower Support
                case 3 -> {
                    g2.draw(new Line2D.Double(1, 155, 299, 155));
                    g2.draw(new Rectangle2D.Double(120, 20, 5, 135));
                    g2.draw(new Line2D.Double(125, 145, 145, 155));
                    g2.draw(new Line2D.Double(125, 140, 154.5, 155));
                }

                //Left Lower Support
                case 4 -> {
                    g2.draw(new Line2D.Double(1, 155, 299, 155));
                    g2.draw(new Rectangle2D.Double(120, 20, 5, 135));
                    g2.draw(new Line2D.Double(125, 145, 145, 155));
                    g2.draw(new Line2D.Double(125, 140, 154.5, 155));
                    g2.draw(new Line2D.Double(120, 145, 105, 155));
                    g2.draw(new Line2D.Double(120, 140, 95.5, 155));
                }

                //Upper Support
                case 5 -> {
                    g2.draw(new Line2D.Double(1, 155, 299, 155));
                    g2.draw(new Rectangle2D.Double(120, 20, 5, 135));
                    g2.draw(new Line2D.Double(125, 145, 145, 155));
                    g2.draw(new Line2D.Double(125, 140, 154.5, 155));
                    g2.draw(new Line2D.Double(120, 145, 105, 155));
                    g2.draw(new Line2D.Double(120, 140, 95.5, 155));
                    g2.draw(new Line2D.Double(125, 32, 132.5, 25));
                    g2.draw(new Line2D.Double(125, 37, 137, 25));
                }

                //Horizontal Strut
                case 6 -> {
                    g2.draw(new Line2D.Double(1, 155, 299, 155));
                    g2.draw(new Rectangle2D.Double(120, 20, 5, 135));
                    g2.draw(new Line2D.Double(125, 145, 145, 155));
                    g2.draw(new Line2D.Double(125, 140, 154.5, 155));
                    g2.draw(new Line2D.Double(120, 145, 105, 155));
                    g2.draw(new Line2D.Double(120, 140, 95.5, 155));
                    g2.draw(new Line2D.Double(125, 32, 132.5, 25));
                    g2.draw(new Line2D.Double(125, 37, 137, 25));
                    g2.draw(new Rectangle2D.Double(125, 20, 70, 5));
                }

                //Noose
                case 7 -> {
                    g2.draw(new Line2D.Double(1, 155, 299, 155));
                    g2.draw(new Rectangle2D.Double(120, 20, 5, 135));
                    g2.draw(new Line2D.Double(125, 145, 145, 155));
                    g2.draw(new Line2D.Double(125, 140, 154.5, 155));
                    g2.draw(new Line2D.Double(120, 145, 105, 155));
                    g2.draw(new Line2D.Double(120, 140, 95.5, 155));
                    g2.draw(new Line2D.Double(125, 32, 132.5, 25));
                    g2.draw(new Line2D.Double(125, 37, 137, 25));
                    g2.draw(new Rectangle2D.Double(125, 20, 70, 5));
                    g2.draw(new Line2D.Double(190, 20, 190, 50));
                    g2.draw(new Line2D.Double(192, 20, 194, 26));
                    g2.draw(new Line2D.Double(190, 20, 192, 26));
                }

                //Head
                case 8 -> {
                    g2.draw(new Line2D.Double(1, 155, 299, 155));
                    g2.draw(new Rectangle2D.Double(120, 20, 5, 135));
                    g2.draw(new Line2D.Double(125, 145, 145, 155));
                    g2.draw(new Line2D.Double(125, 140, 154.5, 155));
                    g2.draw(new Line2D.Double(120, 145, 105, 155));
                    g2.draw(new Line2D.Double(120, 140, 95.5, 155));
                    g2.draw(new Line2D.Double(125, 32, 132.5, 25));
                    g2.draw(new Line2D.Double(125, 37, 137, 25));
                    g2.draw(new Rectangle2D.Double(125, 20, 70, 5));
                    g2.draw(new Line2D.Double(190, 20, 190, 50));
                    g2.draw(new Line2D.Double(192, 20, 194, 26));
                    g2.draw(new Line2D.Double(190, 20, 192, 26));
                    g2.draw(new Ellipse2D.Double(180, 50, 20, 20));
                }

                //Arms
                case 9 -> {
                    g2.draw(new Line2D.Double(1, 155, 299, 155));
                    g2.draw(new Rectangle2D.Double(120, 20, 5, 135));
                    g2.draw(new Line2D.Double(125, 145, 145, 155));
                    g2.draw(new Line2D.Double(125, 140, 154.5, 155));
                    g2.draw(new Line2D.Double(120, 145, 105, 155));
                    g2.draw(new Line2D.Double(120, 140, 95.5, 155));
                    g2.draw(new Line2D.Double(125, 32, 132.5, 25));
                    g2.draw(new Line2D.Double(125, 37, 137, 25));
                    g2.draw(new Rectangle2D.Double(125, 20, 70, 5));
                    g2.draw(new Line2D.Double(190, 20, 190, 50));
                    g2.draw(new Line2D.Double(192, 20, 194, 26));
                    g2.draw(new Line2D.Double(190, 20, 192, 26));
                    g2.draw(new Ellipse2D.Double(180, 50, 20, 20));
                    g2.draw(new Line2D.Double(190, 85, 160, 85));
                    g2.draw(new Line2D.Double(190, 85, 220, 85));

                }

                //Body
                case 10 -> {
                    g2.draw(new Line2D.Double(1, 155, 299, 155));
                    g2.draw(new Rectangle2D.Double(120, 20, 5, 135));
                    g2.draw(new Line2D.Double(125, 145, 145, 155));
                    g2.draw(new Line2D.Double(125, 140, 154.5, 155));
                    g2.draw(new Line2D.Double(120, 145, 105, 155));
                    g2.draw(new Line2D.Double(120, 140, 95.5, 155));
                    g2.draw(new Line2D.Double(125, 32, 132.5, 25));
                    g2.draw(new Line2D.Double(125, 37, 137, 25));
                    g2.draw(new Rectangle2D.Double(125, 20, 70, 5));
                    g2.draw(new Line2D.Double(190, 20, 190, 50));
                    g2.draw(new Line2D.Double(192, 20, 194, 26));
                    g2.draw(new Line2D.Double(190, 20, 192, 26));
                    g2.draw(new Ellipse2D.Double(180, 50, 20, 20));
                    g2.draw(new Line2D.Double(190, 85, 160, 85));
                    g2.draw(new Line2D.Double(190, 70, 190, 110));
                }

                //Left Leg
                case 11 -> {
                    g2.draw(new Line2D.Double(1, 155, 299, 155));
                    g2.draw(new Rectangle2D.Double(120, 20, 5, 135));
                    g2.draw(new Line2D.Double(125, 145, 145, 155));
                    g2.draw(new Line2D.Double(125, 140, 154.5, 155));
                    g2.draw(new Line2D.Double(120, 145, 105, 155));
                    g2.draw(new Line2D.Double(120, 140, 95.5, 155));
                    g2.draw(new Line2D.Double(125, 32, 132.5, 25));
                    g2.draw(new Line2D.Double(125, 37, 137, 25));
                    g2.draw(new Rectangle2D.Double(125, 20, 70, 5));
                    g2.draw(new Line2D.Double(190, 20, 190, 50));
                    g2.draw(new Line2D.Double(192, 20, 194, 26));
                    g2.draw(new Line2D.Double(190, 20, 192, 26));
                    g2.draw(new Ellipse2D.Double(180, 50, 20, 20));
                    g2.draw(new Line2D.Double(190, 85, 160, 85));
                    g2.draw(new Line2D.Double(190, 70, 190, 110));
                    g2.draw(new Line2D.Double(190, 110, 180, 135));
                }

                //Right Leg
                case 12 -> {
                    g2.draw(new Line2D.Double(1, 155, 299, 155));
                    g2.draw(new Rectangle2D.Double(120, 20, 5, 135));
                    g2.draw(new Line2D.Double(125, 145, 145, 155));
                    g2.draw(new Line2D.Double(125, 140, 154.5, 155));
                    g2.draw(new Line2D.Double(120, 145, 105, 155));
                    g2.draw(new Line2D.Double(120, 140, 95.5, 155));
                    g2.draw(new Line2D.Double(125, 32, 132.5, 25));
                    g2.draw(new Line2D.Double(125, 37, 137, 25));
                    g2.draw(new Rectangle2D.Double(125, 20, 70, 5));
                    g2.draw(new Line2D.Double(190, 20, 190, 50));
                    g2.draw(new Line2D.Double(192, 20, 194, 26));
                    g2.draw(new Line2D.Double(190, 20, 192, 26));
                    g2.draw(new Ellipse2D.Double(180, 50, 20, 20));
                    g2.draw(new Line2D.Double(190, 85, 160, 85));
                    g2.draw(new Line2D.Double(190, 70, 190, 110));
                    g2.draw(new Line2D.Double(190, 110, 180, 135));
                    g2.draw(new Line2D.Double(190, 110, 200, 135));
                }
                default -> {
                    ErrorFrame.error = "You are out of guesses";
                    SwingUtilities.invokeLater(new ErrorHandler());
                }
            }
        }
    }
}