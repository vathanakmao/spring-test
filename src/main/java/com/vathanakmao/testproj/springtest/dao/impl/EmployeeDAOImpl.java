package com.vathanakmao.testproj.springtest.dao.impl;

import com.vathanakmao.testproj.springtest.dao.EmployeeDAO;

/**
 * @author Vathanak Mao
 * @since 2012-01-04
 */
public class EmployeeDAOImpl implements EmployeeDAO {
    
    public EmployeeDAOImpl(int a) {
        System.out.println("------------ constructor");
    }
    
    public static void print() {
        System.out.println("----------------------- print");
    }
}
