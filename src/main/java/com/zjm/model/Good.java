package com.zjm.model;

import com.google.gson.annotations.Expose;

import java.util.Date;

public class Good {
    private Integer id;

    private String name;

    private String info;

    private String pic;

    private Date productdate;

    private String expirationdate;

    private Integer warenum;

    private Integer sellnum;

    private Float price;

    private Float discountprice;

    private float deliveryFee;

    private Integer ishot;

    private Integer goodcomment;

    private Integer badcomment;

    private Shop shop;

    private int shopId;

    private String shopName;

    private BigCatogary bigCatogary;

    private int bigCatogaryId;

    private SmallCatogary smallCatogary;

    private int smallCatogaryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getProductdate() {
        return productdate;
    }

    public void setProductdate(Date productdate) {
        this.productdate = productdate;
    }

    public String getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(String expirationdate) {
        this.expirationdate = expirationdate == null ? null : expirationdate.trim();
    }

    public Integer getWarenum() {
        return warenum;
    }

    public void setWarenum(Integer warenum) {
        this.warenum = warenum;
    }

    public Integer getSellnum() {
        return sellnum;
    }

    public void setSellnum(Integer sellnum) {
        this.sellnum = sellnum;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(Float discountprice) {
        this.discountprice = discountprice;
    }

    public Integer getIshot() {
        return ishot;
    }

    public void setIshot(Integer ishot) {
        this.ishot = ishot;
    }

    public Integer getGoodcomment() {
        return goodcomment;
    }

    public void setGoodcomment(Integer goodcomment) {
        this.goodcomment = goodcomment;
    }

    public Integer getBadcomment() {
        return badcomment;
    }

    public void setBadcomment(Integer badcomment) {
        this.badcomment = badcomment;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public float getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(float deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public BigCatogary getBigCatogary() {
        return bigCatogary;
    }

    public void setBigCatogary(BigCatogary bigCatogary) {
        this.bigCatogary = bigCatogary;
    }

    public SmallCatogary getSmallCatogary() {
        return smallCatogary;
    }

    public void setSmallCatogary(SmallCatogary smallCatogary) {
        this.smallCatogary = smallCatogary;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getBigCatogaryId() {
        return bigCatogaryId;
    }

    public void setBigCatogaryId(int bigCatogaryId) {
        this.bigCatogaryId = bigCatogaryId;
    }

    public int getSmallCatogaryId() {
        return smallCatogaryId;
    }

    public void setSmallCatogaryId(int smallCatogaryId) {
        this.smallCatogaryId = smallCatogaryId;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", pic='" + pic + '\'' +
                ", productdate=" + productdate +
                ", expirationdate='" + expirationdate + '\'' +
                ", warenum=" + warenum +
                ", sellnum=" + sellnum +
                ", price=" + price +
                ", discountprice=" + discountprice +
                ", deliveryFee=" + deliveryFee +
                ", ishot=" + ishot +
                ", goodcomment=" + goodcomment +
                ", badcomment=" + badcomment +
                ", shop=" + shop +
                ", shopId=" + shopId +
                ", bigCatogary=" + bigCatogary +
                ", smallCatogary=" + smallCatogary +
                '}';
    }
}