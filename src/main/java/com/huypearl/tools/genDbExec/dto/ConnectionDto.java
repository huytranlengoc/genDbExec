package com.huypearl.tools.genDbExec.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConnectionDto {
    private String url;
    private String username;
    private String password;
}
