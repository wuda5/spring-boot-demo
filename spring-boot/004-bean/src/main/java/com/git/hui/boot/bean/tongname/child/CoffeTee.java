package com.git.hui.boot.bean.tongname.child;

import com.git.hui.boot.bean.tongname.Tee;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class CoffeTee implements Tee {

//    private String name;


    @Override
    public String name() {
        return this.name();
    }
}
