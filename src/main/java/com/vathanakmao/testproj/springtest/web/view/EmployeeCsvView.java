package com.vathanakmao.testproj.springtest.web.view;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.vathanakmao.testproj.springtest.model.Employee;

public class EmployeeCsvView extends AbstractView {
    private final List<String> classesToBound = new ArrayList<String>();

    public EmployeeCsvView() {
        super.setContentType("text/csv");

    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> modelMap, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String fileName = (String) modelMap.get("fileName"); // file name without extension
        if (fileName == null || fileName.isEmpty()) {
            fileName = "file.csv";
        }

        BufferedWriter writer = new BufferedWriter(response.getWriter());
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        List<Employee> employees = (List<Employee>) modelMap.get("employees");
        writer.write(buildContent(employees));
        writer.flush();
        writer.close();
    }

    public String buildContent(List<Employee> employees) {
        StringBuilder result = new StringBuilder();

        if (employees != null) {
            for(Employee emp : employees) {
                result.append(emp.getId());
                result.append("\t");
                result.append(emp.getName());
                result.append("\n");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        new EmployeeCsvView().renderMergedOutputModel(null, null, null);
    }

    public List<String> getClassesToBound() {
        return classesToBound;
    }

    // public abstract String buildContent(Object content);

}
