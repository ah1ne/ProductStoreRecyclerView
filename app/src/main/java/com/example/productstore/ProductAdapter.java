package com.example.productstore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private final List<Product> products;

    public ProductAdapter(List<Product> products) {
        this.products = products;
    }

    // Holds the views belonging to one product item.
    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName;
        TextView productCategory;
        TextView productPrice;
        ImageButton addToCartButton;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            productName = itemView.findViewById(R.id.productName);
            productCategory = itemView.findViewById(R.id.productCategory);
            productPrice = itemView.findViewById(R.id.productPrice);
            addToCartButton = itemView.findViewById(R.id.addToCartButton);
        }
    }

    // Creates a new product item view when needed.
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(row);
    }

    // Connects product data to the views inside the ViewHolder.
    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);

        holder.productName.setText(product.getName());
        holder.productCategory.setText(product.getCategory());
        holder.productPrice.setText(product.getPrice());
        holder.productImage.setImageResource(product.getImageResource());

        holder.addToCartButton.setOnClickListener(view ->
                Toast.makeText(view.getContext(),
                        product.getName() + " added to cart",
                        Toast.LENGTH_SHORT).show());

        holder.itemView.setOnClickListener(view ->
                Toast.makeText(view.getContext(),
                        product.getName(),
                        Toast.LENGTH_SHORT).show());
    }

    // Returns the total number of products.
    @Override
    public int getItemCount() {
        return products.size();
    }
}
