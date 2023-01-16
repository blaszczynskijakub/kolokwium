import javax.swing.*;

public class MyApp implements Runnable {

    public void run() {
        MyFrame frame = new MyFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new MyApp());
    }
}
