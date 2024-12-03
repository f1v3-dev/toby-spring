package seungjo.hello;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

abstract class PaymentService {

    abstract BigDecimal getExRate(String currency) throws IOException;

    public Payment prepare(Long oderId, String currency, BigDecimal foreignCurrencyAmount) throws IOException {
        BigDecimal exRate = getExRate(currency);
        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exRate);
        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30);

        return new Payment(oderId, currency, foreignCurrencyAmount, exRate, convertedAmount, validUntil);
    }
}
