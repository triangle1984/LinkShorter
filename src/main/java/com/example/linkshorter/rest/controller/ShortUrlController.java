package com.example.linkshorter.rest.controller;

import com.example.linkshorter.domain.UrlService;
import com.example.linkshorter.infrastructure.entity.ShortUrlEntity;
import com.example.linkshorter.rest.dto.RequestDto;
import com.example.linkshorter.rest.dto.ResponseDto;
import jdk.jfr.ContentType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrey Markov
 * @version 1.0 23.06.2021
 */

@RestController
@RequestMapping("api")
public class ShortUrlController {
    @Autowired
    UrlService urlService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping(value = "/shortUrl", produces = {"application/json"}, consumes = {"application/json"})
    ResponseDto createShortUrl(@RequestBody RequestDto requestDTO) {
        return modelMapper.map(urlService.createShortUrl(modelMapper.map(requestDTO, ShortUrlEntity.class)), ResponseDto.class);
    }
}
