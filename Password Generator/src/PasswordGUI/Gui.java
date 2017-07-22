/**
 * Challenge # 4 from r/dailyprogrammer.
 * This program is designed to generate a password of a desired length. The passwords can be purely
 * alphabetical, alphanumeric, or alphanumeric with symbols.
 */
package PasswordGUI;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Enumeration;


public class Gui {
    Password pass = new Password();
    JFrame frame = new JFrame();
    Integer length;
    static JTextField passwordOutput = new JTextField("Output",15);

    public static void main(String args[]) {
        Gui g = new Gui();
        g.buildGui();
    }

    private void buildGui() {
        JPanel complexityPanel = new JPanel();
        JPanel passwordPanel = new JPanel();

        // Create radio buttons for the complexity
        JRadioButton alphaButton = new JRadioButton("Alphabetical");
        alphaButton.setSelected(true);
        JRadioButton alphaNumButton = new JRadioButton("Alphanumeric");
        JRadioButton alphaNumSymButton = new JRadioButton("Alphanumeric + Symbols");
        alphaButton.addActionListener(new alphaListener());
        alphaNumButton.addActionListener(new alphaNumListener());
        alphaNumSymButton.addActionListener(new alphaNumSymListener());

        //Group the radio buttons to allow only one selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(alphaButton);
        group.add(alphaNumButton);
        group.add(alphaNumSymButton);

        // Radio Button Groups are not components, so have to add manually to the panel
        complexityPanel.add(alphaButton);
        complexityPanel.add(alphaNumButton);
        complexityPanel.add(alphaNumSymButton);
        complexityPanel.setLayout(new BoxLayout(complexityPanel, BoxLayout.Y_AXIS));

        // Get the password length and save it
        JTextField lengthField = new JTextField("0",3);
        lengthField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = lengthField.getText();
                try {
                    length = Integer.parseInt(str);
                    for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
                        AbstractButton button = buttons.nextElement();

                        if (button.isSelected()) {
                            passwordOutput.setText("");
                            button.doClick();
                        }
                    }

                } catch (NumberFormatException ne) {
                    frame.repaint(); //ignore it
                }
            }
        });
        passwordPanel.add(lengthField);
        passwordPanel.add(passwordOutput);

        frame.getContentPane().add(BorderLayout.WEST, complexityPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, passwordPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        frame.setVisible(true);
    }

    private class alphaListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            passwordOutput.setText(pass.createAlpha(length));
        }
    }

    private class alphaNumListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            passwordOutput.setText(pass.createAlphaNum(length));
        }
    }

    private class alphaNumSymListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            passwordOutput.setText(pass.createAlphaNumSym(length));
        }
    }


}
