package grade;

import java.util.List;

/**
 * Created by I076057 on 8/30/2018.
 */
public class GradeReport {
    private final List<Person> students;

    public GradeReport(List<Person> students) {

        this.students = students;
    }

    public String getAverage() {
        return  this.students.get(0).getGrade();
    }
}
