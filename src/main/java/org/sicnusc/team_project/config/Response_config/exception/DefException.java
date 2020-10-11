package org.sicnusc.team_project.config.Response_config.exception;


public class DefException extends  RuntimeException{
    private int code ;
    private String message;
    private DefException(){}
    public DefException(ExceptionType e, String message){
        this.code = e.getCode();
        this.message = message;
    }
    public int getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }


}
