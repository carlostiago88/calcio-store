package shop.calciostore.restapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.calciostore.persistence.entities.Campaign;

@RestController
public class CampaignController {

    @GetMapping("/test")
    public String findActiveAll(){
        return "1";
    }

}
