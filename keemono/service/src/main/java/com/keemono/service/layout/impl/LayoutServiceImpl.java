package com.keemono.service.layout.impl;

import com.keemono.common.converter.dto.layout.LayoutDto;
import com.keemono.common.converter.dto.layout.LayoutDtoConverter;
<<<<<<< Updated upstream
import com.keemono.core.mongo.domain.layout.Layout;
import com.keemono.core.mongo.repository.layout.ILayoutRepository;
=======
import com.keemono.core.mysql.domain.user.User;
import com.keemono.core.mysql.repository.user.UserRepository;
import com.keemono.core.solr.repository.layout.Layout;
import com.keemono.core.solr.repository.layout.LayoutSolrRepository;
>>>>>>> Stashed changes
import com.keemono.service.layout.ILayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by edu on 10/05/2015.
 */
@Service
public class LayoutServiceImpl implements ILayoutService {

    @Autowired
<<<<<<< Updated upstream
    private ILayoutRepository layoutRepository;
=======
    private UserRepository userRepository;

    @Autowired
    private LayoutSolrRepository layoutSolrRepository;
>>>>>>> Stashed changes

    @Autowired
    private LayoutDtoConverter layoutDtoConverter;

    @Override
<<<<<<< Updated upstream
    public LayoutDto createLayout(LayoutDto layoutDto){
        Layout layout = layoutDtoConverter.createFromDto(layoutDto);
        layout = layoutRepository.save(layout);
=======
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public LayoutDto createLayout(LayoutDto layoutDto) throws Exception {


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

            throw new Exception();
        }

>>>>>>> Stashed changes
        return layoutDtoConverter.createDto(layout);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List <LayoutDto> getAllLayoutList(){
<<<<<<< Updated upstream
        final List <Layout>lista = layoutRepository.findAll();
        final List listDto = new ArrayList<>();
=======
        /*
        final List <Layout>lista = layoutSolrRepository.findAll();
        final List <LayoutDto>listDto = new ArrayList<LayoutDto>();
>>>>>>> Stashed changes
        for(final Layout layout : lista){
            final LayoutDto layoutDto = layoutDtoConverter.createDto(layout);
            listDto.add(layoutDto);
        }
        return listDto;
        */
        return  null;
    }
}
