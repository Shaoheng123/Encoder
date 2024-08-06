import Cipher.CipherFactory;
import Cipher.Cipher;
import Cipher.ApplicationProperties;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EncoderPanel extends JFrame implements ActionListener {

    private JButton encodeButton;
    private JButton decodeButton;
    private JTextField encodeText;
    private JTextField decodeText;
    private JTextField outputField;

    public EncoderPanel() {

        ApplicationProperties applicationProperties = new ApplicationProperties();
        int inputTextLimit = applicationProperties.getInputTextLimit();

        JFrame frame = new JFrame();
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setSize(applicationProperties.getFrameWidth(),applicationProperties.getFrameHeight());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel cardPanel = new JPanel(new CardLayout());
        JPanel panel1 = new JPanel();
        cardPanel.add(panel1);

        encodeText = new JTextField(inputTextLimit);
        decodeText = new JTextField(inputTextLimit);

        JTextArea encode = new JTextArea("Text to encode");
        JTextArea decode = new JTextArea("Text to decode");
        JTextArea outputText = new JTextArea("Output Text");

        encodeButton = new JButton("ENCODE");
        decodeButton = new JButton("DECODE");
        encodeButton.addActionListener(this);
        decodeButton.addActionListener(this);

        outputField = new JTextField(inputTextLimit); // 20 columns wide
        outputField.setFont(new Font("Arial", Font.PLAIN, 12)); // Set font
        outputField.setEditable(false);

        panel1.add(encode);
        panel1.add(encodeText);
        panel1.add(encodeButton);
        panel1.add(decode);
        panel1.add(decodeText);
        panel1.add(decodeButton);
        panel1.add(outputText);
        panel1.add(outputField);

        frame.add(cardPanel);
        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == encodeButton) {
            String textToEncode = encodeText.getText().toUpperCase();
            if(textToEncode.equals("")){
                outputField.setText("");
                return;
            }

            CipherFactory cipherFactory = CipherFactory.getInstance();
            Cipher cipher = cipherFactory.createCipher(textToEncode, encodeButton.getText());
            outputField.setText(cipher.codec());
        } else {

            String textToDecode = decodeText.getText().toUpperCase();
            if(textToDecode.equals("")){
                outputField.setText("");
                return;
            }
            CipherFactory cipherFactory = CipherFactory.getInstance();
            Cipher cipher = cipherFactory.createCipher(textToDecode, decodeButton.getText());
            outputField.setText(cipher.codec());
        }
    }
}

