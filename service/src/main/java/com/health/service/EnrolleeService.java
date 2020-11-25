package com.health.service;

import com.health.vo.EnrolleeVO;

import java.util.List;

public interface EnrolleeService {
    public List<EnrolleeVO> findAllEnrollee();

    public int addEnrollee(EnrolleeVO enrolleeVO);

    int updateEnrollee(int eid, EnrolleeVO enrolleeVO);

    int deleteEnrollee(int eid);
}