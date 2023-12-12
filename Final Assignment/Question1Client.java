//This code is modified from the client example provided in canvas

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Question1Client extends JFrame implements ActionListener {
   // Text field for receiving radius
  private JTextField heightTextField = new JTextField();
  private JTextField weightTextField = new JTextField();

  // Text area to display contents
  private JTextArea jta = new JTextArea();

  // IO streams
  private DataOutputStream outputToServer;
  private DataInputStream inputFromServer;

  public static void main(String[] args) {
    new Question1Client();
  }

  public Question1Client() {
    // Panel p to hold the label and text field
    JPanel heightPanel = new JPanel();
    heightPanel.setLayout(new BorderLayout());
    heightPanel.add(new JLabel("Enter Height"), BorderLayout.WEST);
    heightPanel.add(heightTextField, BorderLayout.CENTER);
    heightTextField.setHorizontalAlignment(JTextField.RIGHT);

    JPanel weightPanel = new JPanel();
    weightPanel.setLayout(new BorderLayout());
    weightPanel.add(new JLabel("Enter Weight"), BorderLayout.WEST);
    weightPanel.add(weightTextField, BorderLayout.CENTER);
    weightTextField.setHorizontalAlignment(JTextField.RIGHT);
 
    getContentPane().setLayout(new GridLayout(2,1));
    getContentPane().add(weightPanel);
    getContentPane().add(heightPanel);
    getContentPane().add(new JScrollPane(jta));

    heightTextField.addActionListener(this); // Register listener
    weightTextField.addActionListener(this);

    setTitle("Question 1 Client");
    setSize(500, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true); // It is necessary to show the frame here!

    try {
      // Create a socket to connect to the server
      Socket socket = new Socket("localhost", 8000);
      // Socket socket = new Socket("130.254.204.36", 8000);
      // Socket socket = new Socket("drake.Armstrong.edu", 8000);

      // Create an input stream to receive data from the server
      inputFromServer = new DataInputStream(
        socket.getInputStream());

      // Create an output stream to send data to the server
      outputToServer =
        new DataOutputStream(socket.getOutputStream());
    }
    catch (IOException ex) {
      jta.append(ex.toString() + '\n');
    }
  }

  public void actionPerformed(ActionEvent e) {
    String actionCommand = e.getActionCommand();
    if (e.getSource() instanceof JTextField) {
      try {
        // Get the height and weight from the text field
        double height = Double.parseDouble(heightTextField.getText().trim());
        double weight = Double.parseDouble(weightTextField.getText().trim());

        // Send the height and weight to the server
        outputToServer.writeDouble(height);
        outputToServer.flush();
        outputToServer.writeDouble(weight);
        outputToServer.flush();


        // Get bmi from the server
        double bmi = inputFromServer.readDouble();

        // Display to the text area
        jta.append("Height is " + height + "\n");
        jta.append("Weight is " + weight + "\n");
        jta.append("BMI received from the server is "
          + bmi + '\n');
      }
      catch (IOException ex) {
        System.err.println(ex);
     }
    }
 }
}