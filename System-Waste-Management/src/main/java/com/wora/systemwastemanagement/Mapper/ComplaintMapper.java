package com.wora.systemwastemanagement.Mapper;

import com.wora.systemwastemanagement.DTO.Complaint.CreateComplaintDTO;
import com.wora.systemwastemanagement.DTO.Complaint.ResponseComplaintDTO;
import com.wora.systemwastemanagement.Entity.Complaint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ComplaintMapper {

    @Mapping(target = "bins" , ignore = true)
    @Mapping(target = "client" , ignore = true)
    Complaint toEntity(CreateComplaintDTO createComplaintDto);
    ResponseComplaintDTO toResponse(Complaint complaint);
}