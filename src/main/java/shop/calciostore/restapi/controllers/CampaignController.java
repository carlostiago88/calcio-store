package shop.calciostore.restapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.calciostore.persistence.entities.Campaign;
import shop.calciostore.persistence.repositories.CampaignRepository;
import shop.calciostore.usecase.campaign.CampaignGateway;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/campanhas")
public class CampaignController {

    private CampaignGateway campaignGateway;
    private CampaignRepository campaignRepository;
    private Date today = Calendar.getInstance().getTime();

    public CampaignController(CampaignGateway campaignGateway, CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
        this.campaignGateway = campaignGateway;
    }

    @GetMapping("/v1")
    public List<Campaign> findAll(){
        return campaignRepository.findAllByEndDateIsGreaterThanEqual(today);
    }

    @PostMapping("/v1/create")
    public ResponseEntity<Object> create(@RequestBody Campaign campaign){
        return new ResponseEntity<>(campaignGateway.create(campaign),HttpStatus.CREATED);
    }

    @PutMapping(path = "/v1/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Campaign campaign){
       Optional<Campaign> exists = campaignRepository.findById(id);
       if(!exists.isPresent()){
           return ResponseEntity.notFound().build();
       }
       campaign.setId(id);
       return new ResponseEntity<>(campaignRepository.save(campaign),HttpStatus.OK);
    }

    @DeleteMapping(path = "/v1/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        Optional<Campaign> exists = campaignRepository.findById(id);
        if(!exists.isPresent()){
            return ResponseEntity.notFound().build();
        }
        campaignRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
