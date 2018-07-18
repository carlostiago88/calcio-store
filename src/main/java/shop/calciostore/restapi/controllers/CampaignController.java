package shop.calciostore.restapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import shop.calciostore.persistence.entities.Campaign;
import shop.calciostore.usecase.campaign.CampaignGateway;

import java.util.List;

@RestController
@RequestMapping(path = "/campanhas")
public class CampaignController {

    private CampaignGateway campaignGateway;

    public CampaignController(CampaignGateway campaignGateway) {
        this.campaignGateway = campaignGateway;
    }

    @GetMapping("/v1")
    public List<Campaign> findAll(){
        return campaignGateway.findAll();
    }

    @PostMapping("/v1/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Campaign create(@RequestBody Campaign campaign){
        return campaignGateway.create(campaign);
    }

/*    @PutMapping(path = "/v1/update",value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody Campaign campaign){

    }

    @DeleteMapping(path = "/v1/delete", value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id){

    }*/

}
