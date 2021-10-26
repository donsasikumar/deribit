package com.test.www.deribit.domain.withdraw;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    public int count;
    public List<Datum> data;
}
