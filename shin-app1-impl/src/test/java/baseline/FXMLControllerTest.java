package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class FXMLControllerTest {
    private static testcontroller app;
    @Test
    void add_to_list() {
       testcontroller app= new testcontroller();

        ObservableList<Newtodo> testlist= FXCollections.observableArrayList();
        //adds a test list size of one and get the values and strings to see if they match
        testlist=app.add_to_list("hello",LocalDate.of(2021,01,01),false);
        Assertions.assertEquals(false,testlist.get(0).getStatus().getValue());
        Assertions.assertEquals(LocalDate.of(2021,01,01),testlist.get(0).getDate());
        Assertions.assertEquals("hello",testlist.get(0).getDescription());
        //compare a test array to a created one to see if they match with the correct inputs
    }

    @Test
    void edit_object() {
        //edits all elements based on the constructor
        ObservableList<Newtodo> objectlist= FXCollections.observableArrayList();
        objectlist.add(new Newtodo(false,(LocalDate.of(2021,01,01)),"hello"));
        //since we have an array size of one I can edit each of its elements to something different

        objectlist.get(0).setStatus(true);
        objectlist.get(0).setDate(LocalDate.of(2022,02,02));
        objectlist.get(0).setDescription("goodbye");
        Assertions.assertEquals(true,objectlist.get(0).getStatus().getValue());
        Assertions.assertEquals(LocalDate.of(2022,02,02),objectlist.get(0).getDate());
        Assertions.assertEquals("goodbye",objectlist.get(0).getDescription());
    }

    @Test
    void testRemove_from_list() {
        testcontroller app= new testcontroller();
        //remove an item from a list and compare to a test list with that item already removed
        ObservableList<Newtodo> testlist1= FXCollections.observableArrayList();
        testlist1=app.add_to_list("hello",LocalDate.of(2021,01,01),false);
        testlist1=app.remove_from_list(testlist1,0);
        Assertions.assertEquals(0,testlist1.size());
    }

    @Test
    void remove_all() {
        testcontroller app= new testcontroller();
        ObservableList<Newtodo> testlist2= FXCollections.observableArrayList();
        for(int i=0;i<50;i++) {
            testlist2 = app.add_to_list("hello", LocalDate.of(2021, 01, 01), false);
        }
        testlist2=app.remove_all(testlist2);
        Assertions.assertEquals(0,testlist2.size());
    }

    @Test
    void testDisplay_specific_list() {
        testcontroller app= new testcontroller();
        ObservableList<Newtodo> testlist3= FXCollections.observableArrayList();
        testlist3.add(new Newtodo(false,LocalDate.of(2021, 01, 01),"hello"));
        testlist3.add(new Newtodo(false,LocalDate.of(2021, 01, 01),"hello"));
        testlist3.add(new Newtodo(false,LocalDate.of(2021, 01, 01),"hello"));
        testlist3.add(new Newtodo(true,LocalDate.of(2021, 01, 01),"hello"));
        testlist3.add(new Newtodo(true,LocalDate.of(2021, 01, 01),"hello"));
        testlist3.add(new Newtodo(true,LocalDate.of(2021, 01, 01),"hello"));
        //will remove all elements if they are false or incomplete and returns it
        testlist3=app.display_specific_list(testlist3);
        Assertions.assertEquals(3,testlist3.size());

    }

    @Test
    void display_completed() {
        testcontroller app= new testcontroller();
        //will return only true elements in the list
        ObservableList<Newtodo> testlist4= FXCollections.observableArrayList();
        testlist4.add(new Newtodo(false,LocalDate.of(2021, 01, 01),"hello"));
        testlist4.add(new Newtodo(true,LocalDate.of(2021, 01, 01),"hello"));
        testlist4.add(new Newtodo(true,LocalDate.of(2021, 01, 01),"hello"));
        testlist4.add(new Newtodo(true,LocalDate.of(2021, 01, 01),"hello"));
        testlist4.add(new Newtodo(true,LocalDate.of(2021, 01, 01),"hello"));
        testlist4.add(new Newtodo(true,LocalDate.of(2021, 01, 01),"hello"));

        testlist4=app.display_completed(testlist4);
        Assertions.assertEquals(1,testlist4.size());
    }
}