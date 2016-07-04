package com.keemono.service.layout.impl;

import com.google.gson.Gson;
import com.keemono.common.mapper.BaseMapper;
import com.keemono.core.mysql.Repository.layout.ILayoutRepository;
import com.keemono.core.mysql.domain.layout.Layout;
import com.keemono.service.layout.ILayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by edu on 10/05/2015.
 */
@Service
public class LayoutServiceImpl extends BaseMapper implements ILayoutService {

    @Autowired
    private ILayoutRepository ILayoutRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,   rollbackFor = Exception.class,readOnly = false)
    public Layout createLayout(Layout layout) throws Exception {

        layout.setCreator(getLoggedUser());
        Gson gson = new Gson();
        String layoutDiv = gson.toJson(layout.getSchema());


        try {
            ILayoutRepository.save(layout);
        }catch (Exception e) {
            throw new Exception(e);
        }
        return layout;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,   rollbackFor = Exception.class,readOnly = false)
    public Layout updateLayout(final Layout layout, String layoutUuid){

        Layout layoutToUpdate = ILayoutRepository.findUUID(layoutUuid);

        if(layout.getSchema()!=null && !layout.getSchema().isEmpty()){
            layoutToUpdate.setSchema(layout.getSchema());
        }
        if(layout.getName()!=null && !layout.getName().isEmpty()){
            layoutToUpdate.setName(layout.getName());
        }

        layoutToUpdate.setCreator(getLoggedUser());

        layoutToUpdate = ILayoutRepository.update(layoutToUpdate);
        return layoutToUpdate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Layout getLayoutByUUId(String uuid){
        return ILayoutRepository.findUUID(uuid);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List <Layout> getAllLayoutList(){
        return  ILayoutRepository.findAll();
    }
}
