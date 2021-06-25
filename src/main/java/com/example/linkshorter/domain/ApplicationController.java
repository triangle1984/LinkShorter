package com.example.linkshorter.domain;

import com.example.linkshorter.domain.UrlService;
import com.example.linkshorter.infrastructure.entity.ShortUrlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Andrey Markov
 * @version 1.0 23.06.2021
 */
@Controller
public class ApplicationController {
    @Autowired
    UrlService urlService;

    @GetMapping("/{prefix}")
    public String redirect(@PathVariable("prefix") String prefix, HttpServletRequest request) {
        ShortUrlEntity url = urlService.findUrlByPrefix(prefix)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prefix not found"));
        if (url.getUrlToShort().startsWith("http")) {
            return String.format("redirect:%s", url.getUrlToShort());
        }else{
            return String.format("redirect:%s://%s", request.getScheme(), url.getUrlToShort());
        }
    }
}
