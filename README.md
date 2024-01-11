# Spring REST Getting Started

## Testing Commands

### Simple GET
- ``` curl -w '\nStatus: %{http_code}\nTotal:  %{time_total} s\n' -X GET -H "Content-Type: application/json" http://localhost:9090/ciao ```

### POST Data
- ``` curl -v -w '\nStatus: %{http_code}\nTotal: %{time_total} s\n' -X POST -H "Content-Type: application/json" -d '{"amount": 100}' http://localhost:9090/payment ```
