package com.arriendos.apialquiler.model.exception;

public class ErrorInformacion{

   private String mensaje;
   private String  httpStatus;

    public ErrorInformacion(String mensaje, String httpStatus) {
        this.mensaje = mensaje;
        this.httpStatus = httpStatus.replace("uri=","");
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    /* private String nombreRecurso;
    private String valorCampo;
    private Object tipoCampo;

    public ErrorInformacion(String nombreRecurso, String valorCampo, Object tipoCampo) {
        super(String.format("%s no fue encontado con: %s='%s'", nombreRecurso, valorCampo, tipoCampo));
        this.nombreRecurso = nombreRecurso;
        this.valorCampo = valorCampo;
        this.tipoCampo = tipoCampo;
    }

    public ErrorInformacion(String nombreRecurso) {
        super(String.format("%s no fue encontado con: %s='%s'", nombreRecurso));
        this.nombreRecurso = nombreRecurso;
    }*/
}
