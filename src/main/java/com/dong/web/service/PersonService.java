package com.dong.web.service;

import com.dong.web.entity.Person;
import com.dong.web.model.PageVO;
import com.dong.web.model.Pagination;
import com.dong.web.model.dto.PersonDTO;
import com.dong.web.model.vo.PersonVO;

public interface PersonService {

    /**
     * 查询人员信息列表
     *
     * @param dto
     * @param pagination
     * @return
     */
    PageVO<PersonVO> findPersonList(PersonDTO dto, Pagination pagination);

    /**
     * 保存人员信息
     *
     * @param dto
     * @return
     */
    Person savePerson(PersonDTO dto);

    /**
     * 查询人员信息详细页面
     *
     * @param id
     * @return
     */
    Person getPerson(String id);

    /**
     * 删除人员信息
     *
     * @param id
     */
    void deletePerson(String id);

    /**
     * 选择单位
     *
     * @param dto
     * @return
     */
    Person chooseOrg(PersonDTO dto);
}
