/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package savepass;
import savepassWindow.*;
import java.io.*;
import savepass.List;
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
  
        //testFrame test = new testFrame();
        //test.setVisible(true);

        List clist = new List();
        
        String[] ss2 = new String[5];
        ss2[0] = "qwerty";
        ss2[1] = "src";
        ss2[2] = "name";
        ss2[3] = "password";
        ss2[4] = "comment";
        clist.add(ss2);
    }
    
}
