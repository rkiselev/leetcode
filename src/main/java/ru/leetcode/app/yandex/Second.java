package ru.leetcode.app.yandex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Second {
    /**
     * Требуется реализовать метод оценки затрат по кварталам.
     * Дано n счетов за услуги в 2022 год. Каждый счет характеризуется тремя параметрами:  dateFrom i,
     * dateFinish i, amount i – начало оказание услуги, последний день оказания услуги, размер оплаты. Необходимо
     * платежи разложить пропорционально дням внутри интервала оказания услуги и просуммировать по кварталам
     * (деление до копеек необходимо выполнять с округлением вниз, т.е. сумма по кварталам может быть меньше общей
     * суммы по счетам). Сначала необходимо определить сумму платежа за один день, а затем округленную сумму прибавить
     * к каждому из дней квартала.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        int count = Integer.parseInt(reader.readLine());
        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[]s = reader.readLine().split(" ");
            payments.add(new Payment(LocalDate.parse(s[1] + ".2022", formatter),LocalDate.parse(s[2] + ".2022", formatter), new BigDecimal(s[0])));
        }

        Map<Integer, BigDecimal> quarterPayments = new HashMap<>();
        for (Payment payment : payments) {
            long totalDays = ChronoUnit.DAYS.between(payment.dateFrom, payment.dateFinish) + 1;
            BigDecimal paymentPerDay = payment.amount.divide(BigDecimal.valueOf(totalDays), 2, RoundingMode.DOWN);
            var currentDate = payment.dateFrom;
            while (currentDate.isBefore(payment.dateFinish) || currentDate.equals(payment.dateFinish)) {
                int quarter = getQuarterNumber(currentDate);
                BigDecimal sum = quarterPayments.getOrDefault(quarter, BigDecimal.ZERO);
                quarterPayments.put(quarter, sum.add(paymentPerDay));
                currentDate = currentDate.plusDays(1);
            }
        }
        System.out.println(quarterPayments.getOrDefault(1, BigDecimal.ZERO.setScale(2, RoundingMode.DOWN)));
        System.out.println(quarterPayments.getOrDefault(2, BigDecimal.ZERO.setScale(2, RoundingMode.DOWN)));
        System.out.println(quarterPayments.getOrDefault(3, BigDecimal.ZERO.setScale(2, RoundingMode.DOWN)));
        System.out.println(quarterPayments.getOrDefault(4, BigDecimal.ZERO.setScale(2, RoundingMode.DOWN)));
    }

    private static int getQuarterNumber(LocalDate date) {
        int month = date.getMonthValue();
        if (month <= 3) {
            return 1;
        } else if (month <= 6) {
            return 2;
        } else if (month <= 9) {
            return 3;
        } else {
            return 4;
        }
    }

    static class Payment {

        LocalDate dateFrom;
        LocalDate dateFinish;
        BigDecimal amount;

        public Payment(LocalDate dateFrom, LocalDate dateFinish, BigDecimal amount) {
            this.dateFrom = dateFrom;
            this.dateFinish = dateFinish;
            this.amount = amount;
        }

    }
}
