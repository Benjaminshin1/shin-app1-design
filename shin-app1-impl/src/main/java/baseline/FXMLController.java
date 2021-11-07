package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
    private MenuButton file_options;

    @FXML
    private MenuItem open_saved;

    @FXML
    private MenuItem remove;

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
    private TableView<Newtodo> table_view=new TableView<>();
    @FXML
    private TableColumn<Newtodo, LocalDate> date_col=new TableColumn<>("date");
    @FXML
    private TableColumn<Newtodo, String> description_col;
    @FXML
    private TableColumn<Newtodo, Boolean> status_col= new TableColumn<>("status");


    //specific lists for the filter function
    ObservableList<Newtodo> list= FXCollections.observableArrayList();
    ObservableList<Newtodo> incompletelist= FXCollections.observableArrayList();
    ObservableList<Newtodo> completelist= FXCollections.observableArrayList();

    @FXML
    private void add_to_list() {
        //will get information from user input that includes the due date, title, and description with a checkmark box
        //orr add to existing list

        //wont add to list if the length of description is empty or longer than 256
        if(list.size()<=100&&!add_description.getText().isEmpty()&&add_description.getText().length()<256) {
            list.add(new Newtodo(false,add_date.getValue(),
                                add_description.getText()));
        }
        table_view.setEditable(true);
        table_view.setItems(list);
    }
    @FXML
    public void remove_from_list(){
        //will remove an item from a list
        delete_item.setOnAction(e -> {
            Newtodo selectedItem = table_view.getSelectionModel().getSelectedItem();
            table_view.getItems().remove(selectedItem);
        });

    }
    @FXML
    public void remove_all(){
        //remove all items from the list
        table_view.getItems().clear();
        list.removeAll();
    }
    @FXML
    void save_file(){
        //will save user list to local database specified with file location and name of saved data
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        //fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(".TXT", String.valueOf(list)));

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        File savedFile= fileChooser.showSaveDialog(null);
        if (savedFile != null) {

            try {
                save(savedFile);
            }
            catch(IOException e) {

                e.printStackTrace();
            }
        }
    }
    @FXML
    //get the file location from filechooser and then create a new txt file with that new location
    public void save(File fileName) throws IOException {
        try {
            FileOutputStream writeData = new FileOutputStream(fileName);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(list.toString());

            writeStream.flush();
            writeStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void display_specific_list(){
        //will show incompleted
        // will filter a list based on completed, incomplete, and all in a saved task list

        //list.removeIf(s-> s.getStatus().getValue());
        incompletelist.clear();

        for(Newtodo a: list){
            if(!a.getStatus().getValue()){
                incompletelist.add(a);
            }
        }
        table_view.setItems(incompletelist);
    }
    @FXML
    void showall(){
        //shows all items in a list
        table_view.setItems(list);
    }
    @FXML
    void display_completed(){
        //will only show items that are completed
        completelist.clear();
        for(Newtodo a: list){
            if(a.getStatus().getValue()){
                completelist.add(a);
            }
        }
        table_view.setItems(completelist);
    }
    @FXML
    void load_data(){
        //will load a prev saved list from storage
    }
    @FXML
    void load_help_window() throws IOException {
        //pops up a new window that will tell the user what each button does and how to use todo application
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("helpwindow.fxml"));
        Parent root1=(Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Help");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        add_date.setValue(LocalDate.now());

//creates editable text boxes in the table view that allows the user to change the status/date/and description easily
        status_col.setCellValueFactory(status_col->status_col.getValue().getStatus());
        status_col.setCellFactory(CheckBoxTableCell.forTableColumn(status_col));

        date_col.setCellValueFactory(new PropertyValueFactory<>("date"));
        date_col.setCellFactory(TextFieldTableCell.forTableColumn(add_date.getConverter()));

        description_col.setCellValueFactory(new PropertyValueFactory<>("description"));
        description_col.setCellFactory(TextFieldTableCell.<Newtodo>forTableColumn());

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

