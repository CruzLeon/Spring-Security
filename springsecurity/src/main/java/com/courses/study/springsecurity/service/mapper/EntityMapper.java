package com.courses.study.springsecurity.service.mapper;

import com.courses.study.springsecurity.dto.RegisteredUser;
import com.courses.study.springsecurity.dto.SaveCategory;
import com.courses.study.springsecurity.dto.SaveProduct;
import com.courses.study.springsecurity.dto.SaveUser;
import com.courses.study.springsecurity.persistence.entity.Category;
import com.courses.study.springsecurity.persistence.entity.Product;
import com.courses.study.springsecurity.persistence.entity.UserSecondProject;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EntityMapper {

    Product mapToEntity(SaveProduct product);
    Category mapToEntity(SaveCategory category);

    RegisteredUser mapTo(UserSecondProject user);

    UserSecondProject mapTo(SaveUser newUser);
}
