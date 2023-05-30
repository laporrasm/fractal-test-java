package com.laporrasm.orders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    @Id
    private String id;
    @DBRef
    private Product product;
    private int quantity;
}
