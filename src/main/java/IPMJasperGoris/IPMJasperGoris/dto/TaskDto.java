package IPMJasperGoris.IPMJasperGoris.dto;

import IPMJasperGoris.IPMJasperGoris.domain.SubTask;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class TaskDto {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    @Size(min = 3)
    private String name;
    @NotEmpty
    @Size(min = 3)
    private String description;
    @NotEmpty
    private String tijdstip;
    @NotEmpty
    private String datum;

    private List<SubTask> subTasks;


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
        subTasks.add(subTask);
    }
}
