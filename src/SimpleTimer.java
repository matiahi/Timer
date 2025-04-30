
import javax.swing.*;

public class SimpleTimer {

    private static int secondsRemaining = (1 * 60);

    public static void main(String[] args) throws Exception {

        // Build a Window
        JFrame frame = new JFrame("Simple Timer");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Build the Label for Time
        JLabel label = new JLabel(formatTime(secondsRemaining), SwingConstants.CENTER);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> startTimer(label));

        // Setting for the Window
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(startButton);
        frame.add(panel);

        frame.setVisible(true);

    }

    public static void startTimer(JLabel label) {
        Timer timer = new Timer(1000, e -> {
            secondsRemaining--;

            label.setText(formatTime(secondsRemaining));

            if (secondsRemaining <= 0) {
                ((Timer) e.getSource()).stop();
                JOptionPane.showMessageDialog(null, "Times end");

            }
        });
        timer.start();
    }

    public static String formatTime(int seconds) {
        int minutes = seconds / 60;
        int remainingSecond = seconds % 60;
        return String.format("%02d:%02d", minutes, remainingSecond);
    }
}
