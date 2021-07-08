package com.example.linkshorter.rest;

import com.example.linkshorter.infrastructure.entity.ShortUrlEntity;
import com.example.linkshorter.rest.dto.RequestDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Andrey Markov
 * @version 1.0 08.07.2021
 */
@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper =  new ModelMapper();
        modelMapper.createTypeMap(RequestDto.class, ShortUrlEntity.class);
        modelMapper.typeMap(RequestDto.class, ShortUrlEntity.class).addMappings(mapper -> mapper.map(RequestDto::getUrl,ShortUrlEntity::setUrlToShort));
        return modelMapper;
    }
}
