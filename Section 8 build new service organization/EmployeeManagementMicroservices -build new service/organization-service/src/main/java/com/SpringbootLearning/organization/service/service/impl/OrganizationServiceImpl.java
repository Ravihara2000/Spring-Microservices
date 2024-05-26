package com.SpringbootLearning.organization.service.service.impl;

import com.SpringbootLearning.organization.service.dto.OrganizationDto;
import com.SpringbootLearning.organization.service.entity.Organization;
import com.SpringbootLearning.organization.service.mapper.OrganizationMapper;
import com.SpringbootLearning.organization.service.repository.OrganizationRepository;
import com.SpringbootLearning.organization.service.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        OrganizationDto organizationDto1 = OrganizationMapper.mapToOrganizationDto(organization);


        return organizationDto1;
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        OrganizationDto organizationDto = OrganizationMapper.mapToOrganizationDto(organization);
        return organizationDto;
    }
}
