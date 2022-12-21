package cn.fvti.core.pojo;

import java.util.Date;

public class Violation {
    private static final long serialVersionUID = 1L;//序列号
    private Integer vid;
    private String vaddress;
    private String vthing;
    private Integer vmoney;
    private Integer cust_id;
    private Integer cid;
    private String vstare;
    private Date vtime;
    private Integer vlicense;

    public String getVstare() {
        return vstare;
    }

    public void setVstare(String vstare) {
        this.vstare = vstare;
    }

    public Integer getVlicense() {
        return vlicense;
    }

    public void setVlicense(Integer vlicense) {
        this.vlicense = vlicense;
    }

    public Date getVtime() {
        return vtime;
    }

    public void setVtime(Date vtime) {
        this.vtime = vtime;
    }



    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getVaddress() {
        return vaddress;
    }

    public void setVaddress(String vaddress) {
        this.vaddress = vaddress;
    }

    public String getVthing() {
        return vthing;
    }

    public void setVthing(String vthing) {
        this.vthing = vthing;
    }

    public Integer getVmoney() {
        return vmoney;
    }

    public void setVmoney(Integer vmoney) {
        this.vmoney = vmoney;
    }

    public Integer getCust_id() {
        return cust_id;
    }

    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
