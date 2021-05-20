package Saving;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    private static List listOfAdress = new ArrayList();

    public static void main(String[] args) throws Exception {

        GameProgress object1 = new GameProgress(80, 99, 2, 1068.5);
        GameProgress object2 = new GameProgress(70, 123, 4, 100);
        GameProgress object3 = new GameProgress(60, 22, 9, 1234.56);
        saveGame("/Users/pavelanokhin/Документы/Games/savegames/object1.dat", object1);
        listOfAdress.add("/Users/pavelanokhin/Документы/Games/savegames/object1.dat");
        saveGame("/Users/pavelanokhin/Документы/Games/savegames/object2.dat", object2);
        listOfAdress.add("/Users/pavelanokhin/Документы/Games/savegames/object2.dat");
        saveGame("/Users/pavelanokhin/Документы/Games/savegames/object3.dat", object3);
        listOfAdress.add("/Users/pavelanokhin/Документы/Games/savegames/object3.dat");
        zipFiles(listOfAdress, "/Users/pavelanokhin/Документы/Games/savegames/allZip.zip");


    }

    public static void saveGame(String adress, GameProgress obj) {
        try (FileOutputStream fos = new FileOutputStream(adress);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void zipFiles(List<String> tempList, String datList) {

        try (ZipOutputStream zipNew = new ZipOutputStream(new FileOutputStream(datList))) {
            try (FileInputStream newFileForReading = new FileInputStream(tempList.get(0))) {
                int i = -1;
                while ((i = newFileForReading.read()) != -1) ;
                ZipEntry entry1 = new ZipEntry(tempList.get(0));
                zipNew.putNextEntry(entry1);
                byte[] buffer1 = new byte[newFileForReading.available()];
                newFileForReading.read(buffer1);
                zipNew.write(buffer1);
                zipNew.closeEntry();
                File trsh0 = new File(tempList.get(0));
                trsh0.delete();
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }

            try (FileInputStream newFileForReading1 = new FileInputStream(tempList.get(1))) {
                int i = -1;
                while ((i = newFileForReading1.read()) != -1) ;
                ZipEntry entry2 = new ZipEntry(tempList.get(1));
                zipNew.putNextEntry(entry2);
                byte[] buffer2 = new byte[newFileForReading1.available()];
                newFileForReading1.read(buffer2);
                zipNew.write(buffer2);
                zipNew.closeEntry();
                File trsh1 = new File(tempList.get(1));
                trsh1.delete();
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }

            try (FileInputStream newFileForReading = new FileInputStream(tempList.get(2))) {
                int i = -1;
                while ((i = newFileForReading.read()) != -1) ;
                ZipEntry entry3 = new ZipEntry(tempList.get(2));
                zipNew.putNextEntry(entry3);
                byte[] buffer3 = new byte[newFileForReading.available()];
                newFileForReading.read(buffer3);
                zipNew.write(buffer3);
                zipNew.closeEntry();
                File trsh2 = new File(tempList.get(2));
                trsh2.delete();


            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }
}
