package com.keemono.integration.page;

import com.keemono.common.converter.dto.page.PageDto;
import com.keemono.common.converter.response.page.PageResponse;
import com.keemono.common.converter.response.page.PageResponseConverter;
import com.keemono.service.page.IPageService;
import com.keemono.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by edu on 25/04/2015.
 */
@RequestMapping(value = Constants._PAGE_URL)
@Controller
public class PageController {

    @Autowired
    private IPageService pageService;

    @Autowired
    private PageResponseConverter pageResponseConverter;

    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = Constants._ID, method = RequestMethod.GET, produces = Constants._APPLICATION_JSON)
    public PageResponse getPage(@PathVariable String id){

        final PageDto pageDto = pageService.getPageById(id);
        final PageResponse pageResponse = pageResponseConverter.createDto(pageDto);
        return pageResponse;
    }

}
