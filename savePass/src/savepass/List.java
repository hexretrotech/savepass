/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package savepass;

import java.io.*;

/**
 *
 * @author hexretrotech
 */
public class List {
    File listFiles = new File("./list");
    FileReader listFilesReader = null;
    String[] listArray = new String[100];
    
    List() {
        try {
            listFilesReader = new FileReader(listFiles);
            BufferedReader listFilesBufferedReader = new BufferedReader(listFilesReader);
            
            String tempString;
            int tempInt = 0;
            
            while((tempString = listFilesBufferedReader.readLine()) != null) {
                listArray[tempInt] = tempString;
                tempInt++;
            }
        } catch(FileNotFoundException e) { System.err.println("Не найде файл списка записей"); System.exit(1);} catch(IOException e) { System.out.println("Ошибка чтения из файла списка записей"); }
        System.out.println(listArray[8]);
    }
    
    public String[] getAccount(String nameAccount) {
        String accountDetails[] = new String[5];
        
        return accountDetails;
    }
}
