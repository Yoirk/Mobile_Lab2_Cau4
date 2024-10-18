package com.example.lab2bai4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Employee> employees;
    private EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần giao diện
        EditText editTextId = findViewById(R.id.editTextId);
        EditText editTextFullName = findViewById(R.id.editTextFullName);
        CheckBox checkBoxIsManager = findViewById(R.id.checkBoxIsManager);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        ListView item_employee_ll_parent= findViewById(R.id.item_employee_ll_parent);

        // Tạo danh sách nhân viên
        employees = new ArrayList<>();
        adapter = new EmployeeAdapter(this, R.layout.item_employee, employees);
        item_employee_ll_parent.setAdapter(adapter);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy thông tin nhập vào
                String id = editTextId.getText().toString();
                String fullName = editTextFullName.getText().toString();
                boolean isManager = checkBoxIsManager.isChecked();

                // Tạo đối tượng Employee mới và thêm vào danh sách
                Employee employee = new Employee(id, fullName, isManager);
                employees.add(employee);

                // Cập nhật ListView
                adapter.notifyDataSetChanged();

                // Xóa nội dung các ô nhập sau khi thêm
                editTextId.setText("");
                editTextFullName.setText("");
                checkBoxIsManager.setChecked(false);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}