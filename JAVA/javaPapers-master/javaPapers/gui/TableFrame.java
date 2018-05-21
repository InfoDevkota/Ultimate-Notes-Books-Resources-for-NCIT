import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.*;

class TableFrame
{
  public static void main(String args[])
  {
    JFrame frame=new JFrame();
    frame.setLayout(new FlowLayout());
    
    Staff s1=new Staff();
    s1.setName("Ram");
    s1.setSurname("Thapa");
    s1.setDate("2033");
    s1.setPosition("Manager");
    s1.setSalary(40000);
    
    java.util.ArrayList<Staff> slist=new java.util.ArrayList<Staff>();
    slist.add(s1);
    
    TableModel model=new MyTableModel(slist);
    JTable table=new JTable(model);
    frame.add(table);
    frame.setVisible(true);
    frame.setSize(400,400);
  }
}

class MyTableModel extends AbstractTableModel {

    private java.util.ArrayList<Staff> staffs;

    public MyTableModel(java.util.ArrayList<Staff> staffs){
        this.staffs = staffs;
    }

   // @Override
    public int getRowCount() {
        return staffs.size();
    }

    //@Override
    public int getColumnCount() {
        return 5;
    }

    public void add(Staff staff) {
        int size = staffs.size();
        staffs.add(staff);
        fireTableRowsInserted(size, size);
    }

    public void remove(Staff staff) {
        if (staffs.contains(staff)) {
            int index = stafff.indexOf(staff);
            staffs.remove(staff);
            fireTableRowsRemove(index, index);
        }
    }

    //@Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Staff staff = staffs.get(rowIndex);
        switch (columnIndex){
            case 0:
                return staff.getName();
            case 1:
                return staff.getSurname();
            case 2:
                return staff.getDate();
            case 3:
                return staff.getPosition();
            case 4:
                return staff.getSalary();
        }
        return "";
    }
}


class Staff
{
  private String name,surname;
  private String date,position;
  private double salary;
  
  public void setName(String name)
  {
    this.name=name;
  }
  public void setSurname(String surname)
  {
    this.surname=surname;
  }
  public void setDate(String date)
  {
    this.date=date;
  }
  public void setPosition(String position)
  {
    this.position=position;
  }
  public void setSalary(double salary)
  {
    this.salary=salary;
  }
  
  public String getName()
  {
    return this.name;
  }
   public String getSurname()
  {
    return this.surname;
  }
    public String getDate()
  {
    return this.date;
  }
     public String getPosition()
  {
    return this.position;
  }
 public double getSalary()
  {
    return this.salary;
  } 
}