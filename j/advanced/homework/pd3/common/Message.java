package j.advanced.homework.pd3.common;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    private MessageTypeEnum type;

    private String content;

    public Message(MessageTypeEnum type, String content) {
        this.type = type;
        this.content = content;
    }

    public MessageTypeEnum getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public void setType(MessageTypeEnum type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
