package com.CadastroViagem.enums;

public enum Status {
    NAO_PAGO(0),
    PAGO(1);

    private int code;

    Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Status valueOf(int code) {
        for (Status value : Status.values()) {
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid status code");
    }
}
