package seungjo.hello;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class PaymentService {

    public Payment prepare(Long oderId, String currency, BigDecimal foreignCurrencyAmount) throws IOException {

        // todo 1. 환율 가져오기
        URL url = new URL("https://open.er-api.com/v6/latest/" + currency);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = br.lines().collect(Collectors.joining());
        br.close();

        // 우리가 필요한 정보(관심사)만 빼오자.
        ObjectMapper mapper = new ObjectMapper();
        ExRateData data = mapper.readValue(response, ExRateData.class);
        BigDecimal exRate = data.rates().get("KRW");


        // todo 2. 금액 계산
        BigDecimal convertedAmount = foreignCurrencyAmount.multiply(exRate);

        // todo 3. 유효 시간 계산
        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30);

        return new Payment(oderId, currency, foreignCurrencyAmount, exRate, convertedAmount, validUntil);
    }

    public static void main(String[] args) throws IOException {
        PaymentService paymentService = new PaymentService();

        Long orderId = 100L;
        String currency = "USD";
        BigDecimal foreignCurrencyAmount = BigDecimal.valueOf(50.7);

        Payment payment = paymentService.prepare(orderId, currency, foreignCurrencyAmount);

        System.out.println(payment);
    }
}
