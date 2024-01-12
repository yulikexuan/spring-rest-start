# Spring REST Getting Started

## Testing Commands

### POST Data
- ``` curl -v -w '\nStatus: %{http_code}\nTotal: %{time_total} s\n' -X POST -H "Content-Type: application/json" -d '{ "account": "yul-1234", "amount": 3000 }' http://localhost:8070/client/payment/14b12699-2d2d-49ba-975d-eba685c3e19d ```
