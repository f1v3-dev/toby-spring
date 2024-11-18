package seungjo.hello;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {

    private Long orderId;
    private String currency;
    private BigDecimal foreignCurrencyAmount; // 돈과 관련된 타입은 정확한 타입을 사용하자.
    private BigDecimal exRate;
    private BigDecimal convertedAmount;
    private LocalDateTime validUntil;

    public Payment(Long orderId, String currency,
                   BigDecimal foreignCurrencyAmount, BigDecimal exRate,
                   BigDecimal convertedAmount, LocalDateTime validUntil) {

        // 파라미터 순서를 헷갈리면 잘못된 객체가 만들어지는 것을 조심해야 한다.
        // 1. Setter
        // 2. Builder

        this.orderId = orderId;
        this.currency = currency;
        this.foreignCurrencyAmount = foreignCurrencyAmount;
        this.exRate = exRate;
        this.convertedAmount = convertedAmount;
        this.validUntil = validUntil;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getForeignCurrencyAmount() {
        return foreignCurrencyAmount;
    }

    public BigDecimal getExRate() {
        return exRate;
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId=" + orderId +
                ", currency='" + currency + '\'' +
                ", foreignCurrencyAmount=" + foreignCurrencyAmount +
                ", exRate=" + exRate +
                ", convertedAmount=" + convertedAmount +
                ", validUntil=" + validUntil +
                '}';
    }
}
