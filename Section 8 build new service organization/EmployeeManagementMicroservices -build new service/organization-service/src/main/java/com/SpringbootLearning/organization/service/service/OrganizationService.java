package com.SpringbootLearning.organization.service.service;

import com.SpringbootLearning.organization.service.dto.OrganizationDto;
import com.SpringbootLearning.organization.service.entity.Organization;
import org.springframework.stereotype.Service;

@Service
public interface OrganizationService {
    OrganizationDto saveOrganization(OrganizationDto organizationDto);
    OrganizationDto getOrganizationByCode(String organizationCode);
}
