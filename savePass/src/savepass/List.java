/*
 * Класс для работы с аккаунтами(чтение списка аккаунтов, добавление аккаунта, получение подробностей аккаунтов и их удаление)
 * Использование:
 *          Конструктор: List()
 *          Получение списка аккаунтов: String[] getListAccounts()
 *          Получение подробностей аккаунта: String[] getAccount(String nameAccount)
 *                                              String[0] - имя аккаунта
 *                                              String[1] - ссылка
 *                                              String[2] - имя пользователя
 *                                              String[3] - пароль
 *                                              String[4] - комментарий
 *          Создание нового аккаунта: void add(String[] Description)
 *                                              String[0] - имя аккаунта
 *                                              String[1] - ссылка
 *                                              String[2] - имя пользователя
 *                                              String[3] - пароль
 *                                              String[4] - комментарий
 */

package savepass;

import java.io.*;

/**
 *
 * @author hexretrotech
 */
public class List {
    File listFiles = new File("./list"); //Открыть файл списка с записями
    FileReader listFilesReader = null; //Создать ссылку на поток из файла
    String[] listArray = new String[100]; //Создать массив для списка аккаунта
    
    List() { //конструктор
        try {
            listFilesReader = new FileReader(listFiles); //создать поток из файла
            BufferedReader listFilesBufferedReader = new BufferedReader(listFilesReader); //создать буфферизированный поток из файла
            
            String tempString; //Временная переменная
            int tempInt = 0; //Временная переменная
            
            while((tempString = listFilesBufferedReader.readLine()) != null) { //Чтение строк пока не наступит конец файла
                listArray[tempInt] = tempString;    //Запись аккаунтов в массив
                tempInt++;
            }
            listFilesReader.close();    //Зактрыть поток
        } catch(FileNotFoundException e) { System.err.println("Не найден файл списка записей"); System.exit(1);} catch(IOException e) { System.out.println("Ошибка чтения из файла списка записей"); }
        
    }
    
    public String[] getListAccounts() {
        return listArray;
    }
    
    public String[] getAccount(String nameAccount) {
        String accountDetails[] = new String[5]; //массив для подробностей аккаунта
        accountDetails[4] = "";
        String tempString; //Временная переменная
        try {
            FileReader accountDetailsReader = new FileReader("./" + nameAccount); //Поток чтения из файла
            BufferedReader accountDetailsBufferedReader = new BufferedReader(accountDetailsReader); //Создать буфферезированный поток чтения из файла
            accountDetails[0] = accountDetailsBufferedReader.readLine(); //чтение имени
            accountDetails[1] = accountDetailsBufferedReader.readLine(); //чтение ссылка
            accountDetails[2] = accountDetailsBufferedReader.readLine(); //чтение логина
            accountDetails[3] = accountDetailsBufferedReader.readLine(); //чтение пароля
            while((tempString = accountDetailsBufferedReader.readLine()) != null) { //чтение коментария до конца файла
                accountDetails[4] += tempString + "\n"; //чтение комментария
            }
        } catch(FileNotFoundException e) { } catch(IOException e) { }
        return accountDetails; //возврат деталей аккаунта
    }
    
    public void add(String[] newAccount) {
        try {
            FileWriter listFilesWriter = new FileWriter(listFiles, true); //Поток записи в файл списка
            String nameNewAccount = newAccount[0] + "\n"; //Обработать имя файла для записи в список аккаунтов
            char[] addList = new char[nameNewAccount.length()]; //создать символьный массив для записи в список аккаунтов
            nameNewAccount.getChars(0, nameNewAccount.length(), addList, 0); //Получить символы названия для записи в список аккаунтов
            listFilesWriter.write(addList); //Запись имени в файл списка аккаунтов
            listFilesWriter.close(); //Закрыть поток записи в список аккаунтов
            
            String newAccountDescription = new String(); //Создать строку для подробностей нового аккаунта
            File newAccountFile = new File("./" + newAccount[0]); //Создать файл описания для нового аккаунта
            FileWriter accountFilesWriter = new FileWriter(newAccountFile); //Создать поток записи в файл описания
            for(int i = 0; i<=4; i++) {
                newAccountDescription += newAccount[i] + "\n"; //Заполнения строки подробностями из аргументов
            }
            char[] addAccount = new char[newAccountDescription.length()]; //Символьный массив для записив файл подробностей
            newAccountDescription.getChars(0, newAccountDescription.length(), addAccount, 0); //Получить символы для записи в файл подробностей
            accountFilesWriter.write(addAccount); //Записать в файл подробностей
            accountFilesWriter.close(); //Закрыть поток записи в файл подробностей
        } catch(FileNotFoundException e) { } catch(IOException e) { }
    }
}

