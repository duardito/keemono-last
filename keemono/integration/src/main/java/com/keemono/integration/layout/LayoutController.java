package com.keemono.integration.layout;

import com.keemono.common.converter.dto.layout.LayoutDto;
import com.keemono.common.converter.request.layout.LayoutRequest;
import com.keemono.common.converter.request.layout.LayoutRequestConverter;
import com.keemono.common.converter.response.layout.LayoutResponse;
import com.keemono.common.converter.response.layout.LayoutResponseConverter;
import com.keemono.service.layout.ILayoutService;
import com.keemono.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by edu on 10/05/2015.
 */
@RequestMapping(value = Constants._LAYOUT_URL)
@RestController
public class LayoutController {

    @Autowired
    private LayoutRequestConverter layoutRequestConverter;

    @Autowired
    private LayoutResponseConverter layoutResponseConverter;
    @Autowired
    private ILayoutService layoutService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping( method = RequestMethod.POST, produces = Constants._APPLICATION_JSON)
    public LayoutResponse createLayout(@RequestBody LayoutRequest layoutRequest){

        LayoutDto layoutDto = layoutRequestConverter.createFromDto(layoutRequest);
        layoutDto = layoutService.createLayout(layoutDto);
        return layoutResponseConverter.createDto(layoutDto);
    }
}
