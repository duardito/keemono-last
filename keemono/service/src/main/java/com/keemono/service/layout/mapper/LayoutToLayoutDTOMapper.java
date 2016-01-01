package com.keemono.service.layout.mapper;

import com.keemono.common.converter.dto.layout.LayoutDto;
import com.keemono.common.mapper.CustomBaseMapper;
import com.keemono.core.mysql.Repository.user.IUserRepository;
import com.keemono.core.mysql.domain.layout.Layout;
import ma.glasnost.orika.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by edu on 12/10/2015.
 */
@Component
public class LayoutToLayoutDTOMapper extends CustomBaseMapper<Layout, LayoutDto> {

    @Autowired
    private IUserRepository userRepository;

    public LayoutToLayoutDTOMapper(){
        super();
        addField("schema", "schema");
        addField("creator.uuid", "creator");
    }

    @Override
    public void mapAtoB(Layout layout, LayoutDto layoutDto, MappingContext context) {
        super.mapAtoB(layout, layoutDto, context);
    }


}
