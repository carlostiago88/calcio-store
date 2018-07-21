package shop.calciostore.restapi.controllers;

import org.javers.core.Changes;
import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.calciostore.persistence.entities.Campaign;
import shop.calciostore.persistence.repositories.CampaignRepository;
import shop.calciostore.usecase.campaign.CampaignGateway;

import java.util.*;

@RestController
@RequestMapping(path = "/campanhas")
public class CampaignController {

    private CampaignGateway campaignGateway;
    private CampaignRepository campaignRepository;
    private Date today;
    private Javers javers;

    public CampaignController(Javers javers, CampaignGateway campaignGateway, CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
        this.campaignGateway = campaignGateway;
        this.today = Calendar.getInstance().getTime();
        this.javers = javers;
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<Object>find(@PathVariable("id") Long id){
        Optional<Campaign> exists = campaignRepository.findById(id);
        if(!exists.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(campaignGateway.findOne(id), HttpStatus.OK);
    }

    @GetMapping("/v1")
    public List<Campaign> findAll(){
        return campaignRepository.findAllByEndDateIsGreaterThanEqual(today);
    }

    @PostMapping("/v1/create")
    public ResponseEntity<Object> create(@RequestBody Campaign campaign){
        return new ResponseEntity<>(campaignGateway.saveOrUpdate(campaign),HttpStatus.CREATED);
    }

    @PutMapping(path = "/v1/update/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Campaign campaign){
       Optional<Campaign> exists = campaignRepository.findById(id);
       if(!exists.isPresent()){
           return ResponseEntity.notFound().build();
       }
       campaign.setId(id);
       return new ResponseEntity<>(campaignGateway.saveOrUpdate(campaign),HttpStatus.OK);
    }

    @DeleteMapping(path = "/v1/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        Optional<Campaign> campaign = campaignRepository.findById(id);
        if(!campaign.isPresent()){
            return ResponseEntity.notFound().build();
        }
        campaignGateway.deleteById(campaign.get());
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/v1/history")
    public ResponseEntity<Object> history(){
        Changes changes = javers.findChanges(QueryBuilder.byClass(Campaign.class)
                .withNewObjectChanges().build());

        return new ResponseEntity<>(changes.prettyPrint(),HttpStatus.OK);
    }

}
