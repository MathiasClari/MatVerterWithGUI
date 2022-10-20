import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Converter {

    public static void main(String[] args){

        File folder = new File(System.getProperty("user.home") + "/Desktop/exports");
        if(!folder.exists()){
            folder.mkdir();
        }
        

        JFrame frame = new JFrame("Matverter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.isResizable();

        //make text and write welcome message to it "Welcome to the converter" and set bounds to it

        JFormattedTextField text = new JFormattedTextField();
        text.setText("Welcome to the Matverter");
        text.setBounds(150, 60, 300, 50);
        frame.add(text);


        text.setBackground(new java.awt.Color(128, 128, 128));
        text.setBorder(null);
        text.setForeground(new java.awt.Color(255, 255, 255));

        //make frame background gray
        frame.getContentPane().setBackground(new java.awt.Color(128, 128, 128));

        //make frame style
        try {
            frame.setIconImage(ImageIO.read(new File("C:\\Users\\skess\\Pictures\\Apps\\Matify.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JButton button = new JButton("Convert");
        button.setBounds(150, 100, 100, 40);
        frame.add(button);

        //make button rounded for 10 pixels on all sides and make button background gray
        //make button text white

        button.setBackground(new java.awt.Color(228, 128, 128));
        button.setForeground(new java.awt.Color(255, 255, 255));



        button.addActionListener(e -> {
            OpenFile openFile = new OpenFile();
            String sourcefile = openFile.openFile();
            String destinationfile = openFile.saveFile();
            if(sourcefile == null){
                JOptionPane.showMessageDialog(null, "No File Selected");
            }
            else{
                    if(sourcefile.endsWith(".png")){
                        try {
                            File file = new File(sourcefile);
                            File file2 = new File(destinationfile + ".jpg");
                            ImageIO.write(ImageIO.read(file), "jpg", file2);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            });
        }
    }