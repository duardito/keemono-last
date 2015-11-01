package com.keemono.service.layout.impl;

import com.keemono.common.converter.dto.layout.LayoutDto;
import com.keemono.common.mapper.BaseMapper;
import com.keemono.core.mysql.Repository.layout.LayoutRepository;
import com.keemono.core.mysql.Repository.user.UserRepository;
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
    private UserRepository userRepository;

    @Autowired
    private LayoutRepository layoutRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,   rollbackFor = Exception.class,readOnly = false)
    public LayoutDto updateLayout(LayoutDto layoutDto){

        Layout lay = layoutRepository.findUUID(layoutDto.getUuid());

        Layout layout = mapper.map(layoutDto,Layout.class);
        lay.setSchema(layout.getSchema());

        lay =layoutRepository.update(lay);
        return mapper.map(lay,LayoutDto.class);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,   rollbackFor = Exception.class,readOnly = false)
    public LayoutDto createLayout(LayoutDto layoutDto) throws Exception {

        Layout layout = mapper.map(layoutDto,Layout.class);

        //FIXME: quitar esta validacion cuando ya estemos pasando el usuario logeado
        if(layoutDto.getUserId() !=null){
            User user = userRepository.findOne(layoutDto.getUserId());
            if(user !=null){
                layout.setCreator(user);
            }
        }
        try {

          layout = layoutRepository.save(layout);
        }catch (Exception e) {
            throw new Exception(e);
        }
        return mapper.map(layout,LayoutDto.class);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List <LayoutDto> getAllLayoutList(){
        List<Layout> lista = layoutRepository.findAll();

        List <LayoutDto>listOut = new ArrayList<>();
        for(Layout layout : lista){
            LayoutDto layoutDto = mapper.map(layout, LayoutDto.class);
            listOut.add(layoutDto);
        }

        return  listOut;
    }
}
