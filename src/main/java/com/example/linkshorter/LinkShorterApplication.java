package com.example.linkshorter;

import com.example.linkshorter.infrastructure.entity.ShortUrlEntity;
import com.example.linkshorter.rest.dto.RequestDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.print.attribute.standard.Destination;

@SpringBootApplication
public class LinkShorterApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinkShorterApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper =  new ModelMapper();
        TypeMap<RequestDto, ShortUrlEntity> typeMap = modelMapper.createTypeMap(RequestDto.class, ShortUrlEntity.class);
        modelMapper.typeMap(RequestDto.class, ShortUrlEntity.class).addMappings(mapper -> mapper.map(RequestDto::getUrl,ShortUrlEntity::setUrlToShort));
        return modelMapper;
    }
}
