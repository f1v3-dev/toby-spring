# toby-spring

## PaymentService

- 돈과 관련된 타입은 `BigDecimal` 을 사용하여 정확한 계산을 할 수 있도록 한다.
  - 부동소수점 (double, float) 관점 생각 
- 외부 API를 통해 환율 정보를 가져옴 (https://open.er-api.com/v6/latest/USD)
- record를 사용하여 JSON 데이터를 객체로 매핑
    - `@JsonIgnoreProperties(ignoreUnknown = true)` 를 통해 필요한 데이터만을 가져온다.