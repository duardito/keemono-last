package com.keemono.controller.pagecontent;

import com.keemono.common.Constants;
import com.keemono.common.converter.request.pagecontent.PageContentRequest;
import com.keemono.common.converter.response.pagecontent.PageContentResponse;
import com.keemono.common.mapper.BaseMapper;
import com.keemono.core.mysql.domain.pagecontent.PageContent;
import com.keemono.service.pagecontent.IPageContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by edu on 16/6/16.
 */
@PreAuthorize("@securityService.hasProtectedAccess()")
@Api(value = "/pageContent", description = "Operations to do about a page")
@RequestMapping(value = Constants._PAGE_CONTENT_URL)
@RestController
public class PageContentController extends BaseMapper {

    @Autowired
    private IPageContentService pageContentService;

    @ApiOperation(value = "create a page content", notes = "create a content inside a div", response = PageContentResponse.class)
    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, produces = Constants._APPLICATION_JSON, consumes = Constants._APPLICATION_JSON)
    public PageContentResponse createPageContent(@ApiParam(value = "basic data to create a page content", required = true)
                                                     @RequestBody @Valid final PageContentRequest pageContentRequest){

        PageContent pageContent= mapper.map(pageContentRequest, PageContent.class);
        pageContent = pageContentService.save(pageContent);
        return mapper.map(pageContent, PageContentResponse.class);

    }

}
