package com.corcino.transactionbff.daily_limit.api;

import com.corcino.transactionbff.daily_limit.json.DailyLimitResponse;
import com.corcino.transactionbff.daily_limit.service.DailyLimitService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1/daily-limit")
@AllArgsConstructor
public class DailyLimitController {

    private DailyLimitService limitService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DailyLimitResponse getDailyLimitWithAgencyAndAccount(@RequestParam Long agencyCode, @RequestParam Long accountCode) {
        return limitService.getLimitByAgencyAndAccount(agencyCode, accountCode);
    }

}
