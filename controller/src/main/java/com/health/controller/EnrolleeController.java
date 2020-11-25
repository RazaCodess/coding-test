package com.health.controller;

import com.health.appResponse.AppResponse;
import com.health.service.EnrolleeService;
import com.health.vo.EnrolleeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/health/v1")
public class EnrolleeController {
    @Autowired
    private EnrolleeService enrolleeService;

    @GetMapping("/showAll")
    public List<EnrolleeVO> showAll() {
        return enrolleeService.findAllEnrollee();
    }

    @PostMapping("/createEnrollee")
    public AppResponse createEnrollee(@RequestBody EnrolleeVO enrolleeVO) {
        int id = enrolleeService.addEnrollee(enrolleeVO);
        AppResponse appResponse = id != 0 ? new AppResponse(200, "Successfully Added") : new AppResponse(300, "Unsuccessful");
        return appResponse;

    }

    @PutMapping("/updateEnrollee/{eid}")
    public AppResponse updateEnrollee(@PathVariable int eid, @RequestBody EnrolleeVO enrolleeVO) {
        AppResponse appResponse = new AppResponse();
        int i = enrolleeService.updateEnrollee(eid, enrolleeVO);
        if (i == 0) {
            appResponse.setCode(301);
            appResponse.setResponse("There was an error updating the record, please check eid");
        } else {
            appResponse.setCode(200);
            appResponse.setResponse("Successfully updated the record");

        }
        return appResponse;
    }

    @DeleteMapping("/deleteEnrollee/{eid}")
    public AppResponse deleteEnrolle(@PathVariable int eid) {
        AppResponse appResponse = new AppResponse();
        int i = enrolleeService.deleteEnrollee(eid);
        if (i == 0) {
            appResponse.setCode(301);
            appResponse.setResponse("There was an error updating the record, please check eid");
        } else {
            appResponse.setCode(200);
            appResponse.setResponse("Successfully deleted the record");

        }
        return appResponse;
    }

}
