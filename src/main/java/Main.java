import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * a simple mis system ... used arrays for saving
 * Created by induwara
 * on 4/8/17.
 */
public class Main {
    private static Scanner scannerObject = new Scanner(System.in);
    private static List<student> studentArray = new ArrayList();

    /**
     * this is the main method...
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome to My MIS\n\n");
        // retriveFromFile();
        controller();
        return;
    }

    private static void controller() {
        while (true) {
            System.out.println("1 enter a student \n"+
                    "2 delete a student\n"+
                    "3 edit a student \n"+
                    "4 search a student\n" +
                    "5 view all students\n"+
                    "6 exit\n\n"+
                    "\tenter the number which you want to do ");

            int i = 0;

            try {
                i = scannerObject.nextInt();
            } catch (Exception ex) {
                System.out.println("Main controller exception");
            }


            switch (i) {
                case 1:
                    try {
                        addStudent();
                    } catch (MyException ex) {
                        System.err.println(ex.getErrorCode() + " - " + ex.getMessage());
                    }

                    break;

                case 2:
                    deleteStudent();
                    break;

                case 3:
                    editStudent();
                    break;

                case 4:
                    searchStudent();
                    break;

                case 5:
                    viewAllStudent();
                    break;

                case 6:
                    // writeToFile();
                    System.exit(0);
                    break;
                default:
                    System.out.println("please enter valid input");
                    controller();
            }
        }
    }

    private static void retriveFromFile() {

        String FILENAME = "/home/induwara/IdeaProjects/StudentMis/log.txt";

        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;

            br = new BufferedReader(new FileReader(FILENAME));

            while ((sCurrentLine = br.readLine()) != null) {
                String[] ar = sCurrentLine.split(",");

                student tempstudent = new student();
                tempstudent.setStuId(Integer.parseInt(ar[0]));
                tempstudent.setStuName(ar[1]);
                tempstudent.setStuSchool(ar[2]);
                studentArray.add(tempstudent);
            }
//            viewAllStudent();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile() {

        String FILENAME = "/home/induwara/IdeaProjects/StudentMis/log.txt";

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);

            for (student aStudentArray : studentArray) {
                bw.write(String.valueOf(aStudentArray));
            }


            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void viewAllStudent() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        for (student aStudentArray : studentArray) {

            System.out.println(aStudentArray);
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    private static void searchStudent() {
        System.out.println("enter the id of the student wich you wish to view");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        student viewStu = new student();
        viewStu.setStuId(scannerObject.nextInt());
        System.out.println(studentArray.get(studentArray.indexOf(viewStu)));
    }

    private static void editStudent() {
        System.out.println("enter the id of the student wich you wish to edit");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        student editStu = new student();
        editStu.setStuId(scannerObject.nextInt());
        System.out.println(studentArray.get(studentArray.indexOf(editStu)));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("what do you wanna edit \n\n 1-name \n 2-school \n");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        int tempOption = scannerObject.nextInt();

        switch (tempOption) {
            case 1:
                System.out.println("enter new name");
                String tempName = scannerObject.next();
                editStu.setStuName(tempName);
                break;

            case 2:
                System.out.println("enter new school");
                String tempSchool = scannerObject.next();
                editStu.setStuName(tempSchool);
                break;
        }
        System.out.println("");
        System.out.println("succefully edited");
        System.out.println("");
    }

    private static void deleteStudent() {
        System.out.println("enter the id of the student wich you wish to delete");
        student delStu = new student();
        delStu.setStuId(scannerObject.nextInt());
        studentArray.remove(delStu);
        System.out.println("");
        System.out.println("succefully removed");
        System.out.println("");
    }

    private static void addStudent() {
        student tempStudent = new student();
        System.out.println("Enter student details");
        System.out.println("id");
        int tempid = 0;
        try {
            tempid = scannerObject.nextInt();
            if (tempid <= 0) {
                throw new MyException("1111", "Id should grater than zero");
            }

            tempStudent.setStuId(tempid);
        } catch (InputMismatchException ex) {
            System.out.println("Please enter a valid number");
            scannerObject.next();
            controller();
        }


        System.out.println("name");
        try {
            String tempname = scannerObject.next();
            tempStudent.setStuName(tempname);
        } catch (InputMismatchException ex) {
            System.out.println("Exception is catched");
            scannerObject.next();
            controller();
        }

        try {
            System.out.println("school");
            String tempschool = scannerObject.next();
            tempStudent.setStuSchool(tempschool);
        } catch (InputMismatchException ex) {
            System.out.println("Exception is catched");
            scannerObject.next();
            controller();
        }

        studentArray.add(tempStudent);

    }
}
