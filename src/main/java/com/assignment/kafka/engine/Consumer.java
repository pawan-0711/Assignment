package com.assignment.kafka.engine;


import com.assignment.kafka.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.net.ConnectException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class Consumer {

    @Autowired
    private RestTemplate restTemplate;


    @KafkaListener(topics = "log123",groupId = "Group11",containerFactory = "kafkaListenerContainerFactory")
    public void consume(ParentRecord parentRecord) {
        System.out.println("Output " + parentRecord);

        List<Record> record = parentRecord.getRecord().stream().filter(r ->
                r.getEventMessage().getInfo().getPayment_mode().equalsIgnoreCase("Online") &&
                        r.getEventMessage().getInfo().getGateway().equalsIgnoreCase("HDFC")).collect(Collectors.toList());

        prepareFinalResponse(record);
    }
        void prepareFinalResponse(List<Record> record){


            ResponseToBank responseToBank = new ResponseToBank();
            for (Record record1 : record) {
                responseToBank.setTotal_amount(record1.getEventMessage().getInfo().getCredit_amount() + record1.getEventMessage().getInfo().getPrevious_balance());
                // responseToBank.setAccount_no(record1.getEventMessage().getInfo().getAccount_no());
                responseToBank.setTransactionDate(record1.getEventMessage().getInfo().getTransactionDate());
                responseToBank.setSourceApplication("Broker");
                break;
            }
            System.out.println("Final Response :- "+responseToBank);


            try {
                if (responseToBank.getAccount_no()!=null)
                    responseToBank.setAccount_no(null);
                MessageDigest md = MessageDigest.getInstance("MD5");

                byte[] messageDigest = md.digest(String.valueOf(responseToBank.getAccount_no()).getBytes());

                BigInteger no = new BigInteger(1, messageDigest);

                String hashtext = no.toString(16);
                while (hashtext.length() < 32) {
                    hashtext = "0" + hashtext;
                }
                responseToBank.setAccount_no(hashtext);
                System.out.println("Hash "+hashtext);
            }

            // For specifying wrong message digest algorithms
            catch (NoSuchAlgorithmException e) {
                System.out.println("No algo found");
            }
            finally {
                callBank(responseToBank);
            }

    }

    public void callBank(ResponseToBank responseToBank){
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity httpEntity = new HttpEntity<>(responseToBank, httpHeaders);
            ResponseEntity responseEntity = restTemplate.exchange("https://localhost:8000/final_response",
                    HttpMethod.POST,
                    httpEntity,
                    ResponseToBank.class);

            HttpStatus httpStatus = responseEntity.getStatusCode();

            System.out.println("Status   -     " + httpStatus);

            System.out.println("Body   -     " + responseEntity.getBody());
        }
        catch (Exception c)
        {
            System.out.println("Connection refused");
        }
    }

}
