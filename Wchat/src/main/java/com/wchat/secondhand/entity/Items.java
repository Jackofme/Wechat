package com.wchat.secondhand.entity;
        import lombok.Data;
        import org.springframework.stereotype.Component;


@Data
@Component
public class Items {
    private String address;
    private String description;
    private double price;
    private String location;
}
