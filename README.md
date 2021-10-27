# Crypto web service

Deribit web service returns the data from Deribit Exchange through REST API.


Here are the main functions.

1. Getting the user's current balances and reserved funds for all available currencies (‘reserved’ means are not available for withdrawal). This data must be stored in the relational database and updated by each call of the method, if it is needed.

Sample Get request:
            curl -X GET "http://localhost:8080/get_account_summary?currency=BTC&extended=true"

Sample Response: 

    {
                        "jsonrpc": "2.0",
                        "result": {
                        "total_pl": 0,
                        "session_upl": 0,
                        "session_rpl": 0,
                        "projected_maintenance_margin": 0,
                        "projected_initial_margin": 0,
                        "projected_delta_total": 0,
                        "portfolio_margining_enabled": false,
                        "options_vega": 0,
                        "options_value": 0,
                        "options_theta": 0,
                        "options_session_upl": 0,
                        "options_session_rpl": 0,
                        "options_pl": 0,
                        "options_gamma": 0,
                        "options_delta": 0,
                        "margin_balance": 99,
                        "maintenance_margin": 0,
                        "limits": {
                        "non_matching_engine": {
                        "rate": 20,
                        "burst": 100
                        },
                        "matching_engine": {
                        "rate": 5,
                        "burst": 20
                        }
                        },
                        "initial_margin": 0,
                        "futures_session_upl": 0,
                        "futures_session_rpl": 0,
                        "futures_pl": 0,
                        "estimated_liquidation_ratio_map": {},
                        "estimated_liquidation_ratio": 0,
                        "equity": 99,
                        "deposit_address": "2N1W5r69hxzipiYWVMa2V9XhvS8buGGXk2Y",
                        "delta_total_map": {},
                        "delta_total": 0,
                        "currency": "BTC",
                        "balance": 99,
                        "available_withdrawal_funds": 99,
                        "available_funds": 99
                        },
                        "usIn": 1634836111316692,
                        "usOut": 1634836111317313,
                        "usDiff": 621,
                        "testnet": true
   }

2. Getting history of withdrawals and deposits.

Deposits

Sample Request: 
            curl -X GET "http://localhost:8080/get_deposits?count=10&currency=BTC&offset=0"

Sample Response:


       {
            "jsonrpc": "2.0",
                           "result": {
                           "data": [
                           {
                           "updated_timestamp": 1634835930268,
                           "transaction_id": "35aca7ddc66688fb496ad8ffcb05751bacfbffadf16795e1392706af0c4df047",
                           "state": "completed",
                           "received_timestamp": 1634835886216,
                           "note": "",
                           "currency": "BTC",
                           "amount": 100,
                           "address": "2N1W5r69hxzipiYWVMa2V9XhvS8buGGXk2Y"
                           }
                           ],
                           "count": 1
                           },
                           "usIn": 1635290982465444,
                           "usOut": 1635290982465622,
                           "usDiff": 178,
                           "testnet": true
   }


Withdrawals

Sample Request: 
            curl -X GET "http://localhost:8080/get_withdrawals?count=10&currency=BTC&offset=0"

Sample Response:
    
    {
                "jsonrpc": "2.0",
                "result": {
                "data": [
                {
                "updated_timestamp": 1635201127212,
                "transaction_id": null,
                "state": "rejected",
                "priority": 1,
                "note": "",
                "id": 16795,
                "fee": 0.0001,
                "currency": "BTC",
                "created_timestamp": 1635197498666,
                "confirmed_timestamp": null,
                "amount": 0.1,
                "address": "2MtT6fquvjFDYb87ZBDwK6r7jUCpa71RBTp"
                },
                {
                "updated_timestamp": 1635196844654,
                "transaction_id": "a021b0da9a931c166332be33e0e41db3f3924f489cf50fa1fb1c5c18d0d12448",
                "state": "completed",
                "priority": 1.5,
                "note": "",
                "id": 16794,
                "fee": 0.0002,
                "currency": "BTC",
                "created_timestamp": 1635196743353,
                "confirmed_timestamp": 1635196788500,
                "amount": 0.2,
                "address": "2MtT6fquvjFDYb87ZBDwK6r7jUCpa71RBTp"
                }
                ],
                "count": 2
                },
                "usIn": 1635291271058136,
                "usOut": 1635291271058340,
                "usDiff": 204,
                "testnet": true
    }


3. Withdraw from exchange to external crypto address.

Sample Request:
            curl -X GET "http://localhost:8080/withdraw?address=2MtT6fquvjFDYb87ZBDwK6r7jUCpa71RBTp&amount=0.1&currency=BTC&priority=high"

Sample Response:


       {
               "jsonrpc": "2.0",
               "id": 2745,
               "result": {
               "count": 1,
               "data": [
               {
               "address": "2NBqqD5GRJ8wHy1PYyCXTe9ke5226FhavBz",
               "amount": 0.5,
               "confirmed_timestamp": null,
               "created_timestamp": 1550571443070,
               "currency": "BTC",
               "fee": 0.0001,
               "id": 1,
               "priority": 0.15,
               "state": "unconfirmed",
               "transaction_id": null,
               "updated_timestamp": 1550571443070
               }
               ]
               }
   }


4. Transfer between main account and sub account.

Sample Request:
            curl -X GET "http://localhost:8080/submit_transfer_to_subaccount?amount=0.4&currency=BTC&destination=34536"

Sample Response:
    
    {
                "jsonrpc": "2.0",
                "result": {
                "updated_timestamp": 1634838061273,
                "type": "subaccount",
                "state": "confirmed",
                "source": 34532,
                "other_side": "donsasikumar_1",
                "note": "",
                "id": 257822,
                "direction": "payment",
                "currency": "BTC",
                "created_timestamp": 1634838061273,
                "amount": 0.4
                },
                "usIn": 1634838061272936,
                "usOut": 1634838061274234,
                "usDiff": 1298,
                "testnet": true
    }


Build Steps

            mvn clean package
            docker build --tag=deribit:latest .  
            docker run -p8080:8080 deribit:latest

Database Console

            http://localhost:8080/h2console/

            JDBC Url = jdbc:h2:mem:testdb

            Click Connect and see Account table!

Getting Auth Token

Sample Get Request:

            curl -X GET "https://test.deribit.com/api/v2/public/auth?client_id=qP-eQ_jt&client_secret=L6wIaR-tQEnJrQzI-nHnJMg-dPNJ2CMu0EPLdhPBc0g&grant_type=client_credentials"



Sample Response:

    {
        "jsonrpc": "2.0",
        "result": {
        "token_type": "bearer",
        "scope": "account:read_write block_trade:read_write custody:read_write mainaccount name:donsasikumar session:rest-waHCBhVpNio= trade:read_write wallet:read_write",
        "refresh_token": "1635811552620.1Paj8pv_.9U2_iM61eDqbeLLReHrs25yV93MXP19xwJeqR2not3la_bN-1xgs9JrfiSep8s-lvqaworRaB27uAWe0PCgPWLU27FMKsxhfg0nfW9Qfcmp6a8t-n9KGC-4ttx1z12nsOOISemtYFsasH-2mrlJWdP1GK47dlWE4mVM3Vx-RXih7XBTK5CQM_OhyicRXI87TESvAUma0HlHexjAwNwzbVbBKpPZaYeTqy_aVrEh9i1KhM2XkXu-nHGpGD8d_IEJ2IR6rXOu5MFN3jtRGuxMbjt8q0KSk9rEG1NtXkkwYNWjm0Q0vspth2H_8zp6_HLy-nweWhsU17Yx49HHOzKagpUaCLc_oKtUUc_MQtD0",
        "expires_in": 899,
        "access_token": "1635207652620.1GDPUAXU.P3o5AT5xRiAXjTprl696FJQqTn3qgOf58nnDgQIpCySxr1ViOophlakE2e8t3TdNn2jDWVna0k_sy57A6uHiag2ukyqDQHof62biClZtWEIhOHTsUjYmsSF3eBp5MuhjmQdgU7fndlmI8SPNDHbBGCW_PwEsoYrFUWj1x5Iseg8EVN7sPJqSxh6t2O6kkAQO0O_kEw43RZCW_Zl5OvNd26n0ZvzCVgn9vkTRKERi-NU_tEcREHVA06P9cd91a2prEvbkLHR4K0s05Dd3IXgmEF2KDoFV9GCaEPBa7qsepUeuKa0P_9gT_BMVp7MR9TpYHev59SXR0TWcGh1dX2pnQ4ITbanJVQMcffloxOZJ"
        },
        "usIn": 1635206752620709,
        "usOut": 1635206752621370,
        "usDiff": 661,
        "testnet": true
}
