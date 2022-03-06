package java.com.fc.dao;

import java.com.fc.entity.Student;
import java.util.List;

public interface StudentDao {
    int getTotalCount();

    List<Student> getList(int pageNo, int pageSize);
}
