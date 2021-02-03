package com.git.hui.boot.bean.tongname.child;

import com.git.hui.boot.bean.tongname.Tee;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class TestDiTee {

//    @Autowired
//    private Tee name; // 这样报错：1.@Autowired是先byType技术查询，此时查到有两个同类型的 bean,就会走2，
//    2.再通过byname查询 name就是这个属性名，此时一看都没这个名对应的bean 就报错了

    @Autowired
    private Tee coffeTee; // 这里不报错就因为，我写对了有个bean的名字是 coffeTee;


 public TestDiTee(){
     System.out.println("testTeedi");
 }
}
