import java.util.ArrayList;
import java.util.List;

/**
 * Created by induwara on 4/8/17.
 */
public class test {


    public static void main(String[] args) {
        List<student> studentArray = new ArrayList();
        student newStu = new student();
        newStu.setStuName("hehe");
        newStu.setStuId(45);
        newStu.setStuSchool("asd");
        studentArray.add(newStu);
        student newStu2 = new student();
        newStu2.setStuName("hevwrververhe");
        newStu2.setStuId(425);
        newStu2.setStuSchool("asververververvd");
        studentArray.add( newStu2);

        student s1=studentArray.get(0);
        s1.setStuName("llllllllllllllllllllllllllllllll");

        System.out.println(studentArray);
    }
}
