 package com.keemono.common.converter.response.pagecontent;

import com.keemono.core.mysql.domain.pagecontent.PageContent;

import java.util.List;

 /**
 * Created by edu on 16/6/16.
 */
public class ExtendedPageContentResponse {


    private List<PageContent> response;

     public List<PageContent> getResponse() {
         return response;
     }

     public void setResponse(List<PageContent> response) {
         this.response = response;
     }
 }
