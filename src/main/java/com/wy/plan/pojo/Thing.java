package com.wy.plan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @author WangYao
 * @date 2021/2/28
 * @function
 */
@Data
@NoArgsConstructor
@Component
public class Thing implements Serializable {
    private String uid;
    private String content;
    private Date time;
    private Integer level;
    private Boolean complete;

    public Thing(String content, Date time, Integer level, Boolean complete) {
        this.uid = content+time.toString();
        this.content = content;
        this.time = time;
        this.level = level;
        this.complete = complete;
    }

    @Override
    public Thing clone() {
        return new Thing(content,time,level,complete);
    }
}
