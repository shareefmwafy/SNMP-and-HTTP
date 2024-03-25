
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;

public class ClientApp extends JFrame implements ActionListener {
    private JTextField usernameField, idField, passwordField;
    private JButton verify1Button, verify2Button;
    private JTextArea responseArea;

    public ClientApp() {
        setTitle("HTTP Client Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Password:"));
        passwordField = new JTextField();
        panel.add(passwordField);

        verify1Button = new JButton("Verify1");
        verify1Button.addActionListener(this);
        panel.add(verify1Button);

        verify2Button = new JButton("Verify2");
        verify2Button.addActionListener(this);
        panel.add(verify2Button);

        responseArea = new JTextArea();
        responseArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(responseArea);
        panel.add(scrollPane);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == verify1Button) {
            verify1();
        } else if (e.getSource() == verify2Button) {
            verify2();
        }
    }

    private void verify1() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            URL url = new URL("http://localhost:8085/ServletJSP"); // Replace with your servlet URL
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
            writer.write("username=" + username + "&password=" + password);
            writer.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String response = reader.readLine();
            responseArea.setText("Verify1 Response: " + response);

            writer.close();
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void verify2() {
        String id = idField.getText();
        String password = passwordField.getText();

        try {
            URL url = new URL("http://localhost:8085/ServletJSP/Auth.jsp"); // Replace with your JSP URL
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
            writer.write("id=" + id + "&password=" + password);
            writer.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String response = reader.readLine();
            responseArea.setText("Verify2 Response: " + response);

            writer.close();
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ClientApp().setVisible(true);
        });
    }
}
