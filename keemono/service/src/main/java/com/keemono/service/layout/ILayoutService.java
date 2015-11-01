package com.keemono.service.layout;

import com.keemono.common.converter.dto.layout.LayoutDto;

import java.util.List;

/**
 * Created by edu on 10/05/2015.
 */
public interface ILayoutService {

    LayoutDto updateLayout(LayoutDto layoutDto, String layoutUuid);

    LayoutDto createLayout(LayoutDto layoutDto) throws Exception;

    List<LayoutDto> getAllLayoutList();
}
