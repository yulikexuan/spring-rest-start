# Spring REST Getting Started

## Testing Commands

### POST Data
- ``` curl -v -w '\nStatus: %{http_code}\nTotal: %{time_total} s\n' -X POST -H "Content-Type: application/json" -d '{ "account": "yul-1234", "amount": 100 }' http://localhost:8090/payment/4abcd288-ae2c-44b2-930e-c0337cd55c3f ```
