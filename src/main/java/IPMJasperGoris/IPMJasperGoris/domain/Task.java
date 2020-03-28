package IPMJasperGoris.IPMJasperGoris.domain;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task  {
    @Id
    @GeneratedValue
    private long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotEmpty
    private String tijdstip;
    @NotEmpty
    private String datum;
    @OneToMany (cascade = {CascadeType.ALL})
    private List<SubTask> subTasks = new ArrayList<>();


    public Task() {
    }

    public Task(String name, String description, String tijdstip, String datum) {
        this.name = name;
        this.description = description;
        this.tijdstip = tijdstip;
        this.datum = datum;
    }


    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTijdstip(String tijdstip) {
        this.tijdstip = tijdstip;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTijdstip() {
        return tijdstip;
    }

    public String getDatum() {
        return datum;
    }


    public void addSubTask(SubTask subTask){
        if (subTask == null){
            throw new IllegalArgumentException("subtask is empty");
        }
        subTasks.add(subTask);
    }
}
