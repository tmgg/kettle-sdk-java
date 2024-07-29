package io.github.tmgg.kettle.sdk.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;



@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class WebResult {

    String result; // ERROR
    String message;
    String id;



}
