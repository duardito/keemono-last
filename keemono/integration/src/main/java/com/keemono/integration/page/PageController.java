package com.keemono.integration.page;

import com.keemono.common.request.converter.page.PageResponse;
import com.keemono.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by edu on 25/04/2015.
 */
@RequestMapping(value = Constants._PAGE_URL)
@Controller
public class PageController {

    @ResponseBody
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public PageResponse getPage(@PathVariable String id){

        PageResponse pageResponse = new PageResponse();
        return pageResponse;
    }

}
