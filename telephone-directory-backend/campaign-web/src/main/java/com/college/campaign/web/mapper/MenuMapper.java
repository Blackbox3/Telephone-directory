package com.college.campaign.web.mapper;

import com.college.campaign.entities.model.AdminMenu;
import com.college.campaign.web.dto.MenuDTO;


public class MenuMapper {

    private MenuMapper() {

    }

    public static MenuDTO convertToMenuDTO(AdminMenu adminMenu) {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setId(adminMenu.getId());
        menuDTO.setCode(adminMenu.getCode());
        menuDTO.setName(adminMenu.getName());
        menuDTO.setDescription(adminMenu.getDescription());
        menuDTO.setAdminMenuGroupName(adminMenu.getAdminMenuGroup().getName());
        return menuDTO;
    }

}
