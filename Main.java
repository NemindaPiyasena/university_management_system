import com.university.*;
import javax.swing.*;
import java.awt.*;

public class Main {
  public static void main(String[] args) {

    EventQueue.invokeLater(() -> {
      try {
        Login window = new Login();
        window.frame.setVisible(true);

      } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null,"There was an error in the system");
      }
    });
  }
}
