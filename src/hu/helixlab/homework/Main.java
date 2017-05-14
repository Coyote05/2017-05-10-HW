package hu.helixlab.homework;

import hu.helixlab.homework.homework09.FileOperation;

public class Main {

    public static void main(String[] args) {

        FileOperation fileOperation = new FileOperation();
        fileOperation.fileMaker("C:\\Users\\C\\IdeaProjects\\2017-05-10-HW\\src\\hu\\helixlab\\homework\\homework09\\","Test.txt");

        fileOperation.fileMaker("C:\\Users\\C\\IdeaProjects\\2017-05-10-HW\\src\\hu\\helixlab\\homework\\homework09\\", 3, "Test.txt");

        fileOperation.fileMakerWithContent("C:\\Users\\C\\IdeaProjects\\2017-05-10-HW\\src\\hu\\helixlab\\homework\\homework09\\", "Third.txt", "Message");

        fileOperation.fileMakerWithContent("C:\\Users\\C\\IdeaProjects\\2017-05-10-HW\\src\\hu\\helixlab\\homework\\homework09\\", 5, "Fourth.txt", "Message");

        fileOperation.printMatrixFromFile();

        fileOperation.printDirsInDirectory("C:\\Users\\C\\IdeaProjects\\2017-05-10-HW");

        fileOperation.printFilesInDirectory("C:\\Users\\C\\IdeaProjects\\2017-05-10-HW");

        fileOperation.printAllInDirectory("C:\\Users\\C\\IdeaProjects\\2017-05-10-HW");
    }
}
