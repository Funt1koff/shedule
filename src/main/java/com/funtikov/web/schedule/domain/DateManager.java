package com.funtikov.web.schedule.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateManager {

    private static final String[] weekDaysNames = {
            "Понедельник",
            "Вторник",
            "Среда",
            "Четверг",
            "Пятница",
            "Суббота",
            "Воскресенье"};

    private static final Map<Integer, String> monthNames = new HashMap<>();

    static {
        monthNames.put(1, "Января");
        monthNames.put(2, "Февраля");
        monthNames.put(3, "Марта");
        monthNames.put(4, "Апреля");
        monthNames.put(5, "Мая");
        monthNames.put(6, "Июня");
        monthNames.put(7, "Июля");
        monthNames.put(8, "Августа");
        monthNames.put(9, "Сентября");
        monthNames.put(10, "Октября");
        monthNames.put(11, "Ноября");
        monthNames.put(12, "Декабря");
    }

    public static List<Day> getCurrentWeek() {

        List<Day> weekDays = new ArrayList<>();

        // Получение текущей даты
        LocalDate today = LocalDate.now();

        // Определение дня недели для текущей даты
        DayOfWeek currentDayOfWeek = today.getDayOfWeek();

        // Вычисление даты понедельника
        LocalDate monday = today.minusDays(currentDayOfWeek.getValue() - DayOfWeek.MONDAY.getValue());

        for (int i = 0; i < 7; i++) {
            LocalDate date = monday.plusDays(i);
            String[] splitDate = date.toString().split("-");
            weekDays.add(new Day(
                    Integer.valueOf(splitDate[2]),
                    weekDaysNames[i],
                    Integer.valueOf(splitDate[2]) + " " + monthNames.get(Integer.valueOf(splitDate[1])) + ", " + weekDaysNames[i]));
        }

        return weekDays;
    }
}
