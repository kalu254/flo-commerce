package com.kalu.flo.model;

import javax.persistence.*;

@Table(name = "product_table")
@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String main_image_url;
    @Column
    private String image_url_one;
    @Column
    private String image_url_two;
    @Column
    private String image_url_three;
    @Column
    private String category;
    @Column
    private String gender;
    @Column
    private double price;

    public ProductEntity() {
    }


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain_image_url() {
        return main_image_url;
    }

    public void setMain_image_url(String main_image_url) {
        this.main_image_url = main_image_url;
    }

    public String getImage_url_one() {
        return image_url_one;
    }

    public void setImage_url_one(String image_url_one) {
        this.image_url_one = image_url_one;
    }

    public String getImage_url_two() {
        return image_url_two;
    }

    public void setImage_url_two(String image_url_two) {
        this.image_url_two = image_url_two;
    }

    public String getImage_url_three() {
        return image_url_three;
    }

    public void setImage_url_three(String image_url_three) {
        this.image_url_three = image_url_three;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", main_image_url='" + main_image_url + '\'' +
            ", image_url_one='" + image_url_one + '\'' +
            ", image_url_two='" + image_url_two + '\'' +
            ", image_url_three='" + image_url_three + '\'' +
            ", category='" + category + '\'' +
            ", gender='" + gender + '\'' +
            ", price=" + price +
            '}';
    }
}
