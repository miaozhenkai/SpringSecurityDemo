package com.mzk.springsecuritydemo.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author miaozhenkai
 * @version 2021-07-12  18:14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TUserRole implements Serializable {
    private Long userId;

    private Long roleId;

    private static final long serialVersionUID = 1L;
}