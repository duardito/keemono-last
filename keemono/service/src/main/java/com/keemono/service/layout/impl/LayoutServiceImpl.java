package com.keemono.service.layout.impl;

import com.keemono.common.converter.dto.layout.LayoutDto;
import com.keemono.common.converter.dto.layout.LayoutDtoConverter;
import com.keemono.core.mysql.Repository.user.UserRepository;
import com.keemono.core.mysql.domain.user.User;
import com.keemono.core.solr.domain.layout.Layout;
import com.keemono.core.solr.repository.layout.LayoutSolrRepository;
import com.keemono.service.layout.ILayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;

/**
 * Created by edu on 10/05/2015.
 */
@Service
public class LayoutServiceImpl implements ILayoutService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LayoutSolrRepository layoutSolrRepository;


    @Autowired
    private LayoutDtoConverter layoutDtoConverter;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,   rollbackFor = Exception.class,readOnly = true)
    public LayoutDto createLayout(LayoutDto layoutDto) throws Exception {
        System.out.println("la transaction 1: "+ TransactionSynchronizationManager.isCurrentTransactionReadOnly());

        Layout layout = layoutDtoConverter.createFromDto(layoutDto);
        createLayoutMod(layoutDto);
        try {
            User user = new User();
            user.setName("edu");
            //layout.setSchema("pepitoooo");
           // user.setLayout(layout);
            userRepository.save(user);
            layoutSolrRepository.save(layout);

          // layout = layoutRepository.save(layout);
            System.out.println("el layout es: " + layout.getId());
            //user = null;
            //userRepository.save(user);
        }catch (Exception e) {

            throw new Exception(e);
        }
        return layoutDtoConverter.createDto(layout);
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class, readOnly = false)
    public LayoutDto createLayoutMod(LayoutDto layoutDto) throws Exception {

        Layout layout = layoutDtoConverter.createFromDto(layoutDto);
        try {
            User user = new User();
            user.setName("edu");
            //layout.setSchema("pepitoooo");
            // user.setLayout(layout);
            userRepository.save(user);
            layoutSolrRepository.save(layout);

            // layout = layoutRepository.save(layout);
            System.out.println("el layout es: " + layout.getId());
            //user = null;
            //userRepository.save(user);
        }catch (Exception e) {

            throw new Exception(e);
        }
        return layoutDtoConverter.createDto(layout);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List <LayoutDto> getAllLayoutList(){
        /*
        final List <Layout>lista = layoutSolrRepository.findAll();
        final List <LayoutDto>listDto = new ArrayList<LayoutDto>();
        for(final Layout layout : lista){
            final LayoutDto layoutDto = layoutDtoConverter.createDto(layout);
            listDto.add(layoutDto);
        }
        return listDto;
        */
        return  null;
    }
}
