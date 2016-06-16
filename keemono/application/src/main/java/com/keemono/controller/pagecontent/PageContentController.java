package com.keemono.controller.pagecontent;

import com.keemono.common.Constants;
import com.keemono.common.mapper.BaseMapper;
import com.keemono.service.pagecontent.IPageContentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
