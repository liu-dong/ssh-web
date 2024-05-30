package com.dong.web.service.impl;


import com.dong.util.CommonUtils;
import com.dong.web.dao.CommonDao;
import com.dong.web.dao.PersonDao;
import com.dong.web.entity.Person;
import com.dong.web.model.PageVO;
import com.dong.web.model.Pagination;
import com.dong.web.model.dto.PersonDTO;
import com.dong.web.model.vo.PersonVO;
import com.dong.web.service.PersonService;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PersonServiceImpl implements PersonService {


    PersonDao personDao;

    CommonDao commonDao;

    /**
     * 查询人员信息列表
     *
     * @param dto
     * @param pagination
     * @return
     */
    @Override
    public PageVO<PersonVO> findPersonList(PersonDTO dto, Pagination pagination) {
        StringBuilder sql = new StringBuilder();
        List<Object> param = new ArrayList<>();
        sql.append(" SELECT t1.id,t1.org_id orgId,t1.`name`,t1.age, ");
        sql.append(" t1.sex,t1.phone,t1.email,t1.present_address presentAddress, ");
        sql.append(" t1.native_place nativePlace,t1.update_time updateTime ");
        sql.append(" FROM `sys_person` t1 ");
        sql.append(" LEFT JOIN sys_org_person t2 ON t2.person_id=t1.id ");
        sql.append(" LEFT JOIN sys_org t3 ON t3.id=t2.org_id ");
        sql.append(" WHERE t1.delete_status = 0 ");
        if (StringUtils.isNotBlank(dto.getName())) {
            sql.append(" AND t1.`name` LIKE ? ");
            param.add("%" + dto.getName().trim() + "%");
        }
        if (StringUtils.isNotBlank(dto.getIdentityCard())) {
            sql.append(" AND t1.identity_card LIKE ? ");
            param.add("%" + dto.getIdentityCard().trim() + "%");
        }
        if (StringUtils.isNotBlank(dto.getOrgName())) {
            sql.append(" AND t3.org_name LIKE ? ");
            param.add("%" + dto.getOrgName().trim() + "%");
        }
        if (StringUtils.isNotBlank(dto.getOrgId())) {
            sql.append(" AND t3.id = ? ");
            param.add(dto.getOrgId());
        }
        sql.append(" ORDER BY t1.update_time DESC ");
        return commonDao.findListBySql(pagination, sql, param, PersonVO.class);
    }

    /**
     * 保存人员信息
     *
     * @param dto
     * @return
     */
    @Override
    public Person savePerson(PersonDTO dto) {
        Person entity = new Person();
        if (StringUtils.isEmpty(dto.getId())) {//新增
            entity.setId(CommonUtils.getUUID());
            entity.setCreateTime(new Date());
        } else {
            entity = personDao.getById(dto.getId());
        }
        entity.setName(dto.getName());
        entity.setIdentityCard(dto.getIdentityCard());
        entity.setAge(dto.getAge());
        entity.setBirthdate(dto.getBirthdate());
        entity.setSex(Short.valueOf(dto.getSex()));
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setPresentAddress(dto.getPresentAddress());
        entity.setNativePlace(dto.getNativePlace());
        entity.setIndividualResume(dto.getIndividualResume());
        entity.setUpdateTime(new Date());
        return personDao.save(entity);
    }

    /**
     * 查询人员信息详细页面
     *
     * @param id
     * @return
     */
    @Override
    public Person getPerson(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new RuntimeException("查询失败，id不能为空!");
        }
        return personDao.getById(id);
    }

    /**
     * 删除人员信息
     *
     * @param id
     */
    @Override
    public void deletePerson(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new RuntimeException("删除失败，id不能为空!");
        }
        personDao.deleteById(id);
    }

    @Override
    public Person chooseOrg(PersonDTO dto) {
        if (StringUtils.isEmpty(dto.getId())) {
            throw new RuntimeException("操作失败，人员id不能为空!");
        }
        Person entity = personDao.getById(dto.getId());
        entity.setOrgId(dto.getOrgId());
        entity.setUpdateTime(new Date());
        return personDao.save(entity);
    }
}
