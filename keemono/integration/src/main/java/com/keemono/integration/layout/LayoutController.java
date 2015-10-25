package com.keemono.integration.layout;

import com.keemono.common.converter.dto.layout.LayoutDto;
import com.keemono.common.converter.request.layout.LayoutRequest;
import com.keemono.common.converter.response.layout.LayoutResponse;
import com.keemono.common.converter.response.layout.ListLayoutResponse;
import com.keemono.common.mapper.BaseMapper;
import com.keemono.common.ordination.OrdinationRequest;
import com.keemono.common.pagination.PaginationRequest;
import com.keemono.service.layout.ILayoutService;
import com.keemono.utils.Constants;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by edu on 10/05/2015.
 */
@Api(value = "/layout", description = "Operations to do about a layout")
@RequestMapping(value = Constants._LAYOUT_URL)
@RestController
public class LayoutController extends BaseMapper {


    @Autowired
    private ILayoutService layoutService;

    @ApiOperation(value = "create a layout", notes = "create a layout", response = LayoutResponse.class)
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping( method = RequestMethod.POST, produces = Constants._APPLICATION_JSON,consumes = Constants._APPLICATION_JSON)
    public LayoutResponse createLayout(@ApiParam(
            value = "basic data to create layout", required = true) @RequestBody  @Valid final LayoutRequest layoutRequest) throws Exception {

        LayoutDto layoutDto = new LayoutDto();
        BeanUtils.copyProperties(layoutRequest,layoutDto);

        layoutDto = layoutService.createLayout(layoutDto);

        return mapper.map(layoutDto, LayoutResponse.class);
    }

    @ApiOperation(value = "get a layout", notes = "get a layout",response =ListLayoutResponse.class )
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping( method = RequestMethod.GET, produces = Constants._APPLICATION_JSON )
    public ListLayoutResponse getLayouts(@ModelAttribute @Valid final PaginationRequest paginationRequest,@Valid final OrdinationRequest ordinationRequest){


        final List <LayoutDto> lista = layoutService.getAllLayoutList();
        final ListLayoutResponse listLayoutResponse = new ListLayoutResponse();

        for(final LayoutDto layoutDto : lista){
            final LayoutResponse layoutResponse = mapper.map(layoutDto,LayoutResponse.class);
            listLayoutResponse.add(layoutResponse);
        }
        return listLayoutResponse;
    }
}
