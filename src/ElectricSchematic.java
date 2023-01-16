import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.TransferHandler;

public class ElectricSchematic extends JPanel {
    private static final long serialVersionUID = 1L;
    private JComponent currentWire = null;
    private JComboBox<String> elements;

    public ElectricSchematic() {
        setLayout(null);
        elements = new JComboBox<>(new String[]{"Wire", "Resistor"});
        elements.setBounds(10, 10, 100, 20);
        elements.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentWire != null) {
                    remove(currentWire);
                }
                switch (elements.getSelectedIndex()) {
                    case 0:
                        currentWire = createWire();
                        break;
                    case 1:
                        currentWire = createResistor();
                        break;
                }
                add(currentWire);
                revalidate();
                repaint();
            }
        });
        add(elements);
    }

    public class WireComponent extends JComponent {
        private static final long serialVersionUID = 1L;
        private int current;

        public void setCurrent(int current) {
            this.current = current;
        }

        public int getCurrent() {
            return current;
        }
    }

    public JComponent createWire() {
        WireComponent wire = new WireComponent();
        wire.setBounds(10, 50, 100, 20);
        wire.setBackground(Color.YELLOW);
        wire.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        wire.setTransferHandler(new TransferHandler("current"));
        wire.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                JComponent c = (JComponent) e.getSource();
                TransferHandler th = c.getTransferHandler();
                th.exportAsDrag(c, e, TransferHandler.COPY);
            }
        });
        wire.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(ElectricSchematic.this, "Current: " + wire.getCurrent());
            }
        });
        return wire;
    }

    public class ResistorComponent extends JComponent {
        private static final long serialVersionUID = 1L;
        private int resistance;

        public void setResistance(int resistance) {
            this.resistance = resistance;
        }

        public int getResistance() {
            return resistance;
        }
    }

    public JComponent createResistor() {
        ResistorComponent resistor = new ResistorComponent();
        resistor.setBounds(10, 50, 100, 20);
        resistor.setBackground(Color.BLUE);
        resistor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        resistor.setTransferHandler(new TransferHandler("resistance"));
        resistor.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                JComponent c = (JComponent) e.getSource();
                TransferHandler th = c.getTransferHandler();
                th.exportAsDrag(c, e, TransferHandler.COPY);
            }
        });
        resistor.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                JOptionPane.showMessageDialog(ElectricSchematic.this, "Resistance: " + resistor.getResistance());
            }
        });
        return resistor;
    }
}