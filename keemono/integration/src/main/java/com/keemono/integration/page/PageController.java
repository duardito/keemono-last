package com.keemono.integration.page;

import com.keemono.common.converter.dto.page.PageDto;
import com.keemono.common.converter.request.page.PageRequest;
import com.keemono.common.converter.request.page.PageRequestConverter;
import com.keemono.common.converter.response.page.PageResponse;
import com.keemono.common.converter.response.page.PageResponseConverter;
import com.keemono.service.page.IPageService;
import com.keemono.utils.Constants;
import com.wordnik.swagger.annotations.Api;
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

    @Autowired
    private PageResponseConverter pageResponseConverter;

    @Autowired
    private PageRequestConverter pageRequestConverter;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = Constants._ID, method = RequestMethod.GET, produces = Constants._APPLICATION_JSON)
    public PageResponse getPage(@PathVariable String id){

        final PageDto pageDto = pageService.getPageById(id);
        return pageResponseConverter.createDto(pageDto);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping( method = RequestMethod.POST, produces = Constants._APPLICATION_JSON)
    public PageResponse createPage(@RequestBody PageRequest pageRequest ){

        PageDto pageDto = pageRequestConverter.createFromDto(pageRequest);
        pageDto = pageService.createPage(pageDto);
        return  pageResponseConverter.createDto(pageDto);
    }

}
