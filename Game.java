import javax.swing.*;

class Game {
    private static void initWindow(){
        //Creating a new window and setting the title
        JFrame window = new JFrame("Celestial Cataclysm");

        //To stop the app once the window closes
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Display display = new Display();

        window.add(display);

        window.addKeyListener(display);

        window.setResizable(true);

        window.pack();

        //To set the window to the centre
        window.setLocationRelativeTo(null);

        window.setVisible(true);
    }
}