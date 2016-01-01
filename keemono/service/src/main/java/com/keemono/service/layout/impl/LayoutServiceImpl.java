package com.keemono.service.layout.impl;

import com.keemono.common.converter.dto.layout.LayoutDto;
import com.keemono.common.mapper.BaseMapper;
import com.keemono.core.mysql.Repository.layout.ILayoutRepository;
import com.keemono.core.mysql.Repository.user.IUserRepository;
import com.keemono.core.mysql.domain.layout.Layout;
import com.keemono.core.mysql.domain.user.User;
import com.keemono.service.layout.ILayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edu on 10/05/2015.
 */
@Service
public class LayoutServiceImpl extends BaseMapper implements ILayoutService {

    @Autowired
    private IUserRepository IUserRepository;

    @Autowired
    private ILayoutRepository ILayoutRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,   rollbackFor = Exception.class,readOnly = false)
    public LayoutDto createLayout(LayoutDto layoutDto) throws Exception {

        Layout layout = mapper.map(layoutDto,Layout.class);

        //FIXME: quitar esta validacion cuando ya estemos pasando el usuario logeado
        if(layoutDto.getUuid() !=null){
            User user = IUserRepository.findOne(layoutDto.getCreator());
            if(user !=null){
                layout.setCreator(user);
            }
        }
        try {

          layout = ILayoutRepository.save(layout);
        }catch (Exception e) {
            throw new Exception(e);
        }
        return mapper.map(layout,LayoutDto.class);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,   rollbackFor = Exception.class,readOnly = false)
    public LayoutDto updateLayout(final LayoutDto layoutDto, String layoutUuid){

        Layout layout = ILayoutRepository.findUUID(layoutUuid);

        if(layoutDto.getSchema()!=null && !layoutDto.getSchema().isEmpty()){
            layout.setSchema(layoutDto.getSchema());
        }
        if(layoutDto.getName()!=null && !layoutDto.getName().isEmpty()){
            layout.setName(layoutDto.getName());
        }
        if(layoutDto.getCreator()!=null && !layoutDto.getCreator().isEmpty()){
            User user = IUserRepository.findOne(layoutDto.getCreator());
            layout.setCreator(user);
        }

        layout = ILayoutRepository.update(layout);
        return mapper.map(layout, LayoutDto.class);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public LayoutDto getLayoutByUUId(String uuid){
        Layout layout = ILayoutRepository.findUUID(uuid);
        return mapper.map(layout, LayoutDto.class);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List <LayoutDto> getAllLayoutList(){
        List<Layout> lista = ILayoutRepository.findAll();

        List <LayoutDto>listOut = new ArrayList<>();
        for(Layout layout : lista){
            LayoutDto layoutDto = mapper.map(layout, LayoutDto.class);
            listOut.add(layoutDto);
        }

        return  listOut;
    }
}
