package com.keemono.service.layout.impl;

import com.keemono.common.converter.dto.layout.LayoutDto;
import com.keemono.common.converter.dto.layout.LayoutDtoConverter;
import com.keemono.core.mongo.domain.layout.Layout;
import com.keemono.core.mongo.repository.layout.ILayoutRepository;
import com.keemono.service.layout.ILayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by edu on 10/05/2015.
 */
@Service
public class LayoutServiceImpl implements ILayoutService {

    @Autowired
    private ILayoutRepository layoutRepository;

    @Autowired
    private LayoutDtoConverter layoutDtoConverter;

    @Override
    public LayoutDto createLayout(LayoutDto layoutDto){
        Layout layout = layoutDtoConverter.createFromDto(layoutDto);
        layout = layoutRepository.save(layout);
        return layoutDtoConverter.createDto(layout);
    }
}
