package seungjo.hello;

import java.io.IOException;
import java.math.BigDecimal;

public class Client {
    public static void main(String[] args) throws IOException {
        PaymentService paymentService = new WebApiExRatePaymentService();

        Long orderId = 100L;
        String currency = "USD";
        BigDecimal foreignCurrencyAmount = BigDecimal.valueOf(50.7);

        Payment payment = paymentService.prepare(orderId, currency, foreignCurrencyAmount);

        System.out.println(payment);

        PaymentService fixedPaymentService = new FixedExRatePaymentService();
        Payment fixedPayment = fixedPaymentService.prepare(orderId, currency, foreignCurrencyAmount);

        System.out.println(fixedPayment);
    }
}
