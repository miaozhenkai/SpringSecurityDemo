package com.mzk.springsecuritydemo.pojo.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author miaozhenkai
 * @version 2021-07-12  18:14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TRole implements Serializable {
    private Long id;

    private String roleValue;

    private String roleName;

    private static final long serialVersionUID = 1L;
}