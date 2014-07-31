/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package savepass;
import savepassWindow.*;
import java.io.*;
/**
 *
 * @author valera
 */
public class SavePass {
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {   
        FileReader fw = new FileReader("./file2.spf");
        BufferedReader br = new BufferedReader(fw);
        
        testFrame test = new testFrame();
        test.setVisible(true);
        test.jTextPane1.setText(br.readLine());

    }
    
}
