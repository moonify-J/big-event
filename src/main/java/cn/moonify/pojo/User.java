package cn.moonify.pojo;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDateTime;
@Data
public class User {
    private Integer id;//主键ID
    private String username;//用户名
    @JsonIgnore // 在序列化时忽略该字段
    private String password;//密码
    private String nickname;//昵称
    private String email;//邮箱
    private String userPic;//用户头像地址
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
