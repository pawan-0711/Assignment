package com.assignment.kafka.engine;

import com.assignment.kafka.model.ParentRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Service
public class Producer {

    @Autowired
    private KafkaTemplate<String, ParentRecord> kafkaTemplate1;


    public void sendlog(ParentRecord parentRecord) {

        /*LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        LocalDate localDate = LocalDate.now();//For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy");
        String formattedString = localDate.format(formatter);

        Record record1 = new Record("p",
                formattedDate,
                "notification event",
                "transaction_notify_event",
                new EventMessage(
                        new Info("Online",
                                "HDFC",
                                1300L,
                                200L,
                                12345L,
                                formattedString
                        )
                ),
                new EventError()
        );

        List<Record> record = new ArrayList<>();
        record.add(record1);

        ParentRecord parentRecord1 = new ParentRecord();
        parentRecord1.setRecord(record);*/

        ListenableFuture<SendResult<String, ParentRecord>> future =
                kafkaTemplate1.send("log123", parentRecord);

        future.addCallback(new ListenableFutureCallback<SendResult<String, ParentRecord>>() {

            @Override
            public void onSuccess(SendResult<String, ParentRecord> result) {
                System.out.println("Sent message=[" + parentRecord +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + parentRecord + "] due to : " + ex.getMessage());
            }
        });

    }
}
