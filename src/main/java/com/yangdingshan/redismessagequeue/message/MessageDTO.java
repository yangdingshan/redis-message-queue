package com.yangdingshan.redismessagequeue.message;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yangdingshan
 * @Date: 2019/12/14 10:48
 * @Description: 消息体
 */
@Data
@Builder
public class MessageDTO implements Serializable {

    /**
     * 消息内容
     */
    private String messageContent;
}
