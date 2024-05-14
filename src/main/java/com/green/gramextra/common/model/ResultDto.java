package com.green.gramextra.common.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class ResultDto<T> {
    private HttpStatus httpStatus;
    private String resultMsg;
    private T resultData;
}
