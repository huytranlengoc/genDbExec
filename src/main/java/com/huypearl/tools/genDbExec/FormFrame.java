package com.huypearl.tools.genDbExec;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.huypearl.tools.genDbExec.dto.ConnectionDto;

public class FormFrame extends JFrame implements ActionListener {
    private static final String DEFAULT_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String DEFAULT_USERNAME = "pearldev";
    private static final String DEFAULT_PASSWORD = "pearldev";

    private static final long serialVersionUID = 1L;
    // Components of the Form
    private Container container;
    private JLabel title;
    private JLabel labelCharGenerate;
    private JTextField textCharGenerate;
    private JLabel labelStringGenerate;
    private JTextField textStringGenerate;
    private JLabel labelUrlConnection;
    private JTextField textUrlConnection;
    private JLabel labelUserConnection;
    private JTextField textUserConnection;
    private JLabel labelPassConnection;
    private JTextField textPassConnection;
    private JLabel labelTableNames;
    private JTextArea areaTableNames;
    private JButton btnGenerate;
    private JButton btnCommit;
    private JTextArea areaDisplay;

    public FormFrame() {
        setTitle("Tool Generate Data");
        setBounds(300, 90, 900, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        container = getContentPane();
        container.setLayout(null);

        title = new JLabel("Data Generate");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        container.add(title);

        labelCharGenerate = new JLabel("Char generate:");
        labelCharGenerate.setFont(new Font("Arial", Font.PLAIN, 20));
        labelCharGenerate.setSize(150, 20);
        labelCharGenerate.setLocation(20, 100);
        container.add(labelCharGenerate);

        textCharGenerate = new JTextField("a");
        textCharGenerate.setFont(new Font("Arial", Font.PLAIN, 15));
        textCharGenerate.setSize(280, 20);
        textCharGenerate.setLocation(180, 100);
        container.add(textCharGenerate);

        labelStringGenerate = new JLabel("Text generate:");
        labelStringGenerate.setFont(new Font("Arial", Font.PLAIN, 20));
        labelStringGenerate.setSize(150, 20);
        labelStringGenerate.setLocation(20, 150);
        container.add(labelStringGenerate);

        textStringGenerate = new JTextField("genText");
        textStringGenerate.setFont(new Font("Arial", Font.PLAIN, 15));
        textStringGenerate.setSize(280, 20);
        textStringGenerate.setLocation(180, 150);
        container.add(textStringGenerate);

        labelUrlConnection = new JLabel("URL:");
        labelUrlConnection.setFont(new Font("Arial", Font.PLAIN, 20));
        labelUrlConnection.setSize(150, 20);
        labelUrlConnection.setLocation(20, 200);
        container.add(labelUrlConnection);

        textUrlConnection = new JTextField(DEFAULT_URL);
        textUrlConnection.setFont(new Font("Arial", Font.PLAIN, 15));
        textUrlConnection.setSize(280, 20);
        textUrlConnection.setLocation(180, 200);
        container.add(textUrlConnection);

        labelUserConnection = new JLabel("Username:");
        labelUserConnection.setFont(new Font("Arial", Font.PLAIN, 20));
        labelUserConnection.setSize(150, 20);
        labelUserConnection.setLocation(20, 250);
        container.add(labelUserConnection);

        textUserConnection = new JTextField(DEFAULT_USERNAME);
        textUserConnection.setFont(new Font("Arial", Font.PLAIN, 15));
        textUserConnection.setSize(280, 20);
        textUserConnection.setLocation(180, 250);
        container.add(textUserConnection);

        labelPassConnection = new JLabel("Password:");
        labelPassConnection.setFont(new Font("Arial", Font.PLAIN, 20));
        labelPassConnection.setSize(150, 20);
        labelPassConnection.setLocation(20, 300);
        container.add(labelPassConnection);

        textPassConnection = new JTextField(DEFAULT_PASSWORD);
        textPassConnection.setFont(new Font("Arial", Font.PLAIN, 15));
        textPassConnection.setSize(280, 20);
        textPassConnection.setLocation(180, 300);
        container.add(textPassConnection);

        labelTableNames = new JLabel("Table Names");
        labelTableNames.setFont(new Font("Arial", Font.PLAIN, 20));
        labelTableNames.setSize(150, 20);
        labelTableNames.setLocation(20, 350);
        container.add(labelTableNames);

        areaTableNames = new JTextArea();
        areaTableNames.setFont(new Font("Arial", Font.PLAIN, 15));
        areaTableNames.setSize(280, 200);
        areaTableNames.setLocation(180, 350);
        areaTableNames.setLineWrap(true);
        container.add(areaTableNames);

        btnGenerate = new JButton("Generate");
        btnGenerate.setFont(new Font("Arial", Font.PLAIN, 15));
        btnGenerate.setSize(100, 20);
        btnGenerate.setLocation(150, 580);
        btnGenerate.addActionListener(this);
        container.add(btnGenerate);

        btnCommit = new JButton("Commit");
        btnCommit.setFont(new Font("Arial", Font.PLAIN, 15));
        btnCommit.setSize(100, 20);
        btnCommit.setLocation(270, 580);
        btnCommit.addActionListener(this);
        container.add(btnCommit);

        areaDisplay = new JTextArea();
        areaDisplay.setFont(new Font("Arial", Font.PLAIN, 15));
        areaDisplay.setSize(300, 450);
        areaDisplay.setLocation(500, 100);
        areaDisplay.setLineWrap(true);
        areaDisplay.setEditable(false);
        container.add(areaDisplay);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGenerate) {
            try {
                ConnectionDto connectionDto = new ConnectionDto(textUrlConnection.getText(),
                        textUserConnection.getText(), textPassConnection.getText());
                areaDisplay.setText(DBExecuteUtils.readDBInformation(connectionDto));
            } catch (Exception e1) {
                areaDisplay.setText("Error when read db\n" + e1.getMessage());
            }
        } else if (e.getSource() == btnCommit) {
            areaDisplay.setText("You clicked commit!");
        }
    }
}
