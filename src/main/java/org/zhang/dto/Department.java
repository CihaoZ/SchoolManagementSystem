package org.zhang.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Department of school
 *
 * @author Cihao Zhang
 */
@Getter
@Setter
public class Department {
    private static int nextId = 1;

    private String id;
    private String departmentName;

    /**
     * Constructor for Department, with an incremented ID
     *
     * @param departmentName name of the department
     */
    public Department(String departmentName) {
        this.id = String.format("D%03d", nextId++);
        this.departmentName = departmentName;
    }

    /**
     * Returns a String that formats the Department
     *
     * @return a String that formats the Department
     */
    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
