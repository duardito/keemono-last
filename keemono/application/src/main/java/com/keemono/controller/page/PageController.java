package com.keemono.controller.page;

import com.keemono.common.Constants;
import com.keemono.common.converter.request.page.PageRequest;
import com.keemono.common.converter.response.page.ListPageResponse;
import com.keemono.common.converter.response.page.PageResponse;
import com.keemono.common.converter.response.pagecontent.PageContentResponse;
import com.keemono.common.mapper.BaseMapper;
import com.keemono.common.ordination.OrdinationRequest;
import com.keemono.common.pagination.PaginationRequest;
import com.keemono.core.mysql.domain.page.Page;
import com.keemono.service.page.IPageService;
import com.keemono.service.pagecontent.IPageContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by edu on 25/04/2015.
 */
@PreAuthorize("@securityService.hasProtectedAccess()")
@Api(value = "/page", description = "Operations to do about a page")
@RequestMapping(value = Constants._PAGE_URL)
@RestController
public class PageController extends BaseMapper {

    @Autowired
    private IPageService pageService;

    @Autowired
    private IPageContentService pageContentService;

    @ApiOperation(value = "get  a page", notes = "get  a page", response = PageResponse.class)
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = Constants._UUID, method = RequestMethod.GET, produces = Constants._APPLICATION_JSON)
    public PageContentResponse getPage(@ApiParam(value = "id of page", required = true) @PathVariable String uuid){

       // final Page pageDto = pageService.getPageByUUId(uuid);
        PageContentResponse pageContent = pageContentService.getContentByPage(uuid);

        return pageContent;
    }

    @ApiOperation(value = "create a page", notes = "create a page", response = PageResponse.class)
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping( method = RequestMethod.POST, produces = Constants._APPLICATION_JSON)
    public PageResponse createPage(@ApiParam(value = "basic data to create a page", required = true)
                                       @RequestBody @Valid PageRequest pageRequest ){

        Page page = mapper.map(pageRequest, Page.class);
        page = pageService.createPage(page);

        return mapper.map(page, PageResponse.class);

    }

    @ApiOperation(value = "edit a page", notes = "edit a page", response = PageResponse.class)
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = Constants._UUID, method = RequestMethod.PUT, produces = Constants._APPLICATION_JSON)
    public PageResponse updatePage(
            @ApiParam(value = "basic data to create a page", required = true)@RequestBody @Valid PageRequest pageRequest,
            @ApiParam(value = "uuid of page", required = true) @PathVariable String uuid){

        Page page = mapper.map(pageRequest, Page.class);
        page = pageService.updatePage(page,uuid);

        return mapper.map(page, PageResponse.class);
    }
    
    @ApiOperation(value = "get all pages", notes = "get all pages list", response = ListPageResponse.class)
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = Constants._LIST,method = RequestMethod.GET, produces = Constants._APPLICATION_JSON)
    public ListPageResponse getPages(@ModelAttribute @Valid final PaginationRequest paginationRequest,@Valid final OrdinationRequest ordinationRequest){
    	List<Page> pages = pageService.getAllPages();
    	
    	final ListPageResponse lista = new ListPageResponse();
        List<PageResponse> out = mapper.mapAsList(pages, PageResponse.class);
        lista.addAll(out);
    	return lista;
    }

}
