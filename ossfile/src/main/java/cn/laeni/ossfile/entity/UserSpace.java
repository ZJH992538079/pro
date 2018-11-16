package cn.laeni.ossfile.entity;

public class UserSpace {
    private String userId;

    private Long sumSpace;

    private Long usedSpace;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getSumSpace() {
        return sumSpace;
    }

    public void setSumSpace(Long sumSpace) {
        this.sumSpace = sumSpace;
    }

    public Long getUsedSpace() {
        return usedSpace;
    }

    public void setUsedSpace(Long usedSpace) {
        this.usedSpace = usedSpace;
    }
}