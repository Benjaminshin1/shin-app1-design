package baseline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private DatePicker add_date;

    @FXML
    private TextField add_description;

    @FXML
    private Button add_task;

    @FXML
    private TextField add_title;

    @FXML
    private MenuItem delete_list;

    @FXML
    private MenuButton dropdown_list;

    @FXML
    private MenuItem edit_date;

    @FXML
    private MenuItem edit_task;

    @FXML
    private MenuItem edit_title;

    @FXML
    private MenuButton file_options;

    @FXML
    private MenuItem open_saved;

    @FXML
    private MenuItem remove;

    @FXML
    private ContextMenu right_click;

    @FXML
    private MenuItem save_button;

    @FXML
    private MenuItem show_all;

    @FXML
    private MenuItem show_completed;

    @FXML
    private MenuItem show_incompleted;

    @FXML
    private ListView<?> view_list;

    @FXML
    //just a test
    void buttonpress(ActionEvent event) {
        System.out.println("you clicked me");
    }

    @FXML
    void add_to_list() {
        //will get information from user input that includes the due date, title, and description with a checkmark box
        //orr add to existing list
    }
    @FXML
    void remove_from_list(){
        //will remove an item from a list
    }
    @FXML
    void edit_date(){
        //will edit a date from an existing list with a new one from user input
    }
    @FXML
    void edit_title(){
        //will edit title of an existing item in a list
    }
    @FXML
    void edit_description(){
        // will edit description of an existing list
    }
    @FXML
    void save_file(){
        //will save user list to local database specified with file location and name of saved data
    }
    @FXML
    void display_specific_list(){
        // will filter a list based on completed, incomplete, and all in a saved task list
    }
    @FXML
    void mark_complete_incomplete(){
        //will mark an item if it is complete or incomplete
    }
    @FXML
    void load_data(){
        //will load a prev saved list from storage
    }

}

