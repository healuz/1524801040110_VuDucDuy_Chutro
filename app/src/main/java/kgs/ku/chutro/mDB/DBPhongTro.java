package kgs.ku.chutro.mDB;

public class DBPhongTro {
    private String keyid;
    private String name;
    private String nguoithue;
    private String giaphong;
    private String giadien;
    private String gianuoc;
    private String tongtienphong;
    private String chuphong;
    private String avatar;
    private boolean status;

    public DBPhongTro() {
    }

    public DBPhongTro(String keyid, String name, String nguoithue, String giaphong, String giadien, String gianuoc, String tongtienphong, String chuphong, String avatar, boolean status) {
        this.keyid = keyid;
        this.name = name;
        this.nguoithue = nguoithue;
        this.giaphong = giaphong;
        this.giadien = giadien;
        this.gianuoc = gianuoc;
        this.tongtienphong = tongtienphong;
        this.chuphong = chuphong;
        this.avatar = avatar;
        this.status = status;
    }

    public String getKeyid() {
        return keyid;
    }

    public void setKeyid(String keyid) {
        this.keyid = keyid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNguoithue() {
        return nguoithue;
    }

    public void setNguoithue(String nguoithue) {
        this.nguoithue = nguoithue;
    }

    public String getGiaphong() {
        return giaphong;
    }

    public void setGiaphong(String giaphong) {
        this.giaphong = giaphong;
    }

    public String getGiadien() {
        return giadien;
    }

    public void setGiadien(String giadien) {
        this.giadien = giadien;
    }

    public String getGianuoc() {
        return gianuoc;
    }

    public void setGianuoc(String gianuoc) {
        this.gianuoc = gianuoc;
    }

    public String getTongtienphong() {
        return tongtienphong;
    }

    public void setTongtienphong(String tongtienphong) {
        this.tongtienphong = tongtienphong;
    }

    public String getChuphong() {
        return chuphong;
    }

    public void setChuphong(String chuphong) {
        this.chuphong = chuphong;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}


