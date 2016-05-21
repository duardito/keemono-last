package com.keemono.web.integration.layout;

import com.keemono.common.Constants;
import com.keemono.common.converter.request.layout.LayoutCreateRequest;
import com.keemono.common.converter.response.layout.LayoutResponse;
import com.keemono.common.converter.response.layout.ListLayoutResponse;
import com.keemono.common.mapper.BaseMapper;
import com.keemono.common.ordination.OrdinationRequest;
import com.keemono.common.pagination.PaginationRequest;
import com.keemono.core.mysql.domain.layout.Layout;
import com.keemono.service.layout.ILayoutService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @RequestMapping(method = RequestMethod.POST, produces = Constants._APPLICATION_JSON, consumes = Constants._APPLICATION_JSON)
    public LayoutResponse createLayout(@ApiParam(value = "basic data to create layout", required = true)
                                       @RequestBody @Valid final LayoutCreateRequest layoutCreateRequest) throws Exception {

        Layout layout = mapper.map(layoutCreateRequest, Layout.class);

        layout = layoutService.createLayout(layout);

        return mapper.map(layout, LayoutResponse.class);
    }

    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "get a layout", notes = "get all layout list", response = ListLayoutResponse.class)
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = Constants._LIST, method = RequestMethod.GET, produces = Constants._APPLICATION_JSON)
    public ListLayoutResponse getLayouts(@ModelAttribute @Valid final PaginationRequest paginationRequest, @Valid final OrdinationRequest ordinationRequest) {

        final List<Layout> lista = layoutService.getAllLayoutList();

        final ListLayoutResponse listLayoutResponse = new ListLayoutResponse();
        List<LayoutResponse> out = mapper.mapAsList(lista, LayoutResponse.class);
        listLayoutResponse.addAll(out);

        return listLayoutResponse;
    }

    @ApiOperation(value = "update a layout", notes = "update a layout", response = LayoutResponse.class)
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/{uuid}", method = RequestMethod.PUT, produces = Constants._APPLICATION_JSON, consumes = Constants._APPLICATION_JSON)
    public LayoutResponse updateLayout(@ApiParam(value = "layout identifier by its uuid", required = true) @PathVariable String uuid,
                                       @ApiParam(value = "basic data to update layout", required = true) @RequestBody @Valid final LayoutCreateRequest layoutRequest) {

        Layout layoutDto = mapper.map(layoutRequest, Layout.class);

        layoutDto = layoutService.updateLayout(layoutDto, uuid);
        return mapper.map(layoutDto, LayoutResponse.class);
    }

}
