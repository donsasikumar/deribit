package com.test.www.deribit.response;

import com.test.www.deribit.domain.accountSummary.Result;

public class AccountSummaryResponse {
    public String jsonrpc;
    public Result result;
    public long usIn;
    public long usOut;
    public int usDiff;
    public boolean testnet;
}
