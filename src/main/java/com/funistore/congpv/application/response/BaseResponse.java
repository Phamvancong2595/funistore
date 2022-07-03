package com.funistore.congpv.application.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class BaseResponse {
    protected String msg;
    protected boolean status;
}
