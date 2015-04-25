package com.keemono.integration.page;

import com.keemono.common.request.converter.page.PageResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by edu on 25/04/2015.
 */
@RequestMapping(value = "/page")
@Controller
public class PageController {

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public PageResponse getPage(@PathVariable String id){

        PageResponse pageResponse = null;
        return pageResponse;
    }

}
