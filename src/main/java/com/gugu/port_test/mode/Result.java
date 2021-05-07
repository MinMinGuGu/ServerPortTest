package com.gugu.port_test.mode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author minmin
 * @since 2021/05/07 23:12
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;
    private String message;
}
