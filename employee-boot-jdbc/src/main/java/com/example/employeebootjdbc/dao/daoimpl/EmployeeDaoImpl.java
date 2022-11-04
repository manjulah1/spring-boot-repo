package com.example.employeebootjdbc.dao.daoimpl;

import com.example.employeebootjdbc.dao.EmployeeDao;
import com.example.employeebootjdbc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
        System.out.println(dataSource);
    }

    @Override
    public void insertEmployee(Employee emp) {
        String sql = "INSERT INTO employee (empId, empName) VALUES (?,?)";
        getJdbcTemplate().update(sql, emp.getEmpId(), emp.getEmpName());
    }

    @Override
    public void insertEmployees(List<Employee> employees) {
        String sql = "INSERT INTO employee (empId, empName) VALUES (?, ?)";
        getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Employee employee = employees.get(i);
                ps.setString(1, employee.getEmpId());
                ps.setString(2, employee.getEmpName());
            }

            @Override
            public int getBatchSize() {
                return employees.size();
            }
        });
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Employee> result = new ArrayList<>();
        for(Map<String, Object> row: rows) {
            Employee emp = new Employee();
            emp.setEmpId((String) row.get("empId"));
            emp.setEmpName((String) row.get("empName"));
            result.add(emp);
        }
        return result;
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        String sql = "SELECT * FROM employee WHERE empId = ?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{employeeId}, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee emp = new Employee();
                emp.setEmpId(rs.getString("empId"));
                emp.setEmpName(rs.getString("empName"));
                return emp;
            }
        });
    }
}
