package com.assignment.kafka.model;


import java.util.List;

public class ParentRecord {

    List<Record> record;

    @Override
    public String toString() {
        return "ParentRecord{" +
                "record=" + record +
                '}';
    }

    public ParentRecord() {
    }

    public List<Record> getRecord() {
        return record;
    }

    public void setRecord(List<Record> record) {
        this.record = record;
    }
}
