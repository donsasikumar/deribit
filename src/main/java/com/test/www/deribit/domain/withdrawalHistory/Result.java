package com.test.www.deribit.domain.withdrawalHistory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result{
    public List<Datum> data;
    public int count;
}