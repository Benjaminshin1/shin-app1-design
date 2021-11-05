package baseline;

import java.time.LocalDate;

public class Newtodo {
    private String description;
    private LocalDate date;
    private Boolean status;


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
        this.status=status;
    }
    public Boolean getStatus(){
        return status;
    }

    public Newtodo(Boolean status, LocalDate date, String description){
        this.setStatus(status);
        this.setDate(date);
        this.setDescription(description);
    }
    @Override
    public String toString(){
        return   this.getDate() + " "+ this.getDescription();

    }

}
