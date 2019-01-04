import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mju.ssm.entity.Person;
import com.mju.ssm.mapper.PersonMapper;
import com.mju.ssm.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class PersonMapperTest {

    @Resource
    private PersonMapper personMapper;

    @Resource
    private PersonService personService;

    @Test
    public void testFindAll(){
        System.out.println(personMapper.selectAll().size());
    }

    @Test
    public void save(){
        Person person = new Person();
        person.setName("admin");
        person.setAge(20);
        person.setPassword(DigestUtils.md5DigestAsHex("admin".getBytes()));

        this.personMapper.insert(person);


    }

    @Test
    public void validatePersonInfo(){
        Person person = new Person();
        person.setName("admin");
        person.setPassword("admin");
        person = this.personService.validatePersonInfo(person);
        System.out.println(person);

    }

    @Test
    public void pageHelper(){

        Person person = new Person();
        PageInfo<Person> pageInfo = this.personService.findWithPageInfo(1,2);
        System.out.println(pageInfo);
    }




}
