package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
//reacreating all the methods with the same logic to test all the methods
public class testcontroller {
    ObservableList<Newtodo> incompletelist= FXCollections.observableArrayList();
    ObservableList<Newtodo> completelist= FXCollections.observableArrayList();
    ObservableList<Newtodo> list= FXCollections.observableArrayList();

    public ObservableList<Newtodo> add_to_list(String add_description, LocalDate add_date, Boolean status) {
        //will get information from user input that includes the due date, title, and description with a checkmark box
        //orr add to existing list

        //wont add to list if the length of description is empty or longer than 256
        if(list.size()<=100&&!add_description.isEmpty()&&add_description.length()<256) {
            list.add(new Newtodo(false,add_date,
                    add_description));
        }
        return list;
    }

    public ObservableList remove_from_list(ObservableList list, int position){
         //will remove an item from a list

        //this is the real code and i will create a similiar code below it for test purposes
         //delete_item.setOnAction(e -> {
         //   Newtodo selectedItem = table_view.getSelectionModel().getSelectedItem();
         //   table_view.getItems().remove(selectedItem);
         // });

        //will remove a list based on position
        list.remove(position);
        return list;

    }
    public ObservableList remove_all(ObservableList list1){
        //remove all items from the list

        //actual code
        //table_view.getItems().clear();
        //list.removeAll();

        list1.clear();
        return list1;
    }

    ObservableList<Newtodo> display_specific_list(ObservableList list2){
        ObservableList<Newtodo> testlist= FXCollections.observableArrayList();
        testlist=list2;
        //will show incompleted
        // will filter a list based on completed, incomplete, and all in a saved task list

        //list.removeIf(s-> s.getStatus().getValue());
        //real code
//        incompletelist.clear();
//
//        for(Newtodo a: list){
//            if(!a.getStatus().getValue()){
//                incompletelist.add(a);
//            }
//        }
//        table_view.setItems(incompletelist);
        testlist.removeIf(element->(!element.getStatus().getValue()));
        return testlist;
    }

    ObservableList display_completed(ObservableList list3){
        ObservableList<Newtodo> testlist3= FXCollections.observableArrayList();
        testlist3=list3;
        //will only show items that are completed
        //real code

//        completelist.clear();
//        for(Newtodo a: list){
//            if(a.getStatus().getValue()){
//                completelist.add(a);
//            }
//        }
//        table_view.setItems(completelist);
        testlist3.removeIf(element->(element.getStatus().getValue()));
        return testlist3;

    }



}
