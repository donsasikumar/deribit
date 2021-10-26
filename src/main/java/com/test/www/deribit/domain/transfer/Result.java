package com.test.www.deribit.domain.transfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result{
    public long updated_timestamp;
    public String type;
    public String state;
    public int source;
    public String other_side;
    public String note;
    public int id;
    public String direction;
    public String currency;
    public long created_timestamp;
    public double amount;
}
