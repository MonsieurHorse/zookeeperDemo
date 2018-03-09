package model;

/**
 * Created by junbaoma on 2017/12/29.
 */
public class ActivityUserInfo {
    private String nick;
    private Integer effectiveSlaves;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getEffectiveSlaves() {
        return effectiveSlaves;
    }

    public void setEffectiveSlaves(Integer effectiveSlaves) {
        this.effectiveSlaves = effectiveSlaves;
    }
}
