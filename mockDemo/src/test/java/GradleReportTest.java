import grade.GradeReport;
import grade.Person;
import grade.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

/**
 * Created by I076057 on 8/30/2018.
 */

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class GradleReportTest {
    @Test(expected = RuntimeException.class)
    public void test_average_gradle() throws Exception {


        List<Person> students = mock(List.class);
        Person person = mock(Person.class);
        when(person.getName()).thenReturn("ABC");
        when(person.getGrade()).thenReturn("A");
        when(students.get(0)).thenReturn(person);
        when(students.get(1)).thenThrow(new RuntimeException());

        students.get(1);

        verify(students, times(10)).get(0);


    }


    @Test
    public void testMockerTimes() throws Exception {


        Person person = mock(Person.class);

        when(person.getGrade()).thenReturn("test");
        when(person.setGrade(anyInt(), any())).thenReturn("test");

        Assert.assertThat(person.getGrade(), is("test"));


        verify(person, atLeast(1)).getGrade();

    }


    @Test
    public void test_mock_pararmeter() throws Exception {

        Person person = mock(Person.class);
        when(person.setGrade(anyInt(), any())).thenReturn("test");

        person.setGrade(1, null);
        person.setGrade(1, "1");
        person.setGrade(1, "test");

        verify(person, atLeast(1)).setGrade(anyInt(), any());
    }


    @Test(expected = RuntimeException.class)
    public void test_mock_void_function() throws Exception {

        Person person = mock(Person.class);

        doThrow(new RuntimeException()).when(person).setFlag();

        person.setFlag();
    }

    @Test
    public void test_mocker_inorder() throws Exception {

        List<Person> list = mock( List.class);
        Person persion_1 = mock(Person.class);
        Person persion_2 = mock(Person.class);

        list.add(persion_1);
        list.add(persion_2);
        InOrder inOrder = inOrder(list);

        inOrder.verify(list).add(persion_1);
        inOrder.verify(list).add(persion_2);
    }

    @Mock
    List<Person> list;
    @Test
    public void test_Mock_anotation() throws Exception {
        MockitoAnnotations.initMocks( this);
        Assert.assertThat(list,   notNullValue());
    }


    @Mock
    List<Person> list2;
    @Test()
    public void tests_Mocker_RunTime() throws Exception {

        Assert.assertThat(list2,   notNullValue());
        when(list2.add(any())).thenReturn( true);
        list2.add(null);
        verify(list2).add(any());

    }

    @Test
    public void test_mock_on_consecutive_way() throws Exception {


        List<String> list = mock(List.class);

        when( list.get(anyInt())).thenReturn("one", "two", "three");



        assertThat( list.get(0), is("one"));
        assertThat( list.get(1), is("two"));
        assertThat( list.get(2), is("three"));

        System.out.println( list.get(0));

       verify(list,atLeast(1)).get(anyInt() );
    }


    @Test
    public void test_mock_on_consecutive_way2() throws Exception {


      Person person = mock(Person.class);

      when(person.setName(any())).thenReturn("one", "two");


      assertThat( person.setName("one"), is("one"));
      assertThat( person.setName("two"), is("two"));

      verify(person, times(2)).getGrade();

    }


    @Test
    public void test_spy_on_Class() throws Exception {

        Student student = new Student();
        Person person = spy(student);

        when(person.getGrade()).thenReturn("yaguang");


        System.out.println( person.getGrade());


        assertThat( person.getGrade(), is("yaguang"));


        System.out.println( person.getName());



    }
}


