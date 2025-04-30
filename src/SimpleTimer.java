
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SimpleTimer {

    private static int timeRemaining;
    private static Timer timer;

    public static void main(String[] args) throws Exception {

        // Build a Window
        JFrame frame = new JFrame("Simple Timer");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));

        JTextField timeInput = new JTextField("0");
        JTextField lableInput = new JTextField("Timer");

        // Build the Label for Time
        JLabel label = new JLabel("00:00", SwingConstants.CENTER);
        JLabel customLabel = new JLabel("", SwingConstants.CENTER);

        JButton startButton = new JButton("Start");

        frame.add(new JLabel("Time:", SwingConstants.CENTER));
        frame.add(timeInput);

        frame.add(new JLabel("Label:", SwingConstants.CENTER));
        frame.add(lableInput);
        frame.add(startButton);
        frame.add(customLabel);
        frame.add(label);

        startButton.addActionListener(e -> {
            try {
                timeRemaining = Integer.parseInt(timeInput.getText()) * 60;
                String userLabel = lableInput.getText();
                customLabel.setText("Label:" + userLabel);

                if (timer != null && timer.isRunning()) {
                    timer.stop();
                }

                timer = new Timer(1000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int minutes = timeRemaining / 60;
                        int seconds = timeRemaining % 60;
                        label.setText(String.format("%02d:%02d", minutes, seconds));
                        timeRemaining--;

                        if (timeRemaining < 0) {
                            timer.stop();
                            label.setText("End!");
                        }
                    }
                });
                timer.start();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please just enter positive integer.");
            }
        });
        frame.setVisible(true);

    }

}
