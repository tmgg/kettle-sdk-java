package io.github.tmgg.kettle.sdk;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {

    boolean success;

    String message;



    public static Result ok(){
        Result rs = new Result();
        rs.setSuccess(true);
        return rs;
    }

    public static Result err(){
        Result rs = new Result();
        rs.setSuccess(false);
        return rs;
    }

    public Result msg(String msg){
        this.message = msg;
        return this;
    }
}
