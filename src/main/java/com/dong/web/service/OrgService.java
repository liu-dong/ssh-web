package com.dong.web.service;

import com.dong.web.entity.Org;
import com.dong.web.model.PageVO;
import com.dong.web.model.Pagination;
import com.dong.web.model.dto.OrgDTO;
import com.dong.web.model.vo.OrgVO;
import com.dong.web.model.vo.PersonVO;

import java.util.List;

public interface OrgService {

    /**
     * 查询组织机构列表
     *
     * @param dto
     * @param pagination
     * @return
     */
    PageVO<OrgVO> findOrgList(OrgDTO dto, Pagination pagination);

    /**
     * 保存组织机构
     *
     * @param dto
     * @return
     */
    Org saveOrg(OrgDTO dto);

    /**
     * 查询组织机构详情
     *
     * @param id
     * @return
     */
    OrgVO getOrg(String id) throws Exception;

    /**
     * 删除组织机构
     *
     * @param id
     * @return
     */
    void deleteOrg(String id) throws Exception;

    Integer addPerson(String orgId, List<String> personIds) throws Exception;

    Integer deletePerson(String orgId, List<String> personIds) throws Exception;

    List<PersonVO> findOrgPersonList(String orgId);
}
