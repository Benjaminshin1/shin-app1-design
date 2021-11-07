package baseline;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;

import java.time.LocalDate;
//constructor for creating each task in a todo list
public class Newtodo {
    private String description;
    private LocalDate date;
    private BooleanProperty status= new SimpleBooleanProperty(true);



    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }

    public LocalDate getDate(){
        return date;
    }
    public void setDate(LocalDate date){
        this.date=date;
    }


    public void setStatus(Boolean status){
        this.status.set(status);
    }
    public ObservableBooleanValue getStatus(){
        return status;
    }

    public Newtodo(Boolean status, LocalDate date, String description){
        this.setStatus(status);
        this.setDate(date);
        this.setDescription(description);
    }
    @Override
    public String toString(){
        //returns the input from text box to readable string for date and description
        return this.getDate() + " "+ this.getDescription();

    }

}
