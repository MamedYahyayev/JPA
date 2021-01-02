package az.maqa.auditing.model;

import az.maqa.auditing.service.FileWriterService;

import javax.persistence.*;
import java.util.Date;

import static az.maqa.auditing.model.AuditOperation.*;

public class AuditingEntity {

    @Column
    private String operation;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    public AuditingEntity() {

    }

    public AuditingEntity(String operation, Date time) {
        this.operation = operation;
        this.time = time;
    }


    @PrePersist
    public void prePersist(Object o) {
        System.out.println("Pre Persist");
        audit(PERSIST.name());
    }

    @PreUpdate
    public void preUpdate(Object o) {
        audit(UPDATE.name());
    }

    @PreRemove
    public void preRemove(Object o) {
        System.out.println("Pre Remove");
        audit(REMOVE.name());
    }

    private void audit(String operation) {
        setOperation(operation);
        setTime(new Date());
        FileWriterService.writeFile(new AuditingEntity(operation, time));
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
