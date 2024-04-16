package Model.ModelTable;

import Model.Entity.Client;
import Model.Entity.Employee;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.ArrayList;

public class ModelTableEmployee extends AbstractTableModel
{
    private ArrayList<Employee> employees;
    public ModelTableEmployee(ArrayList<Employee> employees)
    {
        this.employees = employees;
    }

    @Override
    public Class getColumnClass(int c)
    {
        if (c == 0) return String.class;
        if (c == 1) return String.class;
        if (c == 2) return String.class;
        if (c == 3) return LocalDate.class;
        if (c == 4) return Double.class;
        return null;
    }

    @Override
    public int getRowCount()
    {
        return employees.size();
    }

    @Override
    public int getColumnCount()
    {
        return 5;
    }

    @Override
    public Object getValueAt(int l,int c)
    {
        Employee employee = employees.get(l);
        if (c == -1) return employee;
        if (c == 0) return employee.getRegistrationNumber();
        if (c == 1) return employee.getName();
        if (c == 2) return employee.getFirstname();
        if (c == 3) return employee.getBirthdate();
        if (c == 4) return employee.getSalary();
        return null;
    }
}
