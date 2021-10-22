package baseline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    private ListView<?> listview;

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
    void buttonpress(ActionEvent event) {
        System.out.println("you clicked me");
    }

}
