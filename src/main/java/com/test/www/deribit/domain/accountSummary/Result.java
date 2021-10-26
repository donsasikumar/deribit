package com.test.www.deribit.domain.accountSummary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    public EstimatedLiquidationRatioMap estimated_liquidation_ratio_map;
    public double margin_balance;
    public int options_delta;
    public int futures_session_rpl;
    public int projected_maintenance_margin;
    public String deposit_address;
    public boolean security_keys_enabled;
    public int delta_total;
    public int session_rpl;
    public boolean portfolio_margining_enabled;
    public boolean interuser_transfers_enabled;
    public int options_gamma;
    public int projected_initial_margin;
    public int futures_session_upl;
    public int options_value;
    public int id;
    public int futures_pl;
    public Object referrer_id;
    public String type;
    public int fee_balance;
    public int total_pl;
    public double available_funds;
    public String username;
    public String system_name;
    public double equity;
    public long creation_timestamp;
    public int options_vega;
    public int options_session_upl;
    public Limits limits;
    public int projected_delta_total;
    public String currency;
    public double available_withdrawal_funds;
    public int estimated_liquidation_ratio;
    public String email;
    public int options_session_rpl;
    public int session_upl;
    public int maintenance_margin;
    public int initial_margin;
    public int options_theta;
    public int options_pl;
    public DeltaTotalMap delta_total_map;
    public double balance;
}
