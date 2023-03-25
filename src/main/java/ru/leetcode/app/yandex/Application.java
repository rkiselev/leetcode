package ru.leetcode.app.yandex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Application {

    /**
     * Для разработки модуля отображения фотографий в виде вертикальной ленты решено использовать следующий алгоритм:
     * 	•	выбрать k фотографий из имеющейся коллекции;
     * 	•	отмасштабировать все фотографии до ширины w;
     * 	•	отображать полученные фотографии в вертикальном формате одна над одной без отступов.
     * Определите, какую наибольшую и наименьшую высоту может иметь полученная лента из k фотографий.
     * Будем считать, что при масштабировании фотографии размера w×h до ширины  w, новая высота вычисляется
     * по следующей формуле: 
     * ℎ=ℎ′⋅w/w′
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int wNew = Integer.parseInt(reader.readLine());
        String[] countAndK = reader.readLine().split(" ");
        int count = Integer.parseInt(countAndK[0]);
        int k = Integer.parseInt(countAndK[1]);
        int[][]photos = new int[count][2];
        for (int i = 0; i < count; i++) {
            String[] photo = reader.readLine().split("x");
            photos[i][0] = Integer.parseInt(photo[0]);
            photos[i][1] = Integer.parseInt(photo[1]);
        }
        List<BigDecimal> heights = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            heights.add(new BigDecimal(photos[i][1]).multiply(new BigDecimal(wNew)).divide(new BigDecimal(photos[i][0]), RoundingMode.UP));
        }
        heights.sort(BigDecimal::compareTo);
        int min = 0;
        int max = 0;
        int i = 0;
        while (i < k){
            min += heights.get(i).intValue();
            max += heights.get(count - 1 - i).intValue();
            i++;
        }
        System.out.println(min);
        System.out.println(max);
    }
}
