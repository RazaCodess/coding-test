package com.health.service;

import com.health.entity.Dependent;
import com.health.entity.Enrollee;
import com.health.repo.DependentRepository;
import com.health.repo.EnrolleeRepository;
import com.health.vo.DependentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DependentServiceImpl implements DependentService {
    @Autowired
    private EnrolleeRepository enrolleeRepository;
    @Autowired
    private DependentRepository dependentRepository;

    @Override
    public int addNewDependent(int eid, DependentVO dependentVO) {
        Optional<Enrollee> enrolleeOptional = enrolleeRepository.findById(eid);
        if (enrolleeOptional.isPresent()) {
            Dependent dependent = new Dependent();
            BeanUtils.copyProperties(dependentVO, dependent);
            List<Dependent> dependents = enrolleeOptional.get().getDependents();
            dependents.add(dependent);
            enrolleeOptional.get().setDependents(dependents);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int deleteDependent( int did) {
        try {
            dependentRepository.deleteById(did);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public int updateDependent( int did,DependentVO dependentVO) {
        Optional<Dependent> dependentOptional = dependentRepository.findById(did);
        if (dependentOptional.isPresent()) {
            Dependent dependent=dependentOptional.get();
            BeanUtils.copyProperties(dependentVO,dependent,"id");
            return 1;
        } else {
            return 0;
        }

    }
}
