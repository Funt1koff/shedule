package com.funtikov.web.schedule.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Day {

    private Integer dayNumber;
    private String dayOfWeek;
    private String currentDateBuilder;
}
