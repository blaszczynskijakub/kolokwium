

import javax.swing.*;

public class MyFrame extends JFrame {
    private ElectricSchematic electricSchematic = new ElectricSchematic();

    MyFrame(){
        this.setName("Układ elektryczny");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(electricSchematic);
        this.pack();
        this.setVisible(true);


    }
}
