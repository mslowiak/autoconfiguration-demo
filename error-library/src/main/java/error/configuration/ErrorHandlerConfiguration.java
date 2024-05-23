package error.configuration;

public class ErrorHandlerConfiguration {

    private String headerName;
    private int httpCode;

    public ErrorHandlerConfiguration(String headerName, int httpCode) {
        this.headerName = headerName;
        this.httpCode = httpCode;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public String headerName() {
        return headerName;
    }

    public int httpCode() {
        return httpCode;
    }

}
