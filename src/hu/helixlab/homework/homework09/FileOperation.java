package hu.helixlab.homework.homework09;

import java.io.*;
import java.util.Arrays;

public class FileOperation {

    public static void fileMaker(String place, String nameAndExtension){

        try {
            FileWriter fileWriter = new FileWriter(place + nameAndExtension);
            fileWriter.write("Message");
            fileWriter.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fileMaker(String place, int quantity, String nameAndExtension){

        try {

            for(int i = 1; i <= quantity; i++){

                FileWriter fileWriter = new FileWriter(place + i + nameAndExtension);
                fileWriter.write("Test");
                fileWriter.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fileMakerWithContent(String place, String nameAndExtension, String content){

        try {
            FileWriter fileWriter = new FileWriter(place + nameAndExtension);
            fileWriter.write(content);
            fileWriter.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fileMakerWithContent(String place, int quantity, String nameAndExtension, String content){

        try {

            for(int i = 1; i <= quantity; i++){

                FileWriter fileWriter = new FileWriter(place + i + nameAndExtension);
                fileWriter.write(content);
                fileWriter.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printMatrixFromFile() {

        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\C\\IdeaProjects\\2017-05-10-HW\\src\\hu\\helixlab\\homework\\homework09\\matrix.txt"));

            int rowsCount = 0;
            int charactersCount = 0;
            int numbersCount = 0;
            int columnsCount;

            while ((line = br.readLine()) != null) {

                rowsCount++;

                for (int i = 0; i < line.length(); i++) {

                    charactersCount++;

                    if (Character.isDigit(line.charAt(i))) {

                        numbersCount++;
                    }
                }
            }
            br.close();

            columnsCount = numbersCount / rowsCount;

            FileReader fileReader = new FileReader("C:\\Users\\C\\IdeaProjects\\2017-05-10-HW\\src\\hu\\helixlab\\homework\\homework09\\matrix.txt");

            int charFromFile;
            int count = 0;
            int tempCount = 0;
            int[] temp = new int[charactersCount];
            char[][] array = new char[rowsCount][columnsCount];

            while ((charFromFile = fileReader.read()) != -1) {

                if (charFromFile != 32) {

                    temp[count] = charFromFile;
                    count++;
                }
            }
            fileReader.close();

            for (int m = 0; m < rowsCount; m++) {

                for (int n = 0; n < columnsCount; n++) {

                    if (temp[tempCount] == 13) {

                        tempCount = tempCount + 2;
                    }

                    array[m][n] = (char) temp[tempCount];
                    System.out.print(array[m][n] + " ");
                    tempCount++;
                }
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found! " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        }
    }

    public static void printDirsInDirectory(String place){

        File file = new File(place);

        File[] files = file.listFiles();

        for(File items : files) {
            if (items.isDirectory()) {
                System.out.print(items.getName() + ", ");
            }
        }
    }

    public static void printFilesInDirectory(String place){

        File file = new File(place);

        File[] files = file.listFiles();

        for(File items : files){
            if(items.isFile()){
                System.out.println(items.getName() + ", ");
            }
        }
    }

    public static void printAllInDirectory(String place){

        File file = new File(place);

        File[] files = file.listFiles();

        for(File items : files){
            if(items.isDirectory()){

                System.out.println(items.getName());
            }
            if(items.isFile()){

                System.out.println(items.getName());
            }
        }
    }

    public static String searchFile(String fileName){

        String result = "Not found yet!";
        String pathName = "C:\\Users\\C\\IdeaProjects\\2017-05-10-HW\\src\\hu\\helixlab\\homework\\homework09";

        try {
            File file = new File(pathName);

            File[] files = file.listFiles();

            for (File items : files) {
                if (items.isDirectory()) {

                    pathName = items.getAbsolutePath();

                }
                if (items.isFile()) {

                    if (fileName.equals(items.getName())) {

                        System.out.println(fileName + " is here: ");
                        result = items.getAbsolutePath();
                        break;
                    }
                }
            }

        }catch (NullPointerException e){
            System.out.println("NullPointerException: " + e.getMessage());
        }

        return result;
    }

    public static boolean isFilesEquals(String fileOne, String fileTwo){

        boolean result = false;

        try {

            BufferedReader br1 = new BufferedReader(new FileReader(fileOne));
            BufferedReader br2 = new BufferedReader(new FileReader(fileTwo));

            String lineOne;
            String lineTwo;
            int charFromFileOne;
            int charFromFileTwo;
            int charsCounterOne = 0;
            int charsCounterTwo = 0;
            int charsCounterBigger;
            int count = 0;

            while ((lineOne = br1.readLine()) != null) {

                for (int i = 0; i < lineOne.length()+2; i++) {

                    charsCounterOne++;
                }
            }
            br1.close();

            while ((lineTwo = br2.readLine()) != null) {

                for (int i = 0; i < lineTwo.length()+2; i++) {

                    charsCounterTwo++;
                }
            }
            br2.close();

            if(charsCounterOne < charsCounterTwo){

                charsCounterBigger = charsCounterTwo;
            }
            else{
                charsCounterBigger = charsCounterOne;
            }

            FileReader fileReaderOne = new FileReader(fileOne);
            FileReader fileReaderTwo = new FileReader(fileTwo);

            int[] charsOne = new int[charsCounterBigger];
            int[] charsTwo = new int[charsCounterBigger];

            while (((charFromFileOne = fileReaderOne.read()) != -1) && ((charFromFileTwo = fileReaderTwo.read()) != -1)) {

                charsOne[count] = charFromFileOne;
                charsTwo[count] = charFromFileTwo;
                count++;
            }
            fileReaderOne.close();
            fileReaderTwo.close();

            if (Arrays.equals(charsOne, charsTwo)) {

                result = true;
            }
            else {
                result = false;
            }

        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("The size of the array is not enough!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException" + e.getMessage());
        }

        return result;
    }
}