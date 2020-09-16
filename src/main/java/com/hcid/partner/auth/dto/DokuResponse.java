package com.hcid.partner.auth.dto;

import lombok.Data;

/**
 * Created by yusep.maulana07 on 21/03/2019.
 */
@Data
public class DokuResponse {

    private String status;

    private String message;

    private Object data;
}
