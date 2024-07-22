package com.brs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brs.controller.response.HogeResponse;
import com.brs.domain.service.ZoneService;

@RestController
@RequestMapping("foo")
public class HogeController {
    private final ZoneService zoneService;

    @Autowired
    public HogeController(final ZoneService zoneService) {
        this.zoneService = zoneService;
    }

    @RequestMapping(value = "/hoge", method = RequestMethod.GET)
    public String hoge() {
        return "hogehoge";
    }

    @GetMapping("/uoo")
    public HogeResponse hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new HogeResponse(0, zoneService.getZones());
    }

}
