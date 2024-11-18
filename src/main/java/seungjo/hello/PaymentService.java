package seungjo.hello;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentService {

    public Payment prepare(Long oderId, String currency, BigDecimal foreignCurrencyAmount) {

        // todo 1. 환율 가져오기
        // todo 2. 금액 계산
        // todo 3. 유효 시간 계산

        return new Payment(oderId, currency, foreignCurrencyAmount,
                BigDecimal.ZERO, BigDecimal.ZERO, LocalDateTime.now());
    }

    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();

        Long orderId = 100L;
        String currency = "USD";
        BigDecimal foreignCurrencyAmount = BigDecimal.valueOf(50.7);

        Payment payment = paymentService.prepare(orderId, currency, foreignCurrencyAmount);

        System.out.println(payment);
    }
}
