package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.awt.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {
    @FXML
    private Button help_button;

    @FXML
    private Button delete_item;

    @FXML
    private DatePicker add_date;

    @FXML
    private TextField add_description;

    @FXML
    private Button add_task;

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
    private ListView<Newtodo> view_list;

    @FXML
    private TableView<Newtodo> table_view;
    @FXML
    private TableColumn<Newtodo, LocalDate> date_col;
    @FXML
    private TableColumn<Newtodo, String> description_col;
    @FXML
    private TableColumn<Newtodo, Boolean> status_col;


    ObservableList<Newtodo> list= FXCollections.observableArrayList();
    private TableView<Newtodo> table = new TableView<Newtodo>();

    @FXML
    private void add_to_list(Event e) {
        //will get information from user input that includes the due date, title, and description with a checkmark box
        //orr add to existing list
        Checkbox status = new Checkbox("");
        status.setState(true);
        if(list.size()<=100) {
            list.add(new Newtodo(false,add_date.getValue(),
                                add_description.getText()));
        }
        description_col.setCellFactory(TextFieldTableCell.forTableColumn());
        table_view.setItems(list);
    }
    @FXML
    public void remove_from_list(){
        //will remove an item from a list
        list.remove(remove);
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
    void load_data(){
        //will load a prev saved list from storage
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        add_date.setValue(LocalDate.now());

        status_col.setCellValueFactory(new PropertyValueFactory<>("status"));
        status_col.setCellFactory(column -> new CheckBoxTableCell());
        date_col.setCellValueFactory(new PropertyValueFactory<>("date"));
        description_col.setCellValueFactory(new PropertyValueFactory<>("description"));


        description_col.setOnEditCommit(
                (TableColumn.CellEditEvent<Newtodo, String> t) ->
                        ( t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setDescription(t.getNewValue())
        );
        status_col.setOnEditCommit(
                (TableColumn.CellEditEvent<Newtodo, Boolean> t) ->
                        ( t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setStatus(t.getNewValue())
        );
        date_col.setOnEditCommit(
                (TableColumn.CellEditEvent<Newtodo, LocalDate> t) ->
                        ( t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setDate(t.getNewValue())
        );


        table_view.setItems(list);
        table_view.setEditable(true);


    }
}

