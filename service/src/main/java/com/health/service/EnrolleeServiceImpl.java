package com.health.service;

import com.health.entity.Dependent;
import com.health.entity.Enrollee;
import com.health.repo.DependentRepository;
import com.health.repo.EnrolleeRepository;
import com.health.vo.DependentVO;
import com.health.vo.EnrolleeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class EnrolleeServiceImpl implements  EnrolleeService {
    @Autowired
    private EnrolleeRepository enrolleeRepository;
    @Autowired
    private DependentRepository dependentRepository;

    public List<EnrolleeVO> findAllEnrollee() {
        List<Enrollee> enrollees = enrolleeRepository.findAll();
        List<EnrolleeVO> enrolleeVOs = copyEnrollees(enrollees);
        return enrolleeVOs;
    }

    private List<EnrolleeVO> copyEnrollees(List<Enrollee> enrollees) {
        List<EnrolleeVO> enrolleeVOs = enrollees.stream().map(enrollee -> copy(enrollee)).collect(Collectors.toList());
        return enrolleeVOs;
    }

    private EnrolleeVO copy(Enrollee enrollee) {
        EnrolleeVO enVO = new EnrolleeVO();
        BeanUtils.copyProperties(enrollee, enVO);
        return enVO;
    }

    public int addEnrollee(EnrolleeVO enrolleeVO) {

        List<Dependent> dependents = new ArrayList<>();
        Dependent dependent;
        if(enrolleeVO.getDependents()!=null){
            for (DependentVO dependentVO : enrolleeVO.getDependents()) {
                dependent = new Dependent();
                BeanUtils.copyProperties(dependentVO, dependent);
                dependents.add(dependent);
            }
        }
        Enrollee enrollee = new Enrollee();
        BeanUtils.copyProperties(enrolleeVO, enrollee,"dependents");
        enrollee.setDependents(dependents);
        Enrollee enrollee1=enrolleeRepository.save(enrollee);
        return enrollee1.getId();
    }

    @Override
    public int updateEnrollee(int eid, EnrolleeVO enrolleeVO) {
      Optional<Enrollee> enrolleeOptional=enrolleeRepository.findById(eid);
      if(enrolleeOptional.isPresent()){
          BeanUtils.copyProperties(enrolleeVO,enrolleeOptional.get(),"id");
          return 1;
      }
        return 0;
    }

    @Override
    public int deleteEnrollee(int eid) {

        try{
            enrolleeRepository.deleteById(eid);
            return 1;
        }catch (Exception e){
            System.out.println("Deleting Error "+e.getMessage());
            return 0;

        }
    }
}
