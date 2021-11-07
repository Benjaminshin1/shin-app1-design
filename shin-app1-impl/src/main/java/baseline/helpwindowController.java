package baseline;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class helpwindowController implements Initializable {

    @FXML
    private TextArea textbox;

    @FXML
    private Button adding_a_task;

    @FXML
    private Button deleting_an_item;

    @FXML
    private Button editing_a_task;

    @FXML
    private Button filter_a_list;

    @FXML
    private Button saving_and_loading;

    @FXML
    public void addingatask(){
        textbox.setText(new StringBuilder().append("In order to add a task the text box labeled \"Add task here\" must be filled in\n\n")
                .append("the date will be autofilled with the present date or you can click on the icon next to the textbox and click on an appropriate date\n\n")
                .append("and then to add the task all you have to do is press the add task button").toString());
    }
    @FXML
    public void deletinganitem(){
        textbox.setText(new StringBuilder().append("To delete an item in the list click on the item you want to delete in the list and then that will highlight that option\n\n")
                .append("and then click the delete item button and that will clear that item in your list").toString());
    }
    @FXML
    public void editingatask(){
        textbox.setText("To edit a users date/description/complete checkbox \n\n all they have to do is double click on a tasks date/description/complete checkbox area and it will allow them to change the information");
    }
    @FXML
    public void filteringalist(){
        textbox.setText(new StringBuilder().append("In order to filter a list there is a button labled list view\n").append("\n")
                .append("There will be Three options to filter you task list\n").append("\n")
                .append("the first option will be to show your entire list regardless if they are completed or not\n").append("\n")
                .append("the second option will only show completed tasks in your list\n\n")
                .append("the third option will show incompleted items in the list").toString());
    }
    @FXML
    public void savingandloading(){
        textbox.setText(new StringBuilder().append("There is a button called file and once you click on it the file will open a drop down list in the order delete all,save as, and open saved\n\n")
                .append("the delete all will clear the list\n\n")
                .append("the save as will open a new window where you can choose to save your list as a txt file\n\n")
                .append("the open saved will open a previous file where you can open and show your other saved lists").toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}