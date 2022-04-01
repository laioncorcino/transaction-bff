package com.corcino.transactionbff.daily_limit.feign;

import com.corcino.transactionbff.daily_limit.json.DailyLimitResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "daily-limit", url = "${daily-limit.url}")
public interface DailyLimitClient {

    @GetMapping(path = "/daily-limit", produces = MediaType.APPLICATION_JSON_VALUE)
    DailyLimitResponse getDailyLimitWithAgencyAndAccount(@RequestParam Long agencyCode, @RequestParam Long accountCode);

}
