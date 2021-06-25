package com.example.linkshorter.rest.dto;

import lombok.Data;

import javax.persistence.Column;

/**
 * @author Andrey Markov
 * @version 1.0 23.06.2021
 */
@Data
public class ResponseDto {
    private String urlToShort;
    private String prefix;
}
