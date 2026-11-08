package com.example.productstore;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.app.Activity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<Product> products;
    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Prepare the product data.
        products = new ArrayList<>();
        products.add(new Product("Bitzwolf B-CC1 Camera", "1080P HD Webcam", "US$48.89", R.drawable.camera_product));
        products.add(new Product("Bitzwolf B-CC1 Camera", "1080P HD Webcam", "US$55.89", R.drawable.camera_product));
        products.add(new Product("Bitzwolf B-CC1 Camera", "1080P HD Webcam", "US$78.89", R.drawable.camera_product));
        products.add(new Product("Bitzwolf B-CC1 Camera", "1080P HD Webcam", "US$88.55", R.drawable.camera_product));
        products.add(new Product("Bitzwolf B-CC1 Camera", "1080P HD Webcam", "US$23.67", R.drawable.camera_product));
        products.add(new Product("Bitzwolf B-CC1 Camera", "1080P HD Webcam", "US$44.89", R.drawable.camera_product));
        products.add(new Product("Wireless HD Camera", "1080P HD Webcam", "US$39.99", R.drawable.camera_product));
        products.add(new Product("Mini Security Camera", "Indoor Camera", "US$29.50", R.drawable.camera_product));

        // 2. Find RecyclerView from the XML layout.
        RecyclerView recyclerView = findViewById(R.id.productsRecyclerView);

        // 3. Use a two-column grid, as shown in the reference design.
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // 4. Create the Adapter and connect it to RecyclerView.
        adapter = new ProductAdapter(products);
        recyclerView.setAdapter(adapter);

        // Simple search action.
        EditText searchEditText = findViewById(R.id.searchEditText);
        TextView searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(view -> {
            String query = searchEditText.getText().toString().trim();
            Toast.makeText(this,
                    query.isEmpty() ? "Enter a product name" : "Search: " + query,
                    Toast.LENGTH_SHORT).show();
        });

        TextView filterButton = findViewById(R.id.filterButton);
        filterButton.setOnClickListener(view ->
                Toast.makeText(this, "Filter option selected", Toast.LENGTH_SHORT).show());
    }
}
