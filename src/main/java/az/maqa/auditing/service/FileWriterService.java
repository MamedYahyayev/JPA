package az.maqa.auditing.service;

import az.maqa.auditing.model.AuditingEntity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterService {

    public static void writeFile(AuditingEntity auditingEntity) {
        try {
            FileWriter fileWriter = new FileWriter("log.txt", true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(auditingEntity.getOperation() + " -- " + auditingEntity.getTime() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
