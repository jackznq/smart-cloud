package com.peng.main.api.mapper.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "base_role_module")
public class BaseRoleModule implements Serializable {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "ROLE_ID")
    private Long roleId;

    @Column(name = "MODULE_ID")
    private Long moduleId;

    /**
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return ROLE_ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * @return MODULE_ID
     */
    public Long getModuleId() {
        return moduleId;
    }

    /**
     * @param moduleId
     */
    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }
}