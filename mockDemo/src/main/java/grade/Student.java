package grade;

/**
 * Created by I076057 on 8/30/2018.
 */
public class Student implements Person {
    private int level;
    private String description;
    private String name;

    @Override
    public String getName() {
        return "getName";
    }

    @Override
    public String getGrade() {
        return "A";
    }

    @Override
    public String setGrade(int level, String description) {
        this.level = level;
        this.description = description;
        return "OK";
    }

    @Override
    public String setName(String name) {
        return this.name = name;
    }

    @Override
    public void setFlag() {

    }
}
