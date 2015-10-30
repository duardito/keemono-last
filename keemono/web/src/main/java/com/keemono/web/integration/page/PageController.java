package com.keemono.web.integration.page;

import com.keemono.common.Constants;
import com.keemono.common.converter.dto.page.PageDto;
import com.keemono.common.converter.request.page.PageRequest;
import com.keemono.common.converter.response.page.PageResponse;
import com.keemono.service.page.IPageService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by edu on 25/04/2015.
 */
@Api(value = "/page", description = "Operations to do about a page")
@RequestMapping(value = Constants._PAGE_URL)
@RestController
public class PageController {

    @Autowired
    private IPageService pageService;

    @ApiOperation(value = "get  a page", notes = "get  a page", response = PageResponse.class)
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = Constants._ID, method = RequestMethod.GET, produces = Constants._APPLICATION_JSON)
    public PageResponse getPage(@ApiParam(
            value = "id of page", required = true) @PathVariable String id){

        final PageDto pageDto = pageService.getPageById(id);
        //return pageResponseConverter.createDto(pageDto);
        return null;
    }

    @ApiOperation(value = "create a page", notes = "create a page", response = PageResponse.class)
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping( method = RequestMethod.POST, produces = Constants._APPLICATION_JSON)
    public PageResponse createPage(@RequestBody PageRequest pageRequest ){

        //PageDto pageDto = pageRequestConverter.createFromDto(pageRequest);
        PageDto pageDto = null;
                pageDto = pageService.createPage(pageDto);


        //return  pageResponseConverter.createDto(pageDto);
        return null;

    }

}
