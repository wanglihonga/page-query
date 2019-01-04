package com.mju.ssm.service;

import com.mju.ssm.entity.Person;

public interface PersonService extends BaseService<Person>{
    public Person validatePersonInfo(Person person);
}
