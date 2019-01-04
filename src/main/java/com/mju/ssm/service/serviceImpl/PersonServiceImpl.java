package com.mju.ssm.service.serviceImpl;

import com.mju.ssm.entity.Person;
import com.mju.ssm.mapper.PersonMapper;
import com.mju.ssm.service.BaseService;
import com.mju.ssm.service.PersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service("personService")
@Transactional
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {

    @Resource
    @Override
    public void setMapper(Mapper<Person> mapper) {
        super.setMapper(mapper);
    }

    @Override
    public Person validatePersonInfo(Person person) {
        Example example = new Example(Person.class);
        example.createCriteria().andCondition("name=",person.getName()).andCondition("password=", DigestUtils.md5DigestAsHex(person.getName().getBytes()));
        List<Person> persons = this.findByExample(example);
        return persons!=null&&persons.size()>0?persons.get(0):null;
    }
}
