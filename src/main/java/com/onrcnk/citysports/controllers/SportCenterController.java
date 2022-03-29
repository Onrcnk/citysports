package com.onrcnk.citysports.controllers;

import com.onrcnk.citysports.commands.SportCenterCommand;
import com.onrcnk.citysports.repositories.SportCenterRepository;
import com.onrcnk.citysports.services.FacilityService;
import com.onrcnk.citysports.services.SportCenterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Slf4j
@Controller
public class SportCenterController {

    private final SportCenterService sportCenterService;
    private final SportCenterRepository sportCenterRepository;
    private final FacilityService facilityService;

    public SportCenterController(SportCenterService sportCenterService, SportCenterRepository sportCenterRepository, FacilityService facilityService) {
        this.sportCenterService = sportCenterService;
        this.sportCenterRepository = sportCenterRepository;
        this.facilityService = facilityService;
    }

    @RequestMapping("/sportcenters")
    public String getSportCenterPage(Model model){

        return "showsportcenters";
    }

    @RequestMapping("/sportcenter/{facilityId}/list")
    public String getFacilityList(@PathVariable String facilityId, Model model){

        Set<SportCenterCommand> sportCenterCommandSet = sportCenterService.getSportCenter();
        model.addAttribute("sportCenters", sportCenterCommandSet);
        return "sportcenter/facilitieslist";
    }

}