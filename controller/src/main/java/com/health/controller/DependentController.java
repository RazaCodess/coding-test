package com.health.controller;

import com.health.appResponse.AppResponse;
import com.health.service.DependentService;
import com.health.service.EnrolleeService;
import com.health.vo.DependentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/health/v2")
public class DependentController {
    @Autowired
    private EnrolleeService enrolleeService;
    @Autowired
    private DependentService dependentService;
    @PostMapping("/addDependent/{eid}")
    public AppResponse addDependent(@PathVariable int eid, @RequestBody DependentVO dependentVO){
        int i =dependentService.addNewDependent(eid,dependentVO);
        AppResponse appResponse=new AppResponse();
        if(i!=0){
            appResponse.setCode(200);
            appResponse.setResponse("Successfully added a dependent");
        }else{
            appResponse.setCode(305);
            appResponse.setResponse("Error adding the dependent, please check eid/ provided info");
        }
        return appResponse;
    }
    @DeleteMapping("/deleteDependent/dependent/{did}")
    public AppResponse deleteDependent(@PathVariable int did){
        int i =dependentService.deleteDependent(did);
        AppResponse appResponse=new AppResponse();
        if(i!=0){
            appResponse.setCode(200);
            appResponse.setResponse("Successfully delete the dependent");
        }else{
            appResponse.setCode(305);
            appResponse.setResponse("Error Deleting the dependent, please check the did");
        }
        return appResponse;
    }
    @PutMapping("/updateDependent/dependent/{did}")
    public AppResponse updateDependent(@PathVariable int did,@RequestBody DependentVO dependentVO){
        int i =dependentService.updateDependent(did,dependentVO);
        AppResponse appResponse=new AppResponse();
        if(i!=0){
            appResponse.setCode(200);
            appResponse.setResponse("Successfully updated a dependent");
        }else{
            appResponse.setCode(305);
            appResponse.setResponse("Error Updating the dependent, please check eid/ provided info");
        }
        return appResponse;
    }
}
