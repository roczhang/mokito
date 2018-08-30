package grade;

/**
 * Created by I076057 on 8/30/2018.
 */
public interface Person {

    String getName();

    String getGrade();

    String setGrade(int level, String description);

    String setName( String name);

    void  setFlag();
}
