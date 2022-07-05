package com.example.springlbd.service.employee;

import com.example.springlbd.enity.employee.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Profile("dev")
public class EmployeeServiceOne implements EmployeeService {


    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceOne.class);
    @Value("${prefix}")
    String prefix;
    @Value("${sufix}")
    String sufix;

    Map<Long, Employee> projectMap= new HashMap<>();

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public String GetEmployeeNickname(String firstName, String lastName) {
        LOG.info("firstNmae: "+firstName);
        LOG.info("lastName: "+lastName);
        String nickname=null;
        nickname = prefix+firstName.substring(0,(firstName.length()<3 ? firstName.length() : 3))+sufix+ lastName.substring(0,(lastName.length()<3 ? lastName.length() : 3));
        LOG.info("nickname: "+nickname);
        return nickname;
    }

    @Override
    public Employee findByName(String firstNameOrLastName) {

        Optional<Employee> employee= projectMap
                .entrySet()
                .stream()
                .filter
                        (
                                emp -> (
                                        emp.getValue().getImię()==firstNameOrLastName ||
                                        emp.getValue().getNazwisko()==firstNameOrLastName
                                )
                        )
                .map(Map.Entry::getValue)
                .findFirst();

        if(employee.isPresent())
            return employee.get();
        else
            return null;
    }

    @Override
    public Employee save(Employee employee) {
        Optional<Long> idOpt=projectMap.keySet().stream().max(Long::compareTo);
        Long id=1L;
        if(idOpt.isPresent())
            id=idOpt.get()+1L;
        employee.setId(id);
        projectMap.put(id,employee);
        return projectMap.get(id);
    }
}
