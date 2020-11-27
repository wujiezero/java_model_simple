package com.lylbp.manger.elasticsearch.demo.entity;

import com.lylbp.manger.hbase.annotion.HColumn;
import com.lylbp.manger.hbase.annotion.HRowKey;
import com.lylbp.manger.hbase.annotion.HTable;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @Author weiwenbin
 * @Date: 2020/11/13 上午9:30
 */
@Data
@Document(indexName = "test_user")
@HTable(tableName = "test_user")
public class ESTestUser {
    @HRowKey
    @Field(type = FieldType.Keyword)
    @Id
    @ApiModelProperty(value = "rowKey")
    private String rowKey;

    @HColumn(family = "info", qualifier = "phone")
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "手机号")
    private String phone;

    @HColumn(family = "info", qualifier = "name")
    @Field(type = FieldType.Keyword)
    @ApiModelProperty(value = "名称")
    private String name;

    @HColumn(family = "info", qualifier = "email")
    @ApiModelProperty(value = "email")
    @Transient
    private String email;

    @HColumn(family = "info", qualifier = "createTime")
    @Field(type = FieldType.Keyword, format = DateFormat.basic_date_time)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
