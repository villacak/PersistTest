package au.com.test.app.bean;

/**
 * Created by Klaus on 9/03/14.
 */
public class BrandBean {

    private int brandId;
    private String brandName;
    private String brandAddress;

    public int getBrandId() {
        return brandId;
    }

    public BrandBean(int brandId, String brandName, String brandAddress) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.brandAddress = brandAddress;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandAddress() {
        return brandAddress;
    }

    public void setBrandAddress(String brandAddress) {
        this.brandAddress = brandAddress;
    }
}
