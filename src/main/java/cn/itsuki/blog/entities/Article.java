package cn.itsuki.blog.entities;

import cn.itsuki.blog.constants.PublishState;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author: itsuki
 * @create: 2021-09-14 20:42
 **/
@Entity(name = "Article")
@Getter
@Setter
@ToString(callSuper = true)
public class Article extends IdentifiableEntity {
    /**
     * 标题
     */
    @NotBlank
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * 内容
     */
    private String content;

    /**
     * 封面
     */
    private String cover;

    /**
     * 评论数
     */
    @Min(0)
    private int commenting;

    /**
     * 作者
     */
    private String author;

    /**
     * 喜欢数
     */
    @Min(0)
    private int liking;

    /**
     * 观看数
     */
    @Min(0)
    private int reading;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 文章密码
     */
    private String password;

    /**
     * 发布状态: 0 -> 草稿, 1 -> 已发布, 2 -> 回收站
     */
    private Integer publish;

    /**
     * 文章来源: 0 -> 原创, 1 -> 转载, 2 -> 混合
     */
    private Integer origin;

    /**
     * 公开类型: 0 -> 需要密码, 1 -> 公开, 2 -> 私密
     */
    private Integer open;

    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    /**
     * 更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
}
