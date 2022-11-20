package com.houli.pms.sync.task.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 评价人员表
 * </p>
 *
 * @author hansy
 * @since 2022-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="PmdEmployees对象", description="评价人员表")
public class PmdEmployees implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "人员ID")
    private Long employeesId;

    @ApiModelProperty(value = "人员编码")
    private String employeesCode;

    @ApiModelProperty(value = "人员姓名")
    private String employeesName;

    @ApiModelProperty(value = "出生日期")
    private LocalDate employeesBirthday;

    @ApiModelProperty(value = "技术职称")
    private String employeesAcademic;

    @ApiModelProperty(value = "学历")
    private String employeesEducation;

    @ApiModelProperty(value = "调转类别")
    private String employeesTurnedCategory;

    @ApiModelProperty(value = "在岗情况")
    private String employeesSituation;

    @ApiModelProperty(value = "岗位名称")
    private String employeesJobsName;

    @ApiModelProperty(value = "岗位类别")
    private String employeesJobsType;

    @ApiModelProperty(value = "岗位性质")
    private String employeesJobsNature;

    @ApiModelProperty(value = "科室属性")
    private String employeesDepartmentProperty;

    @ApiModelProperty(value = "所在科室")
    private String employeesDepartment;

    @ApiModelProperty(value = "职务")
    private String employeesPosition;

    @ApiModelProperty(value = "级别")
    private String employeesLevel;

    @ApiModelProperty(value = "个人积分系数")
    private Float employeesJobsCoefficient;

    @ApiModelProperty(value = "职称系数")
    private Float technologyCoefficient;

    @ApiModelProperty(value = "状态 0:正常 1:停用	            ")
    private Integer employeesState;

    @ApiModelProperty(value = "是否是门诊：1、是，2、不是")
    private Integer isClinic;

    @ApiModelProperty(value = "员工属性")
    private String employeesNature;

    @ApiModelProperty(value = "职称")
    private String zc;
    @ApiModelProperty(value = "院龄")
    private Double workingYears;

    @ApiModelProperty(value = "创建人")
    private Long createBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDate createDate;

    @ApiModelProperty(value = "最后修改人")
    private Long updateBy;

    @ApiModelProperty(value = "最后修改时间")
    private LocalDate updateDate;
    @ApiModelProperty(value = "删除（未删除：0；已删除：1）")
    private Integer isDelete;











}
