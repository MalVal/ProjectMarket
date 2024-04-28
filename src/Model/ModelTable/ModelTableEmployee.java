package Model.ModelTable;

import Model.Entity.Employee;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.ArrayList;

public class ModelTableEmployee extends AbstractTableModel
{
    private final ArrayList<Employee> employees;
    public ModelTableEmployee(ArrayList<Employee> employees)
    {
        this.employees = employees;
    }

    @Override
    public Class getColumnClass(int c)
    {
        return switch (c) {
            case 0, 1, 2 -> String.class;
            case 3 -> LocalDate.class;
            case 4 -> Double.class;
            default -> Object.class;
        };
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

        return switch (c) {
            case -1 -> employee;
            case 0 -> employee.getRegistrationNumber();
            case 1 -> employee.getName();
            case 2 -> employee.getFirstname();
            case 3 -> employee.getBirthdate();
            case 4 -> employee.getSalary();
            default -> null;
        };
    }
}
