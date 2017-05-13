import java.security.PrivateKey;

/**
 * Created by induwara on 4/8/17.
 */
public class student {
    private int StuId;
    private String StuName;
    private String StuSchool;


    public int getStuId() {
        return StuId;
    }

    public void setStuId(int stuId) {
        StuId = stuId;
    }

    public String getStuName() {
        return StuName;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public String getStuSchool() {
        return StuSchool;
    }

    public void setStuSchool(String stuSchool) {
        StuSchool = stuSchool;
    }

    @Override
    public String toString() {
        return
                 StuId +","+StuName + "," + StuSchool +"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof student)) return false;

        student student = (student) o;

        return StuId == student.StuId;
    }

    @Override
    public int hashCode() {
        return StuId;
    }
}
