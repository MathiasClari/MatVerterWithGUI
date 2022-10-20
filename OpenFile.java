import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class OpenFile{

        public String openFile(){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(null);
            if(result == JFileChooser.APPROVE_OPTION){
                File selectedFile = fileChooser.getSelectedFile();
                String sourcefile = selectedFile.getAbsolutePath();
                return sourcefile;
            }
            else if(result == JFileChooser.CANCEL_OPTION){
                JOptionPane.showMessageDialog(null, "No File Selected");
            }
            return "";
        }

        public String saveFile(){

            //make public export folder

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop/exports"));
            int result = fileChooser.showSaveDialog(null);
            if(result == JFileChooser.APPROVE_OPTION){
                String destinationfile = fileChooser.getSelectedFile().getAbsolutePath();
                return destinationfile;
            }
            else if(result == JFileChooser.CANCEL_OPTION){
                JOptionPane.showMessageDialog(null, "No File Selected");
            }
            return null;
        }
}