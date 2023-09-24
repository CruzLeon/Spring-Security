package com.courses.study.springsecurity.persistence.entity;

import lombok.Getter;
import java.util.Arrays;
import java.util.List;

import static com.courses.study.springsecurity.persistence.entity.Role.RolePermission.*;

@Getter
public enum Role {

    ROLE_ADMIN(
            Arrays.asList(
                    READ_MY_PROFILE,
                    READ_ALL_PRODUCTS,
                    READ_ONE_PRODUCT,
                    CREATE_ONE_PRODUCT,
                    UPDATE_ONE_PRODUCT,
                    DISABLE_ONE_PRODUCT,
                    READ_ALL_CATEGORIES,
                    READ_ONE_CATEGORY,
                    CREATE_ONE_CATEGORY,
                    UPDATE_ONE_CATEGORY,
                    DISABLE_ONE_CATEGORY)
    ),
    ROLE_ASSISTANT(
            Arrays.asList(
                    READ_MY_PROFILE,
                    READ_ALL_PRODUCTS,
                    READ_ONE_PRODUCT,
                    UPDATE_ONE_PRODUCT,
                    READ_ALL_CATEGORIES,
                    READ_ONE_CATEGORY,
                    UPDATE_ONE_CATEGORY)
    ),

    ROLE_CUSTOMER(
            Arrays.asList(
                    READ_MY_PROFILE
            )
    );

    private List<RolePermission> permissions;

    Role(List<RolePermission> list) {
        permissions = list;
    }

    enum RolePermission {

        READ_MY_PROFILE,
        READ_ALL_PRODUCTS,
        READ_ONE_PRODUCT,
        CREATE_ONE_PRODUCT,
        UPDATE_ONE_PRODUCT,
        DISABLE_ONE_PRODUCT,
        READ_ALL_CATEGORIES,
        READ_ONE_CATEGORY,
        CREATE_ONE_CATEGORY,
        UPDATE_ONE_CATEGORY,
        DISABLE_ONE_CATEGORY

    }
}
