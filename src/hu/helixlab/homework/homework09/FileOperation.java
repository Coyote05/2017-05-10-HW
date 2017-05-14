package hu.helixlab.homework.homework09;

import java.io.*;

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
}