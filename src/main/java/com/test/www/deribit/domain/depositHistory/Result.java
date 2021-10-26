package com.test.www.deribit.domain.depositHistory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result{
    public List<Object> data;
    public int count;
}
