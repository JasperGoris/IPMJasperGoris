package IPMJasperGoris.IPMJasperGoris.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SubTask{
    @Id
    @GeneratedValue
    private Long subId;

    private Long correspondingTask;
    private String name;
    private String description;
    private String tijdstip;
    private String datum;

    public SubTask(){
    }

    public SubTask(String name, String description, String tijdstip, String datum) {
        this.name = name;
        this.description = description;
        this.tijdstip = tijdstip;
        this.datum = datum;
    }


    public void setSubId(Long subId) {
        this.subId = subId;
    }

    public Long getSubId() {
        return subId;
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

    public void setCorrespondingTask(Long correspondingTask) {
        this.correspondingTask = correspondingTask;
    }

    public Long getCorrespondingTask() {
        return correspondingTask;
    }
}
