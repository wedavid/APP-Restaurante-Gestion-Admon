package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.init) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.reser) {
            Intent intent = new Intent(this, Reserva.class);
            startActivity(intent);
        } else if (id == R.id.consul) {
            Intent intent = new Intent(this, Consulta.class);
            startActivity(intent);
        } else if (id == R.id.admin) {

            int adminId = getIntent().getIntExtra("adminId", -1);


            if (adminId == -1) {
                String defaultAdminUser = "superadmin";
                String defaultAdminPass = "2023";

                String user = getIntent().getStringExtra("user");
                String pass = getIntent().getStringExtra("pass");

                if (user != null && pass != null && user.equals(defaultAdminUser) && pass.equals(defaultAdminPass)) {
                    adminId = 0;
                }
            }

            if (adminId != -1) {
                Intent intent = new Intent(this, Admin.class);
                intent.putExtra("adminId", adminId);
                startActivity(intent);
            } else {
                Toast.makeText(this, "No tienes permisos de administrador", Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.close) {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
