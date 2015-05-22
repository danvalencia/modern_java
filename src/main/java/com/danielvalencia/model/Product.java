package com.danielvalencia.model;

import java.util.Map;

/**
 * @author Daniel Valencia (daniel@tacitknowledge.com)
 */
public class Product
{
    private Long sku;
    private String name;
    private Double salePrice;
    private String image;
    private String description;

    public Product(Long sku, String name, Double salePrice, String image)
    {
        this.sku = sku;
        this.name = name;
        this.salePrice = salePrice;
        this.image = image;
    }


    public Product(Map<String, Object> productMap)
    {
        this.sku = ((Number) productMap.get("sku")).longValue();
        this.name = (String) productMap.get("name");
        this.salePrice = (Double) productMap.get("salePrice");
        this.image = (String) productMap.get("image");
    }

    public Long getSku()
    {
        return sku;
    }

    public void setSku(Long sku)
    {
        this.sku = sku;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Double getSalePrice()
    {
        return salePrice;
    }

    public void setSalePrice(Double salePrice)
    {
        this.salePrice = salePrice;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
