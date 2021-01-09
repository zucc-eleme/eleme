package cn.edu.shu.xj.ser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("store")
public class Store {
    @TableId(value="store_id",type =IdType.AUTO)
    private long storeId;
    @TableField(value = "store_class")
    private String storeClass;
    @TableField(value = "store_name")
    private String storeName;
    @TableField(value = "store_passwd")
    private String storePasswd;
    @TableField(value = "store_address")
    private String storeAddress;
    @TableField(value = "store_phone")
    private String storePhone;
    @TableField(value = "delivery_begin")
    private String deliveryBegin;
    @TableField(value = "delivery_end")
    private String deliveryEnd;

    public Store(long storeId, String storeClass, String storeName, String storePasswd, String storeAddress, String storePhone, String deliveryBegin, String deliveryEnd) {
        this.storeId = storeId;
        this.storeClass = storeClass;
        this.storeName = storeName;
        this.storePasswd = storePasswd;
        this.storeAddress = storeAddress;
        this.storePhone = storePhone;
        this.deliveryBegin = deliveryBegin;
        this.deliveryEnd = deliveryEnd;
    }

    public Store(String storeClass, String storeName, String storePasswd, String storeAddress, String storePhone, String deliveryBegin, String deliveryEnd) {
        this.storeClass = storeClass;
        this.storeName = storeName;
        this.storePasswd = storePasswd;
        this.storeAddress = storeAddress;
        this.storePhone = storePhone;
        this.deliveryBegin = deliveryBegin;
        this.deliveryEnd = deliveryEnd;
    }

    public Store(String storePhone, String storePasswd) {
        this.storePhone = storePhone;
        this.storePasswd= storePasswd;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public String getStoreClass() {
        return storeClass;
    }

    public void setStoreClass(String storeClass) {
        this.storeClass = storeClass;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStorePasswd() {
        return storePasswd;
    }

    public void setStorePasswd(String storePasswd) {
        this.storePasswd = storePasswd;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone;
    }

    public String getDeliveryBegin() {
        return deliveryBegin;
    }

    public void setDeliveryBegin(String deliveryBegin) {
        this.deliveryBegin = deliveryBegin;
    }

    public String getDeliveryEnd() {
        return deliveryEnd;
    }

    public void setDeliveryEnd(String deliveryEnd) {
        this.deliveryEnd = deliveryEnd;
    }
}
