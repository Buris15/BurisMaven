package com.buris;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.buris.model.Student;

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.greet();

        try {
            Scanner scanner = new Scanner(new File ("data/student.csv"));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
        }
        scanner.close();    
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}