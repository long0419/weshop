package tech.wetech.weshop.vo;

public class CollectAddOrDeleteResultVO {

    private HandleType type;

    public CollectAddOrDeleteResultVO(HandleType type) {
        this.type = type;
    }

    public enum HandleType{
        add,delete
    }

    public HandleType getType() {
        return type;
    }

    public CollectAddOrDeleteResultVO setType(HandleType type) {
        this.type = type;
        return this;
    }
}
